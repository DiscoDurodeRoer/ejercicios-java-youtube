package ejercicio_poo_ddr_10;


public class Ejercicio_POO_DDR_10 {

    public static void main(String[] args) {
        
        //Creo el almacen
        Almacen a = new Almacen();
        
        Bebida b;
        
        //Añado bebidas (un poco de todo)
        //La forma de hacerlo es opcional
        for(int i=0;i<10;i++){
            switch(i%2){
                case 0:
                    b=new AguaMineral("manantial1", 1.5, 5, "bezoya");
                    a.agregarBebida(b);
                    break;
                case 1:
                    b=new BebidaAzucarada(0.2, true, 1.5, 10, "Coca Cola");
                    a.agregarBebida(b);
                    break;
            }
        }
        
        //Muestro las bebidas
        a.mostrarBebidas();
        
        //Calculo el precio de todas las bebidas
        System.out.println("Precio de todas las bebidas "+a.calcularPrecioBebidas());
        
        //Elimino una bebida en concreto
        a.eliminarBebida(4);
        
        //Muestro las bebidas
        a.mostrarBebidas();
        
        //
        System.out.println("Precio de todas las bebidas"+a.calcularPrecioBebidas());
        
        System.out.println("Precio de todas las bebidas de la marca bezoya" +a.calcularPrecioBebidas("bezoya"));
        
        System.out.println("Calcular el precio de la columna 0: "+a.calcularPrecioBebidas(0));
        
    }
    
}
