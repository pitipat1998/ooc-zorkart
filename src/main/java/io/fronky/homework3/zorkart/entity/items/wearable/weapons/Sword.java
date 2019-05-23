package io.fronky.homework3.zorkart.entity.items.wearable.weapons;

public class Sword extends Weapon {
    public Sword() {
        super(5, 5);
    }

    @Override
    public void examine() {
        System.out.printf("Sword: \n" +
                "   ATK: %d\n" +
                "   WEIGHT: %d\n",
                getAtk(),
                getWeight()
        );
    }

}
