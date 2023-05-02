package io.github.heliecp.etfit;

import net.minecraft.item.ItemStack;

public class TestTab extends CreativeTabTags
{

    public static final CreativeTabTags TEST_TAB = new TestTab();

    public static final String[] tagsNames = new String[]{"test1", "test2"};

    public TestTab() {
        super("test_tab", TEST_TAB, tagsNames);
        this.setTagsBackgroundImage(EmbeddedTagsForItemTab.MOD_ID, "items_tag.png");
    }

    @Override
    public ItemStack getIcon() {
        return new ItemStack(Block.itemBlock.get());
    }
}
