package stockmanager;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SaleList extends javax.swing.JDialog {

    public SaleList(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        try
        {
            String[] headings={"SaleId","SaleDate","CustomerName","Address","ContactNo","Description"};

            DefaultTableModel atm=new DefaultTableModel(headings,0);
            jTable1.setModel(atm);
            try
            {

                Statement s = StockManager.con.createStatement();
                ResultSet rs = s.executeQuery("select * from sales");

                Object[] row;

                while(rs.next())
                {
                    row = new Object[6];
                    
                    row[0] = rs.getInt("SaleId");
                    row[1] = rs.getString("Saledate");
                    row[2] = rs.getString("CustomerName");
                    row[3] = rs.getString("Address");
                    row[4] = rs.getString("Contactno");
                    row[5] = rs.getString("Description");
 
                    atm.addRow(row);

                }

                rs.close();
                s.close();
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(rootPane,ex);
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane,ex);
        }
        
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PAYMENT");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 486, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int X=    JOptionPane.showConfirmDialog(rootPane, "Do you want to exit???", "SALE REGISTER", JOptionPane.YES_NO_OPTION);

        if(X==JOptionPane.YES_OPTION)
        {
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        int i = jTable1.getSelectedRow();
        
        if(i>=0)
        {
            int SMID = Integer.parseInt( jTable1.getValueAt(i, 0).toString());
            
            try
            {
                    String[] headings={"ItemName","Quantity","Price","Total"};

                    DefaultTableModel dtm=new DefaultTableModel(headings,0);
                    jTable2.setModel(dtm);

                    Statement s = StockManager.con.createStatement();
                    ResultSet rs = s.executeQuery("select I.ItemName, S.Quantity, S.Price,S.Quantity*S.Price as [Total] from Items as [I], saledetails as [S] Where I.ItemId=S.ItemId and S.SaleId="+SMID);

                    Object[] row;

                    while(rs.next())
                    {
                        row = new Object[4];

                        row[0] = rs.getString("ItemName");
                        row[1] = rs.getInt("Quantity");
                        row[2] = rs.getFloat("Price");
                        row[3] = rs.getFloat("Total");

                        dtm.addRow(row);
                    }

                    rs.close();
                    s.close();
            }//Try
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(rootPane, ex);
            }//catch

            
            
        }
                    
        
    }//GEN-LAST:event_jTable1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
