package be.maxgaj.cm.rowdyracers.domain.items.light_grenades;

import be.maxgaj.cm.rowdyracers.domain.items.Pickable;
import be.maxgaj.cm.rowdyracers.domain.players.Player;

public class PickableLightGrenade extends LightGrenade implements Pickable {
    @Override
    public void pick(Player player) {
        player.getCurrentPosition().removeItem();
        player.addToInvertory(new UsableLightGrenade());
    }
}
