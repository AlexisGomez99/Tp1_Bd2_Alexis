package ar.unrn.tp.modelo;

public class ProductoVendido {
    private String nombre;
    private double costo;

    private Marca marca;

    public ProductoVendido(String nombre, double costo, Marca marca) {
        this.nombre = nombre;
        this.costo = costo;
        this.marca = marca;
    }
    public double getPrecio(){
        return this.costo;
    }
}
