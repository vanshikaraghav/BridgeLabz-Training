package json.json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JSONToXml {

    public static void main(String[] args) throws Exception {

        String json = """
        {
          "name": "Harshita",
          "age": 22,
          "city": "Mathura"
        }
        """;
 
        ObjectMapper jsonMapper = new ObjectMapper();
        JsonNode jsonNode = jsonMapper.readTree(json);
        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonNode);
        System.out.println(xml);
    }
}