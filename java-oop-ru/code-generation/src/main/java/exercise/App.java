package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;


// BEGIN
public class App {
    public static void save(Path path, Car car) throws IOException {
        var serialize = car.serialize();
        Files.writeString(path,serialize);
    }

    public static Car extract(Path path) throws IOException {
        var readFile = Files.readString(path);
        return Car.deserialize(readFile);
    }

}
// END
