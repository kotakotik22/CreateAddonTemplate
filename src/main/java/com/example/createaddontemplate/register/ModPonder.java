package com.example.createaddontemplate.register;

import com.example.createaddontemplate.CreateAddon;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.ponder.PonderRegistry;
import com.simibubi.create.foundation.ponder.content.PonderTag;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

public class ModPonder {
    public static void register() {
        // Make sure to include your modid in your ponder id! Otherwise it won't generate the lang!
    }

    public static void generateLang(CreateRegistrate registrate, GatherDataEvent event) {
        register();
        PonderRegistry.provideLangEntries().getAsJsonObject().entrySet().forEach(e -> {
            String k = e.getKey();
            String v = e.getValue().getAsString();
            if (k.contains(CreateAddon.modid + ".")) {
                registrate.addRawLang(k, v);
            }
        });
    }
}
