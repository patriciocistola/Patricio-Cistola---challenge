package src.main.java.superliga.punto2;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class EdadPromRacing {
    //2. El promedio de edad de los socios de Racing. 
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
            double eprom2d = Math.round(eprom.getAverage() *100.0)/100.0;
            System.out.println("El promedio de edad de los socios de Racing es  -----> " + eprom2d);
            s.close();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
