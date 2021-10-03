package net.zestyblaze.buffet.item.knives;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.zestyblaze.buffet.Buffet;

public record Knife(String name, String modID, Ingredient repairItem,
                    Integer durability, Float damage) implements ToolMaterial {

    public String getName() {
        return this.name;
    }

    public String getModID() {
        return this.modID;
    }

    public Ingredient getRepairItem() {
        return this.repairItem;
    }

    @Override
    public int getDurability() {
        return this.durability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
    }

    @Override
    public float getAttackDamage() {
        return this.damage;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairItem;
    }

    public static class KnifeBuilder {
        private String name;
        private String modID = Buffet.MOD_ID;
        private Ingredient repairItem;

        private Integer durability;
        private Float damage;

        KnifeBuilder() {
        }

        public KnifeBuilder(String name) {
            this.name = name;
        }

        public KnifeBuilder setModId(String modID) {
            this.modID = modID;
            return this;
        }

        public KnifeBuilder setRepairItem(Ingredient repairItem) {
            this.repairItem = repairItem;
            return this;
        }

        public KnifeBuilder setDurability(Integer durability) {
            this.durability = durability;
            return this;
        }

        public KnifeBuilder setDamage(Float damage) {
            this.damage = damage;
            return this;
        }

        public Knife build() {
            return new Knife(this.name, this.modID, this.repairItem, this.durability, this.damage);
        }
    }

}
