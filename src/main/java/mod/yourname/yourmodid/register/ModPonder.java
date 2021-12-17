package mod.yourname.yourmodid.register;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.ponder.PonderLocalization;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

public class ModPonder {
    public static void register() {
        // Put your ponder here!
    }

    public static void generateLang(CreateRegistrate registrate, GatherDataEvent event) {
        register();
        PonderLocalization.provideRegistrateLang(registrate);
    }
}
