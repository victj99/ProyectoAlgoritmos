package utils;

import entities.Trabajador;
import entities.Usuario;

/**
 *
 * @author victortinoco
 */
public class CloneUtils {

    public static Usuario clonar(Usuario u) {
        return new Usuario(u.getNombreUsuario(), u.getContrasenia(), u.isActivo());
    }

    public static Trabajador clonar(Trabajador t) {
        return new Trabajador(t.getCodigoTrabajador(), t.getNumeroDocumento(), t.getFechaNacimiento(), t.isActivo(), t.getCodArea(), t.getNombre(), t.getApellido());
    }
}
