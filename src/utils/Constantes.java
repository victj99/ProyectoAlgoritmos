package utils;

import java.awt.Color;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.BorderFactory;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class Constantes {
    // Constantes de UI
    public static final Border ERROR_BORDER = BorderFactory.createLineBorder(Color.RED, 2);
    public static final Border DEFAULT_BORDER = UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border");
    
    
     public static final ScheduledExecutorService EXECUTOR = Executors.newScheduledThreadPool(4);
}
