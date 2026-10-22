package Modelo;

import java.util.ArrayList;
import java.util.HashSet;

public class CatalogoMelodias {
    private ArrayList<Melodia> canciones = new ArrayList<>();

    // Registro usando la validación de equals (cantante y año)
    public boolean registrarMelodia(Melodia obj) {
        if (canciones.contains(obj)) {
            return true; // Ya existe (duplicado)
        }
        canciones.add(obj);
        return false; // Registrado con éxito
    }

    public boolean removerMelodia(String nombre) {
        return canciones.removeIf(c -> c.getNombre().equalsIgnoreCase(nombre));
    }

    public ArrayList<Melodia> buscar(String nombreMelodia) {
        ArrayList<Melodia> resultado = new ArrayList<>();
        for (Melodia c : canciones) {
            if (c.getNombre().equalsIgnoreCase(nombreMelodia)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public String mostrarTodasMelodias() {
        StringBuffer sb = new StringBuffer();
        for (Melodia melodia : canciones) {
            sb.append(melodia);
            sb.append("\n");
        }
        return sb.toString();
    }

    public HashSet<String> obtenerGeneros() {
        HashSet<String> generos = new HashSet<>();
        for (Melodia cancion : canciones) {
            generos.add(cancion.getGenero());
        }
        return generos;
    }

    public ArrayList<Melodia> obtenerPorAnio(int anio) {
        ArrayList<Melodia> resultado = new ArrayList<>();
        for (Melodia cancion : canciones) {
            if (cancion.getAnio() == anio) {
                resultado.add(cancion);
            }
        }
        return resultado;
    }

    public ArrayList<Melodia> melodiasPorCompositor(String compositor) {
        ArrayList<Melodia> resultado = new ArrayList<>();
        for (Melodia cancion : canciones) {
            if (cancion.getCompositor().equalsIgnoreCase(compositor)) {
                resultado.add(cancion);
            }
        }
        return resultado;
    }

    public double obtenerPrecioColeccion() {
        double total = 0;
        for (Melodia c : canciones) {
            total += c.getPrecio();
        }
        return total;
    }

    public void ordenarMelodiasPorPrecio() {
        canciones.sort((m1, m2) -> Double.compare(m1.getPrecio(), m2.getPrecio()));
    }

    public void ordenarMelodiasPorAnio() {
        canciones.sort((m1, m2) -> Integer.compare(m1.getAnio(), m2.getAnio()));
    }

    public void ordenarMelodiasPorCantante() {
        canciones.sort((m1, m2) -> m1.getCantante().compareToIgnoreCase(m2.getCantante()));
    }

    public void crearObjetoMelodia(String nm, String nca, String nco, int anio, double precio, String formato, String genero) {
        registrarMelodia(new Melodia(nm, nco, anio, genero, nca, precio, formato));
    }
}


