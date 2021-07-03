
package ScoreBoard;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class ViewerResut extends javax.swing.JFrame {

    
    
    
    
    Connection connection; 
    Statement statement;
    ResultSet resultset;
    String Team1st="";
    String Team2nd="";
    int run1;
    int run2;
    int wicket1;
    int wicket2;
    int matchId;
    
    
    
    public ViewerResut() {
        initComponents();
        connection = ConnectMSSQL.connectDB();
        getname();
        showTeam1Batsman();
        showTeam2Bowler();
        showTeam2Batsman();
        showTeam1Bowler();
    }
   
    
public void getMatchID(){
        try {
            statement=connection.createStatement();
            resultset=statement.executeQuery("select MatchID from matchTable;");
            while(resultset.next())
            {
                wicket1=Integer.parseInt(resultset.getString("MatchID"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ViewerResut.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    

    public void getname(){   
        try {
            statement=connection.createStatement();
            resultset=statement.executeQuery("select * from matchTable where MatchID="+matchId+";");
            while(resultset.next())
            {
                Team1st=resultset.getString("TeamA");
                Team2nd=resultset.getString("TeamB");
            }
            HEADING.setText(Team1st+" VS "+Team2nd);
            
            resultset=statement.executeQuery("select sum(ball) as totalBall,sum(runGiven) as totalRun, sum(wicket) as totalWicket , MatchID from firstInningTable where MatchID="+matchId+" AND TeamName='"+Team1st+"' group by MatchID ");
            while(resultset.next())
            {
                run1=Integer.parseInt(resultset.getString("totalRun"));
                
                System.out.println();
                wicket1=Integer.parseInt(resultset.getString("totalWicket"));
            }  
            
            TEAM1.setText(Team1st+": "+run1+"/"+wicket1);
            
            resultset=statement.executeQuery("select sum(ball) as totalBall,sum(runGiven) as totalRun, sum(wicket) as totalWicket , MatchID from secondInningTable where MatchID="+matchId+" AND TeamName='"+Team2nd+"' group by MatchID ");
            while(resultset.next())
            {
                run2=Integer.parseInt(resultset.getString("totalRun"));
                wicket2=Integer.parseInt(resultset.getString("totalWicket"));
            }  
            
            TEAM2.setText(Team2nd+": "+run2+"/"+wicket2);
            
        } catch (SQLException ex) {
            Logger.getLogger(ViewerResut.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }
    
     public void showTeam1Batsman(){   
        
         try {
            statement=connection.createStatement();
            resultset=statement.executeQuery("select * from firstInningTable where MatchID="+matchId+" and TeamName='"+Team1st+"';");
            Object[] rows = new Object[5];
            DefaultTableModel model = (DefaultTableModel)this.TEAM1BATSMANTABLE.getModel();
            model.setRowCount(0);
            while(resultset.next())
            {
                rows[0] = resultset.getString("PlayerName");
                rows[1] = resultset.getString("runTaken");
                rows[2] = resultset.getString("ball");
                rows[3] = resultset.getString("sixs");
                rows[3] = resultset.getString("fours");

               
                model.addRow(rows);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void showTeam2Bowler(){   
        
         try {
            statement=connection.createStatement();
            resultset=statement.executeQuery("select * from firstInningTable where MatchID="+matchId+" and TeamName='"+Team2nd+"';");
            Object[] rows = new Object[5];
            DefaultTableModel model = (DefaultTableModel)this.TEAM2BOWLERTABLE.getModel();
            model.setRowCount(0);
            while(resultset.next())
            {
                rows[0] = resultset.getString("PlayerName");
                rows[1] = resultset.getString("overs");
                rows[2] = resultset.getString("runGiven");
                rows[3] = resultset.getString("wicket");
                rows[4] = resultset.getString("noBall");

               
                model.addRow(rows);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void showTeam2Batsman(){   
        
         try {
            statement=connection.createStatement();
            resultset=statement.executeQuery("select * from firstInningTable where MatchID="+matchId+" and TeamName='"+Team2nd+"';");
            Object[] rows = new Object[5];
            DefaultTableModel model = (DefaultTableModel)this.TEAM2BATSMANTABLE.getModel();
            model.setRowCount(0);
            while(resultset.next())
            {
                 rows[0] = resultset.getString("PlayerName");
                rows[1] = resultset.getString("runTaken");
                rows[2] = resultset.getString("ball");
                rows[3] = resultset.getString("sixs");
                rows[3] = resultset.getString("fours");

               
                model.addRow(rows);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void showTeam1Bowler(){   
        
         try {
            statement=connection.createStatement();
            resultset=statement.executeQuery("select * from firstInningTable where MatchID="+matchId+" and TeamName='"+Team1st+"';");
            Object[] rows = new Object[5];
            DefaultTableModel model = (DefaultTableModel)this.TEAM1BOWLERTABLE.getModel();
            model.setRowCount(0);
            while(resultset.next())
            {
                rows[0] = resultset.getString("PlayerName");
                rows[1] = resultset.getString("overs");
                rows[2] = resultset.getString("runGiven");
                rows[3] = resultset.getString("wicket");
                rows[4] = resultset.getString("noBall");

               
                model.addRow(rows);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TEAM2BATSMANTABLE = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TEAM1BATSMANTABLE = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TEAM1BOWLERTABLE = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        TEAM2BOWLERTABLE = new javax.swing.JTable();
        HEADING = new javax.swing.JLabel();
        TEAM1 = new javax.swing.JLabel();
        OVER1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TEAM2 = new javax.swing.JLabel();
        OVER2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TEAM2BATSMANTABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Batsman Name", "Total Run", "Ball", "6's", "4's"
            }
        ));
        jScrollPane2.setViewportView(TEAM2BATSMANTABLE);

        TEAM1BATSMANTABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Batsman Name", "Total Run", "Ball", "6's", "4's"
            }
        ));
        jScrollPane3.setViewportView(TEAM1BATSMANTABLE);

        TEAM1BOWLERTABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Bowler Name", "Over", "Run", "Wicket", "No Ball"
            }
        ));
        jScrollPane4.setViewportView(TEAM1BOWLERTABLE);

        TEAM2BOWLERTABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Bowler Name", "Over", "Run", "Wicket", "No Ball"
            }
        ));
        jScrollPane5.setViewportView(TEAM2BOWLERTABLE);

        HEADING.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        HEADING.setText("Team 1 Vs Team 2");

        TEAM1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        TEAM1.setText("Team 1 : Run/wicket");

        OVER1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        OVER1.setText("Over : 20.0");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Innings 1");

        TEAM2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        TEAM2.setText("Team 2 : Run/wicket");

        OVER2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        OVER2.setText("Over : 20.0");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Innings 2");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Batsman ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText(" Batsman ");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Bowler ");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Bowler ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(OVER1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(TEAM1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(TEAM2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(221, 221, 221))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(OVER2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(211, 211, 211))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(474, 474, 474))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(495, 495, 495))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(HEADING)
                .addGap(484, 484, 484))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(HEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TEAM1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(OVER1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TEAM2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(OVER2)))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ViewerResut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewerResut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewerResut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewerResut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewerResut().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HEADING;
    private javax.swing.JLabel OVER1;
    private javax.swing.JLabel OVER2;
    private javax.swing.JLabel TEAM1;
    private javax.swing.JTable TEAM1BATSMANTABLE;
    private javax.swing.JTable TEAM1BOWLERTABLE;
    private javax.swing.JLabel TEAM2;
    private javax.swing.JTable TEAM2BATSMANTABLE;
    private javax.swing.JTable TEAM2BOWLERTABLE;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
