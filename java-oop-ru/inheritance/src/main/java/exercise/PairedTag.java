package exercise;

import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends Tag {
    private final Map<String, String> attributes;
    private final String bodyString;
    private final List<Tag> childTags;

    public PairedTag(String tag,
                     Map<String, String> attributes,
                     String bodyString,
                     List<Tag> childTags) {
        super(tag);
        this.attributes = attributes;
        this.bodyString = bodyString;
        this.childTags = childTags;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(new SingleTag(super.getTag(), this.attributes));

        for (Tag tag : childTags) {
            builder.append(tag.toString());
        }
        return builder.append(bodyString)
                .append("</")
                .append(super.getTag()).append(">")
                .toString();
    }
}
// END
