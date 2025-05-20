package entities;

import java.util.Objects;

/**
 *
 * @author victortinoco
 */
public class Usuario {

    private String nombreUsuario;
    private String contrasenia;
    private boolean activo;

    public Usuario(String nombreUsuario, String contrasenia, boolean activo) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.activo = activo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Usuario) {
            return ((Usuario) obj).getNombreUsuario().equalsIgnoreCase(nombreUsuario);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.nombreUsuario.toLowerCase());
    }

}
