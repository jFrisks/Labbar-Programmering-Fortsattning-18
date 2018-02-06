package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static Set<String> exWords = new HashSet<String>();

	public static void main(String[] args) throws FileNotFoundException {
	    long t0 = System.nanoTime();

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
        TextProcessor landskap = new MultiWordCounter(REGIONS);
        TextProcessor general = new GeneralWordCounter(exWords);

        //add them
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
            landskap.process(word);

		}
		s1.close();


		//Report all in list
        landskap.report();
        for(TextProcessor tp: list){
            tp.report();
        }

        long t1 = System.nanoTime();
        System.out.println("tid: " + (t1-t0) / 1000000.0 + " ms");
	}
}