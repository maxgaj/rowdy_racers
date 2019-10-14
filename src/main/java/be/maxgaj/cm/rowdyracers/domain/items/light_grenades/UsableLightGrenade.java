package be.maxgaj.cm.rowdyracers.domain.items.light_grenades;

import be.maxgaj.cm.rowdyracers.domain.items.Usable;
import be.maxgaj.cm.rowdyracers.domain.players.Player;

public class UsableLightGrenade extends LightGrenade implements Usable {
    @Override
    public void use(Player player) {
        player.removeFromInvertory(this);
        player.getCurrentPosition().setActivableItem(new ActivableLightGrenade());

    }
}
