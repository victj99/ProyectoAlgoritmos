package services;

import entities.Trabajador;
import java.util.List;

import utils.CloneUtils;
import utils.StringUtils;

public class TrabajadorService {

    private static TrabajadorService instance;

    public static TrabajadorService getInstance() {
        if (instance == null) {
            instance = new TrabajadorService();
        }
        return instance;
    }

    private BdTemporal bd = BdTemporal.getInstance();

    public List<Trabajador> buscarPorFiltros(Trabajador filtros) {
        String nombre = filtros.getNombre();
        String codigo = filtros.getCodigoTrabajador();

        return bd.getListaTrabajadores().stream()
                .filter(item -> StringUtils.isEmpty(nombre) || (item.getNombre() + " " + item.getApellido()).contains(nombre))
                .filter(item -> StringUtils.isEmpty(codigo) || item.getCodigoTrabajador().startsWith(codigo))
                .toList();
    }

    public List<Trabajador> listarTodosDatos() {
        return bd.getListaTrabajadores();
    }

    public void registrarDatos(Trabajador entity) {
        bd.getListaTrabajadores().add(entity);
    }

    public void actualizarDatos(Trabajador entity) {
        Trabajador trabajadorExistente = this.obtenerPorCodigo(entity.getCodigoTrabajador(), false);
        trabajadorExistente.setNombre(entity.getNombre());
        trabajadorExistente.setApellido(entity.getApellido());
        trabajadorExistente.setFechaNacimiento(entity.getFechaNacimiento());
        trabajadorExistente.setNumeroDocumento(entity.getNumeroDocumento());

        trabajadorExistente.setCodArea(entity.getCodArea());
    }

    public Trabajador obtenerPorCodigo(String codigoTrabajador) {
        return obtenerPorCodigo(codigoTrabajador, true);
    }

    private Trabajador obtenerPorCodigo(String codigoTrabajador, boolean clone) {
        for (Trabajador item : bd.getListaTrabajadores()) {
            if (item.getCodigoTrabajador().equals(codigoTrabajador)) {
                return clone ? CloneUtils.clonar(item) : item;
            }
        }

        return null;
    }

    public void cambiarEstado(String codigo) {
        var trabajadorExistente = this.obtenerPorCodigo(codigo, false);

        if (trabajadorExistente.isActivo()) {
            trabajadorExistente.setActivo(false);
        } else {
            trabajadorExistente.setActivo(true);
        }
    }
}
