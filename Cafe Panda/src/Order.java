
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import org.jdesktop.swingx.autocomplete.AutoCompleteComboBoxEditor;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;




 

public class Order extends javax.swing.JFrame {

    Connection con;
    ResultSet rs;
    PreparedStatement pst;

    public Order() {
        initComponents();
        con = CafeConnect.ConnecrDb();
        itemInBox();
        AutoCompleteDecorator.decorate(ITEMBOX);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        FOODTABLE = new javax.swing.JTable();
        DELETE = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ADD = new javax.swing.JButton();
        item = new javax.swing.JLabel();
        quantity = new javax.swing.JLabel();
        QUANTITY = new javax.swing.JTextField();
        DONE = new javax.swing.JButton();
        ITEMBOX = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        PRICE = new javax.swing.JTextField();
        discount = new javax.swing.JLabel();
        DISCOUNT = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FOODTABLE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        FOODTABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Quantity", "Price"
            }
        ));
        FOODTABLE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FOODTABLEKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(FOODTABLE);

        DELETE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DELETE.setText("Delete");
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Bernard MT Condensed", 1, 48)); // NOI18N
        jLabel1.setText("Food Table");

        ADD.setText("Add");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });

        item.setText("Item");

        quantity.setText("Quantity");

        DONE.setText("Done");
        DONE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DONEActionPerformed(evt);
            }
        });

        ITEMBOX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        ITEMBOX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ITEMBOXActionPerformed(evt);
            }
        });

        jLabel2.setText("Price");

        discount.setText("Discount");

        DISCOUNT.setText("15");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 917, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(DONE, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(437, 437, 437)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(discount)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(item)
                                .addGap(46, 46, 46)
                                .addComponent(ITEMBOX, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel2)
                                .addGap(29, 29, 29)
                                .addComponent(PRICE, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(quantity)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(QUANTITY, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(ADD))
                            .addComponent(DISCOUNT, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item)
                    .addComponent(ITEMBOX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantity)
                    .addComponent(QUANTITY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ADD)
                    .addComponent(jLabel2)
                    .addComponent(PRICE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DISCOUNT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(discount))
                .addGap(114, 114, 114)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DONE, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(295, 295, 295))
        );

        setSize(new java.awt.Dimension(1171, 960));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed

        delete();
        receiptTable();
        
    }//GEN-LAST:event_DELETEActionPerformed
    private void DONEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DONEActionPerformed
        Payment page = new Payment();
        page.setVisible(true);
        this.hide();
    }//GEN-LAST:event_DONEActionPerformed

    private void ITEMBOXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ITEMBOXActionPerformed
        getPrice();
    }//GEN-LAST:event_ITEMBOXActionPerformed

    private void FOODTABLEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FOODTABLEKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_FOODTABLEKeyReleased

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        addToTable();
        receiptTable();
    }//GEN-LAST:event_ADDActionPerformed

    public void itemInBox() {
        try {
            String sql = "select * from Menu";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {

                ITEMBOX.addItem(rs.getString("Item"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getPrice() {
        try {
            String sql = "select * from Menu where Item=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, (String) ITEMBOX.getSelectedItem());

            rs = pst.executeQuery();

            while (rs.next()) {
                PRICE.setText(rs.getString("Price"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList productList() {

        double quantity = Double.parseDouble(QUANTITY.getText());
        double price = priceOfPerItem();
        ArrayList<Product> list = new ArrayList<Product>();
        Product p = new Product(ITEMBOX.getSelectedItem().toString(), price, quantity);
        list.add(p);
        return list;
    }

    public void addToTable() {
        DefaultTableModel table = (DefaultTableModel) this.FOODTABLE.getModel();
        ArrayList<Product> list = productList();
        Object rowData[] = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getItem();
            rowData[1] = list.get(i).getQuantity();
            rowData[2] = list.get(i).getPrice();

            table.addRow(rowData);
        }
    }

    public double priceOfPerItem() {
        double quantity = Double.parseDouble(QUANTITY.getText());
        double price = Double.parseDouble(PRICE.getText());
        double TotalPrice = 0;
        double Discount =Double.parseDouble(DISCOUNT.getText());
        if (Discount == 0) {
            TotalPrice = (quantity * price);
        }
         else
        {
            Discount=Discount/100;
            TotalPrice = (quantity * price)*Discount;
        }
        return TotalPrice;
    }

    public void receiptTable() {
        try {
            String price = Double.toString(priceOfPerItem());
            String sql = "Insert into Receipt (Item,Quantity,Price) values (?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, ITEMBOX.getSelectedItem().toString());
            pst.setString(2, QUANTITY.getText());
            pst.setString(3, price);
            pst.execute();
            JOptionPane.showMessageDialog(null, "item added");
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void delete()
    {
 
        try {
            String sql = "Delete from Receipt";
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
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
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JButton DELETE;
    private static javax.swing.JTextField DISCOUNT;
    private javax.swing.JButton DONE;
    private javax.swing.JTable FOODTABLE;
    private javax.swing.JComboBox<String> ITEMBOX;
    private javax.swing.JTextField PRICE;
    private javax.swing.JTextField QUANTITY;
    private javax.swing.JLabel discount;
    private javax.swing.JLabel item;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel quantity;
    // End of variables declaration//GEN-END:variables

    private void AutoCompleteDecorator(JComboBox<String> ITEMBOX) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
