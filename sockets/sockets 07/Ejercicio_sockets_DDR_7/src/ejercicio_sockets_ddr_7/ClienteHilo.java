package ejercicio_sockets_ddr_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ClienteHilo extends Thread{
    
    private DataInputStream in;
    private DataOutputStream out;

    public ClienteHilo(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }
    
    @Override
    public void run(){
        
    }
}
