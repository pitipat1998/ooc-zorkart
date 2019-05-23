package io.fronky.homework3.zorkart.entity.items.wearable.armors;

public class AssaultCuirass extends Armor {

    public AssaultCuirass() {
        super(10, 15);
    }

    @Override
    public void examine() {
        System.out.printf("Assault Cuirass: \n" +
                "   ARMOR: %d\n" +
                "   WEIGHT: %d\n",
                getArmor(),
                getWeight()
        );
    }

}
