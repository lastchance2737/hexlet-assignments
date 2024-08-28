package exercise;

import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String path;

    public FileKV(String path, Map<String, String> storage) {
        this.path = path;
        Utils.writeFile(path, Utils.serialize(storage));
    }

    @Override
    public void set(String key, String value) {
        var storage = Utils.deserialize(Utils.readFile(path));
        storage.put(key, value);
        Utils.writeFile(path, Utils.serialize(storage));
    }

    @Override
    public void unset(String key) {
        var storage = Utils.deserialize(Utils.readFile(path));
        storage.remove(key);
        Utils.writeFile(path, Utils.serialize(storage));
    }

    @Override
    public String get(String key, String defaultValue) {
        var storage = Utils.deserialize(Utils.readFile(path));
        return storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return Utils.deserialize(Utils.readFile(path));
    }

    public static void main(String[] args) {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        // Получение значения по ключу
        storage.get("key", "default"); // "value"
    }
}
// END
