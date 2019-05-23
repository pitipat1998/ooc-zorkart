package io.fronky.homework3.zorkart.entity.items.usable.potions;

public class SmallHpPotion extends HpPotion {

    private static final int REGEN = 5;
    private static final int WEIGHT = 1;

    public SmallHpPotion() {
        super(1, REGEN);
    }

    @Override
    public void examine() {
        System.out.printf("HP Potion: \n" +
                "   REGENERATION: %d\n" +
                "   WEIGHT: %d\n",
                REGEN,
                WEIGHT
        );
    }
}
