package services;

import java.util.List;
import entities.Usuario;
import java.util.ArrayList;
import utils.CloneUtils;
import utils.StringUtils;

public class UsuarioService {

    private static UsuarioService instance;

    public static UsuarioService getInstance() {
        if (instance == null) {
            instance = new UsuarioService();
        }
        return instance;
    }

    private BdTemporal bd = BdTemporal.getInstance();

    public List<Usuario> listarTodosDatos() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.addAll(bd.getListaUsuarios());

        return usuarios;
    }

    public void registrarDatos(Usuario entity) {
        bd.getListaUsuarios().add(entity);
    }

    public void actualizarDatos(Usuario entity, String nombreActual) {
        Usuario usuarioExistente = this.obtenerPorNombreUsuario(nombreActual, false);
        
        if (!StringUtils.isEmpty(entity.getNombreUsuario())) {
            usuarioExistente.setNombreUsuario(entity.getNombreUsuario());
        }
        
        // Validamos que la contraseña que se envia no sea un string vacio
        if (!StringUtils.isEmpty(entity.getContrasenia())) {
            usuarioExistente.setContrasenia(entity.getContrasenia());
        }
    }

    public Usuario obtenerPorNombreUsuario(String nombreUsuario) {
        return obtenerPorNombreUsuario(nombreUsuario, true);
    }

    private Usuario obtenerPorNombreUsuario(String nombreUsuario, boolean clone) {
        for (Usuario item : bd.getListaUsuarios()) {
            if (item.getNombreUsuario().equals(nombreUsuario)) {
                return clone ? CloneUtils.clonar(item) : item;
            }
        }

        return null;
    }

    public Usuario obtenerUsuarioPorCredenciales(String nombreUsuario, String contrasenia) {
        return bd.getListaUsuarios().stream().filter(item -> {
            return item.getNombreUsuario().equalsIgnoreCase(nombreUsuario) && item.getContrasenia().equals(contrasenia);
        }).findFirst().orElse(null);
    }

    public List<Usuario> buscarPorFiltros(String nombreUsuario) {
        if (StringUtils.isEmpty(nombreUsuario)) {
            return this.listarTodosDatos();
        }

        return bd.getListaUsuarios().stream().filter(item -> {
            String filtro = nombreUsuario.toUpperCase();
            return item.getNombreUsuario().toUpperCase().startsWith(filtro);
        }).toList();
    }
    
    public void cambiarEstado(String nombreUsuario) {
        Usuario usuarioExistente = obtenerPorNombreUsuario(nombreUsuario, false);
        
        if (usuarioExistente.isActivo()) {
            usuarioExistente.setActivo(false);
        } else {
            usuarioExistente.setActivo(true);
        }
    }
}
