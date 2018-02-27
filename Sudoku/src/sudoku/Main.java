package sudoku;

import javafx.stage.Stage;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SudokuApp app = new SudokuApp();
        Stage primaryStage = new Stage();

        app.start(primaryStage);
    }
}
