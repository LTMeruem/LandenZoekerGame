package view.start.game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import model.Game;
import view.start.StartPresenter;
import view.start.StartView;

import java.util.ArrayList;


public class GamePresenter {

    private Game game;
    private GameView view;

    public GamePresenter(Game game, GameView view, ArrayList<String> raster){
        this.view = view;
        this.game = game;
        initialisePlayer();
        addEventHandlers();
        view.fillGrid(game.getGrid(), raster);
    }

    private void initialisePlayer(){
        HBox hBox1 = new HBox();
        hBox1.setSpacing(10);
        Label playerNaam = new Label();
        playerNaam.setText(game.getPlayers().get(0).getNaam());
        playerNaam.getStyleClass().addAll("lblPlayernaam");

        hBox1.getChildren().addAll(playerNaam);
        view.getvBox().getChildren().add(hBox1);
    }

    private void addEventHandlers(){
        view.getMiQuit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StartView startView = new StartView();
                StartPresenter startPresenter = new StartPresenter(game, startView, new ArrayList<String>());
                view.getScene().setRoot(startView);
            }
        });
    }

}
