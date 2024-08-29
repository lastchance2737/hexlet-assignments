package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {
    private final String error;

    public NegativeRadiusException(String s) {
        this.error = s;
    }

    @Override
    public String toString() {
        return error;
    }
}
// END
