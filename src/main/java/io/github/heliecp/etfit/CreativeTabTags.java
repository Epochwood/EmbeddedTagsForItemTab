package io.github.heliecp.etfit;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class CreativeTabTags extends ItemGroup{

    public static CreativeTabTags tab;
    private String tabName;

    private String[] tagsNames;

    private String tagsBackgroundSuffix = "items_tag.png";
    private net.minecraft.util.ResourceLocation tagsBackgroundLocation;

    public CreativeTabTags(int id, String label, String[] tagsNames) {
        super(id, label);
    }

    public CreativeTabTags(String label, CreativeTabTags tab, String[] tagsNames) {
        super(label);
        this.tabName = label;
        CreativeTabTags.tab = tab;
        this.tagsNames = tagsNames;
    }

    public String getTabName()
    {
        return this.tabName;
    }

    public int getTagsNumber()
    {
        return this.tagsNames.length;
    }

    public String[] getTagsNames()
    {
        return this.tagsNames;
    }

    public ITextComponent[] displayTagsNames() //获取tag资源名称
    {
        TranslationTextComponent[] name = new TranslationTextComponent[tagsNames.length - 1];
        for (int x = 0; x < tagsNames.length; x++)
        {
            name[x] = new TranslationTextComponent("itemGroup." + tabName + "." + this.tagsNames[x]);
        }
        ITextComponent[] tagsNames = name.clone();
        return tagsNames;
    }

    public CreativeTabTags setTagsBackgroundImage(String modId, String imageName)
    {
        this.tagsBackgroundLocation = new ResourceLocation(modId + ":textures/gui/container/creative_inventory/tab_" + imageName);
        return this;
    }

    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getTagsBackgroundImage() {
        if (tagsBackgroundLocation != null)
            return tagsBackgroundLocation;
        return new ResourceLocation( EmbeddedTagsForItemTab.MOD_ID + ":textures/gui/container/creative_inventory/tab_" + tagsBackgroundSuffix);
    }

    public abstract ItemStack getIcon();

    @Override
    public ItemStack makeIcon() {
        return getIcon();
    }
}
