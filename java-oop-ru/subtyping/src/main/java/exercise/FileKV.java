package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private final String path;

    public FileKV(String path, Map<String, String> storage) {
        this.path = path;
        var storageToString = Utils.serialize(storage);
        Utils.writeFile(this.path, storageToString);
    }

    @Override
    public void set(String key, String value) {
        var file = Utils.readFile(path);
        var storage = Utils.unserialize(file);
        storage.put(key, value);
        var storageToString = Utils.serialize(storage);
        Utils.writeFile(path, storageToString);
    }

    @Override
    public void unset(String key) {
        var file = Utils.readFile(path);
        var storage = Utils.unserialize(file);
        storage.remove(key);
        var storageToString = Utils.serialize(storage);
        Utils.writeFile(path, storageToString);
    }

    @Override
    public String get(String key, String defaultValue) {
        var file = Utils.readFile(path);
        var storage = Utils.unserialize(file);
        return storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        var file = Utils.readFile(path);
        var storage = Utils.unserialize(file);
        return new HashMap<>(storage);
    }
}
// END
