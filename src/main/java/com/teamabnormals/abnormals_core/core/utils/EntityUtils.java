package com.teamabnormals.abnormals_core.core.utils;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;

/** 
 * @author - SmellyModder(Luke Tonon)
 */
public class EntityUtils {
	
	public static RayTraceResult rayTrace(Entity entity, double distance, float delta) {
		return entity.world.rayTraceBlocks(new RayTraceContext(
			entity.getEyePosition(delta),
			entity.getEyePosition(delta).add(entity.getLook(delta).scale(distance)),
			RayTraceContext.BlockMode.COLLIDER,
			RayTraceContext.FluidMode.NONE,
			entity
		));
	}
	
	public static RayTraceResult rayTraceWithCustomDirection(Entity entity, float pitch, float yaw, double distance, float delta) {
		return entity.world.rayTraceBlocks(new RayTraceContext(
			entity.getEyePosition(delta),
			entity.getEyePosition(delta).add(getVectorForRotation(pitch, yaw).scale(distance)),
			RayTraceContext.BlockMode.COLLIDER,
			RayTraceContext.FluidMode.NONE,
			entity
		));
	}
	
	public static RayTraceResult rayTraceUpWithCustomDirection(Entity entity, float pitch, float yaw, double distance, float delta) {
		return entity.world.rayTraceBlocks(new RayTraceContext(
			entity.getEyePosition(delta),
			entity.getEyePosition(delta).add(getUpVectorForRotation(pitch, yaw).scale(distance)),
			RayTraceContext.BlockMode.COLLIDER,
			RayTraceContext.FluidMode.NONE,
			entity
		));
	}
	
	public static final Vec3d getVectorForRotation(float pitch, float yaw) {
		float f = pitch * ((float) Math.PI / 180F);
		float f1 = -yaw * ((float) Math.PI / 180F);
		float f2 = MathHelper.cos(f1);
		float f3 = MathHelper.sin(f1);
		float f4 = MathHelper.cos(f);
		float f5 = MathHelper.sin(f);
		return new Vec3d((double) (f3 * f4), (double) (-f5), (double) (f2 * f4));
	}
	
	public static final Vec3d getUpVectorForRotation(float pitch, float yaw) {
		float f = (pitch - 90.0F) * ((float) Math.PI / 180F);
		float f1 = -yaw * ((float) Math.PI / 180F);
		float f2 = MathHelper.cos(f1);
		float f3 = MathHelper.sin(f1);
		float f4 = MathHelper.cos(f);
		float f5 = MathHelper.sin(f);
		return new Vec3d((double) (f3 * f4), (double) (-f5), (double) (f2 * f4));
	}
}

