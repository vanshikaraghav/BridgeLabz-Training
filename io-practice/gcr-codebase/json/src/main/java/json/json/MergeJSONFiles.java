package json.json;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;

public class MergeJSONFiles {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json1 = mapper.readTree(new File("src/main/java/resources/file1.json"));
        JsonNode json2 = mapper.readTree(new File("src/main/java/resources/file2.json"));
        ObjectNode merged = mapper.createObjectNode();
        merged.setAll((ObjectNode) json1);
        merged.setAll((ObjectNode) json2);
        String result = mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(merged);
        System.out.println(result);
    }
}