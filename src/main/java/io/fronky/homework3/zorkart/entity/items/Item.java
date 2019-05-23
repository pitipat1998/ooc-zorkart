package io.fronky.homework3.zorkart.entity.items;

import io.fronky.homework3.zorkart.entity.Entity;

public abstract class Item implements Entity {

    private int weight;
    private boolean isActive;

    protected Item(int weight){
        this.weight = weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

}
