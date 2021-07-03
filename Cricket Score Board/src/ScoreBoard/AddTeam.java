
package ScoreBoard;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class AddTeam extends javax.swing.JFrame {

    Connection connection;
    Statement statement;
    ResultSet resultset;
    String teamname=""; 
    
    public AddTeam() {
        initComponents();
        connection = ConnectMSSQL.connectDB();
        showTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HEADING = new javax.swing.JLabel();
        tname = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TEAMINFOTABLE = new javax.swing.JTable();
        ADD = new javax.swing.JButton();
        BACK = new javax.swing.JButton();
        TEAMNAME = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        HEADING.setFont(new java.awt.Font("Bauhaus 93", 1, 48)); // NOI18N
        HEADING.setText("Team Information");

        tname.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        tname.setText("Team Name");

        TEAMINFOTABLE.setBackground(new java.awt.Color(255, 247, 239));
        TEAMINFOTABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Team Id", "Team Name"
            }
        ));
        jScrollPane1.setViewportView(TEAMINFOTABLE);

        ADD.setBackground(new java.awt.Color(255, 247, 239));
        ADD.setFont(new java.awt.Font("Bauhaus 93", 1, 36)); // NOI18N
        ADD.setText("Add");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });

        BACK.setBackground(new java.awt.Color(255, 247, 239));
        BACK.setFont(new java.awt.Font("Bauhaus 93", 1, 36)); // NOI18N
        BACK.setText("Back");
        BACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BACKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addComponent(HEADING)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tname)
                    .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TEAMNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BACK, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(HEADING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(tname)
                        .addGap(18, 18, 18)
                        .addComponent(TEAMNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(BACK, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        tableInsert();
        showTable();
    }//GEN-LAST:event_ADDActionPerformed

    private void BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACKActionPerformed
        InsertMatch page = new InsertMatch();
        page.setVisible(true);
        this.hide();
    }//GEN-LAST:event_BACKActionPerformed

    
    
    public void showTable(){
    
            try {
            statement=connection.createStatement();
            resultset=statement.executeQuery("select * from teamTable order by TeamID;");
            Object[] rows = new Object[2];
            DefaultTableModel model = (DefaultTableModel)this.TEAMINFOTABLE.getModel();
            model.setRowCount(0);
            while(resultset.next())
            {
                rows[0] = resultset.getString("TeamID"); 
                rows[1] = resultset.getString("TeamName");
                model.addRow(rows);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
}
    
    
    public void tableInsert(){
        teamname=TEAMNAME.getText().toString();

        try {
            
            statement=connection.createStatement();
            statement.executeUpdate("insert into teamTable values('"+teamname+"');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void tableDelete(){
        DefaultTableModel model = (DefaultTableModel)this.TEAMINFOTABLE.getModel();
        
        try {
            int selectedrow= TEAMINFOTABLE.getSelectedRow();
            teamname=model.getValueAt(selectedrow,1).toString();
            model.removeRow(selectedrow);
            
            statement=connection.createStatement();
            statement.executeUpdate("DELETE FROM teamTable WHERE TeamName='"+teamname+"';");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddTeam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddTeam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddTeam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddTeam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddTeam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JButton BACK;
    private javax.swing.JLabel HEADING;
    private javax.swing.JTable TEAMINFOTABLE;
    private javax.swing.JTextField TEAMNAME;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel tname;
    // End of variables declaration//GEN-END:variables
}