package view.start;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class StartPopup extends BorderPane {
    private VBox vBox;
    private Label lblTitel;
    private TextField txtNaam;
    private Button btnAdd;

    public StartPopup() {
        initialiseNodes();
        layoutNodes();

    }

    public void initialiseNodes(){
        vBox = new VBox();
        lblTitel = new Label("Player");
        txtNaam = new TextField();
        btnAdd = new Button("Add");
    }

    public void layoutNodes() {
        this.setPrefSize(300,200);
        lblTitel.getStyleClass().addAll("lblTitel");
        lblTitel.getStyleClass().addAll("btnStart");
        txtNaam.setMaxWidth(150);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        vBox.getChildren().addAll(lblTitel, txtNaam, btnAdd);
        this.setCenter(vBox);
    }

    public Label getLblTitel() {
        return lblTitel;
    }

    public TextField getTxtNaam() {
        return txtNaam;
    }

    public Button getBtnAdd() {
        return btnAdd;
    }
}
