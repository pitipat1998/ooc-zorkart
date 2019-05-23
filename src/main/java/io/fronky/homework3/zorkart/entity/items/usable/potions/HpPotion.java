package io.fronky.homework3.zorkart.entity.items.usable.potions;

import io.fronky.homework3.zorkart.GameMediator;
import io.fronky.homework3.zorkart.entity.character.Player;
import io.fronky.homework3.zorkart.entity.items.usable.UsableItem;

public abstract class HpPotion extends UsableItem {

    private int regen;

    public HpPotion(int weight, int regen) {
        super(weight);
        this.regen = regen;
    }

    @Override
    public boolean activate(GameMediator gameMediator) {
        Player player = gameMediator.getCurrentLevel().getPlayer();
        player.regenHp(regen);
        System.out.println("heal player by " + regen + " units");
        player.removeItem(this);
        return true;
    }
}
