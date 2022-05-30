package ejercicio_arrays_ddr_15;

public class Ejercicio_arrays_DDR_15 {

    public static void main(String[] args) {

        //Creo el array de origen con los numeros que queramos
        int origen[] = {4, 7, 5, 0, 2, 1, 15, 93, 25, 12, 86, 87, 100};

        //Creamos un array con la misma longitud 
        int destino[] = new int[origen.length];

        //Creamos un contador que nos servira de indice en el array de destino
        int contador = 0;
        //Rellenamos el array de destino con la condicion indicada
        for (int i = 0; i < origen.length; i++) {
            if (origen[i] % 2 == 0 && origen[i] > 25) {
                destino[contador] = origen[i]; //usamos contador como indice
                contador++; //aumentamos el contador
            }
        }

        //Muestra el vector de origen
        System.out.println("Mostrar vector origen");
        for (int i = 0; i < origen.length; i++) {
            System.out.println(origen[i]);
        }

        System.out.println("Mostrar Vector destino");
        if (contador == 0) { //Si no hay elementos, mostrara un elemento
            System.out.println("No hay numeros que cumplan la condicion");
        } else {

            //Mostrar el vector de origen
            for (int i = 0; i < contador; i++) {
                System.out.println(destino[i]);
            }
        }

    }

}
