package advent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1 {
    public static void main(String[] args) throws IOException {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        String filePath = System.getProperty("user.dir") + File.separator + "day1.txt";
        try {
            // Read all lines into a List of Strings
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            // Print each line
            for (String line : lines) {
                String[] numbers = line.split(" ");
                list1.add(Integer.parseInt(numbers[0]));
                list2.add(Integer.parseInt(numbers[3]));
            }
            int[] intArray = list1.stream()
                    .mapToInt(Integer::intValue) // Convert Integer to int
                    .toArray();
            int[] intArray1 = list2.stream()
                    .mapToInt(Integer::intValue) // Convert Integer to int
                    .toArray();
            Arrays.sort(intArray);
            Arrays.sort(intArray1);
            long result = 0;
            for (int i = 0; i < intArray.length; i++) {
                result = result + Math.abs(intArray[i] - intArray1[i]);
            }
            System.out.println(result);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
