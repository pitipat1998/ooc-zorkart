package io.fronky.homework3.zorkart.entity.items.wearable.weapons;

import io.fronky.homework3.zorkart.entity.items.wearable.WearableItem;

public abstract class Weapon extends WearableItem{

    private int atk;

    public Weapon(int weight, int atk) {
        super(weight);
        this.atk = atk;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }
}
