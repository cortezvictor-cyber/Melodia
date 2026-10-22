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
            while (opcion != 15) {
                opcion = vista.mostrarMenu();
                switch (opcion) {
                    case 1:
                        vista.mostrarCadena("Registrar una nueva melodia");
                        String n = vista.leerNombreMelodia();
                        String nca = vista.leerCantante();
                        String nco = vista.leerCompositor();
                        String gen = vista.mostrarObtenerGenero();
                        String formato = vista.mostrarObtenerFormato();
                        int anio = vista.leerAnioMelodia();
                        double precio = vista.leerPrecioMelodia();
                        modelo.crearObjetoMelodia(n, nca, nco, anio, precio, formato, gen);
                        vista.mostrarCadena("¡Melodía Registrada!");
                        break;
                    case 2:
                        vista.mostrarCadena("\n Tu Catalogo");
                        vista.mostrarCatalogo(modelo.mostrarTodasMelodias());
                        break;
                    case 3:
                        int idBorrar = vista.leerIdMelodia();
                        boolean delete = modelo.removerMelodia(idBorrar);
                        if (delete) {
                            vista.mostrarCadena("¡Melodía eliminada con éxito!");
                        } else {
                            vista.mostrarCadena("No se encontró la melodía");
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
                        vista.mostrarCadena(" Actualizar Melodía ");
                        int idBuscado = vista.leerIdMelodia();
                        Melodia encontrada = modelo.buscar(idBuscado);
                        if (encontrada != null) {
                            vista.mostrarCadena("Melodía encontrada. Ingresa los nuevos datos:");
                            String newNombre = vista.leerNombreMelodia();
                            String newCantante = vista.leerCantante();
                            String newCompositor = vista.leerCompositor();
                            String newGenero = vista.mostrarObtenerGenero();
                            String newFormato = vista.mostrarObtenerFormato();
                            int newAnio = vista.leerAnioMelodia();
                            double newPrecio = vista.leerPrecioMelodia();

                            boolean actualizado = modelo.actualizarMelodia(idBuscado, newNombre, newCompositor, newAnio, newGenero, newCantante, newPrecio, newFormato);
                            if (actualizado) {
                                vista.mostrarCadena("¡Melodía actualizada!");
                            } else {
                                vista.mostrarCadena("No se pudo actualizar.");
                            }
                        } else {
                            vista.mostrarCadena("No existe ninguna melodía con ese ID.");
                        }
                        break;
                    case 7:
                        modelo.ordenarMelodiasPorAnio();
                        vista.mostrarCadena("Catálogo ordenado por año:");
                        vista.mostrarCatalogo(modelo.mostrarTodasMelodias());
                        break;
                    case 8:
                        modelo.ordenarMelodiasPorCantante();
                        vista.mostrarCadena("Catálogo ordenado por cantante:");
                        vista.mostrarCatalogo(modelo.mostrarTodasMelodias());
                        break;
                    case 9:
                        int anioBuscado = vista.leerAnioBusqueda();
                        vista.mostrarCadena("Melodías del año " + anioBuscado + ":");
                        vista.mostrarCatalogo(modelo.obtenerPorAnio(anioBuscado).toString());
                        break;
                    case 10:
                        String compBuscado = vista.leerCompositor();
                        vista.mostrarCadena("Melodías del compositor " + compBuscado + ":");
                        vista.mostrarCatalogo(modelo.melodiasPorCompositor(compBuscado).toString());
                        break;
                    case 11:
                        vista.mostrarCadena("Géneros: " + modelo.obtenerTodosLosGeneros());
                        break;
                    case 12:
                        String cantanteBuscado = vista.leerCantanteBusqueda();
                        vista.mostrarCadena("Melodías del artista " + cantanteBuscado + ":");
                        vista.mostrarCatalogo(modelo.melodiasPorCantante(cantanteBuscado).toString());
                        break;
                    case 13:
                        vista.mostrarCadena("Total de cantantes distintos: " + modelo.obtenerCantidadCantantes());
                        vista.mostrarCadena("Lista de cantantes: " + modelo.obtenerCantantes());
                        break;
                    case 14:
                        vista.mostrarCadena(modelo.obtenerConteoFormatos());
                        break;
                    case 15:
                        vista.mostrarCadena("Adios");
                        break;
                }
            }
        }
        }
