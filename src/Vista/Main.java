package Vista;

import Control.ControlCatalogo;
import Modelo.CatalogoMelodias;
import Modelo.Melodia;

public class Main {
  public static void main(String[] args) {
    CatalogoMelodias melodias = new CatalogoMelodias();

    Melodia m1 = new Melodia();
    m1.generarId();

    Melodia m2 = new Melodia(2, "Vete", "Alfredo Olivas", 2022, "Banda", "Alfredo Olivas", 150.0, "mp3");
    Melodia m3 = new Melodia(3, "Imaginacion", "Alfredo Olivas", 2025, "Banda", "Alfredo Olivas", 180.5, "flac");
    Melodia m4 = new Melodia(4, "Hotel California", "Don Felder", 1976, "Rock", "Eagles", 170.0, "wav");

    System.out.println("Registro m1: " + (melodias.registrarMelodia(m1) ? "No se pudo" : "Registrada"));
    System.out.println("Registro m2: " + (melodias.registrarMelodia(m2) ? "No se pudo" : "Registrada"));
    System.out.println("Registro m3: " + (melodias.registrarMelodia(m3) ? "No se pudo" : "Registrada"));
    System.out.println("Registro m4: " + (melodias.registrarMelodia(m4) ? "No se pudo" : "Registrada"));

    System.out.println("Registro duplicado m2: " + (melodias.registrarMelodia(m2) ? "No se pudo" : "Registrada"));

    System.out.println("\n--- Catálogo ---");
    System.out.println(melodias.mostrarTodasMelodias());
    System.out.println("Géneros: " + melodias.obtenerGeneros());

    System.out.println("Anio: " + melodias.obtenerPorAnio(2022));
    System.out.println("Compositor: " + melodias.melodiasPorCompositor("Alfredo olivas"));
CatalogoMelodias modelo=new CatalogoMelodias();
CatalogoView vista=new CatalogoView();
    ControlCatalogo control=new ControlCatalogo(vista,modelo);
    control.iniciar();

  }
}



