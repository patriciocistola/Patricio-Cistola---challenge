package src.main.java.superliga.punto5;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import src.main.java.superliga.model.Socio;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;

public class CantSociosPorEquipos {
    // 5. Un listado, ordenado de mayor a menor según la cantidad de
    // socios, que enumere, junto con cada equipo, el promedio de edad
    // de sus socios, la menor edad registrada y la mayor edad registrada.
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
            List<Socio> persona = new ArrayList<Socio>();
            for (List<String> list : data) {
                persona.add(new Socio(list.get(0),
                        Integer.parseInt(list.get(1).toString()),
                        list.get(2),
                        list.get(3),
                        list.get(4)));
            }
            Stream<Entry<String, Long>> grupo1 = persona.stream().collect(
                    Collectors.groupingBy(Socio::getEquipo, Collectors.counting())).entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));

            List<String> equipos = new ArrayList<>();
            grupo1.forEach(eq -> equipos.add(eq.getKey()));

            for (String e : equipos) {
                List<Integer> edadeList = new ArrayList<>();
                int cant = 0;
                for (Socio p : persona) {
                    if (p.getEquipo().contains(e)) {
                        edadeList.add(p.getEdad());
                        cant++;
                    }
                }
                System.out.println("************************************************************");
                System.out.println("La cantidad de socios de " + e + " es : " + cant);
                IntSummaryStatistics eprom = edadeList.stream().mapToInt((a) -> a).summaryStatistics();
                double eprom2d = Math.round(eprom.getAverage() *100.0)/100.0;
                System.out.println("Promedio de edad de socios de " + e +
                        " -----> " + eprom2d);
                System.out.println("Edad maxima de socios de " + e +
                        " -----> " + Collections.max(edadeList));
                System.out.println("Edad minima de socios de " + e +
                        " -----> " + Collections.min(edadeList));
            }
            s.close();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
