package refrct.cameralerp;

import eu.midnightdust.lib.config.MidnightConfig;

public class CameraLerpConfig extends MidnightConfig {
    @Entry(category = "general")
    public static boolean enabled = true;
    @Entry(category = "general", isSlider = true, min = 0.1f, max = 1.0f)
    public static float smoothness = 0.3f;
}
