package ejercicio_poo_ddr_25;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WorldWarBot {

    private ArrayList<String> participantes;

    public WorldWarBot(String ruta) throws FileNotFoundException, Exception {
        this.participantes = new ArrayList<>();
        this.procesarParticipantes(ruta);
    }

    private void procesarParticipantes(String ruta) throws FileNotFoundException, IOException, Exception {

        BufferedReader br = new BufferedReader(new FileReader(ruta));

        String participante;
        while ((participante = br.readLine()) != null) {
            this.participantes.add(participante);
        }

        br.close();

        if (participantes.isEmpty()) {
            throw new Exception("No hay participantes");
        }

    }

    public void mostrarParticipantes() {
        System.out.println("Participantes");
        for (String participante : this.participantes) {
            System.out.println(participante);
        }
    }

    public void combate() {

        int posP1, posP2;
        do {
            posP1 = this.generaNumeroAleatorio(0, this.participantes.size() - 1);
            posP2 = this.generaNumeroAleatorio(0, this.participantes.size() - 1);
        } while (posP1 == posP2);

        String p1 = this.participantes.get(posP1);
        String p2 = this.participantes.get(posP2);

        int probabilidad = this.generaNumeroAleatorio(0, 100);

        if (probabilidad > 50) {
            System.out.println(p2 + " ha vencido a " + p1);
            this.participantes.remove(posP1);
        } else {
            System.out.println(p1 + " ha vencido a " + p2);
            this.participantes.remove(posP2);
        }

    }

    public boolean hayGanador() {
        return this.participantes.size() == 1;
    }

    public void mostrarGanador() {
        if (this.hayGanador()) {
            System.out.println(this.participantes.get(0) + " ha ganado");
        } else {
            System.out.println("No hay ganador");
        }
    }

    private int generaNumeroAleatorio(int minimo, int maximo) {

        int num = (int) (Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
        return num;
    }

}
