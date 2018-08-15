package helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SolutionReader  {

    private File file;

    public SolutionReader(File file){
        this.file = file;
    }

    public ArrayList<String> readFile(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.file));
            String st;
            ArrayList<String> allChars = new ArrayList<>();
            while ((st = br.readLine()) != null) {
                allChars.add(st);
            }
            return allChars;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return new ArrayList<>();
    }
}
