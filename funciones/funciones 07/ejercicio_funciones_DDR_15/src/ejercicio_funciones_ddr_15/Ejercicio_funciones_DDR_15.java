package ejercicio_funciones_ddr_15;

public class Ejercicio_funciones_DDR_15 {

    public static void main(String[] args) {

        int array[] = {5,4,8};

        //Llamo a la funcion
        int mayor_menor[] = mayorMenorArray(array);

        if (mayor_menor != null) {
            for (int i = 0; i < mayor_menor.length; i++) {
                System.out.println(mayor_menor[i]);
            }
        }else{
            System.out.println("El parametro no es valido");
        }

    }

    public static int[] mayorMenorArray(int[] array) {

        if (array == null || array.length == 0) {
            return null;
        }

        // 0 = mayor, 1 = menor
        int[] mayor_menor = new int[2];

        mayor_menor[0] = array[0];
        mayor_menor[1] = array[0];;

        for (int i = 1; i < array.length; i++) {

            if (array[i] > mayor_menor[0]) {
                mayor_menor[0] = array[i];
            }

            if (array[i] < mayor_menor[1]) {
                mayor_menor[1] = array[i];
            }

        }

        return mayor_menor;

    }

}
