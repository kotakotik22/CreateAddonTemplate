package com.example.createaddontemplate;

import com.example.createaddontemplate.register.ModBlocks;
import com.example.createaddontemplate.register.ModEntities;
import com.example.createaddontemplate.register.ModItems;
import com.example.createaddontemplate.register.ModTiles;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.repack.registrate.util.NonNullLazyValue;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// TODO: rename this class! and package name!
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
