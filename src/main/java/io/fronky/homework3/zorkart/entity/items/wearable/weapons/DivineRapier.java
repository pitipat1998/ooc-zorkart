package io.fronky.homework3.zorkart.entity.items.wearable.weapons;

public class DivineRapier extends Weapon {

    public DivineRapier() {
        super(7, 15);
    }

    @Override
    public void examine() {
        System.out.printf("Divine Rapier: \n" +
                "   ATK: %d\n" +
                "   WEIGHT: %d\n",
                getAtk(),
                getWeight()
        );
    }

}
