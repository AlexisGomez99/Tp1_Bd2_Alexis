package ar.unrn.tp.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Promocion{
    private PromocionPorPago porPago;
    private PromocionPorProducto porProducto;

    public Promocion(Date fechaInicioPago, Date fechaFinPago, TarjetaDeCredito tarjetaPago,
                     Date fechaInicioProd, Date fechaFinProd, Marca marcaProd) {
        this.porPago = new PromocionPorPago(fechaInicioPago,fechaFinPago,tarjetaPago);
        this.porProducto = new PromocionPorProducto(fechaInicioProd, fechaFinProd, marcaProd);
    }

    public void calcularDescuento(CarritoDeCompra carrito){
         System.out.println("Precio con descuentos = "+ this.aplicarDescuento(carrito));
    }

    private double aplicarDescuento(CarritoDeCompra carrito){
        double total = this.porProducto.aplicarDescuento(carrito);
        total = this.porPago.aplicarDescuento(total,carrito.obtenerTarjetaAsociada());
        return total;
    }

    public OrdenDePago comprarListado(CarritoDeCompra carrito){
        double total= this.aplicarDescuento(carrito);
        OrdenDePago venta= new OrdenDePago(new Date(), carrito.obtenerCliente(),carrito.obtenerListaProductos(),total);
        return venta;
    }
}
