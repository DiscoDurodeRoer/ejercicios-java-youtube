package ejercicio_interfaces_graficas_ddr_4;

public class MetodosSueltos {

    public static int generaNumeroAleatorio(int minimo, int maximo) {

        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;
    }

}
