package src.main.java.superliga.punto1;
import java.io.File;
import java.util.Scanner;

public class CantidadSocios {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("src/main/java/superliga/model/socios.csv"));
        sc.useDelimiter(";");
        int count = 0;
        while (sc.hasNextLine()) {
            sc.nextLine();
            count++;
        }
        sc.close();
        System.out.println("La cantidad de socios es ************* " + count + " *************");
    }

}
