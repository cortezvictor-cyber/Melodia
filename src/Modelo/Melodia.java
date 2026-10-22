package Modelo;

public class Melodia {
    private int id;
    private String nombre;
    private String compositor;
    private int anio;
    private String genero;
    private String cantante;
    private double precio;
    private String formato;

    public Melodia(int id, String nombre, String compositor, int anio, String genero, String cantante, double precio, String formato) {
        this.id = id;
        this.nombre = nombre;
        this.compositor = compositor;
        this.anio = anio;
        this.genero = genero;
        this.cantante = cantante;
        this.precio = precio;
        this.formato = formato;
    }
    public Melodia(){
        this.id =this.hashCode() ;
        this.nombre = "La batalla de mi vida";
        this.compositor ="Alfredo Olivas";
        this.anio = 2026;
        this.genero = "Banda";
        this.cantante = "Alfredo Olivas";
        this.precio = 200;
        this.formato = "mp3";
    }

    public Melodia(String nm, String nco, int anio, String genero, String nca, double precio, String formato) {
    }


    public int getId(){
        return id;
    }
    public void generarId(){
        this.id=this.hashCode();
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    @Override
    public String toString() {
        return "Modelo.Melodia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", compositor='" + compositor + '\'' +
                ", anio=" + anio +
                ", genero='" + genero + '\'' +
                ", cantante='" + cantante + '\'' +
                ", precio=" + precio +
                ", formato='" + formato + '\'' +
                '}';
    }

}
