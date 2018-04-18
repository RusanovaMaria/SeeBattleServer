package domain;

import domain.cage.Cage;

import java.util.Map;

public class GameAction {

    private Cage.ClassicGame game;
    private Map<Player, PlayingField> players;

    public GameAction (Cage.ClassicGame game) {

        this.game = game;
        players = game.getPlayers();
    }

    public void fire(Player player, Cage cage) {
        cage.mark();
    }

    public void determineHit() {

    }
}
