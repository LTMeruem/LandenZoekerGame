package game;

import helper.SolutionReader;

import java.io.File;
import java.util.ArrayList;

public class GameResolver {

    private File file;
    private ArrayList<String> countries;

    public GameResolver() {
        this.initResolver();
    }

    public void initResolver(){
        this.file = new File("Oplossingen.txt");
        SolutionReader myReader = new SolutionReader(this.file);
        this.countries = myReader.readFile();
    }

    public boolean checkCountryIsValid(String country){
        return this.countries.contains(country);
    }
}
