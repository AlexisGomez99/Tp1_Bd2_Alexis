package ar.unrn.tp.modelo;

public class Cliente {
    private String nombre;
    private String apellido;
    private String email;
    private int DNI;
    private TarjetaDeCredito tarjeta;

    public Cliente(String nombre, String apellido, String email, int DNI, TarjetaDeCredito tarjeta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.DNI = DNI;
        this.tarjeta = tarjeta;
    }
}
