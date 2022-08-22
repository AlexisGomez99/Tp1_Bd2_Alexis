package ar.unrn.tp.modelo;

import java.util.Date;
import java.util.List;

public class PromocionPorProducto extends Promocion{
    private Marca marca;

    public PromocionPorProducto(Date fechaInicio, Date fechaFin, Marca marca, double descuento) {
        super(fechaInicio,fechaFin,descuento);
        this.marca = marca;

    }

    @Override
    public double aplicarDescuento(List<Producto> productos,String tarjeta) {
        Date hoy= new Date();
        double total=0;
        for (Producto prod : productos){

            if(hoy.before(this.fechaFin) && hoy.after(this.fechaInicio) && prod.getMarca().equals(this.marca)){
                total = total + (prod.getPrecio() * this.descuento);
            }
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
