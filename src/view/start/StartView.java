package view.start;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;


public class StartView extends BorderPane {
    private VBox vBox;
    private Button btnStartGame;
    private Button btnSpeler;

    public StartView(){
        initialiseNodes();
        layoutNodes();
    }


    public void initialiseNodes(){
        vBox = new VBox();

        btnStartGame = new Button("Start Game");
        btnSpeler = new Button("Player");

    }

    public void layoutNodes(){
        this.setPrefSize(900, 600);

        btnStartGame.setPrefSize(200, 60);
        btnStartGame.setDisable(true);
        btnStartGame.getStyleClass().addAll("btnStartGame");

        btnSpeler.setPrefSize(100, 30);
        btnSpeler.getStyleClass().addAll("btnSpeler");

        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(btnStartGame, btnSpeler);

        this.setCenter(vBox);

        this.setBackground(new Background(new BackgroundImage(new Image("rsz_1maxresdefault.jpg"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT
        )));
    }

    public Button getBtnStartGame(){
        return btnStartGame;
    }

    public Button getBtnSpeler(){
        return btnSpeler;
    }
}
