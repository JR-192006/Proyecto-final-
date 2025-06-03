package presenter;


import model.*;
import view.Vista;
import model.Negocio;

import java.time.LocalTime;

public class Presentador {
    private Negocio negocio;
    private Vista vista;

    public Presentador(Negocio negocio, Vista vista) {
        this.negocio = negocio;
        this.vista = vista;
    }


    public void iniciar() {


        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    reservarCita();
                    break;
                case 2:
                    agregarEmpleado();
                    break;
                case 3:
                    agregarServicio();
                    break;
                case 4:
                    cancelarCita();
                    break;
                case 5:
                    eliminarEmpleado();
                    break;
                case 6:
                    eliminarServicio();
                    break;
                case 7:
                    verCitasAgendadas();
                    break;
            }
        } while (opcion != 8);
    }



    private void verCitasAgendadas() {
        Cita[] citas = negocio.obtenerCitasAgendadas();
        if (citas.length == 0) {
            vista.mostrarMensaje("No hay citas agendadas.");
        } else {
            vista.mostrarMensaje("Citas agendadas:");
            for (Cita cita : citas) {
                vista.mostrarMensaje("ID: " + cita.getIdCita() + ", Cliente: " + cita.getCliente().getNombre() +
                        ", Empleado: " + cita.getEmpleado().getNombre() + ", Servicio: " + cita.getServicio().getNombre());
            }
        }
    }



    private void reservarCita() {

        vista.mostrarMensaje("Debe ingresar la hora con el siguiente formato: 10:30 (hora:minutos)");
        LocalTime horaReseva2 = LocalTime.parse(vista.leerDato("Hora reserva: "));
        if(horaReseva2.isBefore(negocio.getHoraInicio()) || horaReseva2.isAfter(negocio.getHoraFin())){
            vista.mostrarMensaje("La hora ingresada no esta dentro de nuestros horarios establecidos");
            return;
        }

        String idCita = vista.leerDato("ID de la Cita: ");
        String idCliente = vista.leerDato("ID del Cliente: ");
        String nombreCliente = vista.leerDato("Nombre del Cliente: ");
        String idEmpleado = vista.leerDato("ID del Empleado: ");

        Cliente cliente = new Cliente(idCliente, nombreCliente);

        Empleado empleado = negocio.buscarEmpleadoPorId(idEmpleado);


        if (empleado == null) {
            vista.mostrarMensaje("Empleado no encontrado");
            return;
        }


        if (!empleado.isDisponibilidad()) {

            vista.mostrarMensaje("El empleado no esta disponible");
            return;
        }

        String idServicio = vista.leerDato("ID del Servicio: ");
        Servicio servicio = negocio.buscarServicioPorId(idServicio);
        if (servicio == null) {
            vista.mostrarMensaje("Servicio no encontrado.");
            return;
        }


        Cita cita = new Cita(idCita, cliente, empleado, servicio);
        negocio.reservarCita(cita);
        vista.mostrarMensaje("Cita reservada con éxito.");
    }


    private void agregarEmpleado() {

        String idEmpleado = vista.leerDato("ID del Empleado: ");

        String nombreEmpleado = vista.leerDato("Nombre del Empleado: ");
        String verficacion = vista.leerDato("Disponibilidad del Empleado (true/false): ");

        if(verficacion.equalsIgnoreCase("true") || verficacion.equalsIgnoreCase("false") ){
            boolean disponibilidadEmpleado = Boolean.parseBoolean(verficacion);

            Empleado nuevoEmpleado = new Empleado(idEmpleado, nombreEmpleado, disponibilidadEmpleado);
            negocio.agregarEmpleados(nuevoEmpleado);
            vista.mostrarMensaje("Empleado agregado con éxito.");

        }else {
            vista.mostrarMensaje("el texto ingresado no es correcto");
        }
        Empleado empleado = negocio.buscarEmpleadoPorId(idEmpleado);

    }



    private void agregarServicio() {
        String idServicio = vista.leerDato("ID del Servicio: ");
        String nombreServicio = vista.leerDato("Nombre del Servicio: ");


        Servicio nuevoServicio = new Servicio(idServicio, nombreServicio);

        negocio.agregarNuevosServicios(nuevoServicio);
        vista.mostrarMensaje("Servicio agregado con éxito.");
    }

    private void cancelarCita() {
        String idCita = vista.leerDato("ID de la Cita: ");
        Cita cita = negocio.buscarCitaPorId(idCita);
        if (cita == null) {
            vista.mostrarMensaje("Cita no encontrada");
            return;
        }else {
            negocio.cancelarCitas(idCita);
            vista.mostrarMensaje("Cita cancelada con éxito.");
        }

    }


    private void eliminarEmpleado() {
        String idEmpleado = vista.leerDato("ID del Empleado: ");
        Empleado empleado = negocio.buscarEmpleadoPorId(idEmpleado);

        if (empleado == null) {
            vista.mostrarMensaje("Empleado no encontrado");

        }else {
            negocio.eliminarEmpleados(idEmpleado);
            vista.mostrarMensaje("Empleado eliminado con éxito.");
        }
    }

    private void eliminarServicio() {
        String idServicio = vista.leerDato("ID del Servicio: ");
        Servicio servicio = negocio.buscarServicioPorId(idServicio);

        if (servicio == null) {
            vista.mostrarMensaje("Servicio no encontrado.");

        }else {

            negocio.eliminarServicios(idServicio);
            vista.mostrarMensaje("Servicio eliminado con éxito.");

        }

    }

    public static void main(String[] args) {
        Negocio negocio = new Negocio(100, 50, 50, 50, "08:00:00",
                "17:00:00"); // Máximos valores ajustables
        Vista vista = new Vista();
        Presentador presentador = new Presentador(negocio, vista);

        presentador.iniciar();
    }
}

