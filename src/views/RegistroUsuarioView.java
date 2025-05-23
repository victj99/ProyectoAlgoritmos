package views;

import entities.Usuario;
import javax.swing.JOptionPane;
import services.UsuarioService;
import utils.Constantes;
import utils.StringUtils;

/**
 *
 * @author victortinoco
 */
public class RegistroUsuarioView extends javax.swing.JFrame {

    private String nomUsuario = null;

    /**
     * Creates new form RegistroUsuarioView
     *
     * @param nombreUsuario
     */
    public RegistroUsuarioView(String nombreUsuario) {
        initComponents();
        this.nomUsuario = nombreUsuario;

        lblId.setText("Usuario: " + nombreUsuario);

        this.ocultarTextosError();
        if (nombreUsuario != null) {
            Usuario usuarioExistente = UsuarioService.getInstance().obtenerPorNombreUsuario(nombreUsuario);
            txtNombreUsuario.setText(usuarioExistente.getNombreUsuario());
            txtNombreUsuario.setText(usuarioExistente.getNombreUsuario());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegresar = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        lblErrorNombreUsuario = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        lblErrorContrasenia = new javax.swing.JLabel();
        txtContrasenia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        lblId.setText("Nuevo registro");

        lblErrorNombreUsuario.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorNombreUsuario.setText("Requerido");

        jLabel3.setText("Nombre de usuario");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        lblErrorContrasenia.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorContrasenia.setText("Requerido");

        jLabel4.setText("Contraseña");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblId)
                            .addComponent(jLabel3)
                            .addComponent(lblErrorNombreUsuario)
                            .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(lblErrorContrasenia)
                            .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegistrar)
                        .addGap(156, 156, 156)
                        .addComponent(btnRegresar)
                        .addGap(0, 167, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblId)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorNombreUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorContrasenia)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnRegistrar))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        var view = new BandejaUsuariosView();
        view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // ocultamos los textos de error
        this.ocultarTextosError();

        // Validamos los campos obligatorios
        String contrasenia = txtContrasenia.getText().trim();
        String nombreUsuario = txtNombreUsuario.getText().trim();

        if (StringUtils.isEmpty(nombreUsuario)) {
            lblErrorNombreUsuario.setVisible(true);
            txtNombreUsuario.setBorder(Constantes.ERROR_BORDER);
            return;
        }
        if (StringUtils.isEmpty(contrasenia) && this.nomUsuario == null) { // La contraseña será obligatoria solo si es un nuevo registro
            lblErrorContrasenia.setVisible(true);
            txtContrasenia.setBorder(Constantes.ERROR_BORDER);
            return;
        }

        // registramos los datos
        int resp = JOptionPane.showConfirmDialog(rootPane, "¿Desea registrar el usuario?", "Registrar", JOptionPane.YES_NO_OPTION);
        if (resp != JOptionPane.YES_OPTION) {
            return;
        }

        Usuario usuario = new Usuario(nombreUsuario, contrasenia, true);
        if (this.nomUsuario == null) {
            UsuarioService.getInstance().registrarDatos(usuario);
        } else {
            UsuarioService.getInstance().actualizarDatos(usuario, this.nomUsuario);
        }

        JOptionPane.showMessageDialog(rootPane, "Registro completado", "Completado", JOptionPane.INFORMATION_MESSAGE);
        var view = new BandejaUsuariosView();
        view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblErrorContrasenia;
    private javax.swing.JLabel lblErrorNombreUsuario;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtContrasenia;
    private javax.swing.JTextField txtNombreUsuario;
    // End of variables declaration//GEN-END:variables

    private void ocultarTextosError() {
        lblErrorContrasenia.setVisible(false);
        lblErrorNombreUsuario.setVisible(false);

        txtContrasenia.setBorder(Constantes.DEFAULT_BORDER);
        txtNombreUsuario.setBorder(Constantes.DEFAULT_BORDER);
    }

    protected void limpiar() {
        // ocultamos los textos de error
        this.ocultarTextosError();
        txtContrasenia.setText("");
        txtNombreUsuario.setText("");
        lblId.setText("Nuevo registro");
    }
}
