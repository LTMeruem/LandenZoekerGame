package view.start;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;
import model.Player;
import view.start.game.GamePresenter;
import view.start.game.GameView;

import java.io.File;
import java.util.ArrayList;

public class StartPresenter {

    private Game game;
    private StartView view;
    private StartPopup popup;
    private ArrayList<String> raster;

    public StartPresenter(Game game, StartView view, ArrayList<String> raster) {
        this.view = view;
        this.game = game;
        this.raster = raster;
        addEventHandlers();

    }

    private void addEventHandlers() {
        view.getBtnStartGame().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                game.startGame();
                GameView gameView = new GameView();
                new GamePresenter(game, gameView, raster);
                view.getScene().setRoot(gameView);
            }
        });

        view.getBtnSpeler().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                popup = new StartPopup();
                Scene scene = new Scene(popup);
                scene.getStylesheets().add("css/main.css");
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Add your PlayerName");
                stage.setResizable(false);
                stage.show();

                popup.getBtnAdd().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        Player player = new Player(popup.getTxtNaam().getText());
                        popup.getTxtNaam().setText("");
                        game.addPlayer(player);

                        view.getBtnStartGame().setDisable(false);
                        stage.close();

                    }
                });

            }

        }

        );
    }
}
