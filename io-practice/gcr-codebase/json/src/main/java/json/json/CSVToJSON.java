package json.json;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.csv.*;
import java.io.*;
import java.util.*;

public class CSVToJSON {

    public static void main(String[] args) throws Exception {
        File csvFile = new File("src/main/java/resources/student.csv");
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        MappingIterator<Map<String, String>> it =
                csvMapper.readerFor(Map.class)
                          .with(schema)
                          .readValues(csvFile);
        List<Map<String, String>> data = it.readAll();
        ObjectMapper jsonMapper = new ObjectMapper();
        String json = jsonMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(data);
        System.out.println(json);
    }
}