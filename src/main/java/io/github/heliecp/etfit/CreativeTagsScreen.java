package io.github.heliecp.etfit;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemGroup;


public class CreativeTagsScreen
{
    protected FontRenderer font;
    private static int selectedTab = ItemGroup.TAB_BUILDING_BLOCKS.getId();


    protected void renderLabels(MatrixStack p_230451_1_, int p_230451_2_, int p_230451_3_) {
        ItemGroup itemgroup = ItemGroup.TABS[selectedTab];
        CreativeTabTags creativeTabTags = CreativeTabTags.tab;
        if (itemgroup != null && itemgroup.showTitle()) {
            RenderSystem.disableBlend();
            for (int x = 0; x < creativeTabTags.getTagsNames().length; x++)
            {
                this.font.draw(p_230451_1_, creativeTabTags.displayTagsNames()[x], 8.0F, 6.0F, itemgroup.getLabelColor());
            }
        }

    }
}
