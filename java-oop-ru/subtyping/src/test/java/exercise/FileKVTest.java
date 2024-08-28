package exercise;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

// BEGIN
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    @Test
    public void KVtest() {
        var map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");

        String path = "src/test/resources/file";

        var storage = new FileKV(path, map);
        var result1 = new HashMap<>(Map.of("key1", "value1", "key2", "value2"));

        assertThat(storage.toMap()).isEqualTo(result1);

        assertThat(storage.get("key2", "deff")).isEqualTo("value2");
        assertThat(storage.get("key5", "deff")).isEqualTo("deff");

        storage.set("key3", "value3");
        assertThat(storage.get("key3", "defaultValue")).isEqualTo("value3");
        result1.put("key3", "value3");
        assertThat(storage.toMap()).isEqualTo(result1);

        storage.unset("key1");
        assertThat(storage.get("key1","vvaalluuee")).isEqualTo("vvaalluuee");

    }
    // END
}
