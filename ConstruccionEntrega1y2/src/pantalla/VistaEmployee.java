package pantalla;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.EmployeeTableModel;

/**
 *
 * @author Francisco and tony 
 */
public class VistaEmployee extends javax.swing.JFrame {
    
    private final EmployeeTableModel employeeTableModel;

    public VistaEmployee() throws IOException {
        this.employeeTableModel = new EmployeeTableModel();
        initComponents();
        employeeTableModel.loadData(Jtable_Objs);
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Jtable_Objs = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Jtable_Objs.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Id", "Nombre", "Apellido", "Foto"
                }));
        jScrollPane1.setViewportView(Jtable_Objs);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE));

        pack();
    }
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaEmployee.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaEmployee.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaEmployee.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaEmployee.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VistaEmployee().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(VistaEmployee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private javax.swing.JTable Jtable_Objs;
    private javax.swing.JScrollPane jScrollPane1;
    
}
