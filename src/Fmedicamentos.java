
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Fmedicamentos extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Fmedicamentos.class.getName());
    
   Conexion2 cnx = new Conexion2();
    public Fmedicamentos() {
        initComponents();
        
        String todo = "SELECT * FROM medicamentos ORDER BY nombreme";
        setLocationRelativeTo(this);
        
        if (cnx.conectar("127.0.0.1", "simitel", "root", "")==1) {
            cnx.entablar(todo, TConsultas);
        } else {
            JOptionPane.showMessageDialog(this, "Error al entar a la base de datos");
            System.exit(0);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        BRegistar = new javax.swing.JButton();
        BActualizar = new javax.swing.JButton();
        BBorrar = new javax.swing.JButton();
        TValor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TConsultas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion de medicamentos");

        jToolBar1.setBackground(new java.awt.Color(204, 0, 51));
        jToolBar1.setRollover(true);

        BRegistar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BRegistar.setText("Registrar");
        BRegistar.setFocusable(false);
        BRegistar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BRegistar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(BRegistar);

        BActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BActualizar.setText("Actualizar");
        BActualizar.setFocusable(false);
        BActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(BActualizar);

        BBorrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BBorrar.setText("Borrar");
        BBorrar.setFocusable(false);
        BBorrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BBorrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(BBorrar);

        TValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TValorKeyPressed(evt);
            }
        });
        jToolBar1.add(TValor);

        TConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TConsultas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TValorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TValorKeyPressed
           char tecla = evt.getKeyChar();
        if (tecla == '\n') {

            String sql = "{call filtar_medicamento(?)}";

            try {
                CallableStatement cs = (CallableStatement) cnx.con.prepareCall(sql);
                cs.setString(1, TValor.getText());
                cs.execute();

            } catch (SQLException e) {
                System.err.println("Error al llamar al procedimiento");
            }
        }

    }//GEN-LAST:event_TValorKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Fmedicamentos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BActualizar;
    private javax.swing.JButton BBorrar;
    private javax.swing.JButton BRegistar;
    private javax.swing.JTable TConsultas;
    private javax.swing.JTextField TValor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
