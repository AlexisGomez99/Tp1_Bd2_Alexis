package ar.unrn.tp.modelo;

import java.util.Date;

public class TarjetaDeCredito {
    private String nombre;
    private Date fechaVencimiento;
    private int numero;
    private double fondos;

    public TarjetaDeCredito(String nombre, Date fechaVencimiento, int numero, double fondos) {
        this.nombre = nombre;
        this.fechaVencimiento = fechaVencimiento;
        this.numero = numero;
        this.fondos = fondos;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregar(double monto){
        this.fondos=this.fondos+monto;
    }
    public void descontar(double monto){
        this.fondos=this.fondos-monto;
    }

    public double getTotal(){
        return this.fondos;
    }
}

