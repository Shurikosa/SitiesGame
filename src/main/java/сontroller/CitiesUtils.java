package сontroller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CitiesUtils {

    private static List<String> words;
    private String filePath = "src/main/resources/CitiesList.txt";

    private CitiesUtils() {
        words = readSitiesFromFile();
    }

    private List<String> readSitiesFromFile() {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<String> getWords() {
        return words;
    }
}
