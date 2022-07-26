package src.main.java.superliga.punto3;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.main.java.superliga.model.Socio;

import java.util.Arrays;
import java.util.Collections;

public class CasadosUniversitarios {
    //3. Un listado con las 100 primeras personas casadas, con estudios
    //Universitarios, ordenadas de menor a mayor según su edad. Por
    //cada persona, mostrar: nombre, edad y equipo.
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
            int count = 0;
            List<Socio> persona = new ArrayList<Socio>();
            for (List<String> list : data) {
                if ((list.contains("Casado")) && (list.contains("Universitario"))) {
                    count++;
                    if (count <= 100) {
                        persona.add(new Socio(list.get(0),
                                Integer.parseInt(list.get(1).toString()),
                                list.get(2),
                                list.get(3),
                                list.get(4)));
                   }
                }
            }
            Collections.sort(persona,
                    (p1, p2) -> new Integer(p1.getEdad()).compareTo(new Integer(p2.getEdad())));
            persona.forEach(p -> System.out.println(
                    "nombre : " + p.getNombre() +
                    " , edad : " + p.getEdad() +
                    " , equipo : " + p.getEquipo()
            ));
            s.close();
        } catch (Exception e) {
            System.out.print(e);
        }
    }

}
