package refrct.cameralerp;

import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ClientModInitializer;

public class CameraLerpClient implements ClientModInitializer {
	public static final String MOD_ID = "cameralerp";

	@Override
	public void onInitializeClient() {
		MidnightConfig.init(MOD_ID, CameraLerpConfig.class);
	}
}