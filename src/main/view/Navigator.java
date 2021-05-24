package main.view;

import java.awt.Color;
import static java.awt.Frame.NORMAL;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author pablo
 */
public class Navigator extends javax.swing.JFrame {

    public Navigator() {
        initComponents();
    }

    public void addExternalContent(JComponent jComponent) {
        bodyContainerExternalContent.add(jComponent);

        jComponent.setVisible(true);

    }

    public void removeExternalContent() {
        bodyContainerExternalContent.removeAll();
        super.repaint();
        super.revalidate();
        resetColorButtons();
    }

    public void resetColorButtons() {
        btnOpenExternalContentClient.setSelected(false);
        btnOpenExternalContentClient.setForeground(new Color(0, 0, 0));
        btnOpenExternalContentClient.setBackground(new Color(255, 255, 255));

        btnOpenExternalContentArticle.setSelected(false);
        btnOpenExternalContentArticle.setForeground(new Color(0, 0, 0));
        btnOpenExternalContentArticle.setBackground(new Color(255, 255, 255));
    }

    public void openModalDialog(JComponent jComponent, int width, int height, int x, int y) {
        // X = 120
        // Y = 27
        // Width = 480
        // Height = 425
        super.repaint();
        super.revalidate();

        jComponent.setBounds(x, y, width, height);
        bodyDialog.add(jComponent);

        modalDialog.setVisible(true);
        modalDialog.setSize(this.getWidth(), this.getHeight());
        modalDialog.setLocationRelativeTo(this);
        modalDialog.setBackground(new Color(0, 0, 0, 0));
        bodyDialog.setBackground(new Color(0, 0, 0, 100));

        super.repaint();
        super.revalidate();
    }

    public void closeModalDialog() {
        modalDialog.setVisible(false);
        modalDialog.dispose();
        bodyDialog.remove(1);
        super.repaint();
        super.revalidate();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modalDialog = new javax.swing.JDialog();
        containerDialog = new javax.swing.JPanel();
        bodyDialog = new javax.swing.JPanel();
        btnCloseModalDialog = new javax.swing.JButton();
        navigatorContainer = new javax.swing.JDesktopPane();
        navigatorNav = new javax.swing.JPanel();
        btnCloseApp = new javax.swing.JLabel();
        navigatorSidebar = new javax.swing.JScrollPane();
        sidebarContent = new javax.swing.JPanel();
        sidebarTitle = new javax.swing.JLabel();
        btnOpenExternalContentClient = new javax.swing.JButton();
        btnOpenExternalContentArticle = new javax.swing.JButton();
        navigatorExternalContent = new javax.swing.JScrollPane();
        containerExternalContent = new javax.swing.JPanel();
        bodyContainerExternalContent = new javax.swing.JPanel();

        modalDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        modalDialog.setUndecorated(true);
        modalDialog.setResizable(false);

        containerDialog.setOpaque(false);
        containerDialog.setPreferredSize(new java.awt.Dimension(720, 480));

        bodyDialog.setLayout(null);

        btnCloseModalDialog.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        btnCloseModalDialog.setText("Close");
        btnCloseModalDialog.setBorderPainted(false);
        btnCloseModalDialog.setFocusPainted(false);
        btnCloseModalDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseModalDialogActionPerformed(evt);
            }
        });
        bodyDialog.add(btnCloseModalDialog);
        btnCloseModalDialog.setBounds(615, 10, 90, 25);

        javax.swing.GroupLayout containerDialogLayout = new javax.swing.GroupLayout(containerDialog);
        containerDialog.setLayout(containerDialogLayout);
        containerDialogLayout.setHorizontalGroup(
            containerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyDialog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        containerDialogLayout.setVerticalGroup(
            containerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyDialog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        modalDialog.getContentPane().add(containerDialog, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        navigatorContainer.setBackground(new java.awt.Color(255, 255, 255));
        navigatorContainer.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        navigatorNav.setBackground(new java.awt.Color(255, 255, 255));
        navigatorNav.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(240, 240, 240)));

        btnCloseApp.setBackground(new java.awt.Color(255, 255, 255));
        btnCloseApp.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        btnCloseApp.setForeground(new java.awt.Color(153, 153, 153));
        btnCloseApp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCloseApp.setText("<html>&times;</html>");
        btnCloseApp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(240, 240, 240)));
        btnCloseApp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseAppMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout navigatorNavLayout = new javax.swing.GroupLayout(navigatorNav);
        navigatorNav.setLayout(navigatorNavLayout);
        navigatorNavLayout.setHorizontalGroup(
            navigatorNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navigatorNavLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCloseApp, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        navigatorNavLayout.setVerticalGroup(
            navigatorNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCloseApp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        navigatorSidebar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(240, 240, 240)));
        navigatorSidebar.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        sidebarContent.setBackground(new java.awt.Color(255, 255, 255));

        sidebarTitle.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        sidebarTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sidebarTitle.setText("Dashboard admin");

        btnOpenExternalContentClient.setBackground(new java.awt.Color(255, 255, 255));
        btnOpenExternalContentClient.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        btnOpenExternalContentClient.setText("Clients");
        btnOpenExternalContentClient.setBorder(null);
        btnOpenExternalContentClient.setBorderPainted(false);
        btnOpenExternalContentClient.setFocusPainted(false);
        btnOpenExternalContentClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnOpenExternalContentClientMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOpenExternalContentClientMouseExited(evt);
            }
        });
        btnOpenExternalContentClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenExternalContentClientActionPerformed(evt);
            }
        });

        btnOpenExternalContentArticle.setBackground(new java.awt.Color(255, 255, 255));
        btnOpenExternalContentArticle.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        btnOpenExternalContentArticle.setText("Articles");
        btnOpenExternalContentArticle.setBorder(null);
        btnOpenExternalContentArticle.setBorderPainted(false);
        btnOpenExternalContentArticle.setFocusPainted(false);
        btnOpenExternalContentArticle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnOpenExternalContentArticleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOpenExternalContentArticleMouseExited(evt);
            }
        });
        btnOpenExternalContentArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenExternalContentArticleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidebarContentLayout = new javax.swing.GroupLayout(sidebarContent);
        sidebarContent.setLayout(sidebarContentLayout);
        sidebarContentLayout.setHorizontalGroup(
            sidebarContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sidebarTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(btnOpenExternalContentArticle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnOpenExternalContentClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidebarContentLayout.setVerticalGroup(
            sidebarContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sidebarTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnOpenExternalContentClient, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnOpenExternalContentArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(348, Short.MAX_VALUE))
        );

        navigatorSidebar.setViewportView(sidebarContent);

        navigatorExternalContent.setBorder(null);

        containerExternalContent.setBackground(new java.awt.Color(255, 255, 102));

        bodyContainerExternalContent.setLayout(null);

        javax.swing.GroupLayout containerExternalContentLayout = new javax.swing.GroupLayout(containerExternalContent);
        containerExternalContent.setLayout(containerExternalContentLayout);
        containerExternalContentLayout.setHorizontalGroup(
            containerExternalContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyContainerExternalContent, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );
        containerExternalContentLayout.setVerticalGroup(
            containerExternalContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyContainerExternalContent, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        navigatorExternalContent.setViewportView(containerExternalContent);

        navigatorContainer.setLayer(navigatorNav, javax.swing.JLayeredPane.DEFAULT_LAYER);
        navigatorContainer.setLayer(navigatorSidebar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        navigatorContainer.setLayer(navigatorExternalContent, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout navigatorContainerLayout = new javax.swing.GroupLayout(navigatorContainer);
        navigatorContainer.setLayout(navigatorContainerLayout);
        navigatorContainerLayout.setHorizontalGroup(
            navigatorContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navigatorNav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(navigatorContainerLayout.createSequentialGroup()
                .addComponent(navigatorSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(navigatorExternalContent))
        );
        navigatorContainerLayout.setVerticalGroup(
            navigatorContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigatorContainerLayout.createSequentialGroup()
                .addComponent(navigatorNav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(navigatorContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(navigatorSidebar)
                    .addComponent(navigatorExternalContent)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navigatorContainer)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navigatorContainer)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseModalDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseModalDialogActionPerformed
        closeModalDialog();
    }//GEN-LAST:event_btnCloseModalDialogActionPerformed

    private void btnCloseAppMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseAppMouseClicked
        super.dispose();
    }//GEN-LAST:event_btnCloseAppMouseClicked

    private void btnOpenExternalContentClientMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOpenExternalContentClientMouseEntered
        if (!btnOpenExternalContentClient.isSelected()) {
            btnOpenExternalContentClient.setForeground(new Color(255, 255, 255));
            btnOpenExternalContentClient.setBackground(new Color(34, 111, 240));
        }
    }//GEN-LAST:event_btnOpenExternalContentClientMouseEntered

    private void btnOpenExternalContentArticleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOpenExternalContentArticleMouseExited
        if (!btnOpenExternalContentArticle.isSelected()) {
            btnOpenExternalContentArticle.setForeground(new Color(0, 0, 0));
            btnOpenExternalContentArticle.setBackground(new Color(255, 255, 255));
        }
    }//GEN-LAST:event_btnOpenExternalContentArticleMouseExited

    private void btnOpenExternalContentClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenExternalContentClientActionPerformed
        if (!btnOpenExternalContentClient.isSelected()) {
            removeExternalContent();

            FrmClient frmClient = new FrmClient(this);

            addExternalContent(frmClient);

            btnOpenExternalContentClient.setSelected(true);

            btnOpenExternalContentClient.setForeground(new Color(255, 255, 255));
            btnOpenExternalContentClient.setBackground(new Color(34, 111, 240));
        }

    }//GEN-LAST:event_btnOpenExternalContentClientActionPerformed

    private void btnOpenExternalContentArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenExternalContentArticleActionPerformed
        if (!btnOpenExternalContentArticle.isSelected()) {
            removeExternalContent();

            FrmArticle frmArticle = new FrmArticle(this);

            addExternalContent(frmArticle);

            btnOpenExternalContentArticle.setSelected(true);

            btnOpenExternalContentArticle.setForeground(new Color(255, 255, 255));
            btnOpenExternalContentArticle.setBackground(new Color(34, 111, 240));
        }
    }//GEN-LAST:event_btnOpenExternalContentArticleActionPerformed

    private void btnOpenExternalContentArticleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOpenExternalContentArticleMouseEntered
        if (!btnOpenExternalContentArticle.isSelected()) {
            btnOpenExternalContentArticle.setForeground(new Color(255, 255, 255));
            btnOpenExternalContentArticle.setBackground(new Color(34, 111, 240));
        }
    }//GEN-LAST:event_btnOpenExternalContentArticleMouseEntered

    private void btnOpenExternalContentClientMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOpenExternalContentClientMouseExited
        if (!btnOpenExternalContentClient.isSelected()) {
            btnOpenExternalContentClient.setForeground(new Color(0, 0, 0));
            btnOpenExternalContentClient.setBackground(new Color(255, 255, 255));
        }
    }//GEN-LAST:event_btnOpenExternalContentClientMouseExited

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Navigator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Navigator().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyContainerExternalContent;
    private javax.swing.JPanel bodyDialog;
    private javax.swing.JLabel btnCloseApp;
    private javax.swing.JButton btnCloseModalDialog;
    private javax.swing.JButton btnOpenExternalContentArticle;
    private javax.swing.JButton btnOpenExternalContentClient;
    private javax.swing.JPanel containerDialog;
    private javax.swing.JPanel containerExternalContent;
    private javax.swing.JDialog modalDialog;
    private javax.swing.JDesktopPane navigatorContainer;
    private javax.swing.JScrollPane navigatorExternalContent;
    private javax.swing.JPanel navigatorNav;
    private javax.swing.JScrollPane navigatorSidebar;
    private javax.swing.JPanel sidebarContent;
    private javax.swing.JLabel sidebarTitle;
    // End of variables declaration//GEN-END:variables
}
