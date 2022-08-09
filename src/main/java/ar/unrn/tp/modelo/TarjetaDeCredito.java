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
}

