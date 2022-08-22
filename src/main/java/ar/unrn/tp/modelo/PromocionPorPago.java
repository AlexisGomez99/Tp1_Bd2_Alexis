package ar.unrn.tp.modelo;

import ar.unrn.tp.exception.NotNullException;

import java.util.Date;
import java.util.List;

public class PromocionPorPago extends Promocion{

    private TarjetaDeCredito tarjeta;


    public PromocionPorPago(Date fechaInicio, Date fechaFin, TarjetaDeCredito tarjeta, double descuento) {
        super(fechaInicio,fechaFin,descuento);
        this.tarjeta = tarjeta;
    }


    @Override
    public double aplicarDescuento(List<Producto> productos, String tarjeta) {
        Date hoy= new Date();
        double total=0;
        if (hoy.before(this.fechaFin) && hoy.after(this.fechaInicio) && this.tarjeta.getNombre().equalsIgnoreCase(tarjeta)){
            total = getTotal(productos);
            total = total * this.descuento;
        }
        return total;
    }


    public double getTotal(List<Producto> productos) {
        double total = 0;
        if(productos != null) {
            for (Producto prod : productos) {
                total = total + prod.getPrecio();
            }
        }
        return total;
    }

}
