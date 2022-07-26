package src.main.java.superliga.punto2;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class EdadPromRacing {
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
            List<Integer> edades = new ArrayList<>();
            for (List<String> list : data) {
                if (list.contains("Racing")) {
                    edades.add(Integer.parseInt(list.get(1).toString()));
                }
            }
            IntSummaryStatistics eprom = edades.stream().mapToInt((a) -> a).summaryStatistics();
            System.out.println("El promedio de edad de los socios de Racing es  -----> " + eprom.getAverage());
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
