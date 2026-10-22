package Modelo;

import java.util.ArrayList;
import java.util.HashSet;

public class CatalogoMelodias {
    private ArrayList<Melodia> canciones = new ArrayList<>();
    public boolean registrarMelodia(Melodia obj) {
        for (Melodia melodia : canciones) {
            if (melodia.getId() == obj.getId()) {
                return true;
            }
        }
        canciones.add(obj);
        return false;
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
    public void crearObjetoMelodia(String nm, String nca, String nco, int anio,double precio,String formato,String genero) {
        registrarMelodia(new Melodia(nm, nco, anio, genero, nca, precio, formato));
    }
    }


