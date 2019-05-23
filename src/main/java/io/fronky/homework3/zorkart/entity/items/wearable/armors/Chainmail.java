package io.fronky.homework3.zorkart.entity.items.wearable.armors;

public class Chainmail extends Armor{

    public Chainmail() {
        super(6, 5);
    }

    @Override
    public void examine() {
        System.out.printf("Chainmail: \n" +
                "   ARMOR: %d\n" +
                "   WEIGHT: %d\n",
                getArmor(),
                getWeight()
        );
    }
}
