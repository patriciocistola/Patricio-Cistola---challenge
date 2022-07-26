package src.main.java.superliga.punto4;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Comparator;

public class NombresComunesRiver {
   // 4. Un listado con los 5 nombres más comunes entre los hinchas de River.
    public static void main(String[] args) {
        try {
            List<List<String>> data = new ArrayList<>();
            String filePath = "src/main/java/superliga/model/socios.csv";
            File file = new File(filePath);
            Scanner s = new Scanner(file);
            while (s.hasNextLine()) {
                List<String> lineData = Arrays.asList(s.nextLine().split(";"));
                data.add(lineData);
            }
            List<String> nombresRiver = new ArrayList<>();
            for (List<String> list : data) {
                if (list.contains("River")) {
                    nombresRiver.add(list.get(0));
                }
            }
            Map<String, Integer> map = nombresRiver.stream()
                    .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
            map.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(5)
                    .forEach(System.out::println);
            s.close();
        } catch (Exception e) {
            System.out.print(e);
        }

    }

}
