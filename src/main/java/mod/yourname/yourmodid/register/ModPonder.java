package mod.yourname.yourmodid.register;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.ponder.PonderLocalization;
import com.simibubi.create.foundation.ponder.PonderRegistry;
import mod.yourname.yourmodid.BuildConfig;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

public class ModPonder {
    public static void register() {
        PonderRegistry.startRegistration(BuildConfig.MODID);
        // Put your ponder here!
        PonderRegistry.endRegistration();
    }

    public static void generateLang(CreateRegistrate registrate, GatherDataEvent event) {
        register();
        PonderLocalization.provideRegistrateLang(registrate);
    }
}
