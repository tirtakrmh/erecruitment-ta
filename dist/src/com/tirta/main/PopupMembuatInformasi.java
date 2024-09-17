/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.tirta.main;

import com.tirta.dao.InformasiDAO;
import com.tirta.dao.LamaranDAO;
import com.tirta.model.EnumStatus;
import com.tirta.model.ModelInformasi;
import com.tirta.model.ModelLamaranPelamar;
import com.tirta.model.ModelLowongan;
import com.tirta.model.ModelPelamarLamaran;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Tirta Karimah
 */
public class PopupMembuatInformasi extends javax.swing.JFrame {
    private String statusLamaran;
    private ModelLowongan lowongan;
    private LamaranDAO lamaranDAO = new LamaranDAO();
    private InformasiDAO informasiDAO = new InformasiDAO();
    private List<ModelPelamarLamaran> listLamaran = new ArrayList<>();
    
    public PopupMembuatInformasi(ModelLowongan lowongan) {
        this.lowongan = lowongan;
        initComponents();
        init();
    }
    
    private void init(){
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the frame
        setResizable(false);  // Disable resizing
        setSize(802, 802);  // Set frame size
        
        if (lowongan.getStatus().equalsIgnoreCase(EnumStatus.OPEN.name())) {
            this.statusLamaran = EnumStatus.INTERVIEW.name();
            lblInformasi.setText("Informasi Interview");
            lblTanggal.setText("Tanggal Interview");
            lblJam.setText("Jam Interview");
            lblDeskripsi.setText("Deskripsi Interview");
            btnKirim.setText("Kirim Pemberitahuan Interview");
        } else if (lowongan.getStatus().equalsIgnoreCase(EnumStatus.CLOSED.name())) {
            this.statusLamaran = EnumStatus.DITERIMA.name();
            lblInformasi.setText("Informasi Onboarding");
            lblTanggal.setText("Tanggal Onboarding");
            lblJam.setText("Jam Onboarding");
            lblDeskripsi.setText("Deskripsi Onboarding");
            btnKirim.setText("Kirim Pemberitahuan Onboarding");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblInformasi = new javax.swing.JLabel();
        lblTanggal = new javax.swing.JLabel();
        lblJam = new javax.swing.JLabel();
        lblDeskripsi = new javax.swing.JLabel();
        scrollDeskripsi = new javax.swing.JScrollPane();
        txtDeskripsi = new javax.swing.JTextArea();
        txtJam = new javax.swing.JTextField();
        txtTanggal = new javax.swing.JTextField();
        btnKirim = new com.tirta.swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(802, 802));

        kGradientPanel1.setBackground(new java.awt.Color(56, 109, 126));
        kGradientPanel1.setForeground(new java.awt.Color(56, 109, 126));
        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(56, 109, 126));
        kGradientPanel1.setkStartColor(new java.awt.Color(56, 109, 126));
        kGradientPanel1.setMaximumSize(null);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("INFORMASI PEMBERITAHUAN LOKER");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0, 0)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );

        lblInformasi.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblInformasi.setForeground(new java.awt.Color(255, 255, 255));
        lblInformasi.setText("INFORMASI:");

        lblTanggal.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblTanggal.setForeground(new java.awt.Color(255, 255, 255));
        lblTanggal.setText("Tanggal");

        lblJam.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblJam.setForeground(new java.awt.Color(255, 255, 255));
        lblJam.setText("Jam");

        lblDeskripsi.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblDeskripsi.setForeground(new java.awt.Color(255, 255, 255));
        lblDeskripsi.setText("Deskripsi");

        scrollDeskripsi.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        txtDeskripsi.setColumns(20);
        txtDeskripsi.setRows(5);
        scrollDeskripsi.setViewportView(txtDeskripsi);

        txtJam.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        txtTanggal.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        btnKirim.setForeground(new java.awt.Color(56, 109, 126));
        btnKirim.setText("INFO INTERVIEW");
        btnKirim.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnKirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKirimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblInformasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDeskripsi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTanggal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblJam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                            .addComponent(txtJam)
                            .addComponent(scrollDeskripsi)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKirim, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel3)
                .addGap(36, 36, 36)
                .addComponent(lblInformasi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTanggal)
                    .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJam)
                    .addComponent(txtJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(lblDeskripsi)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollDeskripsi, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKirimActionPerformed
        // TODO add your handling code here:
        try {
            listLamaran = lamaranDAO.getListPelamarByLowonganID(statusLamaran, (int)lowongan.getId());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error Get Data lamaran: " + ex.getMessage());
            System.out.println("ERR: " + ex.getMessage());
        }
        
        System.out.println("DATA LAMARAN"+listLamaran.toString());

        String tanggalText = txtTanggal.getText();
        String jamText = txtJam.getText();

        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");

        Date tanggal = null;
        Date jam = null;

        try {
            tanggal = dateFormatter.parse(tanggalText);
            jam = timeFormatter.parse(jamText);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Error parsing date or time: " + e.getMessage());
            System.out.println("ERR: " + e.getMessage());
            return;
        }

        ModelInformasi informasi = new ModelInformasi();
        informasi.setTanggal(tanggal);
        informasi.setJam(jam);
        informasi.setDeskripsi(txtDeskripsi.getText());

        try {
            boolean isInsert = informasiDAO.insertInformasi(listLamaran, informasi);
            if (isInsert) {
                JOptionPane.showMessageDialog(this, "Informasi berhasil dikirim.");
            } else {
                JOptionPane.showMessageDialog(this, "Gagal mengirim informasi.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error inserting informasi: " + ex.getMessage());
            System.out.println("ERR: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnKirimActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(PopupPemberitahuanPelamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PopupPemberitahuanPelamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PopupPemberitahuanPelamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PopupPemberitahuanPelamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PopupPemberitahuanPelamar().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.tirta.swing.Button btnKirim;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblDeskripsi;
    private javax.swing.JLabel lblInformasi;
    private javax.swing.JLabel lblJam;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JScrollPane scrollDeskripsi;
    private javax.swing.JTextArea txtDeskripsi;
    private javax.swing.JTextField txtJam;
    private javax.swing.JTextField txtTanggal;
    // End of variables declaration//GEN-END:variables
}