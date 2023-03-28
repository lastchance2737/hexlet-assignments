package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    private final Map<String, String> attribute;

    public SingleTag(String tag, Map<String, String> attribute) {
        super(tag);
        this.attribute = attribute;
    }

    public String toString() {
        return "<" + super.getTag() + super.mapToString(attribute) + ">";
    }

}
// END
