package ar.unrn.tp.modelo;

import java.util.List;

public class Cliente {
    private String nombre;
    private String apellido;
    private String email;
    private int DNI;

    private List<TarjetaDeCredito> tarjetas;

    public Cliente(String nombre, String apellido, String email, int DNI, TarjetaDeCredito tarjeta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.DNI = DNI;
        this.tarjetas.add(tarjeta);
    }

    public void agregarTarjeta(TarjetaDeCredito tarjeta){
        this.tarjetas.add(tarjeta);
    }


}
