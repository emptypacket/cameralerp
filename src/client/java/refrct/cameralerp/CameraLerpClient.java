package refrct.cameralerp;

import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ClientModInitializer;

import static refrct.cameralerp.CameraLerp.MOD_ID;

public class CameraLerpClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		MidnightConfig.init(MOD_ID, CameraLerpConfig.class);
	}
}