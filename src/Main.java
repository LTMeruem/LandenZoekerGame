import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;
import view.start.StartPresenter;
import view.start.StartView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Game model = new Game();
        StartView view = new StartView();
        StartPresenter pres = new StartPresenter(model, view);
        Scene scene = new Scene(view);
        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Press+Start+2P");
        scene.getStylesheets().add("css/main.css");
        primaryStage.sizeToScene();
        primaryStage.setTitle("LandenZoeker");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
