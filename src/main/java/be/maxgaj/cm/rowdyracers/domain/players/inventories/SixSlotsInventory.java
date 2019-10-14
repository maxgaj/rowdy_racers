package be.maxgaj.cm.rowdyracers.domain.players.inventories;

import be.maxgaj.cm.rowdyracers.domain.items.Usable;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SixSlotsInventory implements Inventory {
    private static final int MAX_ITEM = 6;
    private final Deque<Usable> items;

    public SixSlotsInventory() {
        items = new ArrayDeque<>();
    }

    @Override
    public boolean addItem(Usable item){
        if (items.size()  >= MAX_ITEM){
            return false;
        }
        return items.add(item);
    }

    @Override
    public boolean removeItem(Usable item){
        return items.remove(item);
    }


}
