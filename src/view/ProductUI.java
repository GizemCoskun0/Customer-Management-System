
package view;

import business.ProductController;
import core.Helper;
import entity.Product;


public class ProductUI extends javax.swing.JFrame {
    private Product product;
    private ProductController productController;
 
    public ProductUI(Product product) {
        this.product = product;
        this.productController = new ProductController();
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setTitle("Product Add/Update");
        this.setVisible(true);
        setDefaultCloseOperation(ProductUI.DISPOSE_ON_CLOSE);
        
        if(this.product.getId()==0){
            this.lbl_title.setText("Add a Product");
        }else{
            this.lbl_title.setText("Update a Product");
            this.txt_product_name.setText(this.product.getName());
            this.txt_product_code.setText(this.product.getCode());
            this.txt_product_price.setText(String.valueOf(this.product.getPrice()));
            this.txt_stock_status.setText(String.valueOf(this.product.getStock()));
            
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_title = new javax.swing.JLabel();
        lbl_product_name = new javax.swing.JLabel();
        txt_product_name = new javax.swing.JTextField();
        lbl_product_code = new javax.swing.JLabel();
        txt_product_code = new javax.swing.JTextField();
        lbl_product_price = new javax.swing.JLabel();
        txt_product_price = new javax.swing.JTextField();
        lbl_price_stocksstatus = new javax.swing.JLabel();
        txt_stock_status = new javax.swing.JTextField();
        btn_save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_title.setText("jLabel1");

        lbl_product_name.setText("Product Name:");

        lbl_product_code.setText("Code:");

        lbl_product_price.setText("Price:");

        lbl_price_stocksstatus.setText("Stock Status:");

        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_product_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_product_name)
                    .addComponent(lbl_product_code, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_product_code)
                    .addComponent(lbl_product_price, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_product_price)
                    .addComponent(lbl_price_stocksstatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_stock_status))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(btn_save)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_product_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_product_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_product_code)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_product_code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_product_price)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_product_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_price_stocksstatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_stock_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_save)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
           if(this.txt_product_name.getText().isEmpty() || this.txt_product_code.getText().isEmpty() || this.txt_product_price.getText().isEmpty() || this.txt_stock_status.getText().isEmpty()){
            Helper.showMsg("fill");
            
        }else{
            boolean result = false;
            this.product.setName(this.txt_product_name.getText());
            this.product.setCode(this.txt_product_code.getText());
            this.product.setPrice(Integer.parseInt(this.txt_product_price.getText()));
            this.product.setStock(Integer.parseInt(this.txt_stock_status.getText()));
            

            if (this.product.getId()==0){
                result = this.productController.save(this.product);
            }else{
                result = this.productController.update(this.product);
            }
            
            
            
            if(result){
                Helper.showMsg("done");
            }else{
                Helper.showMsg("error");
            }
        }
    }//GEN-LAST:event_btn_saveActionPerformed


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
            java.util.logging.Logger.getLogger(ProductUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_save;
    private javax.swing.JLabel lbl_price_stocksstatus;
    private javax.swing.JLabel lbl_product_code;
    private javax.swing.JLabel lbl_product_name;
    private javax.swing.JLabel lbl_product_price;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JTextField txt_product_code;
    private javax.swing.JTextField txt_product_name;
    private javax.swing.JTextField txt_product_price;
    private javax.swing.JTextField txt_stock_status;
    // End of variables declaration//GEN-END:variables
}
