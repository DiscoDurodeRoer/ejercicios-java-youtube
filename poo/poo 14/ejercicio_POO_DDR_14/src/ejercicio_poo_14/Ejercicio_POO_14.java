/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_poo_14;

import java.io.IOException;
import java.security.InvalidParameterException;
import javax.mail.MessagingException;

public class Ejercicio_POO_14 {

    public static void main(String[] args) {

        try {
            Mail m = new Mail("config/configuracion.prop");

            m.enviarEmail("Test", "Hola mundo", "administrador@discoduroderoer.es");
            
            String correos[] = {"administrador@discoduroderoer.es", "pikao3000@gmail.com"};
            
            m.enviarEmail("Test", "Hola mundo", correos);

            System.out.println("Se ha enviado!!");
        } catch (InvalidParameterException | IOException | MessagingException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
