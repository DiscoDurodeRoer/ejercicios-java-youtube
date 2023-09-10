package ejercicio_poo_ddr_40;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio_POO_DDR_40 {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");

        String nombre;
        int puntuacion;
        Score score;

        ArrayList<Score> highScores = new ArrayList<>();

        // Pedimos las 5 puntuaciones
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("Nombre:");
                nombre = sn.next();

                System.out.println("Puntuacion:");
                puntuacion = sn.nextInt();

                score = new Score(puntuacion, nombre);

                highScores.add(score);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                i--;
            }

        }

        // Ordenamos las puntuaciones
        Collections.sort(highScores);

        // Mostramos las puntuaciones
        for (int i = 0; i < 5; i++) {
            score = highScores.get(i);
            System.out.println((i + 1) + ". " + score.toString());
        }

    }
}
