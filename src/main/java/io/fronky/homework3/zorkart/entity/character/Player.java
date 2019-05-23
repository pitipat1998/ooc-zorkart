package io.fronky.homework3.zorkart.entity.character;

import io.fronky.homework3.zorkart.entity.items.Item;
import io.fronky.homework3.zorkart.entity.items.wearable.WearableItem;
import io.fronky.homework3.zorkart.entity.items.wearable.armors.Armor;
import io.fronky.homework3.zorkart.entity.items.wearable.weapons.Weapon;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Player extends Character {

    private static final int PLAYER_HP = 100;
    private static final int PLAYER_ATK = 100;
    private static final int PLAYER_ARMOR = 20;
    private static final int PLAYER_REGEN_RATE = 2;
    private static final double PLAYER_EVASION = 0.2;
    private static final int PLAYER_MAX_WEIGHT = 20;

    private double evasion;
    private List<Item> items;
    private Weapon equippedWeapon;
    private Armor equippedArmor;
    private int holdingWeight;

    public Player(){
        setHp(PLAYER_HP);
        setArmor(PLAYER_ARMOR);
        setAtk(PLAYER_ATK);
        evasion = PLAYER_EVASION;
        items = new ArrayList<>();
        equippedWeapon = null;
        equippedArmor = null;
        holdingWeight = 0;
    }

    public <T extends Item> List<T> getItems(Class<T> itemClass){
        List<T> itemList = new ArrayList<>();
        try{
            for(Item item : items){
                if(itemClass.isAssignableFrom(item.getClass())){
                    itemList.add(itemClass.cast(item));
                }
            }
            return itemList;
        } catch (ClassCastException e){
            return null;
        }
    }

    public void removeItem(Item item){
        if(item == null) return;
        items.remove(item);
        holdingWeight = Math.max(0, holdingWeight-item.getWeight());
    }

    public double getEvasion() {
        return evasion;
    }

    @Override
    public void examine() {
        System.out.printf("Player: \n" +
                "   HP: %d/%d\n" +
                "   ARMOR: %d\n" +
                "   ATK: %d\n" +
                "   REGENERATION RATE: %d\n" +
                "   EVASION: %f\n" +
                "   INVENTORY WEIGHT: %d/%d\n",
                getHp(), PLAYER_HP,
                getArmor(),
                getAtk(),
                PLAYER_REGEN_RATE,
                evasion,
                holdingWeight, PLAYER_MAX_WEIGHT
        );
    }

    @Override
    public int reduceHp(int atk) {
        int dmg = Math.max(0, atk-getArmor());
        setHp(Math.max(0, getHp()-dmg));
        return dmg;
    }

    public void regenHp(int regen){
        setHp(Math.min(PLAYER_HP, getHp()+regen));
    }

    public void regenHp(){
        setHp(Math.min(PLAYER_HP, getHp()+PLAYER_REGEN_RATE));
    }

    @Override
    public int attack(Character character) {
        if(character instanceof Monster){
            Monster monster = (Monster) character;
            double r = rand.nextDouble();
            int dmgDone = 0;
            if(r < 1-monster.getEvasion()){
                dmgDone = monster.reduceHp(getAtk());
            }
            int recDamage = monster.attack(this);
            if(recDamage > 0)
                System.out.println("The monster do " + recDamage + " damage to you");
            return dmgDone;
        }
        return 0;
    }

    public boolean takeItem(Item item){
        if(item == null) return false;
        if(item.getWeight() + holdingWeight < PLAYER_MAX_WEIGHT){
            items.add(item);
            holdingWeight += item.getWeight();
            System.out.println("You have pick up " + item.getClass().getSimpleName());
            return true;
        }
        else{
            System.out.println("Your bag is full");
            return false;
        }
    }

    public Pair<Armor, Weapon> getEquippedItem(){
        return new Pair<>(equippedArmor, equippedWeapon);
    }

    public boolean equipItem(WearableItem item){
        if(item == null){
            System.out.println("specify item to equip");
            return false;
        }
        if(item instanceof Armor){
            Armor armorItem = (Armor) item;
            if(equippedArmor != null){
                unequip(equippedArmor);
            }
            removeItem(armorItem);
            this.equippedArmor = armorItem;
            setArmor(getArmor()+armorItem.getArmor());
            System.out.println("You have equipped " + armorItem.getClass().getSimpleName());
            return true;
        }
        else if (item instanceof Weapon){
            Weapon weaponItem = (Weapon) item;
            if(equippedWeapon != null){
                unequip(equippedWeapon);
            }
            removeItem(weaponItem);
            this.equippedWeapon = weaponItem;
            setAtk(getAtk()+weaponItem.getAtk());
            System.out.println("You have equipped " + weaponItem.getClass().getSimpleName());
            return true;
        }
        System.out.println("you can't equip " + item.getClass().getSimpleName());
        return false;
    }

    public boolean unequip(WearableItem item){
        if(item instanceof Armor){
            if(equippedArmor == null){
                System.out.println("Nothing to unequip");
                return false;
            }
            else if (!equippedArmor.equals(item)){
                System.out.println("You are not equipping this item");
                return false;
            }
            else{
                System.out.println("unequip " + item.getClass().getSimpleName());
                setArmor(getArmor() - equippedArmor.getArmor());
                takeItem(equippedArmor);
                equippedArmor = null;
                return true;
            }
        }
        else if (item instanceof Weapon){
            if(equippedWeapon == null){
                return false;
            }
            else if (!equippedWeapon.equals(item)){
                System.out.println("You are not equipping this item");
                return false;
            }
            else{
                System.out.println("unequip " + item.getClass().getSimpleName());
                setAtk(getAtk()-equippedWeapon.getAtk());
                takeItem(equippedWeapon);
                equippedWeapon = null;
                return true;
            }
        }
        System.out.println(item.getClass().getSimpleName() + " cannot be equipped or unequipped");
        return false;
    }
}
