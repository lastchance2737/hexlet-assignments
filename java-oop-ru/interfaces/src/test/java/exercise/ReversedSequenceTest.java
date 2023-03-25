package exercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReversedSequenceTest {

    @Test
    public void Test() {
        String string = "abcd";
        int length = 4;
        char charAt1 = 'c';
        String subString = "cb";

        String result = "dcba";

        ReversedSequence newString = new ReversedSequence(string);
        assertThat(result).isEqualTo(newString.toString());
        assertThat(length).isEqualTo(newString.length());
        assertThat(charAt1).isEqualTo(newString.charAt(1));
        assertThat(subString).isEqualTo(newString.subSequence(1, 3));
    }

    @Test
    public void emptyStringTest() {
        String string = "";
        int length = 0;

        String result = "";

        ReversedSequence newString = new ReversedSequence(string);
        assertThat(result).isEqualTo(newString.toString());
        assertThat(length).isEqualTo(newString.length());
    }
}
