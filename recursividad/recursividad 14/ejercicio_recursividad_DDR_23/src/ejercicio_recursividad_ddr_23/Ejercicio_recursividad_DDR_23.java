package ejercicio_recursividad_ddr_23;

public class Ejercicio_recursividad_DDR_23 {

    public static void main(String[] args) {

        int[] dados = {1, 1, 1};
        int valorSuperar = 15;

        tiradas(dados, valorSuperar, 0, 0);
    }

    public static void tiradas(int[] dados, int valorSuperar, int suma, int tirada) {

        //Si la tirada es el numero de dados y la suma es mayor que el valor a superar
        //muestro la solucion
        if (tirada == dados.length && suma >= valorSuperar) {

            for (int i = 0; i < dados.length; i++) {
                if (i == dados.length-1) {
                    System.out.print(dados[i] + "=");
                } else {
                    System.out.print(dados[i] + "+");
                }

            }
            System.out.println(suma);

        } else if (tirada != dados.length) { //Evita problemas por si la tirada es mayor o igual que 3
            for (int i = 1; i <= 6; i++) {
                dados[tirada] = i; //le doy valor al dado

                suma += i; //sumo

                tiradas(dados, valorSuperar, suma, tirada + 1);

                suma -= i; // deshago la suma
            }

        }

    }

}
