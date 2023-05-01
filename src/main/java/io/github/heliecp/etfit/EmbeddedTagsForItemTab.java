package io.github.heliecp.etfit;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("etfit")
public class EmbeddedTagsForItemTab
{
    public static final String MOD_ID = "etfit";

    public EmbeddedTagsForItemTab()
    {
        IEventBus eventBus = (FMLJavaModLoadingContext.get().getModEventBus());
        Block.ITEMS.register(eventBus);
        Block.BLOCKS.register(eventBus);
    }
}
