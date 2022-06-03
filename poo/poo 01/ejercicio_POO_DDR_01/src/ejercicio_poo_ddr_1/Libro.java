package ejercicio_poo_ddr_1;

public class Libro {
    
    /*Atributos*/
    private int ISBN;
    private String titulo;
    private String autor;
    private int numPaginas;
    
    /*Constructores*/
    
    public Libro(int pISBN, String pTitulo, String pAutor, int pNumPaginas){
    
        ISBN=pISBN;
        titulo=pTitulo;
        autor=pAutor;
        numPaginas=pNumPaginas;
    
    }
    
    /*Metodos*/

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
    
    @Override
    public String toString(){
        return "El libro "+titulo+" con ISBN "+ISBN+""
                + " creado por el autor "+autor
                + " tiene "+numPaginas+" páginas";
    } 
    
    
    
}
