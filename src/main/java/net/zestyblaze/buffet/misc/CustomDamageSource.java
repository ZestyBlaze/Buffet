package net.zestyblaze.buffet.misc;

import net.minecraft.entity.damage.DamageSource;

public class CustomDamageSource extends DamageSource {

    public static final CustomDamageSource BLEEDING = (CustomDamageSource) new CustomDamageSource("bleeding").setBypassesArmor();

    private boolean bypassesArmor;
    private float exhaustion = 0.1F;
    public CustomDamageSource(String name) {
        super(name);
    }

    @Override
    public DamageSource setBypassesArmor() {
        this.bypassesArmor = true;
        this.exhaustion = 0.0F;
        return this;
    }
}
