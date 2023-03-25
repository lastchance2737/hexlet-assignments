package exercise;

import java.util.*;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> homes, int size) {
        if (homes.size() == 0) {
            return new ArrayList<>();
        }

        List<Home> list = new ArrayList<>(homes);
        Comparator<Home> comparator = Comparator.comparing(Home::getArea);
        list.sort(comparator);

        var count = size;
        if (count > homes.size()) {
            count = homes.size();
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(list.get(i).toString());
        }
        return result;
    }
}
// END
