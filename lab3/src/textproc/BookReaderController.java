
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class BookReaderController extends Application {
	Button searchButton;
	Boolean cond = false;
	TextField textField;
	ObservableList<Map.Entry<String, Integer>> observableList;
	ObservableList<Map.Entry<String, Integer>> alphabetic;
	ObservableList<Map.Entry<String, Integer>> frequency;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane root = new BorderPane();
		HBox hbox = new HBox();
		Scene scene = new Scene(root, 500, 500);
		primaryStage.setTitle("BookReader");
		primaryStage.setScene(scene);
		primaryStage.show();
		Button alphaButton = new Button("Alphabetic");
		Button freqButton = new Button("Frequency");
		searchButton = new Button("Search");
		textField = new TextField ();
	
		root.setBottom(hbox);
		hbox.getChildren().addAll(alphaButton, freqButton, textField, searchButton );

		Set<String> allUWords = new HashSet<String>();
		Scanner su = new Scanner(new File("undantagsord.txt"));

		while (su.hasNext()) {
			String word = su.next().toLowerCase();
			allUWords.add(word);
		}

		GeneralWordCounter words = new GeneralWordCounter(allUWords);
		su.close();

		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			words.process(word);

		}
		s.close();
		System.out.println(words.getWords());	
		observableList = FXCollections.observableArrayList(words.getWords());
		frequency = observableList;
		alphabetic = FXCollections.observableArrayList(words.getWords());
		frequency.sort(new WordCountComparator());
		ListView listView = new ListView(observableList);

		root.setCenter(listView);

		alphaButton.setOnAction(event -> {
			cond = false;
			listView.setItems(alphabetic);
		});
		freqButton.setOnAction(event -> {
			cond = true;
			listView.setItems(frequency);
		});
		searchButton.setOnAction(event -> {
			
			int index = searchIndex(textField.getText());
			System.out.println(index);
			listView.scrollTo(index);
			
		});
		
	}
	
	
	
	
	public int searchIndex(String input){
		if(cond == true){
			for(int i = 0; i< observableList.size(); i++){
				if(observableList.get(i).getKey().equals(input)){
					return i;	
				}
			
			}	
		}
		
		if(cond == false){
		for(int i = 0; i< alphabetic.size(); i++){
			if(alphabetic.get(i).getKey().equals(input)){
				return i;	
			}
		}

		}
		
		return -1;
	}

	public static void main(String[] args) {

		Application.launch(args);
	}

}
