package view.start;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;
import model.Player;
import view.start.game.GamePresenter;
import view.start.game.GameView;

public class StartPresenter {

    private Game game;
    private StartView view;
    private StartPopup popup;

    public StartPresenter(Game game, StartView view){
        this.view = view;
        this.game = game;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getBtnStartGame().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                game.startGame();

                GameView gameView = new GameView();
                GamePresenter gamePresenter = new GamePresenter(game, gameView);
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

    private void updateView(){

    }
}
