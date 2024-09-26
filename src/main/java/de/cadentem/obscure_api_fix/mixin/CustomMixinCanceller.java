package de.cadentem.obscure_api_fix.mixin;

import com.bawnorton.mixinsquared.api.MixinCanceller;

import java.util.List;

public class CustomMixinCanceller implements MixinCanceller {
    @Override
    public boolean shouldCancel(final List<String> targetClassNames, final String mixinClassName) {
        return mixinClassName.equals("com.obscuria.obscureapi.mixin.LivingEntityMixin");
    }
}