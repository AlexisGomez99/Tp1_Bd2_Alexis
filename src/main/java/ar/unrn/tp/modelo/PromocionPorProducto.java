package ar.unrn.tp.modelo;

import java.util.Date;
import java.util.List;

public class PromocionPorProducto implements Promocion {

    private Date fechaInicio;
    private Date fechaFin;
    private TarjetaDeCredito tarjeta;
    private double descuento;

    public PromocionPorProducto( Date fechaInicio, Date fechaFin,TarjetaDeCredito tarjeta,int descuento) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tarjeta = tarjeta;
        this.descuento = descuento;
    }

    @Override
    public double devolverPrecio(CarritoDeCompra carrito) {
        List<Producto> productos = carrito.devolverProductos();

        double total=0;
        for (Producto prod : productos){
            if(carrito.fechaVenta().before(this.fechaFin) && carrito.fechaVenta().after(this.fechaInicio)){
                total += total + prod.getPrecio() * this.descuento;
            }
            else {
                total += total + prod.getPrecio();
            }
        }
        return total;
    }

}
