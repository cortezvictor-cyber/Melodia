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
            while (opcion != 6) {
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
                        modelo.crearObjetoMelodia(n, nca, nco, anio, precio, formato, gen);
                        vista.mostrarCadena("¡Melodía Registrada!");

        break;
                    case 2:
                        vista.mostrarCadena("\n Tu Catalogo");
                        vista.mostrarCatalogo(modelo.mostrarTodasMelodias());
                        break;
                    case 3:
                        String nombreBorar=vista.leerNombreParaBorrar();
                        boolean delete=modelo.removerMelodia(nombreBorar);
                        if(delete){
                            vista.mostrarCadena("The melody is eliminated");
                        }else{
                            vista.mostrarCadena("No se encontro la melodia");

                        }
                        break;
                    case 4:
                        double valorTot = modelo.obtenerPrecioColeccion();
                        vista.mostrarCadena("El valor monetario total de la colección es: $" + valorTot);
                        break;
                    case 5:
                        modelo.ordenarMelodiasPorPrecio();
                        vista.mostrarCadena("Catálogo ordenado por precio:");
                        vista.mostrarCatalogo(modelo.mostrarTodasMelodias());
                        break;
                    case 6:
                        vista.mostrarCadena("Adios");
                }
            }
        }
    }