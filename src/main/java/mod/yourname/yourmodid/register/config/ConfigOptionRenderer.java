package mod.yourname.yourmodid.register.config;

import com.simibubi.create.foundation.config.ui.BaseConfigScreen;
import com.simibubi.create.foundation.gui.AbstractSimiScreen;
import com.simibubi.create.foundation.gui.ScreenOpener;
import com.simibubi.create.foundation.gui.TextStencilElement;
import com.simibubi.create.foundation.gui.widgets.BoxWidget;
import mod.yourname.yourmodid.BuildConfig;
import mod.yourname.yourmodid.CreateAddon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import javax.annotation.Nonnull;
import java.lang.reflect.Field;
import java.util.List;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class ConfigOptionRenderer {
    /**
     * The offset to render the button, for addon compatibility.
     * <p>
     * You should probably +add to this instead of =setting it directly, again, for compatibility.
     */
    public static int renderOffset = 60;

    public static Field widgetListField = ObfuscationReflectionHelper.findField(AbstractSimiScreen.class, "widgets");

    public static class ModConfigScreen extends BaseConfigScreen {
        public ModConfigScreen(Screen parent, @Nonnull String modID) {
            super(parent, modID);
        }
    }

    public static ModConfigScreen createScreen(Screen parent) {
        return (ModConfigScreen) new ModConfigScreen(parent, BuildConfig.MODID)
                .withTitles("Client Settings", "World Generation Settings", "Gameplay Settings")
                .withSpecs(null, null, ModConfigs.SERVER.specification);
    }

    @SubscribeEvent
    public static void render(GuiScreenEvent.InitGuiEvent.Post event) throws IllegalAccessException {
        Screen screen = event.getGui();
        if (screen.getClass().equals(BaseConfigScreen.class)) {
            BaseConfigScreen configScreen = (BaseConfigScreen) screen;
            TextStencilElement buttonText = new TextStencilElement(Minecraft.getInstance().font, new StringTextComponent(BuildConfig.DISPLAY_NAME)).centered(true, true);
            BoxWidget buttonWidget;
            buttonWidget = new BoxWidget(configScreen.width / 2 - 100, configScreen.height / 2 + renderOffset, 200, 16).showingElement(buttonText);

            buttonWidget.withCallback(() -> ScreenOpener.open(createScreen(configScreen)));
            buttonText.withElementRenderer(BoxWidget.gradientFactory.apply(buttonWidget));
            List<Widget> widgets = (List<Widget>) widgetListField.get(configScreen);
            widgets.add(buttonWidget);
        }
    }
}
