package services;

import entities.Area;
import entities.Trabajador;
import entities.Usuario;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author victortinoco
 */
public class BdTemporal {

    private static BdTemporal instance;

    public static BdTemporal getInstance() {
        if (instance == null) {
            instance = new BdTemporal();
        }
        return instance;
    }

    private String usuarioActual = "";

    private Set<Usuario> listaUsuarios = new HashSet<>(Arrays.asList(
            new Usuario("victj", "1234", true)
    ));

    private List<Trabajador> listaTrabajadores = new ArrayList<>();

    private String[][] listaSedes = {
        {"S1", "Piura"},
        {"S2", "Lima"},};

    private Area[] listaArea = {
        new Area(1l, "Limpieza", "S1", true),
        new Area(2l, "Mantenimiento", "S1", true),
        new Area(3l, "Producción", "S2", true),
        new Area(4l, "QA", "S2", true)
    };

    // Getters
    public String getUsuarioActual() {
        return usuarioActual;
    }

    public Set<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public List<Trabajador> getListaTrabajadores() {
        return listaTrabajadores;
    }

    public String[][] getListaSedes() {
        return listaSedes;
    }

    public Area[] getListaArea() {
        return listaArea;
    }

}
