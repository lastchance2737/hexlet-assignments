package exercise;

import java.util.List;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> homeList, int length) {
        return homeList.stream()
                .sorted(Home::compareTo)
                .map(Home::toString)
                .limit(length)
                .toList();
    }
}
// END
