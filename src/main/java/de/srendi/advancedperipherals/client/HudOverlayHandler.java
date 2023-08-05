package de.srendi.advancedperipherals.client;

import de.srendi.advancedperipherals.common.argoggles.ARRenderAction;
import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;
import java.util.List;

public class HudOverlayHandler {
    private static HudOverlayHandler instance;
    private final List<ARRenderAction> canvas = new ArrayList<>();

    public static void init() {
        instance = new HudOverlayHandler();
        MinecraftForge.EVENT_BUS.register(instance);
    }

    public static HudOverlayHandler getInstance() {
        return instance;
    }

    public static void updateCanvas(List<ARRenderAction> actions) {
        if (instance == null)
            return;
        instance.canvas.clear();
        instance.canvas.addAll(actions);
    }

    public static void clearCanvas() {
        if (instance == null)
            return;
        instance.canvas.clear();
    }

    //TODO: Use the forge Overlay System instead
    /*@SubscribeEvent(priority = EventPriority.LOWEST)
    public void onRender(RenderGuiEvent.Post event) {
        if (event.getWindow() == null)
            return;
        Minecraft mc = Minecraft.getInstance();
        PoseStack matrixStack = event.getMatrixStack();
        for (ARRenderAction action : canvas) {
            action.draw(mc, matrixStack, event.getWindow().getScreenWidth(), event.getWindow().getScreenHeight());
        }
        RenderSystem.setShaderTexture(0, GuiComponent.GUI_ICONS_LOCATION);
    }*/
}
