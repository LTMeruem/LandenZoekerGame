package view.start.game;

import game.GameResolver;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import model.Grid;

import java.util.ArrayList;

public class GameView extends BorderPane {

    private MenuItem miAbout, miQuit;
    private GridPane gpBoard;
    private Label lblCell, lblPlayernaam;
    private VBox vBox;
    private HBox hBox;
    private BorderPane borderPane;
    private ArrayList<Label> clickedLabels;
    private GameResolver gameResolver;
    public GameView() {
        initialiseNodes();
        layoutNodes();
        this.clickedLabels = new ArrayList<Label>();
        this.gameResolver = new GameResolver();
    }

    public void initialiseNodes() {
        miAbout = new MenuItem("About");
        miQuit = new MenuItem("Quit");
        gpBoard = new GridPane();
        vBox = new VBox();
        lblCell = new Label();
        borderPane = new BorderPane();
    }

    public void layoutNodes() {
        this.setPrefSize(900, 600);

        Menu mnHelp = new Menu("Options");
        mnHelp.getItems().addAll(miAbout, miQuit);
        MenuBar menuBar = new MenuBar(mnHelp);

        this.setStyle("-fx-background-color: #a0c8b9");

        this.setCenter(gpBoard);
        this.setTop(menuBar);
    }

    public void fillGrid(Grid grid, ArrayList<String> raster) {

        raster.forEach((stringRaster) -> {
            char[] characters = stringRaster.toCharArray();
            // create array of labels with char length
            Label[] labels = new Label[characters.length];
            for (int i = 0; i < characters.length; i++) {
                // create a label for each character
                labels[i] = new Label("" + characters[i]);
            }
            gpBoard.addRow(raster.indexOf(stringRaster), labels);
        });


        for (Node n : gpBoard.getChildren()) {
            if (n instanceof Label) {
                Label label = (Label) n;
                label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                setControlColor(label, "cornsilk");
                label.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getClickCount() == 2) {
                            // TODO: moet groen worden als die in de oplossing.txt steekt

                            if(!labelExists(label)){
                                clickedLabels.add(label);
                            }
                            final String[] country = {""};
                            clickedLabels.forEach((label) -> {
                                country[0] += label.getText();
                            });
                            System.out.println(gameResolver.checkCountryIsValid(country[0]));
                            System.out.println(clickedLabels);

                            if(gameResolver.checkCountryIsValid(country[0])){
                                clickedLabels.forEach((label) -> {
                                    setControlColor(label, "#3a801d");
                                });
                            } else {
                                clickedLabels.forEach((label) -> {
                                    setControlColor(label, "cornsilk");
                                });
                            }
                        } else {
                            if (label.getStyle().contains("cornsilk")) {
                                if(!labelExists(label)){
                                    setControlColor(label, "gray");
                                    clickedLabels.add(label);
                                }
                            } else {
                                if(labelExists(label)){
                                    setControlColor(label, "cornsilk");
                                    clickedLabels.remove(label);
                                }
                            }
                        }

                    }
                });
            }
            if (n instanceof Pane) {
                Pane pane = (Pane) n;
                pane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                pane.setStyle("-fx-background-color: cornsilk; -fx-alignment: center;");
            }
        }

        gpBoard.setStyle("-fx-background-color: palegreen;  -fx-padding: 5; -fx-hgap: 5; -fx-vgap: 5;");
        gpBoard.setSnapToPixel(false);
        // gpBoard.setGridLinesVisible(true);

        ColumnConstraints oneThird = new ColumnConstraints();
        oneThird.setPercentWidth(100 / 3.0);
        oneThird.setHalignment(HPos.CENTER);
        gpBoard.getColumnConstraints().addAll(oneThird, oneThird, oneThird, oneThird, oneThird, oneThird, oneThird,
                oneThird, oneThird, oneThird, oneThird, oneThird);

        RowConstraints oneHalf = new RowConstraints();
        oneHalf.setPercentHeight(100 / 2.0);
        oneHalf.setValignment(VPos.CENTER);
        gpBoard.getRowConstraints().addAll(oneHalf, oneHalf, oneHalf, oneHalf, oneHalf, oneHalf, oneHalf, oneHalf);

    }

    private void setControlColor(Control control, String color){
        control.setStyle("-fx-background-color:" + color +"; -fx-alignment: center;");
    }

    public boolean labelExists(Label label){
        return this.clickedLabels.indexOf(label) > -1;
    }

    public MenuItem getMiAbout() {
        return miAbout;
    }

    public GridPane getGpBoard() {
        return gpBoard;
    }

    public VBox getvBox() {
        return vBox;
    }

    public MenuItem getMiQuit() {
        return miQuit;
    }
}
