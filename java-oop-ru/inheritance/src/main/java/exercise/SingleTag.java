package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    public SingleTag(String name, Map<String, String> attributes) {
        super(name, attributes);
    }

    public String toString() {
        //return "<" + getName() + stringAttributes() + ">";
        return String.format("<%s%s>", getName(), stringAttributes());
    }
}
// END
