package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    private final String name;
    private final Map<String, String> attributes;

    public Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public String stringAttributes() {
        if (attributes.isEmpty()) return "";
        return attributes.keySet().stream()
                .map(key -> {
                    var value = attributes.get(key);
                    //return key + "=\"" + value + "\"";
                    return String.format(" %s=\"%s\"", key, value);
                }).collect(Collectors.joining(""));
    }

}
// END
