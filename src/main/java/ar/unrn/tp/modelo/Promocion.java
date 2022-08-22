package ar.unrn.tp.modelo;

import ar.unrn.tp.exception.NotNullException;

import java.util.Date;
import java.util.List;

public abstract class Promocion {
    protected Date fechaInicio;
    protected Date fechaFin;
    protected double descuento;

    public Promocion(Date fechaInicio, Date fechaFin, double descuento) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descuento = descuento;
    }


    protected abstract double aplicarDescuento(List<Producto> productos, String tarjeta);

    protected double getTotal(List<Producto> productos) {
        return 0;
    }
}
