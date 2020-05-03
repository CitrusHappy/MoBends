package goblinbob.mobends.standard.data;

import goblinbob.mobends.core.animation.controller.IAnimationController;
import goblinbob.mobends.core.client.model.ModelPartTransform;
import goblinbob.mobends.core.data.LivingEntityData;
import goblinbob.mobends.standard.animation.controller.WolfController;
import net.minecraft.entity.passive.EntityWolf;

public class WolfData extends LivingEntityData<EntityWolf>
{

    public ModelPartTransform head;
    public ModelPartTransform nose;
    public ModelPartTransform mouth;
    public ModelPartTransform body;
    public ModelPartTransform leg1;
    public ModelPartTransform leg2;
    public ModelPartTransform leg3;
    public ModelPartTransform leg4;
    public ModelPartTransform tail;
    public ModelPartTransform mane;

    public ModelPartTransform foreLeg1;
    public ModelPartTransform foreLeg2;
    public ModelPartTransform foreLeg3;
    public ModelPartTransform foreLeg4;

    private final WolfController controller = new WolfController();

    public WolfData(EntityWolf entity)
    {
        super(entity);
    }

    @Override
    public IAnimationController<?> getController()
    {
        return controller;
    }

    @Override
    public void onTicksRestart()
    {
        // No behaviour
    }

    @Override
    public void initModelPose()
    {
        super.initModelPose();

        nameToPartMap.put("head", head = new ModelPartTransform());
        nameToPartMap.put("body", body = new ModelPartTransform());
        nameToPartMap.put("leg1", leg1 = new ModelPartTransform());
        nameToPartMap.put("leg2", leg2 = new ModelPartTransform());
        nameToPartMap.put("leg3", leg3 = new ModelPartTransform());
        nameToPartMap.put("leg4", leg4 = new ModelPartTransform());
        nameToPartMap.put("tail", tail = new ModelPartTransform());
        nameToPartMap.put("mane", mane = new ModelPartTransform());

        nameToPartMap.put("nose", nose = new ModelPartTransform());
        nameToPartMap.put("mouth", mouth = new ModelPartTransform());
        nameToPartMap.put("foreLeg1", foreLeg1 = new ModelPartTransform());
        nameToPartMap.put("foreLeg2", foreLeg2 = new ModelPartTransform());
        nameToPartMap.put("foreLeg3", foreLeg3 = new ModelPartTransform());
        nameToPartMap.put("foreLeg4", foreLeg4 = new ModelPartTransform());

        head.position.set(-1.0F, 2.0F, -10.0F);
        body.position.set(0.0F, 11.0F, 3.0F);
        mane.position.set(0.0F, 2.0F, -7.0F);
        leg1.position.set(-2.5F, 16.0F, 7.0F);
        leg2.position.set(0.5F, 16.0F, 7.0F);
        leg3.position.set(-2.5F, 16.0F, -4.0F);
        leg4.position.set(0.5F, 16.0F, -4.0F);
        tail.position.set(-1.0F, 0.0F, 5.0F);

        nose.position.set(0.0F, 0.0F, 0.0F);
        mouth.position.set(0.0F, 0.0F, 0.0F);
        foreLeg1.position.set(0.0F, 0.0F, 0.0F);
        foreLeg2.position.set(0.0F, 0.0F, 0.0F);
        foreLeg3.position.set(0.0F, 0.0F, 0.0F);
        foreLeg4.position.set(0.0F, 0.0F, 0.0F);
    }

    @Override
    public void updateParts(float ticksPerFrame)
    {
        super.updateParts(ticksPerFrame);

        head.update(ticksPerFrame);
        body.update(ticksPerFrame);
        leg1.update(ticksPerFrame);
        leg2.update(ticksPerFrame);
        leg3.update(ticksPerFrame);
        leg4.update(ticksPerFrame);
        tail.update(ticksPerFrame);
        mane.update(ticksPerFrame);

        nose.update(ticksPerFrame);
        mouth.update(ticksPerFrame);
        foreLeg1.update(ticksPerFrame);
        foreLeg2.update(ticksPerFrame);
        foreLeg3.update(ticksPerFrame);
        foreLeg4.update(ticksPerFrame);
    }

}
