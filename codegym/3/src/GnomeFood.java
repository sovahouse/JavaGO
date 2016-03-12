import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class GnomeFood {



    public int[] find(int[] gnames, int[] portions) {

        Map<Integer, Integer> mapGnomes = new TreeMap<>();
        Map<Integer, Integer> mapPortion = new TreeMap<>();
        
        int[] indexes = new int[gnames.length];
        
        for (int i = 0; i < gnames.length; i++) {
            
            mapGnomes.put(gnames[i], i);
            mapPortion.put(portions[i], i);
            
        }


        Iterator iterPortions = mapPortion.values().iterator();
        for (int i: mapGnomes.values()) {

            indexes[i] = (Integer) iterPortions.next();

        }

       return indexes;
    }
}