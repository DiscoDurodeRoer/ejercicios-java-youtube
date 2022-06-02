/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_sockets_ddr_8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando
 */
public class ServidorHilo extends Thread {
    
    private DataInputStream in;
    private DataOutputStream out;
    private String nombreCliente;
    
    public ServidorHilo(DataInputStream in, DataOutputStream out, String nombreCliente) {
        this.in = in;
        this.out = out;
        this.nombreCliente = nombreCliente;
    }
    
    @Override
    public void run() {
        
        int opcion;
        File f = new File("numeros.txt");
        
        while (true) {
            
            try {
                opcion = in.readInt();
                switch (opcion) {
                    case 1:
                        // Recibo el numero aleatorio
                        int numeroAleatorio = in.readInt();
                        // escribo el numero
                        escribirNumeroAleatorio(f, numeroAleatorio);
                        System.out.println("Se escribio el numero en el cliente: " + nombreCliente);
                        // Mando el mensaje de confirmacion al cliente
                        out.writeUTF("Numero guardado correctamente");
                        break;
                    
                    case 2:
                        break;
                    
                    case 3:
                        break;
                    
                    case 4:
                        break;
                    
                    case 5:
                        break;
                    
                    case 6:
                        break;
                    default:
                        out.writeUTF("Solo numero del 1 al 6");
                }
                
            } catch (IOException ex) {
                Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    
    public void escribirNumeroAleatorio(File f,int numeroAleatorio) throws IOException{
        
        FileWriter fw = new FileWriter(f, true);
        fw.write(nombreCliente + ":"+numeroAleatorio + "\r\n");
        fw.close();
        
    }
 
    
    
    
}
