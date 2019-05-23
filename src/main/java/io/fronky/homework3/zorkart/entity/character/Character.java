package io.fronky.homework3.zorkart.entity.character;

import io.fronky.homework3.zorkart.entity.Entity;

import java.util.Random;

public abstract class Character implements Entity {

    private int hp;
    private int atk;
    private int armor;
    protected Random rand;

    protected Character(){
        rand = new Random();
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public abstract int reduceHp(int atk);

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public boolean isAlive(){
        return hp != 0;
    }

    @Override
    public boolean isActive() {
        return isAlive();
    }

    public abstract int attack(Character character);

}
