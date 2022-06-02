package ejercicio_sockets_ddr_5;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Observable implements Runnable {

    private int puerto;

    public Cliente(int puerto) {
        this.puerto = puerto;
    }

    @Override
    public void run() {
        //Host del servidor
        final String HOST = "127.0.0.1";

        DataInputStream dis;
        try {
            //Creo el socket para conectarme con el cliente
            Socket sc = new Socket(HOST, puerto);
            dis = new DataInputStream(sc.getInputStream());
            String nombre;
            double valor;
            while (true) {

                nombre = dis.readUTF();
                
                this.setChanged();
                this.notifyObservers(nombre);
                this.clearChanged();
                
                valor = dis.readDouble();

                this.setChanged();
                this.notifyObservers(valor);
                this.clearChanged();
                
            }

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
