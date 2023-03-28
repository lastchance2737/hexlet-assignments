package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    private final String tag;

    public Tag(String tag) {
        this.tag = tag;
    }

    protected final String getTag() {
        return tag;
    }

    public String toString() {
        return "<" + tag + ">";
    }
}
// END
