package be.maxgaj.cm.rowdyracers.domain.players.inventories;

import be.maxgaj.cm.rowdyracers.domain.items.Usable;

public interface Inventory {
    boolean addItem(Usable item);
    boolean removeItem(Usable item);
}
