package exercise;

// BEGIN
import java.util.HashMap;

public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        var reversedMap = new HashMap<String, String>();
        storage.toMap().forEach((key, value) -> {
            reversedMap.put(value, key);
        });

        var keySet = storage.toMap().keySet();
        keySet.forEach(storage::unset);

        reversedMap.forEach(storage::set);
    }
}
// END
