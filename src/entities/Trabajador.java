package entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import services.BdTemporal;

/**
 *
 * @author victortinoco
 */
public class Trabajador extends Persona {

    private String codigoTrabajador;
    private String numeroDocumento;
    private LocalDate fechaNacimiento;
    private boolean activo;

    // Foraneos
    private Long codArea;
    //private Area area;

    public Trabajador() {
        this.codigoTrabajador = "T" + (BdTemporal.getInstance().getListaTrabajadores().size() + 1);
    }

    public Trabajador(String codigoTrabajador, String numeroDocumento, LocalDate fechaNacimiento, boolean activo, Long idArea, String nombre, String apellido) {
        super(nombre, apellido);
        this.codigoTrabajador = codigoTrabajador;
        this.numeroDocumento = numeroDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.activo = activo;
        this.codArea = idArea;
    }

    public Long obtenerEdad() {
        return ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
    }

    public String getCodigoTrabajador() {
        return codigoTrabajador;
    }

    public void setCodigoTrabajador(String codigoTrabajador) {
        this.codigoTrabajador = codigoTrabajador;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getCodArea() {
        return codArea;
    }

    public void setCodArea(Long codArea) {
        this.codArea = codArea;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
