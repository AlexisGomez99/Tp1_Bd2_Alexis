package ar.unrn.tp.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venta {
    private Date fechaVenta;
    private Cliente cliente;
    private List<ProductoVendido> listaProductos = new ArrayList<ProductoVendido>();
    private double descuentoAplicado;

    public Venta(Date fechaVenta, Cliente cliente, List<Producto> listaProductos, double montoTotal) {
        this.fechaVenta = fechaVenta;
        this.cliente = cliente;
        this.listaProductos = this.convertProd(listaProductos);
        this.descuentoAplicado = montoTotal;
    }

    private List<ProductoVendido> convertProd(List<Producto> listaProductos){
        List<ProductoVendido> list = new ArrayList<>();
        for (Producto prod: listaProductos){
            list.add(new ProductoVendido(prod.getDescripcion(),prod.getPrecio(),prod.getMarca()));
        }

        return list;
    }
}
