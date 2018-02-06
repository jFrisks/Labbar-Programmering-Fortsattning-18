package textproc;

import java.util.*;

public class GeneralWordCounter implements TextProcessor{

    private Set<String> exWords;
    private Map<String, Integer> freqMap = new HashMap<String, Integer>();
    Set<Map.Entry<String, Integer>> wordSet = freqMap.entrySet();

    public GeneralWordCounter(Set<String> exWords){
        this.exWords = exWords;
    }

    @Override
    public void process(String w) {
        //If word is
        if(exWords.contains(w));
        else if(freqMap.containsKey(w)){
            freqMap.put(w, freqMap.get(w) + 1);
        }
        else{
            //If not existing already we need to put 0 to prevent form throwing exception
            freqMap.put(w, 1);
        }

    }

    @Override
    public void report() {
        Map<String, Integer> filteredMap = new HashMap<String, Integer>();

        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
        wordList.sort(new WordCountComparator());


        //Sortera ut ord med 200 eller fler förekomster
        for(int i = 0; i < 200; i++){
            System.out.println(wordList.get(i));
        }

        /**
          for(String key: freqMap.keySet()){
            if(freqMap.get(key) >= 200){
                filteredMap.put(key, freqMap.get(key));
            }
        }


        //print
        for(String key: wordList){
            System.out.println(filteredMap.get(key));
        }
        */
        //Gå igenom alla
    }

    public Set<Map.Entry<String, Integer>> getWords(){
        //om ej processad - gör det
        return wordSet;
    }

}
