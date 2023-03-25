package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String string;

    public ReversedSequence(String string) {
        char[] array = string.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            builder.append(array[i]);
        }
        this.string = builder.toString();
    }

    @Override
    public int length() {
        return string.length();
    }

    @Override
    public char charAt(int i) {
        return string.charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return string.subSequence(i, i1).toString();
    }

    @Override
    public String toString() {
        return string;
    }
}
// END
