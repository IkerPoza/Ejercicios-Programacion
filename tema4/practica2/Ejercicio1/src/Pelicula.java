import java.util.ArrayList;

public class Pelicula {
    private String titulo;
    private int ano;
    private int duracion;
    private String tipo;
    private ArrayList<Estudio> estudios = new ArrayList<>();

    public Pelicula(String titulo, int ano, int duracion, String tipo, ArrayList<Estudio> estudios) {
        this.titulo = titulo;
        this.ano = ano;
        this.duracion = duracion;
        this.tipo = tipo;
        this.estudios = estudios;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Estudio> getEstudios() {
        return estudios;
    }

    public void setEstudios(ArrayList<Estudio> estudios) {
        this.estudios = estudios;
    }


}
