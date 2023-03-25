package exercise;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        var keys = storage.toMap().keySet();

        for (String str : keys) {
            var key = storage.get(str, "");
            storage.unset(str);
            storage.set(key, str);
        }
    }
}
// END
