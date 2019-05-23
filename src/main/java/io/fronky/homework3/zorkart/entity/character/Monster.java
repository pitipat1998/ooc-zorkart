package io.fronky.homework3.zorkart.entity.character;

import java.util.Random;

public class Monster extends Character {

    private static final int MONSTER_HP = 100;
    private static final int MONSTER_ATK = 20;
    private static final int MONSTER_ARMOR = 10;
    private static final double EVASION = 0;


    public Monster(){
        setHp(MONSTER_HP);
        setArmor(MONSTER_ARMOR);
        setAtk(MONSTER_ATK);
    }

    @Override
    public void examine() {
        System.out.printf("Monster: \n" +
                "   HP: %d/%d\n" +
                "   ARMOR: %d\n" +
                "   ATK: %d\n",
                getHp(), MONSTER_HP,
                getArmor(),
                getAtk()
        );
    }

    public double getEvasion() {
        return EVASION;
    }

    @Override
    public int reduceHp(int atk) {
        int dmg = Math.max(0, atk-getArmor());
        setHp(Math.max(0, getHp()-dmg));
        return dmg;
    }

    @Override
    public int attack(Character character){
        if(character instanceof Player){
            Player player = (Player) character;
            double r = rand.nextDouble();
            if(r < 1-player.getEvasion()){
                int dmgDone = player.reduceHp(getAtk());
                return dmgDone;
            }
            else
                return 0;
        }
        return 0;
    }
}
