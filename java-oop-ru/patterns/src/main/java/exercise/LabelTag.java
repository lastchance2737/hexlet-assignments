package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private final String value;
    private final TagInterface inputTag;

    public LabelTag(String value, TagInterface inputTag) {
        this.value = value;
        this.inputTag = inputTag;
    }

    @Override
    public String render() {
        // <label>Press Submit<input type="submit" value="Save"></label>
        return "<label>" + value + inputTag + "</label>";
    }

    @Override
    public String toString() {
        return render();
    }
}
// END
