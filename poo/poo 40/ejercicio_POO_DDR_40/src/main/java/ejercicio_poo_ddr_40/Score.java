package ejercicio_poo_ddr_40;

public class Score implements Comparable<Score> {

    private int puntuacion;
    private String nombre;

    public Score(int puntuacion, String nombre) throws Exception {
        this.puntuacion = puntuacion;
        comprobarNombre(nombre);
    }

    private void comprobarNombre(String nombre) throws Exception {
        // comprobamos la longitud del nombre
        if (nombre.length() != 3) {
            throw new Exception("El nombre debe tener 3 caracteres");
        }
        // Transformamos el nombre a mayusculas
        this.nombre = nombre.toUpperCase();
    }

    @Override
    public String toString() {
        return nombre + " " + puntuacion;
    }

    @Override
    public int compareTo(Score o) {
        // Puntuacion mayor va primero
        if(this.puntuacion > o.puntuacion){
            return -1;
            
        // Puntuacion menor va ultima
        }else if(this.puntuacion < o.puntuacion){
            return 1;
        }
        return 0;
    }
    
}
