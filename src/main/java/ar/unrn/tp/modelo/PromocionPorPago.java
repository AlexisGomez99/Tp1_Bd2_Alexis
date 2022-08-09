package ar.unrn.tp.modelo;

import java.util.Date;
import java.util.List;

public class PromocionPorPago implements Promocion {
    private Promocion orden;
    private Date fechaInicio;
    private Date fechaFin;
    private Marca marca;
    private double descuento;

    public PromocionPorPago( Date fechaInicio, Date fechaFin, Marca marca, int descuento) {
        this.orden = orden;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.marca = marca;
        this.descuento = descuento;
    }

    @Override
    public double devolverPrecio(CarritoDeCompra carrito) {
        List<Producto> productos = carrito.devolverProductos();

        double total=0;
        for (Producto prod : productos){
            if(carrito.fechaVenta().before(this.fechaFin) && carrito.fechaVenta().after(this.fechaInicio) && prod.getMarca().equals(this.marca)){
                total += total + prod.getPrecio() * this.descuento;
            }
            else {
                total += total + prod.getPrecio();
            }
        }
        return total;
    }

}
