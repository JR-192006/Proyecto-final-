package model;

public class Servicio {
    private String idServicio;
    private String nombre;

    public Servicio(String idServicio, String nombre) {
        this.idServicio = idServicio;
        this.nombre = nombre;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public String getNombre() {
        return nombre;
    }

}
