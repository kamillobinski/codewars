import java.util.*;

public class FindOdd {
    
    public static int findIt(int[] a) {
        Map<Integer,Integer> hashMap = new HashMap<>();

        for(int key: a) {
            if(!hashMap.containsKey(key)) {
                hashMap.put(key, 1);
            } else {
                hashMap.put(key, hashMap.get(key) + 1);
            }
        }

        for(Integer key: hashMap.keySet()) {
            if(hashMap.get(key) % 2 != 0) {
                return key;
            }
        }

        return 0;
    }
}