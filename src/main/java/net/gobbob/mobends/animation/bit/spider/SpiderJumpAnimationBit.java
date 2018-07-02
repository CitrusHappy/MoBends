package net.gobbob.mobends.animation.bit.spider;

import net.gobbob.mobends.animation.bit.AnimationBit;
import net.gobbob.mobends.data.EntityData;
import net.gobbob.mobends.data.SpiderData;
import net.gobbob.mobends.util.GUtil;

public class SpiderJumpAnimationBit extends AnimationBit
{
	@Override
	public String[] getActions(EntityData entityData)
	{
		return new String[] { "jump" };
	}
	
	@Override
	public void perform(EntityData entityData)
	{
		if (!(entityData instanceof SpiderData))
			return;
		SpiderData data = (SpiderData) entityData;
		
		float ticksInAir = data.getTicksAfterLiftoff();
		ticksInAir = Math.min(ticksInAir * 0.1F, 1.0F);
		ticksInAir = (float) GUtil.easeInOut(ticksInAir, 3);
		
		float legAngle = -130.0F + ticksInAir * 95.0F;
		float smoothness = 1F;
		data.spiderLeg1.rotation.setSmoothness(smoothness).rotateZ(legAngle);
		data.spiderLeg2.rotation.setSmoothness(smoothness).rotateZ(-legAngle);
		data.spiderLeg3.rotation.setSmoothness(smoothness).rotateZ(legAngle);
		data.spiderLeg4.rotation.setSmoothness(smoothness).rotateZ(-legAngle);
		data.spiderLeg5.rotation.setSmoothness(smoothness).rotateZ(legAngle);
		data.spiderLeg6.rotation.setSmoothness(smoothness).rotateZ(-legAngle);
		data.spiderLeg7.rotation.setSmoothness(smoothness).rotateZ(legAngle);
		data.spiderLeg8.rotation.setSmoothness(smoothness).rotateZ(-legAngle);
		
		float foreLegAngle = 70.0F - ticksInAir * 50.0F;
		data.spiderForeLeg1.rotation.setSmoothness(smoothness).rotateZ(foreLegAngle);
		data.spiderForeLeg2.rotation.setSmoothness(smoothness).rotateZ(-foreLegAngle);
		data.spiderForeLeg3.rotation.setSmoothness(smoothness).rotateZ(foreLegAngle);
		data.spiderForeLeg4.rotation.setSmoothness(smoothness).rotateZ(-foreLegAngle);
		data.spiderForeLeg5.rotation.setSmoothness(smoothness).rotateZ(foreLegAngle);
		data.spiderForeLeg6.rotation.setSmoothness(smoothness).rotateZ(-foreLegAngle);
		data.spiderForeLeg7.rotation.setSmoothness(smoothness).rotateZ(foreLegAngle);
		data.spiderForeLeg8.rotation.setSmoothness(smoothness).rotateZ(-foreLegAngle);
		
	}
}
