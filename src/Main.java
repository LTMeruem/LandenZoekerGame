import helper.RasterReader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;
import view.start.StartPresenter;
import view.start.StartView;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 to start game or Press 2 to test InvalidRowException");
        int choice = scanner.nextInt();

        if (choice == 1) {
            // TODO: game starts here
            File file = new File("Raster.txt");
            RasterReader myReader = new RasterReader(file);
            ArrayList<String> raster = myReader.readFile();

            Game model = new Game();
            StartView view = new StartView();
            new StartPresenter(model, view, raster);
            Scene scene = new Scene(view);
            scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Press+Start+2P");
            scene.getStylesheets().add("css/main.css");
            primaryStage.sizeToScene();
            primaryStage.setTitle("LandenZoeker");
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.show();
        } else {
            System.out.println("============================");
            System.out.println("============================");
            System.out.println("Trying to read a wrong file");
            File file = new File("Raster met exception.txt");
            RasterReader myReader = new RasterReader(file);
            myReader.readFile();
        }
    }
}
