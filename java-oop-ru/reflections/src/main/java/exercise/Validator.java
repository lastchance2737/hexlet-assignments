package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

// BEGIN
public class Validator {

    public static List<String> validate(Object valClass) {
        List<String> result = new ArrayList<>();

        var curClass = valClass.getClass();
        var curFields = curClass.getDeclaredFields();

        return Stream.of(curFields)
                .filter(x -> x.isAnnotationPresent(NotNull.class))
                .filter(x -> {
                    Object value;
                    try {
                        x.setAccessible(true);
                        value = x.get(valClass);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                    return value == null;
                })
                .map(Field::getName)
                .toList();

        /*
        for (Field field : curFields) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            if (notNull != null) {
                field.setAccessible(true);
                try {
                    Object object = field.get(valClass);
                    if (object == null) {
                        result.add(field.getName());
                    }
                } catch (Exception ignored) {
                }
            }
        }
        return result;
         */
    }

    public static Map<String, List<String>> advancedValidate(Object valClass) {
        Map<String, List<String>> result = new HashMap<>();

        var curClass = valClass.getClass();
        var curFields = curClass.getDeclaredFields();

        Stream.of(curFields)
                .filter(x -> x.isAnnotationPresent(NotNull.class) || x.isAnnotationPresent(MinLength.class))
                .forEach(x -> {
                    String fieldName = x.getName();
                    List<String> errors = getValidateErrors(x, valClass);
                    if (!errors.isEmpty()) {
                        result.put(fieldName, errors);
                    }
                });
        return result;
    }

    private static List<String> getValidateErrors(Field field, Object valClass) {
        List<String> errors = new ArrayList<>();

        String value;
        try {
            field.setAccessible(true);
            value = (String) field.get(valClass);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        if (field.isAnnotationPresent(NotNull.class) && value == null) {
            errors.add("can not be null");
        }

        if (field.isAnnotationPresent(MinLength.class)) {
            int minLength = field.getAnnotation(MinLength.class).minLength();
            if (value == null || value.length() < minLength) {
                errors.add("length less than " + minLength);
            }
        }
        return errors;
    }

    public static void main(String[] args) {
        Address address = new Address("USA", "Texas", null, "7", "2");
        Map<String, List<String>> notValidFields = Validator.advancedValidate(address);
        System.out.println(notValidFields); // =>  {country=[length less than 4], street=[can not be null]}
    }
}
// END
