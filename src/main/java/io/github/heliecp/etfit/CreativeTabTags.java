package io.github.heliecp.etfit;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.List;

public abstract class CreativeTabTags extends ItemGroup{

    private ItemGroup tab;
    private String tabName;

    private String[] tagsNames;
    private ITextComponent[] displayTagsName;

    protected FontRenderer font;
    private static int selectedTab = ItemGroup.TAB_BUILDING_BLOCKS.getId();

    public CreativeTabTags(int id, String label, ItemGroup tab, String[] tagsNames) {
        super(id, label);
    }

    public CreativeTabTags(String label, ItemGroup tab, String[] tagsNames) {
        super(label);
        this.tab = tab;
        this.tabName = label;
        this.tagsNames = tagsNames;
        this.displayTagsName = displayTagsNames();
    }

    public ItemGroup getTab()
    {
        return tab;
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

    public ITextComponent[] displayTagsNames()
    {
        TranslationTextComponent name = null;
        for (int x = 0; x < tagsNames.length + 1; x++)
        {
            name = new TranslationTextComponent("itemGroup." + tabName + "." + this.tagsNames[x]);
        }
        ITextComponent[] tagName = new ITextComponent[]{name};
        return tagName;
    }

    protected void renderLabels(MatrixStack p_230451_1_, int p_230451_2_, int p_230451_3_) {
        ItemGroup itemgroup = this.tab;
        if (itemgroup != null && itemgroup.showTitle()) {
            RenderSystem.disableBlend();
            this.font.draw(p_230451_1_, displayTagsNames()[0], 8.0F, 6.0F, itemgroup.getLabelColor());
        }

    }

    public abstract ItemStack getIcon();

    @Override
    public ItemStack makeIcon() {
        return getIcon();
    }
}
