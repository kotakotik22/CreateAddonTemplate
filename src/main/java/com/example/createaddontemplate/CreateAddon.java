package com.example.createaddontemplate;

import com.example.createaddontemplate.register.*;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.repack.registrate.util.NonNullLazyValue;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DatagenModLoader;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// TODO: rename this class! and package name!
@Mod(CreateAddon.modid)
public class CreateAddon {

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String modid = "youraddon"; // TODO: change this!
    public static IEventBus modEventBus;

    public static final NonNullLazyValue<CreateRegistrate> registrate = CreateRegistrate.lazy(modid);

    public CreateAddon() {
        modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        CreateRegistrate r = registrate.get();
        ModItems.register(r);
        ModBlocks.register(r);
        ModEntities.register(r);
        ModTiles.register(r);
        if (DatagenModLoader.isRunningDataGen()) {
            modEventBus.addListener((GatherDataEvent g) -> ModPonder.generateLang(r, g));
        }
        modEventBus.addListener((FMLClientSetupEvent e) -> ModPonder.register());
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT,
                () -> ModPartials::load);
    }
}
