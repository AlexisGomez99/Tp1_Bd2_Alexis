package ar.unrn.tp.modelo;

import java.util.Date;
import java.util.List;

public class PromocionPorPago {

    private Date fechaInicio;
    private Date fechaFin;

    private TarjetaDeCredito tarjeta;
    private double descuento = 0.08;

    public PromocionPorPago(Date fechaInicio, Date fechaFin, TarjetaDeCredito tarjeta) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tarjeta = tarjeta;
    }

    public double aplicarDescuento(double totalN, TarjetaDeCredito tarjeta) {
        Date hoy= new Date();
        double total = totalN;
        if(tarjeta!=null) {

                if (hoy.before(this.fechaFin) && hoy.after(this.fechaInicio) && this.tarjeta.equals(tarjeta)){
                    total = total - (total * this.descuento);
                }

        }
        else {
            System.out.println("necesita vincular una tarjeta/cliente para aplicar este descuento.");
        }
        return total;
    }

}
