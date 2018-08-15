package helper;

import exceptions.InvalidRowException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RasterReader {

    private File file;

    public RasterReader(File file){
        this.file = file;
    }

    public ArrayList<String> readFile(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.file));
            String st;
            ArrayList<String> allChars = new ArrayList<>();
            while ((st = br.readLine()) != null) {
                if (st.length() < 12) {
                    throw new InvalidRowException("Aantal letters per rij zijn niet gelijk aan 12");
                } else {
                    allChars.add(st);
                }
            }
            return allChars;
        } catch (IOException | InvalidRowException e) {
            System.err.println(e.getMessage());
        }

        return new ArrayList<>();
    }
}
