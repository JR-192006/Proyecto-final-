package model;
import java.time.LocalTime;


public class Negocio {
    private Cita[] citas;
    private Empleado[] empleados;
    private Cliente[] clientes;
    private Servicio[] servicios;
    private int citaIndex, empleadoIndex, clienteIndex, servicioIndex;
    private model.Cita Cita;
    private LocalTime horaFin;
    private LocalTime horaInicio;



    public Cita[] obtenerCitasAgendadas() {
        int count = 0;
        for (Cita cita : citas) {
            if (cita != null) {
                count++;
            }
        }

        Cita[] citasAgendadas = new Cita[count];
        int index = 0;
        for (Cita cita : citas) {
            if (cita != null) {
                citasAgendadas[index++] = cita;
            }
        }
        return citasAgendadas;
    }



    public Negocio(int maxCitas, int maxEmpleados, int maxClientes, int maxServicios, String horaInicio, String horaFin) {
        this.citas = new Cita[maxCitas];
        this.empleados = new Empleado[maxEmpleados];
        this.clientes = new Cliente[maxClientes];
        this.servicios = new Servicio[maxServicios];
        this.citaIndex = 0;
        this.empleadoIndex = 0;
        this.clienteIndex = 0;
        this.servicioIndex = 0;
        this.horaInicio = LocalTime.parse(horaInicio);
        this.horaFin = LocalTime.parse(horaFin);
    }



    public void reservarCita(Cita cita) {
        if (citaIndex < citas.length) {
            citas[citaIndex++] = cita;
        }
    }

    public void agregarEmpleados(Empleado nuevoEmpleado) {
        if (empleadoIndex < empleados.length) {
            empleados[empleadoIndex++] = nuevoEmpleado;
        }
    }


    public void agregarNuevosServicios(Servicio nuevoServicio) {
        if (servicioIndex < servicios.length) {
            servicios[servicioIndex++] = nuevoServicio;
        }
    }

    public void cancelarCitas(String idCita) {
        for (int i = 0; i < citaIndex; i++) {
            if (citas[i].getIdCita().equals(idCita)) {
                citas[i] = citas[--citaIndex];
                citas[citaIndex] = null;
                break;
            }
        }
    }

    public void eliminarEmpleados(String idEmpleado) {
        for (int i = 0; i < empleadoIndex; i++) {
            if (empleados[i].getIdEmpleado().equals(idEmpleado)) {
                empleados[i] = empleados[--empleadoIndex];
                empleados[empleadoIndex] = null;
                break;
            }
        }
    }

    public void eliminarServicios(String idServicio) {
        for (int i = 0; i < servicioIndex; i++) {
            if (servicios[i].getIdServicio().equals(idServicio)) {
                servicios[i] = servicios[--servicioIndex];
                servicios[servicioIndex] = null;
                break;
            }
        }
    }

    public Empleado buscarEmpleadoPorId(String idEmpleado) {
        for (Empleado empleado : empleados) {
            if (empleado != null && empleado.getIdEmpleado().equals(idEmpleado)) {
                return empleado;
            }
        }
        return null;
    }

    public Servicio buscarServicioPorId(String idServicio) {
        for (Servicio servicio : servicios) {
            if (servicio != null && servicio.getIdServicio().equals(idServicio)) {
                return servicio;
            }
        }
        return null;
    }

    public Cita buscarCitaPorId(String idCita) {
        for (Cita cita : citas) {
            if (cita != null && cita.getIdCita().equals(idCita)) {
                return cita;
            }
        }
        return null;
    }




    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }


}



