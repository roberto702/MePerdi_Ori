package cl.micasa.meperdi;

/**
 * Created by Angela on 29/08/2016.
 */

import java.sql.Date;
import java.sql.Time;

public class Mascotas {
    private int id;
    private String tipo_animal;
    private String nombre_mascota;
    private String foto_1;
    private String foto_2;
    private String foto_3;
    private String caracteristicas;
    private Date fecha;
    public Time hora;
    private String nombre_dueno;
    private String telefono;
    private String email;
    private String recompensa;

    public Mascotas(){}

    public Mascotas(String tipo_animal, String nombre_mascota, String foto_1, String foto_2, String foto_3, String caracteristicas,
                    Date fecha, Time hora, String nombre_dueno, String telefono, String email, String recompensa) {

        String tipo_animal1 = this.tipo_animal;
        String nombre_mascota1 = this.nombre_mascota;
        String foto_11 = this.foto_1;
        String foto_21 = this.foto_2;
        String foto_31 = this.foto_3;
        String caracteristicas1 = this.caracteristicas;
        Date fecha1 = this.fecha;
        Time hora1 = this.hora;
        String nombre_dueno1 = this.nombre_dueno;
        String telefono1 = this.telefono;
        String email1 = this.email;
        String recompensa1 = this.recompensa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_animal() {
        return tipo_animal;
    }

    public void setTipo_animal(String tipo_animal) {
        this.tipo_animal = tipo_animal;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public String getFoto_1() {
        return foto_1;
    }

    public void setFoto_1(String foto_1) {
        this.foto_1 = foto_1;

    }

    public String getFoto_2() {
        return foto_2;
    }

    public void setFoto_2(String foto_2) {
        this.foto_2 = foto_2;
    }

    public String getFoto_3() {
        return foto_3;
    }

    public void setFoto_3(String foto_3) {
        this.foto_3 = foto_3;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;

    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getNombre_dueno() {
        return nombre_dueno;
    }

    public void setNombre_dueno(String nombre_dueno) {
        this.nombre_dueno = nombre_dueno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(String recompensa) {
        this.recompensa = recompensa;
    }

    @Override
    public String toString() {
        return "Mascotas{" +
                "id=" + id +
                ", tipo_animal='" + tipo_animal + '\'' +
                ", nombre_mascota='" + nombre_mascota + '\'' +
                ", foto_1='" + foto_1 + '\'' +
                ", foto_2='" + foto_2 + '\'' +
                ", foto_3='" + foto_3 + '\'' +
                ", caracteristicas='" + caracteristicas + '\'' +

                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", nombre_dueno='" + nombre_dueno + '\'' +


                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", recompensa='" + recompensa + '\'' +
                '}';
    }

}