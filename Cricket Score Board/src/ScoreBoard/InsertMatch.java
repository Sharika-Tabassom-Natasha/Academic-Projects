

package ScoreBoard;
import java.awt.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.swingx.autocomplete.AutoCompleteComboBoxEditor;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;



public class InsertMatch extends javax.swing.JFrame {

    
    Connection connection;
    Statement statement;
    PreparedStatement preparedstatement;
    ResultSet resultset;
    String teamaname="";
    String teambname="";
    int generatedKey = 0;
    
    public InsertMatch() {
        initComponents();
        connection = ConnectMSSQL.connectDB();
        TEAMPANEL.setVisible(false);
        teamBox();
        AutoCompleteDecorator.decorate(TEAM_A);
        AutoCompleteDecorator.decorate(TEAM_B);
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TEAMPANEL = new javax.swing.JPanel();
        teamA = new javax.swing.JLabel();
        teamB = new javax.swing.JLabel();
        ADDGAME = new javax.swing.JButton();
        TEAM_A = new javax.swing.JComboBox<>();
        TEAM_B = new javax.swing.JComboBox<>();
        HEADING = new javax.swing.JLabel();
        MENUPANEL = new javax.swing.JPanel();
        ADDPLAYER = new javax.swing.JButton();
        NEWGAME = new javax.swing.JButton();
        ADDTEAM = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TEAMPANEL.setBackground(new java.awt.Color(255, 247, 239));
        TEAMPANEL.setForeground(new java.awt.Color(255, 247, 239));

        teamA.setFont(new java.awt.Font("Bauhaus 93", 1, 36)); // NOI18N
        teamA.setText("Team A");

        teamB.setFont(new java.awt.Font("Bauhaus 93", 1, 36)); // NOI18N
        teamB.setText("Team B");

        ADDGAME.setBackground(new java.awt.Color(255, 247, 239));
        ADDGAME.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        ADDGAME.setText("Add Game");
        ADDGAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDGAMEActionPerformed(evt);
            }
        });

        TEAM_A.setBackground(new java.awt.Color(255, 252, 222));
        TEAM_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TEAM_AActionPerformed(evt);
            }
        });

        TEAM_B.setBackground(new java.awt.Color(255, 252, 222));
        TEAM_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TEAM_BActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TEAMPANELLayout = new javax.swing.GroupLayout(TEAMPANEL);
        TEAMPANEL.setLayout(TEAMPANELLayout);
        TEAMPANELLayout.setHorizontalGroup(
            TEAMPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TEAMPANELLayout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(teamA, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 350, Short.MAX_VALUE)
                .addComponent(teamB)
                .addGap(247, 247, 247))
            .addGroup(TEAMPANELLayout.createSequentialGroup()
                .addGroup(TEAMPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TEAMPANELLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(TEAM_A, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144)
                        .addComponent(TEAM_B, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TEAMPANELLayout.createSequentialGroup()
                        .addGap(449, 449, 449)
                        .addComponent(ADDGAME, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TEAMPANELLayout.setVerticalGroup(
            TEAMPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TEAMPANELLayout.createSequentialGroup()
                .addGroup(TEAMPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TEAMPANELLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(TEAMPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(teamB)
                            .addComponent(teamA, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(TEAMPANELLayout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addGroup(TEAMPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TEAM_B, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TEAM_A, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(48, 48, 48)
                .addComponent(ADDGAME, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        HEADING.setFont(new java.awt.Font("Bauhaus 93", 1, 55)); // NOI18N
        HEADING.setText("Match");

        MENUPANEL.setBackground(new java.awt.Color(255, 247, 239));

        ADDPLAYER.setBackground(new java.awt.Color(255, 247, 239));
        ADDPLAYER.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        ADDPLAYER.setText("Add Player");
        ADDPLAYER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDPLAYERActionPerformed(evt);
            }
        });

        NEWGAME.setBackground(new java.awt.Color(255, 247, 239));
        NEWGAME.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        NEWGAME.setText("New Game");
        NEWGAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NEWGAMEActionPerformed(evt);
            }
        });

        ADDTEAM.setBackground(new java.awt.Color(255, 247, 239));
        ADDTEAM.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        ADDTEAM.setText("Add Team");
        ADDTEAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDTEAMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MENUPANELLayout = new javax.swing.GroupLayout(MENUPANEL);
        MENUPANEL.setLayout(MENUPANELLayout);
        MENUPANELLayout.setHorizontalGroup(
            MENUPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MENUPANELLayout.createSequentialGroup()
                .addGap(406, 406, 406)
                .addComponent(NEWGAME, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MENUPANELLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(ADDPLAYER, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 345, Short.MAX_VALUE)
                .addComponent(ADDTEAM, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(211, 211, 211))
        );
        MENUPANELLayout.setVerticalGroup(
            MENUPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MENUPANELLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(MENUPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ADDTEAM, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ADDPLAYER, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addComponent(NEWGAME, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(HEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(438, 438, 438))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MENUPANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TEAMPANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(HEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MENUPANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(TEAMPANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ADDPLAYERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDPLAYERActionPerformed
        AddPlayer page = new AddPlayer();
            page.setVisible(true);
            this.hide();
    }//GEN-LAST:event_ADDPLAYERActionPerformed

    private void ADDGAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDGAMEActionPerformed
        addValue();
        NewGame page = new NewGame(generatedKey);
            page.setVisible(true);
            this.hide();
    }//GEN-LAST:event_ADDGAMEActionPerformed

    private void NEWGAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NEWGAMEActionPerformed
        MENUPANEL.setVisible(false);
        TEAMPANEL.setVisible(true);   
    }//GEN-LAST:event_NEWGAMEActionPerformed

    private void ADDTEAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDTEAMActionPerformed
        AddTeam page = new AddTeam();
            page.setVisible(true);
            this.hide();
    }//GEN-LAST:event_ADDTEAMActionPerformed

    private void TEAM_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TEAM_AActionPerformed

    }//GEN-LAST:event_TEAM_AActionPerformed

    private void TEAM_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TEAM_BActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TEAM_BActionPerformed

    
    public void teamBox(){
        
        try {
            
            statement=connection.createStatement();
            resultset=statement.executeQuery("select TeamName from teamTable");
            
            while(resultset.next()){
                TEAM_A.addItem(resultset.getString("TeamName"));
                TEAM_B.addItem(resultset.getString("TeamName"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
    public void addValue(){
         generatedKey = 0;
         LocalDate localDate = LocalDate.now();
         teamaname=TEAM_A.getSelectedItem().toString();
         teambname=TEAM_B.getSelectedItem().toString();
       // System.out.println(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate));
        try {
            preparedstatement=connection.prepareStatement("insert into matchTable "
                    + "values('"+DateTimeFormatter.ofPattern("yyy-MM-dd").format(localDate)+"','"+teamaname+"','"+teambname+"');",Statement.RETURN_GENERATED_KEYS);
            
            preparedstatement.execute();
            resultset = preparedstatement.getGeneratedKeys();
            
            if (resultset.next()) {
            generatedKey = resultset.getInt(1);
            
            //System.out.println("Inserted record's ID: " + generatedKey);
        }
            
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
            java.util.logging.Logger.getLogger(InsertMatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertMatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertMatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertMatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertMatch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADDGAME;
    private javax.swing.JButton ADDPLAYER;
    private javax.swing.JButton ADDTEAM;
    private javax.swing.JLabel HEADING;
    private javax.swing.JPanel MENUPANEL;
    private javax.swing.JButton NEWGAME;
    private javax.swing.JPanel TEAMPANEL;
    private javax.swing.JComboBox<String> TEAM_A;
    private javax.swing.JComboBox<String> TEAM_B;
    private javax.swing.JLabel teamA;
    private javax.swing.JLabel teamB;
    // End of variables declaration//GEN-END:variables
}
