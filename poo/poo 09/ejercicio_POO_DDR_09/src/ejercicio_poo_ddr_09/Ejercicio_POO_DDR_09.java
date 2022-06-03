package ejercicio_poo_ddr_09;

public class Ejercicio_POO_DDR_09 {

    public static void main(String[] args) {
        
        //Creo que array de productos
        Producto[] productos = new Producto[3];
        
        //Creo los elementos
        productos[0] = new Producto("producto 1", 10);
        productos[1] = new Perecedero(1, "producto 2", 20);
        productos[2] = new NoPerecedero("tipo 1", "producto 3", 5);

        //Calculo el precio
        double total=0;
        for(int i=0;i<productos.length;i++){
            total += productos[i].calcular(5); //Polimorfismo
        }
        
        //Muestro el total
        System.out.println("el total es "+total);
        
    }
    
}
