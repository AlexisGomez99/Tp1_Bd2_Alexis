package ar.unrn.tp.modelo;

import ar.unrn.tp.exception.NotNullException;
import ar.unrn.tp.exception.NotNumException;

public class Producto {
    private int codigo;
    private String descripcion;
    private String categoria;
    private double precio;
    private Marca marca;

    public Producto(int codigo, String descripcion, String categoria, String precio, Marca marca) throws NotNullException, NotNumException {

        if (descripcion == null)
            throw new NotNullException("descripcion");
        if (precio == null)
            throw new NotNullException("precio");
        if (categoria == null)
            throw new NotNullException("categoria");


        if (!isNumeric(precio))
            throw new NotNumException();

        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = Integer.parseInt(precio);
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

    private static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
}
