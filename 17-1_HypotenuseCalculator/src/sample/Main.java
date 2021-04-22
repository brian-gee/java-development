package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    TextField sideA = new TextField();
    TextField sideB = new TextField();
    TextField sideC = new TextField();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Future Value Calculator");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(10);
        grid.setVgap(10);

        Scene scene = new Scene(grid);

        grid.add(new Label("Side A:"), 0, 0);
        sideA = new TextField();
        grid.add(sideA, 1, 0);

        grid.add(new Label("Side B:"), 0, 1);
        sideB = new TextField();
        grid.add(sideB, 1, 1);

        grid.add(new Label("Side C:"), 0, 2);
        sideC = new TextField();
        grid.add(sideC, 1, 2);


        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(event -> calculateButtonClicked());

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> exitButtonClicked());

        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().add(calculateButton);
        buttonBox.getChildren().add(exitButton);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        grid.add(buttonBox, 0, 4, 2, 1);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateButtonClicked() {
        Validation v = new Validation();
        String errorMsg = "";
        errorMsg += v.isDouble(sideA.getText(),
                "Side A");
        errorMsg += v.isDouble(sideB.getText(),
                "Side B");

        if (errorMsg.isEmpty()) {
            Double a = Double.parseDouble(
                    sideA.getText());
            Double b = Double.parseDouble(
                    sideB.getText());

            double c = Calculations.calculateHypotenuse(
                    a, b);

            sideC.setText(String.valueOf(c));
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Data");
            alert.setContentText(errorMsg);
            alert.showAndWait();
        }
    }

    private void exitButtonClicked() {
        System.exit(0);   // 0 indicates a normal exit
    }



    public static void main(String[] args) {
        launch(args);
    }
}