
package com.tirta.main;

import static com.tirta.main.MainSystemPelamar.refreshFrom;
import com.tirta.model.ModelUser;
import com.tirta.model.ModelUserLogin;
import com.tirta.sidebar.Drawer;
import com.tirta.sidebar.DrawerController;
import com.tirta.sidebar.DrawerItem;
import com.tirta.sidebar.EventDrawer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainSystemHRD extends javax.swing.JFrame {
    private DrawerController drawer;
    private Font font = new Font("Segoe UI", Font.BOLD, 16);
    private JLabel lblFooter = new JLabel("@Copyright Tirta Karimah");
    private final ModelUserLogin user;

    public MainSystemHRD(ModelUserLogin user) {
        this.user = user;
        initComponents();
        getContentPane().setBackground(new Color(255, 255, 255));
        lbUser.setText(user.getName());
        setTitle("");
        Image icon2 = Toolkit.getDefaultToolkit().getImage("/src/com/tirta/icon/logo.png");  
        setIconImage(icon2);
        refreshFrom(new Welcome());
        lblFooter.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        lblFooter.setForeground(Color.white);
        lblFooter.setHorizontalAlignment(SwingConstants.CENTER);
        
        drawer = Drawer.newDrawer(this)
                .header(new Header())
                .separator(2, new Color(56, 109, 126))
                .background(new Color(56, 109, 126))
                .duration(100)
                .enableScroll(true)
                .space(30)
                .itemHeight(50)
                .drawerBackground(new Color(56, 109, 126))
                .backgroundTransparent(0.2f)
                .addChild(new DrawerItem("Profil")
                        .foreGround(Color.white)
                        .font(font)
                        .icon(new ImageIcon(getClass().getResource("/com/tirta/icon/profil.png")))
                        .build())
                .addChild(new DrawerItem("Tentang LoKer")
                        .foreGround(Color.white)
                        .font(font)
                        .icon(new ImageIcon(getClass().getResource("/com/tirta/icon/loker.png")))
                        .build())
//                .addChild(new DrawerItem("Pemberitahuan LoKer")
//                        .foreGround(Color.white)
//                        .font(font)
//                        .icon(new ImageIcon(getClass().getResource("/com/tirta/icon/pemberitahuan.png")))
//                        .build())
                .addFooter(new DrawerItem("Keluar Akun")
                        .foreGround(Color.white)
                        .font(font)
                        .icon(new ImageIcon(getClass().getResource("/com/tirta/icon/keluar.png")))
                        .build())
                .addFooter(lblFooter)
                .addFooter(new JLabel(" "))
                .addFooter(new JLabel(" "))
                .event(new EventDrawer(){
                    @Override
                    public void selected(int index, DrawerItem item) {
                        System.out.println(index);
                        switch (index) {
                            case 0:
                                refreshFrom(new MenuProfilKaryawan(user.getId()));
                                break;
                            case 1:
                                refreshFrom(new MenuTentangLoker(user.getId(), user));
                                break;
                            case 2:
                                dispose();
                                new Main().setVisible(true);
                                break;
                            default:
                                throw new AssertionError();
                        }
                    }
                }
            )
        .build();
    }
    
    public static void refreshFrom(JComponent component){
        panelForm.removeAll();
        panelForm.add(component);
        panelForm.repaint();
        panelForm.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        sideBar = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panelForm = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1291, 1000));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(56, 109, 126));
        jPanel1.setForeground(new java.awt.Color(56, 109, 126));
        jPanel1.setMaximumSize(new java.awt.Dimension(1291, 40));
        jPanel1.setMinimumSize(new java.awt.Dimension(1291, 40));
        jPanel1.setPreferredSize(new java.awt.Dimension(1291, 40));

        sideBar.setBackground(new java.awt.Color(0,0,0,0));
        sideBar.setForeground(new java.awt.Color(255, 255, 255));
        sideBar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sideBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tirta/icon/menu.png"))); // NOI18N
        sideBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sideBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sideBarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sideBarMouseEntered(evt);
            }
        });

        lbUser.setBackground(new java.awt.Color(56, 109, 126));
        lbUser.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbUser.setForeground(new java.awt.Color(255, 255, 255));
        lbUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUser.setText("User Name");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 921, Short.MAX_VALUE)
                .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbUser)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(sideBar, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelForm.setBackground(new java.awt.Color(0,0,0,0)
        );
        panelForm.setForeground(new java.awt.Color(255, 255, 255));
        panelForm.setMaximumSize(new java.awt.Dimension(1291, 1000));
        panelForm.setMinimumSize(new java.awt.Dimension(1291, 1000));
        panelForm.setOpaque(false);
        panelForm.setPreferredSize(new java.awt.Dimension(1291, 1000));
        panelForm.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sideBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBarMouseClicked
        if (drawer.isShow()) {
            drawer.hide();
        }else{
            drawer.show();
        }
    }//GEN-LAST:event_sideBarMouseClicked

    private void sideBarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBarMouseEntered
        sideBar.setBackground(new java.awt.Color(0,0,0,50));
    }//GEN-LAST:event_sideBarMouseEntered

//    public static void main(ModelUser user) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainSystem(user).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbUser;
    public static javax.swing.JPanel panelForm;
    private javax.swing.JLabel sideBar;
    // End of variables declaration//GEN-END:variables
}
