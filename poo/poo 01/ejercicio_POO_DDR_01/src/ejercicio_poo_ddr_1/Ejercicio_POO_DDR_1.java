package ejercicio_poo_ddr_1;

public class Ejercicio_POO_DDR_1 {

    public static void main(String[] args) {
       
        //Creamos lo objetos
        Libro libro1=new Libro(1111111111, "titulo1", "autor1", 30);
        Libro libro2=new Libro(1111111112, "titulo2", "autor2", 60);
        
        //Mostramos su estado
        System.out.println(libro1.toString());
        System.out.println(libro2.toString());
        
        //Modificamos el atributo numPaginas del libro1
        libro1.setNumPaginas(70);
        
        //Comparamos quien tiene mas paginas
        if(libro1.getNumPaginas()>libro2.getNumPaginas()){
            System.out.println(libro1.getTitulo()+" tiene más páginas");
        }else{
            System.out.println(libro2.getTitulo()+" tiene más páginas");
        }
        
        
    }
    
}
