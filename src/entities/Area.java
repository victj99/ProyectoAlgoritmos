package entities;

/**
 *
 * @author victortinoco
 */
public class Area {

    private Long codArea;
    private String nombre;
    private String codSede;
    private boolean activo;

    public Area(Long codArea, String nombre, String idSede, boolean activo) {
        this.codArea = codArea;
        this.nombre = nombre;
        this.codSede = idSede;
        this.activo = activo;
    }

    public Long getCodArea() {
        return codArea;
    }

    public void setCodArea(Long codArea) {
        this.codArea = codArea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodSede() {
        return codSede;
    }

    public void setCodSede(String codSede) {
        this.codSede = codSede;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

   
}
