package Vista;

import Control.ControlCatalogo;
import Modelo.CatalogoMelodias;
import Modelo.Melodia;

public class Main {
  public static void main(String[] args) {
    CatalogoMelodias melodias = new CatalogoMelodias();

    Melodia m1 = new Melodia();
    m1.generarId();

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



