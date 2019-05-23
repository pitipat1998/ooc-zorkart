package io.fronky.homework3.zorkart.entity.items.usable.potions;

public class BigHpPotion extends HpPotion {

    private static final int REGEN = 10;
    private static final int WEIGHT = 2;

    public BigHpPotion() {
        super(WEIGHT, REGEN);
    }

    @Override
    public void examine() {
        System.out.printf("Big HP Potion: \n" +
                "   REGENERATION: %d\n" +
                "   WEIGHT: %d\n",
                REGEN,
                WEIGHT
        );
    }

}
