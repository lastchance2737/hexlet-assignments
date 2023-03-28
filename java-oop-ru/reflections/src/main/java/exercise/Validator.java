package exercise;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// BEGIN
public class Validator {
    public static List<String> validate(Object obj) {

        Address address = (Address) obj;
        for (Field m : obj.getClass().getDeclaredFields()) {
            if (m.isAnnotationPresent(NotNull.class)) {
                Annotation[] notNull = m.getAnnotations();
                System.out.println(Arrays.toString(notNull));

            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        var address = new Address("aaa", null, "ccc", "ddd", "eee");
        validate(address);
    }
}
// END
