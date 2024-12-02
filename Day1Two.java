package advent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Day1Two {
    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        String filePath = System.getProperty("user.dir") + File.separator + "day1.txt";
        try {
            // Read all lines into a List of Strings
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            // Print each line
            for (String line : lines) {
                String[] numbers = line.split(" ");
                list.add(Integer.parseInt(numbers[0]));
                int number = Integer.parseInt(numbers[3]);
                map.put(number, map.getOrDefault(number,0)+1);
            }
            long result = 0;
            for (int i = 0; i < list.size(); i++) {
                result = result + ((long) list.get(i) * map.getOrDefault(list.get(i), 0));
            }
            System.out.println(result);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
