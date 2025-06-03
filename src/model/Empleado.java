package model;

public class Empleado {
    private String idEmpleado;
    private String nombre;
    private boolean disponibilidad;

    public Empleado(String idEmpleado, String nombre, boolean disponibilidad) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.disponibilidad = disponibilidad;
    }


    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
