package ar.unrn.tp.modelo;

import java.util.Date;
import java.util.List;

public class PromocionPorProducto  {

    private Date fechaInicio;
    private Date fechaFin;

    private Marca marca;
    private double descuento = 0.05;

    public PromocionPorProducto(Date fechaInicio, Date fechaFin, Marca marca) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.marca = marca;
    }

    public double aplicarDescuento(List<Producto> productos) {
        Date hoy= new Date();
        double total=0;
        for (Producto prod : productos){
            if(hoy.before(this.fechaFin) && hoy.after(this.fechaInicio) && prod.getMarca().equals(this.marca)){
                total += total + (prod.getPrecio() - prod.getPrecio() * this.descuento);
            }
            else {
                total += total + prod.getPrecio();
            }
        }
        return total;
    }

}
