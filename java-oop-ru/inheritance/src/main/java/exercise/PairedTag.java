package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private final String tagBody;
    private final List<Tag> listSingleTags;

    public PairedTag(String name,
                     Map<String, String> attributes,
                     String tagBody,
                     List<Tag> listSingleTags) {
        super(name, attributes);
        this.tagBody = tagBody;
        this.listSingleTags = listSingleTags;
    }

    public String getTagBody() {
        return tagBody;
    }

    public String stringSigneTags() {
        return listSingleTags.stream()
                .map(Tag::toString)
                .collect(Collectors.joining());
    }

    public String toString() {
        //return "<" + getName() + stringAttributes() + ">" + getTagBody() + stringSigneTags() + "</" + getName() + ">";
        return String.format("<%s%s>%s%s</%s>", getName(), stringAttributes(), getTagBody(), stringSigneTags(), getName());
    }
}
// END
