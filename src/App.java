
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import views.IniciarSesionView;

/**
 *
 * @author victortinoco
 */
public class App {
    public static void main(String[] args) {
        FlatLightLaf.setup();

        SwingUtilities.invokeLater(() -> {
            IniciarSesionView view = new IniciarSesionView();
            view.setVisible(true);
        });
    }
}
