package ar.unrn.tp.modelo;

import ar.unrn.tp.exception.EmailException;
import ar.unrn.tp.exception.NotNullException;
import ar.unrn.tp.exception.NotNumException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {
    private String nombre;
    private String apellido;
    private String email;
    private int DNI;

    private Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    private List<TarjetaDeCredito> tarjetas = new ArrayList<>();

    public Cliente(String nombre, String apellido, String email, String DNI, TarjetaDeCredito tarjeta) throws NotNullException, NotNumException, EmailException {

        if (nombre == null)
            throw new NotNullException("nombre");
        if (apellido == null)
            throw new NotNullException("apellido");
        if (email == null)
            throw new NotNullException("email");
        if (DNI == null)
            throw new NotNullException("DNI");
        if (!isNumeric(DNI))
            throw new NotNumException();

        Matcher mather = pattern.matcher(email);
        if (mather.find() == false)
            throw new EmailException();

        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.DNI = Integer.parseInt(DNI);
        this.tarjetas.add(tarjeta);
    }

    public void agregarTarjeta(TarjetaDeCredito tarjeta){
        this.tarjetas.add(tarjeta);
    }

    public TarjetaDeCredito obtenerTarjeta(int index){
        return tarjetas.get(index);
    }
    private static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
}
