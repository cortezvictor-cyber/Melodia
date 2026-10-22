package Modelo;

import java.util.ArrayList;
import java.util.HashSet;

public class CatalogoMelodias {
    private ArrayList<Melodia> canciones = new ArrayList<>();
    public ArrayList<String> obtenerTodosLosGeneros() {
        ArrayList<String> generos = new ArrayList<>();
        for (Melodia cancion : canciones) {
            if (!generos.contains(cancion.getGenero())) {
                generos.add(cancion.getGenero());
            }
        }
        return generos;
    }
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
    public Melodia buscar(int id) {
        for (Melodia c : canciones) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
    public boolean removerMelodia(int id) {
        return canciones.removeIf(c -> c.getId() == id);
    }
    public boolean actualizarMelodia(int id, String nombre, String compositor, int anio, String genero, String cantante, double precio, String formato) {
        Melodia amp = buscar(id);
        if (amp != null) {
            amp.setNombre(nombre);
            amp.setCompositor(compositor);
            amp.setAnio(anio);
            amp.setGenero(genero);
            amp.setCantante(cantante);
            amp.setPrecio(precio);
            amp.setFormato(formato);
            return true;
        }
        return false;

}

    public ArrayList<Melodia> melodiasPorCantante(String cantante) {
        ArrayList<Melodia> resultado = new ArrayList<>();
        for (Melodia cancion : canciones) {
            if (cancion.getCantante().equalsIgnoreCase(cantante)) {
                resultado.add(cancion);
            }
        }
        return resultado;
    }


    public HashSet<String> obtenerCantantes() {
        HashSet<String> cantantes = new HashSet<>();
        for (Melodia cancion : canciones) {
            cantantes.add(cancion.getCantante());
        }
        return cantantes;
    }


    public int obtenerCantidadCantantes() {
        return obtenerCantantes().size();
    }
    public String obtenerConteoFormatos() {
        int mp3 = 0, ogg = 0, wav = 0;
        for (Melodia cancion : canciones) {
            if (cancion.getFormato().equalsIgnoreCase("mp3")) mp3++;
            else if (cancion.getFormato().equalsIgnoreCase("ogg")) ogg++;
            else if (cancion.getFormato().equalsIgnoreCase("wav")) wav++;
        }
        return "Formatos -> MP3: " + mp3 + ", OGG: " + ogg + ", WAV: " + wav;
    }
}


