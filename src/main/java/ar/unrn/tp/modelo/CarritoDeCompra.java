package ar.unrn.tp.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarritoDeCompra {
    private List<Producto> productoList = new ArrayList<Producto>();
    private Cliente cliente;
    private TarjetaDeCredito tarjeta;
    public CarritoDeCompra(Cliente cliente) {
        this.cliente=cliente;
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
    public Cliente obtenerCliente(){
        return this.cliente;
    }
    public void vaciarCarrito(){
        productoList.clear();
    }
    public TarjetaDeCredito obtenerTarjetaAsociada(){
        return this.tarjeta;
    }
    public List<Producto> obtenerListaProductos(){
        return this.productoList;
    }


}
