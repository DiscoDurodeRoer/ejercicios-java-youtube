package ejercicio_recursividad_ddr_25;

public class Ejercicio_recursividad_DDR_25 {

    public static void main(String[] args) {

        int[] millones = {1, 2, 3, 4, 0};

        int[][] bancos
                = {
                    {2, 1, 1},
                    {5, 3, 4},
                    {6, 6, 5},
                    {7, 7, 8},
                    {0, 0, 0}

                };

        //numero de millones que tenemos
        int numMillones = 4;

        //Solucion optima
        int[] solucion = new int[bancos[0].length];
        //Lo usaremos para ir insertando lo invertido
        int[] invertido = new int[bancos[0].length];

        mejorInversion(millones, bancos, invertido, solucion, numMillones, 0);

        //mostramos la solucion optima
        for (int i = 0; i < solucion.length; i++) {
            System.out.println(solucion[i]);
        }

    }

    public static void mejorInversion(int[] millones, int[][] bancos, int[] invertido, int[] solucion, int numMillonesActuales, int etapa) {

        //Caso Base: invertir en los 3 bancos
        if (etapa == bancos[0].length) {

            //Obtengo las ganancias
            int sumaSolucion = sumaGanacia(solucion);
            int sumaInvertido = sumaGanacia(invertido);

            //si lo que tengo es menor a la solución, lo copio
            if (sumaInvertido > sumaSolucion) {
                for (int i = 0; i < invertido.length; i++) {
                    solucion[i] = invertido[i];
                }
            }

        } else {

            for (int i = 0; i < millones.length; i++) {

                //si tengo los suficientes millones, sigo inviertiendo
                if (numMillonesActuales - millones[i] >= 0) {
                    //Añado
                    invertido[etapa] = bancos[i][etapa];
                    mejorInversion(millones, bancos, invertido, solucion, numMillonesActuales - millones[i], etapa + 1);
                    //elimino
                    invertido[etapa] = 0;
                }

            }

        }

    }

    public static int sumaGanacia(int[] inversion) {
        int suma = 0;
        for (int i = 0; i < inversion.length; i++) {
            suma += inversion[i];
        }
        return suma;
    }

}
