
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Payment extends javax.swing.JFrame {

    Connection con;
    ResultSet rs;
    PreparedStatement pst;

    public Payment() {
        con = CafeConnect.ConnecrDb();
        initComponents();
        doSubTotal();
        doTotal();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        total = new javax.swing.JLabel();
        TOTAL = new javax.swing.JTextField();
        amountpaid = new javax.swing.JLabel();
        AMOUNTPAID = new javax.swing.JTextField();
        change = new javax.swing.JLabel();
        CHANGE = new javax.swing.JTextField();
        Payment = new javax.swing.JLabel();
        CONFIRM = new javax.swing.JButton();
        tax = new javax.swing.JLabel();
        subtotal = new javax.swing.JLabel();
        SUBTOTAL = new javax.swing.JTextField();
        TAX = new javax.swing.JTextField();
        CALCULATE = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        total.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        total.setText("Total");

        TOTAL.setText("0");

        amountpaid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        amountpaid.setText("Amount Paid");

        AMOUNTPAID.setText("0");

        change.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        change.setText("Change");

        CHANGE.setText("0");

        Payment.setFont(new java.awt.Font("Bernard MT Condensed", 1, 48)); // NOI18N
        Payment.setText("Payment");

        CONFIRM.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CONFIRM.setText("Comfirm");
        CONFIRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CONFIRMActionPerformed(evt);
            }
        });

        tax.setText("Tax");

        subtotal.setText("Sub Total");

        SUBTOTAL.setText("0");

        TAX.setText("15");

        CALCULATE.setText("Calculate");
        CALCULATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CALCULATEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(CONFIRM)
                        .addGap(115, 115, 115)
                        .addComponent(CALCULATE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(Payment))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(total)
                            .addComponent(amountpaid)
                            .addComponent(change)
                            .addComponent(tax)
                            .addComponent(subtotal))
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SUBTOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AMOUNTPAID, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TAX, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CHANGE, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(284, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(Payment)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subtotal)
                    .addComponent(SUBTOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tax)
                    .addComponent(TAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total)
                    .addComponent(TOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amountpaid)
                    .addComponent(AMOUNTPAID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(change)
                    .addComponent(CHANGE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(138, 138, 138)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CONFIRM)
                    .addComponent(CALCULATE))
                .addGap(94, 94, 94))
        );

        setSize(new java.awt.Dimension(844, 865));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void CONFIRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CONFIRMActionPerformed

        Receipt page = new Receipt();
        page.setVisible(true);
        page.receiptCreate();
        this.hide();
    }//GEN-LAST:event_CONFIRMActionPerformed

    private void CALCULATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CALCULATEActionPerformed

        Final();
    }//GEN-LAST:event_CALCULATEActionPerformed

    void doSubTotal() {

        try {
            String sql = "select sum(Price) from Receipt";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String sum = rs.getString("sum(Price)");
                SUBTOTAL.setText(sum);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void doTotal() {
        double TAx = Double.parseDouble(TAX.getText());
        double Subtotal = Double.parseDouble(SUBTOTAL.getText());
        double Total = Subtotal + (TAx / 100) * Subtotal;
        String TOtal = String.valueOf(Total);
        TOTAL.setText(TOtal);

    }

    void Final() {
        double Total = Double.parseDouble(TOTAL.getText());
        double Amount = Double.parseDouble(AMOUNTPAID.getText());
        double Change = Amount - Total;
        String TOtal = String.valueOf(Change);
        CHANGE.setText(TOtal);
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
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AMOUNTPAID;
    private javax.swing.JButton CALCULATE;
    private javax.swing.JTextField CHANGE;
    private javax.swing.JButton CONFIRM;
    private javax.swing.JLabel Payment;
    private javax.swing.JTextField SUBTOTAL;
    private static javax.swing.JTextField TAX;
    private javax.swing.JTextField TOTAL;
    private javax.swing.JLabel amountpaid;
    private javax.swing.JLabel change;
    private javax.swing.JLabel subtotal;
    private javax.swing.JLabel tax;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}