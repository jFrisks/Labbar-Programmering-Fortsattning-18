package textproc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class BookReaderController extends Application {

    public static Set<String> exWords = new HashSet<String>();
    public static Set<String> words = new HashSet<String>();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();



        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("BookReader - MUDDAFUKKAS");
        primaryStage.setScene(scene);
        primaryStage.show();

        //Läs ut en mängd med alla ord och antal (general word counter)
            //läsa in holgersson (som holgessonfil)
            //Läsa in med genwordcount
            //spara ner


        //Skapa Observable till en variabel

        //skapa listview objeckt

    }

    public void read(){

        /****----------------------****/
        //läs in undantagsorden
        Scanner s2 = new Scanner(new File("undantagsord.txt"));

        while (s2.hasNext()) {
            String word = s2.next().toLowerCase();
            exWords.add(word);
        }
        s2.close();
        /****----------------------****/

        //skapa skit
        ArrayList<TextProcessor> list = new ArrayList<TextProcessor>();
        //Textproccessor
        TextProcessor general = new GeneralWordCounter(exWords);

        //add them to the list with all different missions
        list.add(general);

        //LÄs in nilsholge
        Scanner s1 = new Scanner(new File("nilsholg.txt"));
        s1.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

        while (s1.hasNext()) {
            String word = s1.next().toLowerCase();

            //Gå igeno alla processors
            for(TextProcessor tp: list){
                tp.process(word);
            }

        }
        s1.close();


        //Report all in list
        for(TextProcessor tp: list){
            tp.report();
        }
    }
}
