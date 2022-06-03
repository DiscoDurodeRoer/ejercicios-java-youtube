package ejercicio_ficheros_ddr_20;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Ejercicio_ficheros_DDR_20 {

    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new Producto(1, "producto 1", 10.5, true, 'T'));
        productos.add(new Producto(2, "producto 2", 50.5, true, 'R'));
        productos.add(new Producto(3, "producto 3", 10.5, false, 'T'));
        productos.add(new Producto(4, "producto 4", 30.5, true, 'B'));
        productos.add(new Producto(5, "producto 5", 20.5, true, 'T'));

        try (RandomAccessFile raf = new RandomAccessFile("ejemplo_raf.dat", "rw")) {

            for (Producto p : productos) {

                raf.writeInt(p.getId());

                StringBuffer sb = new StringBuffer(p.getNombre());
                sb.setLength(10);

                raf.writeChars(sb.toString());
                raf.writeDouble(p.getPrecio());
                raf.writeBoolean(p.isDescuento());
                raf.writeChar(p.getTipo());

            }

            // 4 + 20 + 8 + 1 + 2 = 35 bytes cada registro 
            raf.seek(35);

            System.out.println(raf.readInt());
            String nombre = "";
            for (int i = 0; i < 10; i++) {
                nombre += raf.readChar();
            }
            System.out.println(nombre);
            System.out.println(raf.readDouble());
            System.out.println(raf.readBoolean());
            System.out.println(raf.readChar());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
