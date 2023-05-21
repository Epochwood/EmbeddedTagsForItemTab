package io.github.heliecp.etfit.mixin;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import io.github.heliecp.etfit.CreativeTabTags;
import io.github.heliecp.etfit.TestTab;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.CreativeScreen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreativeScreen.class)
public abstract class TabTagsMixin {
    //@Shadow private int selectedTab = ItemGroup.TAB_BUILDING_BLOCKS.getId();

    @Inject(method = {"renderLabels"}, at = {@At("HEAD")}, cancellable = true)
    protected void renderLabels(MatrixStack matrix, int p_230451_2_, int p_230451_3_, CallbackInfo info){
        RenderSystem.color4f(1f,1f,1f,1f);
        //ItemGroup itemgroup = ItemGroup.TABS[0];
        CreativeTabTags creativeTab = new TestTab(); // CreativeTabTags.tab;
        if (creativeTab != null && creativeTab.showTitle()) {
            RenderSystem.disableBlend();
            for (int x = 0; x < creativeTab.getTagsNames().length - 1; x++)
            {
                Minecraft.getInstance().font.draw(matrix, creativeTab.displayTagsNames()[x], 8.0F + (float) x, 6.0F, creativeTab.getLabelColor());
            }
        }
    }

}
