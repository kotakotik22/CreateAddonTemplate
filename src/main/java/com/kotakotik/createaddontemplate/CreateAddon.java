package com.kotakotik.createaddontemplate;

import com.kotakotik.createaddontemplate.register.ModBlocks;
import com.kotakotik.createaddontemplate.register.ModEntities;
import com.kotakotik.createaddontemplate.register.ModItems;
import com.kotakotik.createaddontemplate.register.ModTiles;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.repack.registrate.util.NonNullLazyValue;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// TODO: rename this class!
@Mod(CreateAddon.modid)
public class CreateAddon {

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String modid = "youraddon"; // TODO: change this!

    public static final NonNullLazyValue<CreateRegistrate> registrate = CreateRegistrate.lazy(modid);

    public CreateAddon() {
        CreateRegistrate r = registrate.get();
        ModItems.register(r);
        ModBlocks.register(r);
        ModEntities.register(r);
        ModTiles.register(r);
    }
}
