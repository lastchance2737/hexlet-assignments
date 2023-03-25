package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    public void Test() {
        var filepath = "src/test/resources/testfile";
        KeyValueStorage storage = new FileKV(filepath, Map.of("key", "value", "key1", "value1"));
        storage.set("key2", "value2");
        storage.set("key", "value3");
        var expected = Map.of("key", "value3", "key1", "value1", "key2", "value2");
        var result = storage.toMap();
        assertThat(result).isEqualTo(expected);

        var get1 = storage.get("key2", "");
        assertThat(get1).isEqualTo("value2");

        storage.unset("key2");
        storage.unset("key1");
        result = storage.toMap();
        assertThat(result).isEqualTo(Map.of("key", "value3"));
    }
    // END
}
