package main.view;

import main.controllers.ArticleController;
import main.model.entities.Article;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

/**
 *
 * @author pablo
 */
public class FrmEditArticle extends javax.swing.JPanel {

    private final ArticleController articleController;
    
    private final int code;
    
    private final FrmArticle parent;
    
    public FrmEditArticle(int code, FrmArticle parent) {
        initComponents();
        
        this.code = code;
        this.parent = parent;
        
        articleController = new ArticleController();
        
        formBody.getVerticalScrollBar().setUnitIncrement(15);
        
        super.revalidate();
        super.repaint();
        
        uplodCategoriesToComboBox();
        
        uploadInformation(code);
        
        ((JSpinner.DefaultEditor) txtPrice.getEditor()).getTextField().
                setFont(new Font("Poppins", 0, 11));

        ((JSpinner.DefaultEditor) txtStock.getEditor()).getTextField().
                setFont(new Font("Poppins", 0, 11));
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formHeader = new javax.swing.JPanel();
        formTitle = new javax.swing.JLabel();
        formBody = new javax.swing.JScrollPane();
        formBodyContent = new javax.swing.JPanel();
        titleForm = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JSpinner();
        lblCategory = new javax.swing.JLabel();
        cboCategory = new javax.swing.JComboBox<>();
        lblStock = new javax.swing.JLabel();
        txtStock = new javax.swing.JSpinner();
        btnUpdate = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        formHeader.setBackground(new java.awt.Color(255, 255, 255));
        formHeader.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        formHeader.setLayout(null);

        formTitle.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        formTitle.setText("Edit article");
        formHeader.add(formTitle);
        formTitle.setBounds(10, 5, 460, 17);

        formBody.setBackground(new java.awt.Color(255, 255, 255));
        formBody.setBorder(null);
        formBody.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        formBodyContent.setBackground(new java.awt.Color(255, 255, 255));

        titleForm.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        titleForm.setText("Article information edit form");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblName.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblName.setText("Name:");
        lblName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtName.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        txtName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtName.setOpaque(false);

        lblPrice.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblPrice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPrice.setText("Price:");

        txtPrice.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        txtPrice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        lblCategory.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblCategory.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCategory.setText("Category:");

        cboCategory.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N

        lblStock.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblStock.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblStock.setText("Stock:");

        txtStock.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        btnUpdate.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnUpdate.setText("Update information");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout formBodyContentLayout = new javax.swing.GroupLayout(formBodyContent);
        formBodyContent.setLayout(formBodyContentLayout);
        formBodyContentLayout.setHorizontalGroup(
            formBodyContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formBodyContentLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(formBodyContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formBodyContentLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(titleForm, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(formBodyContentLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(formBodyContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboCategory, 0, 400, Short.MAX_VALUE)
                            .addComponent(lblCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtName)
                            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblStock, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPrice)
                            .addComponent(txtStock))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        formBodyContentLayout.setVerticalGroup(
            formBodyContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formBodyContentLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(formBodyContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleForm, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(lblCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(cboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(lblStock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        formBody.setViewportView(formBodyContent);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(formHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(formBody)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(formHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(formBody, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        final JButton btnCancel = new JButton("Cancel");
        
        btnCancel.setBackground(new Color(108, 117, 125, 255));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setBorder(null);
        btnCancel.setFont(new Font("Poppins", 1, 11));
        btnCancel.setFocusPainted(false);
        btnCancel.setPreferredSize(new Dimension(100, 25));
        
        btnCancel.addActionListener((ActionEvent e) -> {
            JOptionPane.getRootFrame().dispose();
        });
        
        final JButton btnEdit = new JButton("Edit");
        
        btnEdit.setBackground(new Color(238, 183, 17, 255));
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setBorder(null);
        btnEdit.setFont(new Font("Poppins", 1, 11));
        btnEdit.setFocusPainted(false);
        btnEdit.setPreferredSize(new Dimension(100, 25));
        
        btnEdit.addActionListener((ActionEvent actionEvent) -> {
            
            JOptionPane.getRootFrame().dispose();
            
            int category = articleController.findCategoryByName(cboCategory.getSelectedItem().toString());
            
            articleController.editArticle(code, new Article(
                    txtName.getText(),
                    (Integer) txtPrice.getValue(),
                    category,
                    (Integer) txtStock.getValue()
            ));
            
            JOptionPane.getRootFrame().dispose();
            
            final JButton btnSuccess = new JButton("Ok");
            
            btnSuccess.setBackground(new Color(71, 201, 162, 255));
            btnSuccess.setForeground(Color.WHITE);
            btnSuccess.setBorder(null);
            btnSuccess.setFont(new Font("Poppins", 1, 11));
            btnSuccess.setFocusPainted(false);
            btnSuccess.setPreferredSize(new Dimension(100, 25));
            
            btnSuccess.addActionListener((ActionEvent e) -> {
                parent.generateTable();
                JOptionPane.getRootFrame().dispose();
                parent.parent.closeModalDialog();
            });
            
            final JButton[] btnSucessOption = {btnSuccess};
            
            JOptionPane.showOptionDialog(null, "<html><div align='center'>Success</div></html>\nThe records have been successfully updated.", "Successful Dialog", 0, JOptionPane.INFORMATION_MESSAGE, null, btnSucessOption, null);
            
        });
        
        final JButton[] btnOptions = {btnCancel, btnEdit};
        
        JOptionPane.showOptionDialog(null, "Are you sure?\nDo you really want to edit these records? This process cannot be undone.", "Confirm Dialog", 0, JOptionPane.WARNING_MESSAGE, null, btnOptions, null);

    }//GEN-LAST:event_btnUpdateActionPerformed
    
    private void uplodCategoriesToComboBox() {
        cboCategory.setModel(articleController.listCategories());
    }
    
    private void uploadInformation(int code) {
        final Article article = articleController.findArticleByCode(code);
        
        txtName.setText(article.getNameArticle());
        txtPrice.setValue(article.getPrice());
        
        final String currentCategory = articleController.findCategoryById(article.getCategory());
        
        cboCategory.setSelectedItem(currentCategory);
        
        txtStock.setValue(article.getStock());
        
        formTitle.setText(formTitle.getText() + " - " + article.getNameArticle());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboCategory;
    private javax.swing.JScrollPane formBody;
    private javax.swing.JPanel formBodyContent;
    private javax.swing.JPanel formHeader;
    private javax.swing.JLabel formTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel titleForm;
    private javax.swing.JTextField txtName;
    private javax.swing.JSpinner txtPrice;
    private javax.swing.JSpinner txtStock;
    // End of variables declaration//GEN-END:variables
}
