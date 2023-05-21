package io.github.heliecp.etfit;

import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Block extends net.minecraft.block.Block {

    public Block() {
        super(net.minecraft.block.Block.Properties.of(Material.STONE).strength(1.5F));
    }

    public static final DeferredRegister<net.minecraft.block.Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EmbeddedTagsForItemTab.MOD_ID);

    public static final RegistryObject<net.minecraft.block.Block> block = BLOCKS.register("block", Block::new);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EmbeddedTagsForItemTab.MOD_ID);

    public static final RegistryObject<Item> itemBlock = ITEMS.register("block", () -> new BlockItem(block.get(), new Item.Properties().tab(TestTab.TEST_TAB)));
}
