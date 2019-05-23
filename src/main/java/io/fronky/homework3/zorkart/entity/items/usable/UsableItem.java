package io.fronky.homework3.zorkart.entity.items.usable;

import io.fronky.homework3.zorkart.GameMediator;
import io.fronky.homework3.zorkart.entity.items.Item;

public abstract class UsableItem extends Item {

    public UsableItem(int weight) {
        super(weight);
    }

    public abstract boolean activate(GameMediator gameMediator);

}
