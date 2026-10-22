package Vista;

import Control.ControlCatalogo;
import Modelo.CatalogoMelodias;
import Modelo.Melodia;

public class Main {
  public static void main(String[] args) {
    // Inicializamos el modelo, la vista y el controlador principal
    CatalogoMelodias modelo = new CatalogoMelodias();
    CatalogoView vista = new CatalogoView();

    // (Opcional) Si quieres probar agregando la melodía por defecto al iniciar:
    Melodia m1 = new Melodia();
    modelo.registrarMelodia(m1);

    ControlCatalogo control = new ControlCatalogo(vista, modelo);
    control.iniciar();
  }
}


