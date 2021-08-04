package goblinbob.mobends.standard.animation.bit.player;

import goblinbob.mobends.standard.data.PlayerData;

public class SprintAnimationBit extends goblinbob.mobends.standard.animation.bit.biped.SprintAnimationBit<PlayerData>
{
	@Override
	public void perform(PlayerData data)
	{
		super.perform(data);

		if (data.getTicksAfterAttack() < 10)
		{
			data.head.rotation.setSmoothness(0.5F).orientX(data.headPitch.get())
					.rotateY(data.headYaw.get());
		}
	}
}
