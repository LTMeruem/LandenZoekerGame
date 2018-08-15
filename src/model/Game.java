package model;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Grid grid = new Grid(8, 12);
    private List<Player> players = new ArrayList<>();

    public Game(){

    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void startGame() {
        grid = new Grid(8, 12);
    }

    public Grid getGrid() {
        return grid;
    }

    public List<Player> getPlayers() {
        return players;
    }

}
