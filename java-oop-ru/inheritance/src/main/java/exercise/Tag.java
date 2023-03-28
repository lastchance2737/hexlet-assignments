package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    private final String tag;

    public Tag(String tag) {
        this.tag = tag;
    }

    protected String getTag() {
        return tag;
    }

    public String toString() {
        return "<" + tag + ">";
    }

    protected final String mapToString(Map<String, String> map) {
        if (map.isEmpty()) {
            return "";
        }
        return " " + map.keySet().stream()
                .map(key -> key + "=\"" + map.get(key) + "\"")
                .collect(Collectors.joining(" "));
    }
}
// END
