package services;

import entities.Area;
import java.util.ArrayList;
import java.util.List;
import utils.ListItem;

public class AreaService {

    private static AreaService instance;

    public static AreaService getInstance() {
        if (instance == null) {
            instance = new AreaService();
        }
        return instance;
    }
    private BdTemporal bd = BdTemporal.getInstance();

    public Area[] buscarPorFiltros(String nombre, Long idEmpresa) {
        return bd.getListaArea();
    }

    public Area[] listarTodosDatos() {
        return bd.getListaArea();
    }

    public List<ListItem> listarAreaCombo() {
        List<ListItem> items = new ArrayList<>();

        for (Area item : bd.getListaArea()) {
            items.add(new ListItem(item.getCodArea(), item.getNombre()));
        }
        return items;
    }
    
    public List<ListItem> listarAreasPorSedeCombo(String codSede) {
        List<ListItem> items = new ArrayList<>();

        for (Area item : bd.getListaArea()) {
            if (item.getCodSede().equals(codSede)) {
             items.add(new ListItem(item.getCodArea(), item.getNombre()));   
            }
        }
        return items;
    }

    public String obtenerSedePorCodArea(Long codArea) {
        Area area = obtenerPorCodigo(codArea);
        return area != null ? obtenerNombreSede(area.getCodSede()) : null;
    }

    public String obtenerNombreSede(String codSede) {
        for (String[] item : bd.getListaSedes()) {
            if (item[0].equals(codSede)) {
                return item[1];
            }
        }
        return null;
    }

    public Area obtenerPorCodigo(Long cod) {
        for (Area item : bd.getListaArea()) {
            if (!item.getCodArea().equals(cod)) {
                continue;
            }

            return item;
        }

        return null;
    }
}
