package be.maxgaj.cm.rowdyracers.domain.players.player_managers;

import be.maxgaj.cm.rowdyracers.domain.grid.Grid;
import be.maxgaj.cm.rowdyracers.domain.players.Player;
import be.maxgaj.cm.rowdyracers.domain.squares.Square;

public class TwoPlayersManager implements PlayerManager {
    private final Player[] players = new Player[2];
    private int activePlayerId;

    public TwoPlayersManager() {
        players[0] = new Player();
        players[1] = new Player();
        activePlayerId = 0;
    }

    @Override
    public void placePlayers(Grid grid) {
        Square firstPlayerPosition = grid.getSquareAtPosition(grid.getNumberOfRows() - 1, 0);
        Square secondPlayerPosition = grid.getSquareAtPosition(0, grid.getNumberOfColumns() - 1);
        players[0].setCurrentPosition(firstPlayerPosition);
        players[0].setFinishPosition(secondPlayerPosition);
        players[1].setCurrentPosition(secondPlayerPosition);
        players[1].setFinishPosition(firstPlayerPosition);
    }

    @Override
    public Player getActivePlayer() {
        return players[activePlayerId];
    }

    @Override
    public Player nextPlayer() {
        activePlayerId = (activePlayerId + 1) % 2;
        return getActivePlayer();
    }
}
