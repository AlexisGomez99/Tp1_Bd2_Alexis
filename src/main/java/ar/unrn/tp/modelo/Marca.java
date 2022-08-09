package ar.unrn.tp.modelo;

import java.util.Objects;

public class Marca {
    private String nombre;

    public Marca(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marca marca = (Marca) o;
        return Objects.equals(getNombre(), marca.getNombre());
    }

    public String getNombre() {
        return nombre;
    }
}
