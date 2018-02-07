
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
public class MultiWordCounter implements TextProcessor {

Map<String, Integer> FreqMap = new TreeMap<String, Integer>();
	
	public MultiWordCounter(String[] words){
		
		for(String w : words){
			FreqMap.put(w, 0);	
			
			}
		}
	
	
	@Override
	public void process(String w) {
			for(String key : FreqMap.keySet()){
				if(w.equals(key)){
					FreqMap.put(key, FreqMap.get(key) +1);
							
				}
			}
		
	}

	@Override
	public void report() {
		for(String k : FreqMap.keySet()){
			System.out.println(k + ": " + FreqMap.get(k));
		}
		
		
		
	}
	
}
