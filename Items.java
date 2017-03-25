
package stockmanager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Items extends javax.swing.JDialog {

    public Items(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        loadItems();
        
    }

    private void loadItems()
    {
                String[] headings={"ItemId","ItemName","Category","Description"};
        DefaultTableModel dtm=new DefaultTableModel(headings,0);
        jTable1.setModel(dtm);
        try
        {
            PreparedStatement ps= StockManager.con.prepareStatement("select * from Items");
            ResultSet rs=ps.executeQuery();
            while(rs.next()==true)
            {
                  Object[] row=new Object[5];
                   row[0]=rs.getInt("ItemId");
                   row[1]=rs.getString("ItemName");
                   row[2]=rs.getString("Category");
                   row[3]=rs.getString("Description");
                   
                   dtm.addRow(row);
            }
            rs.close();
            ps.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int x = jTable1.getSelectedRow();
        if(x>=0)
        {
            int a = Integer.parseInt( jTable1.getValueAt(x,0).toString() );
            Item obj = new Item(null, true);
            obj.startEditing(a);
            obj.setVisible(true);
            
            loadItems();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int index = jTable1.getSelectedRow();
        
        if(index>=0)
        {
            
            int res = JOptionPane.showConfirmDialog(rootPane, "Do you want to delete selected item?","Stock Manager", JOptionPane.YES_NO_OPTION);
            
            if(res==JOptionPane.YES_OPTION)
            {
                int a = Integer.parseInt( jTable1.getValueAt(index, 0).toString() );
                try
                {
                    PreparedStatement ps = StockManager.con.prepareStatement("Delete From Items Where ItemId=?");
                    ps.setInt(1, a);
                    ps.execute();
                    JOptionPane.showMessageDialog(rootPane,"Item Deleted Successfully...");
                    loadItems();
                }//Try
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(rootPane, "Item cannot be deleted because it has related records!!!");
                }
            }//IF Yes
            
        }//IF Index
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
