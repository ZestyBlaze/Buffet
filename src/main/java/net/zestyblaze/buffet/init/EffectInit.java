package net.zestyblaze.buffet.init;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zestyblaze.buffet.Buffet;
import net.zestyblaze.buffet.effect.BleedingEffect;

public class EffectInit {

    public static final StatusEffect Bleeding = new BleedingEffect();

    public static void register() {
        Registry.register(Registry.STATUS_EFFECT, new Identifier(Buffet.MODID, "bleeding"), Bleeding);
    }

}
