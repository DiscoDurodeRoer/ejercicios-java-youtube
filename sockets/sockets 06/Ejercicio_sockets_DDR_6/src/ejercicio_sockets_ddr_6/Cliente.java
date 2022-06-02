package ejercicio_sockets_ddr_6;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.M;

public class Cliente extends Observable implements Runnable {

    private int puerto;

    public Cliente(int puerto) {
        this.puerto = puerto;
    }

    @Override
    public void run() {
        //Host del servidor
        final String HOST = "127.0.0.1";
        try {
            //Creo el socket para conectarme con el cliente
            Socket sc = new Socket(HOST, puerto);
            ObjectInputStream ois = new ObjectInputStream(sc.getInputStream());
            while (true) {

                Gasolinera g = (Gasolinera) ois.readObject();

                this.setChanged();
                this.notifyObservers(g);
                this.clearChanged();

            }

        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
