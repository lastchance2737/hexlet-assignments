package exercise;

import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
public class SingleTag extends Tag {
    private final Map<String, String> attribute;

    public SingleTag(String tag, Map<String, String> attribute) {
        super(tag);
        this.attribute = attribute;
    }

    public final String toString() {
        return "<" + super.getTag() + mapToString(attribute) + ">";
    }

    private final String mapToString(Map<String, String> map) {
        if (map.isEmpty()) {
            return "";
        }
        return " " + map.keySet().stream()
                .map(key -> key + "=\"" + map.get(key) + "\"")
                .collect(Collectors.joining(" "));
    }
}
// END
