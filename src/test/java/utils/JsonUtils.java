package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class JsonUtils {
    private static JsonNode root;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream input = JsonUtils.class.getClassLoader().getResourceAsStream("testdata/users.json");
            root = mapper.readTree(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static User getUser(String userType) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            return mapper.treeToValue(root.get(userType), User.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
