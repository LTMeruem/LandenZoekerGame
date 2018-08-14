package view.start.game;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.Grid;

import java.io.File;

public class GameView extends BorderPane {

    private MenuItem miAbout, miQuit;
    private GridPane gpBoard;
    private Label lblCell, lblPlayernaam;
    private VBox vBox;
    private HBox hBox;
    private BorderPane borderPane;
    private int cellNumber;
    private int teller = 0;
    File file = new File("roosterInhoud/oplossingen.txt");


    public GameView() {
        initialiseNodes();
        layoutNodes();

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
        this.setPrefSize(900,600);

        Menu mnHelp = new Menu("Options");
        mnHelp.getItems().addAll(miAbout, miQuit);
        MenuBar menuBar = new MenuBar(mnHelp);

        this.setStyle("-fx-background-color: #a0c8b9");

        this.setCenter(gpBoard);
        this.setTop(menuBar);
    }

    public void fillGrid(Grid grid) {
        /*for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getColumns(); j++) {
                cellNumber = grid.getCells()[i][j].getCellNumber();
                lblCell = new Label(String.valueOf(cellNumber));
                lblCell.setPrefSize(50, 50);
                lblCell.setStyle("-fx-font-weight: bold");
                lblCell.setAlignment(Pos.CENTER);
                gpBoard.add(lblCell, j, i);
            }
        }*/
        gpBoard.addRow(0, new Label("1"), new Label("2"), new Label("3"), new Label("3"), new Label("1"), new Label("2"), new Label("3"), new Label("3"), new Label("1"), new Label("2"), new Label("3"), new Label("3"));
        gpBoard.addRow(1, new Label("1"), new Label("2"), new Label("3"), new Label("3"), new Label("1"), new Label("2"), new Label("3"), new Label("3"), new Label("1"), new Label("2"), new Label("3"), new Label("3"));
        gpBoard.addRow(2, new Label("1"), new Label("2"), new Label("3"), new Label("3"), new Label("1"), new Label("2"), new Label("3"), new Label("3"), new Label("1"), new Label("2"), new Label("3"), new Label("3"));
        gpBoard.addRow(3, new Label("1"), new Label("2"), new Label("3"), new Label("3"), new Label("1"), new Label("2"), new Label("3"), new Label("3"), new Label("1"), new Label("2"), new Label("3"), new Label("3"));
        gpBoard.addRow(4, new Label("1"), new Label("2"), new Label("3"), new Label("3"), new Label("1"), new Label("2"), new Label("3"), new Label("3"), new Label("1"), new Label("2"), new Label("3"), new Label("3"));
        gpBoard.addRow(5, new Label("1"), new Label("2"), new Label("3"), new Label("3"), new Label("1"), new Label("2"), new Label("3"), new Label("3"), new Label("1"), new Label("2"), new Label("3"), new Label("3"));
        gpBoard.addRow(6, new Label("1"), new Label("2"), new Label("3"), new Label("3"), new Label("1"), new Label("2"), new Label("3"), new Label("3"), new Label("1"), new Label("2"), new Label("3"), new Label("3"));
        gpBoard.addRow(7, new Label("1"), new Label("2"), new Label("3"), new Label("3"), new Label("1"), new Label("2"), new Label("3"), new Label("3"), new Label("1"), new Label("2"), new Label("3"), new Label("3"));

        for (Node n: gpBoard.getChildren()) {
            if (n instanceof Control) {
                Control control = (Control) n;
                control.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                control.setStyle("-fx-background-color: cornsilk; -fx-alignment: center;");
                control.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getClickCount() == 2 && teller < 17){

                            teller++;
                        }else if (){

                        }else if (event.getClickCount() == 2 && teller == 17){

                        }else if (){

                        }else {
                            control.setStyle("-fx-background-color: gray; -fx-alignment: center;");
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
        //gpBoard.setGridLinesVisible(true);

        ColumnConstraints oneThird = new ColumnConstraints();
        oneThird.setPercentWidth(100/3.0);
        oneThird.setHalignment(HPos.CENTER);
        gpBoard.getColumnConstraints().addAll(oneThird, oneThird, oneThird, oneThird, oneThird, oneThird, oneThird, oneThird, oneThird, oneThird, oneThird, oneThird);

        RowConstraints oneHalf = new RowConstraints();
        oneHalf.setPercentHeight(100/2.0);
        oneHalf.setValignment(VPos.CENTER);
        gpBoard.getRowConstraints().addAll(oneHalf, oneHalf, oneHalf, oneHalf, oneHalf, oneHalf, oneHalf, oneHalf);

    }

    public MenuItem getMiAbout(){return miAbout;}

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
