package ar.unrn.tp.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Carrito {
    private PromocionPorPago porPago;
    private PromocionPorProducto porProducto;
    private List<Producto> productoList = new ArrayList<Producto>();
    private Cliente cliente;
    private TarjetaDeCredito tarjeta;
    public Carrito(Date fechaInicioPago, Date fechaFinPago, TarjetaDeCredito tarjetaPago,
                   Date fechaInicioProd, Date fechaFinProd, Marca marcaProd) {
        this.porPago = new PromocionPorPago(fechaInicioPago,fechaFinPago,tarjetaPago);
        this.porProducto = new PromocionPorProducto(fechaInicioProd, fechaFinProd, marcaProd);
    }
    public void asociarCliente(Cliente cliente){
        this.cliente= cliente;
    }
    public void asociarTarjeta(TarjetaDeCredito tarjeta){
        this.tarjeta=tarjeta;
    }
    public void agregarProducto(Producto prod){
        productoList.add(prod);
    }
    public void calcularDescuento(){
         System.out.println("Precio con descuentos = "+ this.aplicarDescuento());
    }

    private double aplicarDescuento(){
        double total = this.porProducto.aplicarDescuento(this.productoList);
        total = this.porPago.aplicarDescuento(total,this.tarjeta);
        return total;
    }

    public OrdenDePago comprarListado(){
        double total= this.aplicarDescuento();
        OrdenDePago venta= new OrdenDePago(new Date(), this.cliente,this.productoList,total);
        return venta;
    }
}
