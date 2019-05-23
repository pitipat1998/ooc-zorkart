package io.fronky.homework3.zorkart.map;

import io.fronky.homework3.zorkart.entity.character.Monster;
import io.fronky.homework3.zorkart.entity.items.Item;

public class Room {

    private Monster monster = null;
    private Item item = null;
    private boolean isWall;
    private boolean isLocked;

    public Room(boolean isWall){
        this.isWall = isWall;
        this.isLocked = false;
    }

    public boolean isWall(){
        return isWall;
    }

    public boolean isLocked(){
        return isLocked;
    }

    public void setLocked(boolean locked){
        this.isLocked = locked;
    }

    public void setMonster(Monster monster){
        if (isWall) return;
        this.monster = monster;
    }

    public Monster getMonster(){
        return monster;
    }

    public void setItem(Item item) {
        if (isWall) return;
        if(this.item == null || item == null){
            this.item = item;
        }
    }

    public Item getItem(){
        return item;
    }

    public void showStatus(){
        if(monster != null){
            monster.examine();
        }
        if(item != null){
            item.examine();
        }
    }

}
