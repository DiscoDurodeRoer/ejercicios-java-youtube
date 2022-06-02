/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_sockets_ddr_9;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                        // Recojo el numero de lineas
                        int numLineas = numeroLineasFichero(f);
                        // Envio el numero de lineas al cliente
                        out.writeInt(numLineas);
                        break;
                    
                    case 3:
                        // Obtenemos el numero de numeros del fichero
                        ArrayList<Integer> numeros = listaNumeros(f);
                        
                        // Envio el numero de elementos que hay al cliente
                        out.writeInt(numeros.size());
                        
                        // Envio al cliente los numeros uno a uno
                        for (int n:numeros) {
                            out.writeInt(n);
                        }
                        
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
        // Por ejemplo, fer:52
        fw.write(nombreCliente + ":"+numeroAleatorio + "\r\n");
        fw.close();
        
    }
 
    public int numeroLineasFichero(File f) throws FileNotFoundException, IOException{
        
        int numLineas = 0;
        BufferedReader br = new BufferedReader(new FileReader(f));
        
        String linea = "";
        
        while( (linea = br.readLine()) != null){
            numLineas++;
        }
        
        br.close();
        return numLineas;
        
    }
    
    public ArrayList<Integer> listaNumeros(File f) throws FileNotFoundException, IOException {
        
        ArrayList<Integer> numeros = new ArrayList<>();
        
        BufferedReader br = new BufferedReader(new FileReader(f));
        
        String linea = "";
        
        while( (linea = br.readLine()) != null){
            // Corto la linea en dos partes
            String[] partes = linea.split(":");
            // obtengo el numero
            int numero = Integer.parseInt(partes[1]);
            // añado el numero
            numeros.add(numero);
        }
        
        br.close();
        
        
        return numeros;
    }
    
    
    
}
