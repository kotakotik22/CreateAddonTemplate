package com.example.createaddontemplate.register;

import com.example.createaddontemplate.CreateAddon;
import com.jozufozu.flywheel.core.PartialModel;
import com.simibubi.create.AllBlockPartials;
import com.simibubi.create.Create;
import net.minecraft.util.ResourceLocation;

public class ModPartials {
    public static PartialModel get(String name) {
        return new PartialModel(new ResourceLocation(CreateAddon.modid, "block/" + name));
    }

    public static PartialModel getCreate(String name) {
        return new PartialModel(Create.asResource("block/" + name));
    }

    public static PartialModel getEntity(String name) {
        return new PartialModel(new ResourceLocation(CreateAddon.modid, "entity/" + name));
    }

    public static PartialModel getEntityCreate(String name) {
        return new PartialModel(Create.asResource("entity/" + name));
    }

    public static void load() {

    }
}
