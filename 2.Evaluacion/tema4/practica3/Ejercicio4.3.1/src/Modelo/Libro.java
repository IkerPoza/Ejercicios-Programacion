package Modelo;

public class Libro {
    private String titulo;
    private String editorial;
    private int numeroPaginas;
    private int numeroEjemplares;
    private Autor autor;

    public Libro(String titulo, String editorial, int numeroPaginas, Autor autor) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.numeroPaginas = numeroPaginas;
        this.numeroEjemplares = 3;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public int getNumeroEjemplares() {
        return numeroEjemplares;
    }

    public void setNumeroEjemplares(int numeroEjemplares) {
        this.numeroEjemplares = numeroEjemplares;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void alquilar(Alumno alumno){
        if (this.numeroEjemplares>0){
            numeroEjemplares--;
            alumno.alquilar(this);
        }else {
            System.out.println("Este libro no tiene mas ejemplares.");
        }
    }

    public void devolver (Alumno alumno){
        numeroEjemplares++;
    }

    public String mostrar(){
        return "El libro con el titulo "+titulo+ " es de la editorial "+editorial+ " y tiene "+numeroPaginas+" paginas.";
    }
}
