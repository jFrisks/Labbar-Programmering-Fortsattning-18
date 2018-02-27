package sudoku;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;


public class SudokuApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        HBox root = addBoardToRoot();
        Scene scene = new Scene(root, 440, 400);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Sudoku");
        primaryStage.show();
    }


    private static HBox addBoardToRoot() {
        final int tilepaneSize = 140;
        final int textFieldSize = 40;
        HBox hbox = new HBox();

        for(int y = 0; y < 3; y++){
            for(int x = 0; x < 3; x++) {
                TilePane tilepane = new TilePane();
                tilepane.setPrefSize(tilepaneSize, tilepaneSize);
                tilepane.setPrefColumns(9);
                tilepane.setPrefRows(9);

                //9 x 9 one hbox
                for(int j = 0; j<3; j++){
                    for(int i = 0; i<3; i++) {
                        TextField textfield = new TextField();
                        textfield.setPrefHeight(textFieldSize);
                        textfield.setPrefWidth(textFieldSize);
                        tilepane.getChildren().add(textfield);
                        //label är matrixens innehåll
                        //ändra färgen och kantlinje
                    }
                }

                hbox.getChildren().add(tilepane);
            }
        }
        return hbox;
    }
}
