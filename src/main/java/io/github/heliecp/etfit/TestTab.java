package io.github.heliecp.etfit;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class TestTab extends CreativeTabTags
{

    public static final ItemGroup TEST_TAB = new TestTab();

    public static final String[] tagsNames = new String[]{"test1", "test2"};

    public TestTab() {
        super("test_tab", TEST_TAB, tagsNames);
    }

    @Override
    public ItemStack getIcon() {
        return new ItemStack(Block.itemBlock.get());
    }
}
