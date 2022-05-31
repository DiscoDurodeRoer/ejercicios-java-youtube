package ejercicio_recursividad_ddr_33;

public class Ejercicio_recursividad_DDR_33 {

    public static void main(String[] args) {

        // Zonas donde puedo puntuar
        int zonas[] = {10, 25, 50, 75};

        // numero de dardos que lanzo
        int dardos = 5;
        // Regiones con el numero de dardos en cada region
        int regionesDadas[] = new int[zonas.length];
        // puntuacion que se debe llegar
        int puntuacion = 100;
        int etapa = 0;

        dardosV2(zonas, regionesDadas, dardos, etapa, 0, puntuacion);

    }

    public static void dardosV2(
            int[] zonas,
            int[] regionesDadas,
            int dardos,
            int etapa,
            int puntuacionActual,
            int puntuacionIgualar
    ) {

        // CASO BASE: 
        //  - Que hayamos recorrido todo
        //  - Que nos quedemos sin dardos
        //  - Que la puntuacion llegue a 0
        if (dardos == 0 || etapa == zonas.length || calcularPuntuacion(zonas, regionesDadas) == puntuacionIgualar) {
            // Si entra, puede ser que sea por la puntuacion
            if (calcularPuntuacion(zonas, regionesDadas) == puntuacionIgualar) {
                mostrarSolucion(zonas, regionesDadas);
            }

        } else {

            // Recorro tanto como dardos tenga (en este caso puedo lanzar de 0 a 5 dardos)
            // Si en algun momento, la variable fin es true, terminamos
            for (int d = 0; d <= dardos; d++) {

                // Calculo la puntuacion si tirase x dardos a una zona conreta
                // Por ejemplo: si tirase 3 dardos a la zona 10 serian 30
                int puntuacionZona = zonas[etapa] * d;

                // Sumo esa puntuación a la total para saber si me paso o no
                int puntuacionRestante = puntuacionActual + puntuacionZona;

                // Compruebo si la puntuacion es mayor que cero
                if (puntuacionRestante <= puntuacionIgualar) {

                    // Actualizo las regionesDada con el numero de dardos
                    regionesDadas[etapa] = d;

                    dardosV2(
                            zonas,
                            regionesDadas,
                            dardos - d,
                            etapa + 1,
                            puntuacionActual + puntuacionZona,
                            puntuacionIgualar
                    );

                    // Deshago, sino lo hago el resultado daria mal ya que habria regiones Dadas que no se limpiarian
                    regionesDadas[etapa] = 0;

                }

            }

        }

    }

    /**
     * Calcula los puntos de las zonas segun las regiones dadas
     *
     * @param zonas
     * @param regionesDada
     * @return
     */
    public static int calcularPuntuacion(int[] zonas, int[] regionesDada) {

        int puntos = 0;
        // Recorro las regiones donde tengo el numero de dardos
        for (int i = 0; i < regionesDada.length; i++) {
            // Sumo los puntos
            puntos += zonas[i] * regionesDada[i];
        }
        return puntos;
    }

    /**
     * Muestra el resultado segun los dardos usados Por ejemplo: 0 2 1 0
     * (regiones) => 25 25 50
     *
     * @param zonas
     * @param regionesDada
     */
    public static void mostrarSolucion(int[] zonas, int[] regionesDada) {

        // Recorro las regiones donde tengo el numero de dardos
        for (int i = 0; i < regionesDada.length; i++) {
            // Si es distinto de cero
            if (regionesDada[i] != 0) {

                // muestro la zona repetida tantas veces como dardos haya
                for (int j = 0; j < regionesDada[i]; j++) {
                    System.out.print(zonas[i] + " ");
                }
            }
        }
        System.out.println("");

    }

}
