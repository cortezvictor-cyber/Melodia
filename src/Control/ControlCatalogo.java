package Control;

import Modelo.CatalogoMelodias;
import Modelo.Melodia;
import Vista.CatalogoView;


    public class ControlCatalogo {
        private CatalogoMelodias modelo;
        private CatalogoView vista;

        public ControlCatalogo(CatalogoView vista, CatalogoMelodias modelo) {
            this.modelo = modelo;
            this.vista = vista;
        }

        public void iniciar() {
            int opcion = 0;
            while (opcion != 3) {
                opcion = vista.mostrarMenu();
                switch (opcion) {
                    case 1:
                        vista.mostrarCadena("Registrar una nueva melodia");
                        String n = vista.leerNombreMelodia();
                        String nca = vista.leerCantante();
                        String nco = vista.leerCompositor();
                        String gen = vista.mostrarObtenerGenero();
                        String formato=vista.mostrarObtenerFormato();
                        int anio = vista.leerAnioMelodia();
                        double precio=vista.leerPrecioMelodia();
                    //    public void crearObjetoMelodia(String nm, String nca, String nco, int anio,double precio,String formato,String genero) {
                      //  registrarMelodia(new Melodia(nm, nco, anio, genero, nca, precio, formato));
                    //}
modelo.crearObjetoMelodia(n, nca, nco, anio, precio, formato, gen);
        break;
                    case 2:
                        break;
                    case 3:
                        vista.mostrarCadena("Adios");
                }
            }
        }
    }