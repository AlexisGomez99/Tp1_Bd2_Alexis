package ar.unrn.tp.modelo;

import ar.unrn.tp.exception.NotNullException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Carrito {
    private List<Promocion> promocions = new ArrayList<>();
    private List<Producto> productoList = new ArrayList<Producto>();
    private Cliente cliente;
    private TarjetaDeCredito tarjeta;
    public Carrito( List<Promocion> listPromociones) {
        this.promocions = listPromociones;
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




    public double calcularDescuento() throws NotNullException {
        return this.totalSinDescuento()- this.aplicarDescuento();
    }

    private double aplicarDescuento() throws NotNullException {
        if (tarjeta == null)
            throw new NotNullException("Tarjeta");
        double total= 0;
        for (Promocion prom : this.promocions){
            total = total + prom.aplicarDescuento(this.productoList,this.tarjeta.getNombre());
        }
        return total;
    }

    public Venta comprarListado() throws NotNullException {
        double total= this.aplicarDescuento();
        tarjeta.descontar(this.calcularDescuento());
        Venta venta= new Venta(new Date(), this.cliente,this.productoList,total);
        return venta;
    }

    public double totalSinDescuento() {
        double total = 0;
        if(this.productoList != null) {
            for (Producto prod : this.productoList) {
                total = total + prod.getPrecio();
            }
        }
        return total;
    }
}
