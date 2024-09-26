package de.cadentem.obscure_api_fix.mixin;

import com.obscuria.obscureapi.registry.ObscureAPIAttributes;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @ModifyArg(method = "getDamageAfterArmorAbsorb", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/damagesource/CombatRules;getDamageAfterAbsorb(FFF)F"), index = 1)
    private float obscure_api_fix$modifyTotalArmor(float totalArmor) {
        LivingEntity instance = (LivingEntity) (Object) this;
        return totalArmor * (1 - ObscureAPIAttributes.getPenetration(instance));
    }

    @ModifyArg(method = "getDamageAfterArmorAbsorb", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/damagesource/CombatRules;getDamageAfterAbsorb(FFF)F"), index = 2)
    private float obscure_api_fix$modifyToughness(float toughness) {
        LivingEntity instance = (LivingEntity) (Object) this;
        return toughness * (1 - ObscureAPIAttributes.getPenetration(instance));
    }
}
