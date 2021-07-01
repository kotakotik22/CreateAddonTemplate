package com.kotakotik.createaddontemplate.register;

import com.kotakotik.createaddontemplate.CreateAddon;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItems {
    public static ItemGroup itemGroup = new ItemGroup(CreateAddon.modid) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(AllItems.WRENCH.get());
        }
    };

    public static void register(CreateRegistrate registrate) {
        registrate.itemGroup(()->itemGroup, "Create Addon"); // TODO: change this
    }
}
