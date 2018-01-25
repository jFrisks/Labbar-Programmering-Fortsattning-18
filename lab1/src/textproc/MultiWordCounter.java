package textproc;

import java.util.HashMap;
import java.util.Map;

public class MultiWordCounter implements TextProcessor{

    private Map<String,Integer> freqMap = new HashMap<String, Integer>();


    public MultiWordCounter(String[] words){
        for(String word: words){
            freqMap.put(word, 0);
        }
    }

    @Override
    public void process(String w) {
        //loopa genom hela mapens keys
            for (String key : freqMap.keySet()) {
                //Add one to value of key if same
                if(w.equals(key)) {
                    freqMap.put(key, freqMap.get(key) + 1);
                }
            }
    }

    @Override
    public void report() {
        for(String key: freqMap.keySet()){
            System.out.println(key + ": " + freqMap.get(key));
        }
    }


}
