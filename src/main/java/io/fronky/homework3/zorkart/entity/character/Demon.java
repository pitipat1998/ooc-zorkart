package io.fronky.homework3.zorkart.entity.character;

public class Demon extends Monster {

    private static final int DEMON_HP = 150;
    private static final int DEMON_ATK = 40;
    private static final int DEMON_ARMOR = 20;
    private static final double EVASION = 0.3;

    public Demon(){
        setHp(DEMON_HP);
        setArmor(DEMON_ARMOR);
        setAtk(DEMON_ATK);
    }

    @Override
    public double getEvasion(){
        return EVASION;
    }

    @Override
    public void examine() {
        System.out.printf("Demon: \n" +
                "   HP: %d/%d\n" +
                "   ARMOR: %d\n" +
                "   ATK: %d\n",
                getHp(), DEMON_HP,
                getArmor(),
                getAtk()
        );
    }

}
