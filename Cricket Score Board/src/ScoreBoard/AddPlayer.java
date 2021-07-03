
package ScoreBoard;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.Locale.filter;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


public class AddPlayer extends javax.swing.JFrame {
    
    
    Connection connection;
    Statement statement;
    ResultSet resultset;
    ResultSet resultset1;
    private ResultSet DefaultTableModel;
    private ResultSet TableRowSorter;
    private Object filter;
    String teamname="";
    String playername="";
    String playerstatus="";
    
    public AddPlayer() {
        initComponents();
        connection = ConnectMSSQL.connectDB();
        tableShow();
        teamBox();
        AutoCompleteDecorator.decorate(TEAM);
    }

  
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HEADING = new javax.swing.JLabel();
        teamS = new javax.swing.JLabel();
        ADD = new javax.swing.JButton();
        pname = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PLAYERINFOTABLE = new javax.swing.JTable();
        BACK = new javax.swing.JButton();
        PLAYERNAME = new javax.swing.JTextField();
        STATUS = new javax.swing.JTextField();
        TEAM = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));

        HEADING.setFont(new java.awt.Font("Bauhaus 93", 1, 48)); // NOI18N
        HEADING.setText("Player Information");

        teamS.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        teamS.setText("Team");

        ADD.setBackground(new java.awt.Color(255, 247, 239));
        ADD.setFont(new java.awt.Font("Bauhaus 93", 1, 36)); // NOI18N
        ADD.setText("Add");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });

        pname.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        pname.setText("Player Name");

        status.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        status.setText("Status");

        PLAYERINFOTABLE.setBackground(new java.awt.Color(255, 247, 239));
        PLAYERINFOTABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Player Id", "Team Name", "Player Name", "Status"
            }
        ));
        jScrollPane1.setViewportView(PLAYERINFOTABLE);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(pname)
                                .addGap(56, 56, 56))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(teamS, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(status)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PLAYERNAME, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(STATUS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                            .addComponent(TEAM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(BACK, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(HEADING)
                .addGap(431, 431, 431))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(status)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(HEADING)
                        .addGap(151, 151, 151)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(teamS, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TEAM, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pname)
                            .addComponent(PLAYERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(84, 84, 84)
                        .addComponent(STATUS, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(BACK, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(123, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        tableInsert();
        tableShow();
    }//GEN-LAST:event_ADDActionPerformed

    private void BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACKActionPerformed
        InsertMatch page = new InsertMatch();
        page.setVisible(true);
        this.hide();
    }//GEN-LAST:event_BACKActionPerformed

    
        public void teamBox(){
        
        try {
            
            statement=connection.createStatement();
            resultset=statement.executeQuery("select TeamName from teamTable");
            
            while(resultset.next()){
                TEAM.addItem(resultset.getString("TeamName"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public void tableShow(){
          
        try {
            statement=connection.createStatement();
            resultset=statement.executeQuery("select * from playerInformationTable order by TeamName;");
            Object[] rows = new Object[4];
            DefaultTableModel model = (DefaultTableModel)this.PLAYERINFOTABLE.getModel();
            model.setRowCount(0);
            while(resultset.next())
            {
                rows[0] = resultset.getString("PlayerID");
                rows[1] = resultset.getString("TeamName");
                rows[2] = resultset.getString("PlayerName");
                rows[3] = resultset.getString("PlayerStatus");

               
                model.addRow(rows);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
}
    
    public void tableInsert(){
        teamname=TEAM.getSelectedItem().toString();
        playername=PLAYERNAME.getText().toString();
        playerstatus=STATUS.getText().toString();
        try {
            
            statement=connection.createStatement();
            statement.executeUpdate("insert into playerInformationTable values('"+teamname+"','"+playername+"','"+playerstatus+"');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void filter(String query)
    {

        TableRowSorter<DefaultTableModel> tr= new TableRowSorter<DefaultTableModel> ((DefaultTableModel)resultset1);
        PLAYERINFOTABLE.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    
    public void deleteRow(){
         DefaultTableModel model = (DefaultTableModel) PLAYERINFOTABLE.getModel();
       try{
        int selectedRow= PLAYERINFOTABLE.getSelectedRow();
        model.removeRow(selectedRow);
       }catch(Exception e)
       {
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
            java.util.logging.Logger.getLogger(AddPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPlayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JButton BACK;
    private javax.swing.JLabel HEADING;
    private javax.swing.JTable PLAYERINFOTABLE;
    private javax.swing.JTextField PLAYERNAME;
    private javax.swing.JTextField STATUS;
    private javax.swing.JComboBox<String> TEAM;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pname;
    private javax.swing.JLabel status;
    private javax.swing.JLabel teamS;
    // End of variables declaration//GEN-END:variables
}
