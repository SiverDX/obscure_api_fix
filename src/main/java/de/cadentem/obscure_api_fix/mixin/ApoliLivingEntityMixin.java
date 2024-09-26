package de.cadentem.obscure_api_fix.mixin;

import com.bawnorton.mixinsquared.TargetHandler;
import com.obscuria.obscureapi.registry.ObscureAPIAttributes;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = LivingEntity.class, priority = 1500)
public abstract class ApoliLivingEntityMixin {
    @TargetHandler(mixin = "io.github.apace100.apoli.mixin.LivingEntityMixin", name = "modifyArmorApplicance")
    @ModifyArg(method = "@MixinSquared:Handler", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/damagesource/CombatRules;getDamageAfterAbsorb(FFF)F"), index = 1)
    private float obscure_api_fix$modifyTotalArmor(float totalArmor) {
        LivingEntity instance = (LivingEntity) (Object) this;
        return totalArmor * (1 - ObscureAPIAttributes.getPenetration(instance));
    }

    @TargetHandler(mixin = "io.github.apace100.apoli.mixin.LivingEntityMixin", name = "modifyArmorApplicance")
    @ModifyArg(method = "@MixinSquared:Handler", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/damagesource/CombatRules;getDamageAfterAbsorb(FFF)F"), index = 2)
    private float obscure_api_fix$modifyToughness(float toughness) {
        LivingEntity instance = (LivingEntity) (Object) this;
        return toughness * (1 - ObscureAPIAttributes.getPenetration(instance));
    }
}
