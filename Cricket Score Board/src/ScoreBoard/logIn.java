

package ScoreBoard;
import java.awt.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class logIn extends javax.swing.JFrame {

    Connection connection; 
    Statement statement;
    ResultSet resultset;
    String[] username;
    String[] password;
    String usernameinput="";
    String passwordinput="";
    int i=0;
    int flag=0;
    int count=0;
    String log="";
    
    
    public logIn() {
        initComponents();
        connection = ConnectMSSQL.connectDB();

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LOGINPANEL = new javax.swing.JPanel();
        AFMIN = new javax.swing.JLabel();
        U = new javax.swing.JLabel();
        USERNAME = new javax.swing.JTextField();
        P = new javax.swing.JLabel();
        PASSWORD = new javax.swing.JTextField();
        LOGIN = new javax.swing.JButton();
        Heading = new javax.swing.JLabel();
        VIEW = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(144, 214, 195));

        LOGINPANEL.setBackground(new java.awt.Color(255, 247, 239));

        AFMIN.setFont(new java.awt.Font("Bauhaus 93", 1, 36)); // NOI18N
        AFMIN.setText("Admin");

        U.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        U.setText("User Name");

        P.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        P.setText("Password");

        LOGIN.setBackground(new java.awt.Color(255, 255, 255));
        LOGIN.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        LOGIN.setText("LogIn");
        LOGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGINActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LOGINPANELLayout = new javax.swing.GroupLayout(LOGINPANEL);
        LOGINPANEL.setLayout(LOGINPANELLayout);
        LOGINPANELLayout.setHorizontalGroup(
            LOGINPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LOGINPANELLayout.createSequentialGroup()
                .addGroup(LOGINPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LOGINPANELLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(LOGINPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LOGINPANELLayout.createSequentialGroup()
                                .addComponent(P, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(PASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(LOGINPANELLayout.createSequentialGroup()
                                .addComponent(U, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(USERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(LOGINPANELLayout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(AFMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LOGINPANELLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
        );
        LOGINPANELLayout.setVerticalGroup(
            LOGINPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LOGINPANELLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(AFMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(LOGINPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(U, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(USERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87)
                .addGroup(LOGINPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        Heading.setFont(new java.awt.Font("Bauhaus 93", 1, 48)); // NOI18N
        Heading.setText("Cricket Score Board");

        VIEW.setBackground(new java.awt.Color(255, 247, 239));
        VIEW.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        VIEW.setText("View");
        VIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VIEWActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(Heading, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(262, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(VIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LOGINPANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(Heading, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(VIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(LOGINPANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void VIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VIEWActionPerformed
        ViewerResut page = new ViewerResut();
        page.setVisible(true);
        this.hide();
    }//GEN-LAST:event_VIEWActionPerformed

    private void LOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGINActionPerformed
        getValue();
        loginCheck();
    }//GEN-LAST:event_LOGINActionPerformed

    
    public void getValue() {
        
        username= new String[10];
        password= new String[10];
        try {
            statement = connection.createStatement();
            resultset = statement.executeQuery("select UserName,UserPassword from loginTable");
            while (resultset.next()) {
                username[i]=resultset.getString("UserName");
                password[i]=resultset.getString("UserPassword");
                i++;
                count++;
            }
            //System.out.println(username[0]);
                       
        } catch (SQLException ex) {
            Logger.getLogger(logIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loginCheck(){
        
        usernameinput = USERNAME.getText().toString();                                          
        passwordinput = PASSWORD.getText().toString(); 
        
        flag=0;

        for (i = 0; i < count; i++) {
            if (usernameinput.equals(username[i]) && passwordinput.equals(password[i])) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            JOptionPane.showMessageDialog(this, "Incorrect username of password");
        } else {
            InsertMatch page = new InsertMatch();
            page.setVisible(true);
            this.hide();
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
            java.util.logging.Logger.getLogger(logIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(logIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(logIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(logIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new logIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AFMIN;
    private javax.swing.JLabel Heading;
    private javax.swing.JButton LOGIN;
    private javax.swing.JPanel LOGINPANEL;
    private javax.swing.JLabel P;
    private javax.swing.JTextField PASSWORD;
    private javax.swing.JLabel U;
    private javax.swing.JTextField USERNAME;
    private javax.swing.JButton VIEW;
    // End of variables declaration//GEN-END:variables
}
