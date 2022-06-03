package ejecicio_poo_ddr_16;

import es.discoduroderoer.expresiones_regulares.ExpresionesRegulares;

public class ErroresFormulario {

    private StringBuilder errores;

    public ErroresFormulario() {
        this.errores = new StringBuilder();
    }

    public boolean hasError() {
        return !this.errores.toString().isEmpty();
    }

    public String getErrores() {
        return errores.toString();
    }

    public void validarNumeroEntero(String textoValidar) {
        if (!ExpresionesRegulares.validaNumeroEntero_Exp(textoValidar)) {
            this.errores.append(" - ").append(textoValidar).append(" no es un numero entero\n");
        }
    }

    public void validarNumeroEntero(String textoValidar, String mensajeError) {
        if (!ExpresionesRegulares.validaNumeroEntero_Exp(textoValidar)) {
            this.errores.append(mensajeError);
        }
    }

    public void validarNumeroReal(String textoValidar) {
        if (!ExpresionesRegulares.validaNumeroReal_Exp(textoValidar)) {
            this.errores.append(" - ").append(textoValidar).append(" no es un numero real\n");
        }
    }

    public void validarNumeroReal(String textoValidar, String mensajeError) {
        if (!ExpresionesRegulares.validaNumeroReal_Exp(textoValidar)) {
            this.errores.append(mensajeError);
        }
    }

}
