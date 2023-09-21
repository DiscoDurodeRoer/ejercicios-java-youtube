package ejercicio_funciones_ddr_13;

public class Ejercicio_funciones_DDR_13 {

    public static void main(String[] args) {

        //Escribimos un CCC
        String CCC = "57472369937147769785";
        try {
            validarCCC(CCC); //Si salta excepcion, no ejecutara el mensaje siguiente
            System.out.println("CCC correcto");
        } catch (Exception ex) {
            System.out.println(ex.getMessage()); //muestro el error
        }
                
    }

    public static void validarCCC(String CCC) throws Exception {

        if (CCC.length() != 20) {
            throw new Exception("La longitud debe ser de 20 digitos"); //lanzo excepcion
        }

        //mensaje de error que ira variando segun el error
        String mensajeError="";
        String aux;
        
        String ent_of;
        String numeros_cuenta;
        String digitos_control_resultado;

        //Digitos resultados de entidad - oficina y numero de cuenta
        int digito_ent_of, digito_num_cuenta;
        
        //4 casos
        // entidad, oficina y numero de cuenta, solo hay que validar que son numeros
        for (int i = 0; i < 4; i++) {

            try {

                switch (i) {
                    case 0: //entidad
                        aux = CCC.substring(0, 4);
                        mensajeError = "Los digitos de la entidad no son numeros";
                        Integer.parseInt(aux);

                        break;
                    case 1: //oficina
                        aux = CCC.substring(4, 8);
                        mensajeError = "Los digitos de la oficina no son numeros";
                        Integer.parseInt(aux);
                        break;
                    case 2: // numero de cuenta
                        aux = CCC.substring(10, 20);
                        mensajeError = "Los digitos del numero de cuenta no son numeros";
                        Long.parseLong(aux);
                        break;
                    case 3: //digito de control
                        aux = CCC.substring(8, 10);
                        mensajeError = "Los digitos de control no son numeros";
                        Integer.parseInt(aux);
                        
                        ent_of = "00" + CCC.substring(0,8);
                        numeros_cuenta = CCC.substring(10, 20);
                        
                        //digito de los numeros de la izquierda
                        digito_ent_of = obtenerDigitoControl(ent_of);
                        
                        //digito de los numeros de la derecha
                        digito_num_cuenta = obtenerDigitoControl(numeros_cuenta);
                        
                        //obtengo el resultado de los digitos en un String
                        digitos_control_resultado = String.valueOf(digito_ent_of) + String.valueOf(digito_num_cuenta);
                        
                        //comparo si son iguales
                        if(!digitos_control_resultado.equals(aux)){
                            mensajeError = "Los digitos de control no coinciden";
                            throw new Exception(mensajeError); //lanzo excepcion
                        }
                        
                        break;
                    
                }

            } catch (NumberFormatException e) { //Captura la excepcion cuando no se puede convertir el numero
                throw new Exception(mensajeError); //lanzo excepcion, solo cuando no se pueda convertir a numero
            }

        }

    }

    public static int obtenerDigitoControl(String valor_cuenta) {

        int[] factores = {1, 2, 4, 8, 5, 10, 9, 7, 3, 6}; //valores predefinidos
        int digito_control = 0;

        int digito_cuenta;
        
        //Cojemos cada digito pasado por parametro y lo multiplicamos por los factores
        for (int i = 0; i < valor_cuenta.length(); i++) {
            digito_cuenta = Integer.parseInt(String.valueOf(valor_cuenta.charAt(i)));
            digito_control += digito_cuenta * factores[i];
        }
        
        digito_control = 11 - (digito_control % 11);
        
        //si es 11 o 10 (solo es un digito) le cambiamos el valor,
        // en caso de que no lo sean devolvera el digito tal cual
        if (digito_control == 11) {
            digito_control = 0;
        } else if (digito_control == 10) {
            digito_control = 1;
        }
        return digito_control;

    }

}
