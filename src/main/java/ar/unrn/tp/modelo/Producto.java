package ar.unrn.tp.modelo;

public class Producto {
    private int codigo;
    private String descripcion;
    private String categoria;
    private double precio;
    private Marca marca;

    public Producto(int codigo, String descripcion, String categoria, double precio, Marca marca) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.marca = marca;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public Marca getMarca() {
        return marca;
    }
}
