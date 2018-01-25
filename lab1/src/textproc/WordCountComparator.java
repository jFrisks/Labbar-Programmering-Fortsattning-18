package textproc;

import java.util.*;

import java.util.Comparator;

public class WordCountComparator implements Comparator<Map.Entry<String, Integer>>{
    public WordCountComparator(){

    }

    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        if(o1.getValue() > o2.getValue()){
            return -1;
        }
        else if(o1.getValue().equals(o2.getValue())){
            if(o1.getKey().compareTo(o2.getKey()) > 0){
                return 1;
            }else if(o1.getKey().compareTo(o2.getKey()) < 0){
                return -1;
            } else return 0;
        }
        else if(o1.getValue() < o2.getValue()){
            return 1;
        }
        else return 0;
    }
}
