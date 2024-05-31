package TestType;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GetKeyByValue {
    public Character getKeyByValue(HashMap<Character, Double> map, Double value) {
        for (Map.Entry<Character, Double> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
