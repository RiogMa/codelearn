package HashMap;

import java.util.HashMap;
import java.util.Map;

public class MapEntry {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("id", 10);
        hashMap.put("banna", 11);
        hashMap.put("apple", 12);
        for(Map.Entry<String, Integer> entry:hashMap.entrySet()){
            System.out.println(entry.getKey()+"    "+entry.getValue());
        }
    }
}
