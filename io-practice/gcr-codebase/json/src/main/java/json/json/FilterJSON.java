package json.json;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.stream.Collectors;

public class FilterJSON {
 
    static class Person {
        private String name;
        private int age;
 
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) throws Exception {

        String json = """
            [
              {"name": "Harshita", "age": 22},
              {"name": "Vanshika", "age": 28},
              {"name": "Neha", "age": 30},
              {"name": "Aman", "age": 24}
            ]
            """;
        ObjectMapper mapper = new ObjectMapper();
        List<Person> people = mapper.readValue(
                json,
                new TypeReference<List<Person>>() {}
        );
        List<Person> filtered = people.stream()
                .filter(p -> p.getAge() > 25)
                .collect(Collectors.toList());
        String resultJson = mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(filtered);
        System.out.println(resultJson);
    }
}