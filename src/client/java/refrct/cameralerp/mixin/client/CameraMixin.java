package refrct.cameralerp.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import org.joml.Math;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.*;
import refrct.cameralerp.CameraLerpConfig;

@Mixin(Camera.class)
public class CameraMixin {
    @Shadow private float pitch;
    @Shadow private float yaw;
    @Mutable
    @Final
    @Shadow private final Quaternionf rotation;

    @Mutable
    @Final
    @Shadow private final Vector3f horizontalPlane;
    @Mutable
    @Final
    @Shadow private final Vector3f verticalPlane;
    @Mutable
    @Final
    @Shadow private final Vector3f diagonalPlane;

    @Shadow private boolean thirdPerson;

    public CameraMixin(Quaternionf rotation, Vector3f horizontalPlane, Vector3f verticalPlane, Vector3f diagonalPlane) {
        this.rotation = rotation;
        this.horizontalPlane = horizontalPlane;
        this.verticalPlane = verticalPlane;
        this.diagonalPlane = diagonalPlane;
    }

    /**
     * @author refrct
     * @reason yeah
     */
    @Overwrite
    public void setRotation(float yaw, float pitch) {
        this.pitch = CameraLerpConfig.enabled && !thirdPerson ? Math.lerp(this.pitch, pitch, CameraLerpConfig.smoothness) : pitch;
        this.yaw = CameraLerpConfig.enabled && !thirdPerson? Math.lerp(this.yaw, yaw, CameraLerpConfig.smoothness) : yaw;
        this.rotation.rotationYXZ(-yaw * 0.017453292F, pitch * 0.017453292F, 0.0F);
        this.horizontalPlane.set(0.0F, 0.0F, 1.0F).rotate(this.rotation);
        this.verticalPlane.set(0.0F, 1.0F, 0.0F).rotate(this.rotation);
        this.diagonalPlane.set(1.0F, 0.0F, 0.0F).rotate(this.rotation);
    }
}
