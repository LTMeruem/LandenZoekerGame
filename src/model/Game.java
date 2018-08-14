package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Grid grid = new Grid(8, 12);
    private List<Player> players = new ArrayList<>();

    File file = new File("Raster.txt");

    public Game(){

    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void InvalidRowException(){
        /*try {
            BufferedReader ch = new BufferedReader(new FileReader("roosterInhoud/Raster.txt"));
            String lijn =  ch.readLine();
            System.out.print(lijn);
        }catch (IOException e){
            e.printStackTrace();
        }*/
        try {
            Scanner input = new Scanner(file);
            while (input.hasNext()){
                String num = input.nextLine();
            }
        }catch (IOException e){
            System.err.format("File does not exist \n");
        }
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
