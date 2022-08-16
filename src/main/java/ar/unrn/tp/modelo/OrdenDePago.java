package ar.unrn.tp.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdenDePago {
    private Date fechaVenta;
    private Cliente cliente;
    private List<Producto> listaProductos = new ArrayList<Producto>();
    private double montoTotal;

    public OrdenDePago(Date fechaVenta, Cliente cliente, List<Producto> listaProductos, double montoTotal) {
        this.fechaVenta = fechaVenta;
        this.cliente = cliente;
        this.listaProductos = listaProductos;
        this.montoTotal = montoTotal;
    }
}
