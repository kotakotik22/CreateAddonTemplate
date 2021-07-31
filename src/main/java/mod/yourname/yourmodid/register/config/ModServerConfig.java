package mod.yourname.yourmodid.register.config;

import com.simibubi.create.foundation.block.BlockStressDefaults;
import com.simibubi.create.foundation.block.BlockStressValues;
import mod.yourname.yourmodid.BuildConfig;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.HashMap;
import java.util.Map;

public class ModServerConfig extends ModConfigs.Config {
    public static class StressValues extends ModConfigs.Config implements BlockStressValues.IStressValueProvider {
        protected Map<ResourceLocation, ConfigFloat> impacts = new HashMap<>();
        protected Map<ResourceLocation, ConfigFloat> capacities = new HashMap<>();

                {
            BlockStressDefaults.DEFAULT_IMPACTS.forEach((r, i) -> {
                if (r.getNamespace().equals(BuildConfig.MODID)) {
                    impacts.put(r, f(i.floatValue(), Float.MAX_VALUE, r.getPath()));
                }
            });
            BlockStressDefaults.DEFAULT_CAPACITIES.forEach((r, i) -> {
                if (r.getNamespace().equals(BuildConfig.MODID)) {
                    capacities.put(r, f(i.floatValue(), Float.MAX_VALUE, r.getPath()));
                }
            });
            BlockStressValues.registerProvider(BuildConfig.MODID, this);
        }

        @Override
        public double getImpact(Block block) {
            ConfigFloat c = impacts.get(block.getRegistryName());
            return c == null ? 0d : c.get();
        }

        @Override
        public double getCapacity(Block block) {
            ConfigFloat c = capacities.get(block.getRegistryName());
            return c == null ? 0d : c.get();
        }

        @Override
        public boolean hasImpact(Block block) {
            return impacts.containsKey(block.getRegistryName());
        }

        @Override
        public boolean hasCapacity(Block block) {
            return capacities.containsKey(block.getRegistryName());
        }
    }

//    public StressValues stressValues = nested(0, StressValues::new);
}
