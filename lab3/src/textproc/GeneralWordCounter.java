

import java.util.Set;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
//import java.util.Comparator;
public class GeneralWordCounter implements TextProcessor {
		
		Map<String, Integer> FreqMap = new TreeMap<String, Integer>();
		Map<String, Integer> Map = new TreeMap<String, Integer>();
		Map<String,Integer> Map200 = new TreeMap<String,Integer>();
		Set<Map.Entry<String, Integer>> wordSet = Map.entrySet();
		

		
	public GeneralWordCounter(Set<String> mängd){
	
		
		for (String s : mängd) {
			if(mängd.contains(s)){
			FreqMap.put(s, 0);
			
			}
		}	
		
	}
	
	
	@Override
	public void process(String w) {
		
		if(FreqMap.containsKey(w)){ 
		
		}
		else if (Map.containsKey(w)){
			Map.put(w, Map.get(w)+1);
			
		}
		else{
			Map.put(w, 1);
		}
		
		
	
		
	}

	
	
	@Override
	public void report() {
	
	List<Map.Entry<String,Integer>> wordList = new ArrayList<>(wordSet);
		wordList.sort(new WordCountComparator());
	for(int i = 0; i<20; i++){
		System.out.println(wordList.get(i));
	}
		
	
	
	
	
	for(String key : Map.keySet()){
			if(Map.get(key)>=200){
				Map200.put(key, Map.get(key));
				
			}
			
		}
	
	

	
	
	
	
		
		/*for(String k : Map200.keySet()){
			System.out.println(k + ": " + Map.get(k));
		}*/
		
		
	}
					
		public Set<Map.Entry<String, Integer>> getWords(){
		
		return wordSet;
		
		
	}
}
