package ar.unrn.tp.modelo;

public abstract Promocion{
    private Date fechaInicio;
    private Date fechaFin;
    private double descuento;

    double aplicarDescuento(CarritoDeCompra carrito);

}
