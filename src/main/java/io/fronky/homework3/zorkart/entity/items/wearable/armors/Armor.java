package io.fronky.homework3.zorkart.entity.items.wearable.armors;

import io.fronky.homework3.zorkart.entity.items.wearable.WearableItem;

public abstract class Armor extends WearableItem{

    private int armor;

    protected Armor(int weight, int armor) {
        super(weight);
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
