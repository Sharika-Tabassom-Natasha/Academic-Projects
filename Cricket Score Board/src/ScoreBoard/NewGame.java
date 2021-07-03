
package ScoreBoard;

import java.awt.Color;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


public class NewGame extends javax.swing.JFrame {

    Connection connection; 
    Statement statement;
    ResultSet resultset;
    int matchId;
    String teamAname="";
    String teamBname="";
    String teamAplayer="";
    String teamBplayer="";
    
    public NewGame() {
        initComponents();
        connection = ConnectMSSQL.connectDB();
    }
    
    public NewGame(int matchId){
        initComponents();
        this.matchId=matchId;
       // System.out.println(this.matchId);
        connection = ConnectMSSQL.connectDB();
        getTeamName();
        PlayerBox();
        AutoCompleteDecorator.decorate(TEAMA);
        AutoCompleteDecorator.decorate(TEAMB);
    }
    
    
    public void getTeamName(){

        TEAMANAME.setEditable(false);
        TEAMBNAME.setEditable(false);
        try {
            statement=connection.createStatement();
            resultset=statement.executeQuery("select TeamA,TeamB from matchTable where MatchID="+matchId+"");
            resultset.next();
            TEAMANAME.setText(resultset.getString("TeamA"));
            TEAMBNAME.setText(resultset.getString("TeamB"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
    
    
    
    public void PlayerBox(){
        
        teamAname=TEAMANAME.getText().toString();
        teamBname=TEAMBNAME.getText().toString();
        //System.out.println(teamAname);
        
        teamBname=TEAMBNAME.getText().toString();
        try {
            
            statement=connection.createStatement();
            resultset=statement.executeQuery("select PlayerName from playerInformationTable where TeamName='"+teamAname+"' order by PlayerName");
            
            while(resultset.next()){
                TEAMA.addItem(resultset.getString("PlayerName"));
            }
             resultset=statement.executeQuery("select PlayerName from playerInformationTable where TeamName='"+teamBname+"' order by PlayerName");
           
            while(resultset.next()){
                TEAMB.addItem(resultset.getString("PlayerName"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        
    }
     

    public void addTOTable(){
        teamAplayer=TEAMA.getSelectedItem().toString();
        
        
        
            try {
            statement=connection.createStatement();
            statement.executeUpdate("insert into playingTeamTable values("+matchId+",'"+teamAname+"',(select PlayerID from playerInformationTable WHERE PlayerName='"+teamAplayer+"'));");
            
 
            resultset=statement.executeQuery("select PlayerName from playerInformationTable where PlayerID in (select playerID from playingTeamTable where MatchID="+matchId+" and TeamName='"+teamAname+"');");
            Object[] rows = new Object[2];
            DefaultTableModel model = (DefaultTableModel)this.TEAMATABLE.getModel();
            model.setRowCount(0);
            while(resultset.next())
            {
                rows[0] = resultset.getString("PlayerName");
                model.addRow(rows);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
        public void addTOTable2(){
        teamBplayer=TEAMB.getSelectedItem().toString();
        
        
        
            try {
            statement=connection.createStatement();
            statement.executeUpdate("insert into playingTeamTable values("+matchId+",'"+teamBname+"',(select PlayerID from playerInformationTable WHERE PlayerName='"+teamBplayer+"'));");
            
 
            resultset=statement.executeQuery("select PlayerName from playerInformationTable where PlayerID in (select playerID from playingTeamTable where MatchID="+matchId+" and TeamName='"+teamBname+"');");
            Object[] rows = new Object[2];
            DefaultTableModel model = (DefaultTableModel)this.TEAMBTABLE.getModel();
            model.setRowCount(0);
            while(resultset.next())
            {
                rows[0] = resultset.getString("PlayerName");
                model.addRow(rows);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        teamA = new javax.swing.JLabel();
        teamB = new javax.swing.JLabel();
        TEAMB = new javax.swing.JComboBox<>();
        HEADING = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TEAMATABLE = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TEAMBTABLE = new javax.swing.JTable();
        ADD = new javax.swing.JButton();
        TEAMANAME = new javax.swing.JTextField();
        TEAMBNAME = new javax.swing.JTextField();
        TEAMA = new javax.swing.JComboBox<>();
        SET1 = new javax.swing.JButton();
        SET2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 247, 239));

        teamA.setFont(new java.awt.Font("Bauhaus 93", 1, 30)); // NOI18N
        teamA.setText("Team A");

        teamB.setFont(new java.awt.Font("Bauhaus 93", 1, 30)); // NOI18N
        teamB.setText("Team B");

        TEAMB.setBackground(new java.awt.Color(255, 252, 222));
        TEAMB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TEAMBActionPerformed(evt);
            }
        });

        HEADING.setFont(new java.awt.Font("Bauhaus 93", 1, 48)); // NOI18N
        HEADING.setText("Team Information");

        TEAMATABLE.setBackground(new java.awt.Color(255, 247, 239));
        TEAMATABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Player"
            }
        ));
        jScrollPane1.setViewportView(TEAMATABLE);

        TEAMBTABLE.setBackground(new java.awt.Color(255, 247, 239));
        TEAMBTABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Player"
            }
        ));
        jScrollPane2.setViewportView(TEAMBTABLE);

        ADD.setBackground(new java.awt.Color(255, 252, 222));
        ADD.setFont(new java.awt.Font("Bauhaus 93", 1, 36)); // NOI18N
        ADD.setText("Add");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });

        TEAMA.setBackground(new java.awt.Color(255, 252, 222));
        TEAMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TEAMAActionPerformed(evt);
            }
        });

        SET1.setBackground(new java.awt.Color(255, 252, 222));
        SET1.setFont(new java.awt.Font("Bauhaus 93", 1, 36)); // NOI18N
        SET1.setText("Set");
        SET1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SET1ActionPerformed(evt);
            }
        });

        SET2.setBackground(new java.awt.Color(255, 252, 222));
        SET2.setFont(new java.awt.Font("Bauhaus 93", 1, 36)); // NOI18N
        SET2.setText("Set");
        SET2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SET2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(teamA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(teamB)
                .addGap(273, 273, 273))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(TEAMANAME, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TEAMA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(26, 26, 26)
                                .addComponent(SET1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(TEAMBNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TEAMB, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(SET2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(366, 366, 366)
                        .addComponent(HEADING))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(489, 489, 489)
                        .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(HEADING)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teamA)
                    .addComponent(teamB))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TEAMANAME, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TEAMBNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TEAMB, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SET1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(TEAMA, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(SET2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TEAMBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TEAMBActionPerformed
        
    }//GEN-LAST:event_TEAMBActionPerformed

    private void TEAMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TEAMAActionPerformed
        
    }//GEN-LAST:event_TEAMAActionPerformed

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
       ScoreInput page = new ScoreInput(matchId);
            page.setVisible(true);
            this.hide();
    }//GEN-LAST:event_ADDActionPerformed

    private void SET1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SET1ActionPerformed
        addTOTable();
        
    }//GEN-LAST:event_SET1ActionPerformed

    private void SET2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SET2ActionPerformed
        addTOTable2();
       
    }//GEN-LAST:event_SET2ActionPerformed

    
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
            java.util.logging.Logger.getLogger(NewGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JLabel HEADING;
    private javax.swing.JButton SET1;
    private javax.swing.JButton SET2;
    private javax.swing.JComboBox<String> TEAMA;
    private javax.swing.JTextField TEAMANAME;
    private javax.swing.JTable TEAMATABLE;
    private javax.swing.JComboBox<String> TEAMB;
    private javax.swing.JTextField TEAMBNAME;
    private javax.swing.JTable TEAMBTABLE;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel teamA;
    private javax.swing.JLabel teamB;
    // End of variables declaration//GEN-END:variables
}
