package model;


public class Cita {
    private String idCita;
    private Cliente cliente;
    private Empleado empleado;
    private Servicio servicio;

    public Cita(String idCita, Cliente cliente, Empleado empleado, Servicio servicio) {
        this.idCita = idCita;
        this.cliente = cliente;
        this.empleado = empleado;
        this.servicio = servicio;
    }

    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}



