package ejercicio_recursividad_DDR_24;

public class Ejercicio_recursividad_DDR_24 {

    public static void main(String[] args) {

        //Array con todas las becas
        Beca[] becas
                = {
                    new Beca(1, 5, 250),
                    new Beca(6, 12, 100),
                    new Beca(5, 8, 350),
                    new Beca(1, 4, 150)
                };

        //Arrays con las becas que combinaremos
        Beca[] becasUsadas = new Beca[becas.length];
        //Array con las becas mas optimas
        Beca[] solucion = new Beca[becas.length];

        //Llamada inicial
        mejoresBecas(becas, becasUsadas, solucion, 0);

        //Muestramos la solucion
        for (int i = 0; i < solucion.length; i++) {
            if (solucion[i] != null) {
                System.out.println(solucion[i]);
            }
        }
        System.out.println(sumaBecas(solucion));

    }

    public static void mejoresBecas(Beca[] becas, Beca[] becasUsadas, Beca[] solucion, int etapa) {

        //Caso base, hasta que lleguemos al final del array
        if (etapa == becas.length - 1) {

            //Cojo las ganacias de las becas
            int ganaciaBecasUsadas = sumaBecas(becasUsadas);
            int ganaciaSolucion = sumaBecas(solucion);

            //Si las ganacias se superan, se copian la solucion optima
            if (ganaciaBecasUsadas > ganaciaSolucion) {
                for (int i = 0; i < becasUsadas.length; i++) {
                    solucion[i] = becasUsadas[i];
                }
            }

        } else {

            for (int i = 0; i < becas.length; i++) {

                //Indica si es compatible con las que tenemos
                if (esValida(becasUsadas, becas[i])) {

                    //inserto beca
                    becasUsadas[etapa] = becas[i];
                    mejoresBecas(becas, becasUsadas, solucion, etapa + 1);
                    //elimino beca
                    becasUsadas[etapa] = null;

                } else {
                    //Sigo hacia delante, sin meter la beca
                    mejoresBecas(becas, becasUsadas, solucion, etapa + 1);
                }

            }

        }

    }

    public static boolean esValida(Beca[] becasUsadas, Beca b) {

        boolean correcto = true;
        for (int i = 0; i < becasUsadas.length; i++) {
            if (becasUsadas[i] != null && !becasUsadas[i].compatible(b)) {
                correcto = false;
            }
        }
        return correcto;

    }

    public static int sumaBecas(Beca[] becas) {

        int suma = 0;
        for (int i = 0; i < becas.length; i++) {
            if (becas[i] != null) {
                suma += becas[i].precioBeca();
            }
        }

        return suma;

    }

}
