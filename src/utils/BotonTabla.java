package utils;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Function;
import javax.imageio.ImageIO;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author victortinoco
 */
public class BotonTabla extends DefaultCellEditor {

    private String textOrIcon;
    private final Consumer<Integer> alHacerClick;
    final Function<Object, String> lambda;

    public BotonTabla(Consumer<Integer> alHacerClick, String textOrIcon) {
        super(new JCheckBox());
        this.alHacerClick = alHacerClick;
        this.textOrIcon = textOrIcon;
        this.lambda = null;
    }

    public BotonTabla(Consumer<Integer> alHacerClick, Function<Object, String> lambda) {
        super(new JCheckBox());
        this.alHacerClick = alHacerClick;
        this.lambda = lambda;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (lambda != null && table != null) {
            textOrIcon = obtenerIconoTexto(table, row, column, lambda);
        }
        if (textOrIcon == null) {
            return null;
        }

        var boton = crearBoton(textOrIcon);
        boton.setBackground(table.getSelectionBackground());
        boton.addActionListener((evt) -> alHacerClick.accept(row));
        return boton;
    }

    public static class Render extends DefaultTableCellRenderer {

        private String textOrIcon;
        final Function<Object, String> lambda;

        public Render(String textOrIcon) {
            this.textOrIcon = textOrIcon;
            this.lambda = null;
        }

        public Render(Function lambda) {
            this.lambda = lambda;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (lambda != null && table != null) {
                textOrIcon = obtenerIconoTexto(table, row, column, lambda);
            }
            if (textOrIcon == null) {
                return null;
            }

            var boton = crearBoton(textOrIcon);
            return boton;
        }
    }

    static String obtenerIconoTexto(JTable table, int row, int column, Function<Object, String> lambda) {
        String textOrIcon = null;
        // si se renderiza mediante una lambda
        if (table instanceof TablaConBotones tablaBotones) {
            textOrIcon = lambda.apply(tablaBotones.obtenerDato(row));
        } else if (table != null) {
            textOrIcon = lambda.apply(table.getModel().getValueAt(row, column));
        }

        return textOrIcon;
    }

    static JButton crearBoton(String textOrIcon) {
        var boton = new JButton();
        if (textOrIcon.toLowerCase().endsWith("png")) {
            try {
                var file = new File(BotonTabla.class.getResource("/imagenes/" + textOrIcon).getFile());
                var img = ImageIO.read(file);
                boton.setIcon(new ImageIcon(img));
            } catch (IOException ignored) {
                boton.setText(textOrIcon);
            }
        } else {
            boton.setText(textOrIcon);
        }

        return boton;
    }

}
