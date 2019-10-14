package be.maxgaj.cm.rowdyracers.domain.players.player_managers;

import be.maxgaj.cm.rowdyracers.domain.grid.Grid;
import be.maxgaj.cm.rowdyracers.domain.players.Player;

public interface PlayerManager {
    void placePlayers(Grid grid);
    Player getActivePlayer();
    Player nextPlayer();

}
