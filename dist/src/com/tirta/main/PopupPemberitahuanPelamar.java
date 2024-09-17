/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.tirta.main;

import com.tirta.model.EnumStatus;
import com.tirta.model.ModelLamaranPelamar;
import com.tirta.util.TextUtils;
import java.awt.FontMetrics;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author Tirta Karimah
 */
public class PopupPemberitahuanPelamar extends javax.swing.JFrame {
    private ModelLamaranPelamar lamaranPelamar;
    private final String catatanStatusDiPeriksa = "Catatan: Silahkan cek secara berkala untuk informasi selanjutnya";
    private final String catatanStatusDiTolak = "Catatan: Mohon maaf anda belum sesuai kualifikasi";
    // SimpleDateFormat untuk tanggal dalam format "dd, MMMM yyyy"
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd, MMMM yyyy", new Locale("id", "ID")); // Format untuk bahasa Indonesia

    /**
     * Creates new form PopupPemberitahuanPelamar
     */
    public PopupPemberitahuanPelamar(ModelLamaranPelamar lamaranPelamar) {
        this.lamaranPelamar = lamaranPelamar;
        initComponents();
        init();
    }
    
    private void init(){
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the frame
        setResizable(false);  // Disable resizing
        setSize(802, 802);  // Set frame size
        lblStatus.setText(lamaranPelamar.getStatus());
        txtPerusahaan.setText(lamaranPelamar.getPerusahaan());
        txtPosisi.setText(lamaranPelamar.getPosisi());
        int maxWidth = txtKualifikasi.getWidth(); // Misalnya, ambil lebar dari komponen txtKualifikasi
        FontMetrics metrics = txtKualifikasi.getFontMetrics(txtKualifikasi.getFont());
        String formattedKualifikasi = TextUtils.formatTextAreaString(lamaranPelamar.getKualifikasi(), maxWidth, metrics);
        txtKualifikasi.setText(formattedKualifikasi);
        
        txtPerusahaan.setEditable(false);
        txtPosisi.setEditable(false);
        txtKualifikasi.setEditable(false);
        txtTanggal.setEditable(false);
        txtJam.setEditable(false);
        txtDeskripsi.setEditable(false);
        
        setDataInfromasi();
    }
    
    private void setDataInfromasi(){
        if (lamaranPelamar.getStatus().equalsIgnoreCase(EnumStatus.INTERVIEW.name())) {
            lblInformasi.setText("Informasi Interview");
            lblTanggal.setText("Tanggal Interview");
            lblJam.setText("Jam Interview");
            lblDeskripsi.setText("Deskripsi Interview");
            int maxWidth = txtDeskripsi.getWidth(); // Misalnya, ambil lebar dari komponen
            FontMetrics metrics = txtDeskripsi.getFontMetrics(txtDeskripsi.getFont());
            String formattedDeskripsi = TextUtils.formatTextAreaString(lamaranPelamar.getDeskripsiInformasi(), maxWidth, metrics);
            String tanggalInformasi = dateFormat.format(lamaranPelamar.getTanggalInformasi());
            txtTanggal.setText(tanggalInformasi);
            txtJam.setText(lamaranPelamar.getJamInformasi());
            txtDeskripsi.setText(formattedDeskripsi);
//            lblTanggal.setVisible(true);
//            lblJam.setVisible(true);
//            lblDeskripsi.setVisible(true);
        } else if (lamaranPelamar.getStatus().equalsIgnoreCase(EnumStatus.DITERIMA.name())) {
            lblInformasi.setText("Informasi Onboarding");
            lblTanggal.setText("Tanggal Onboarding");
            lblJam.setText("Jam Onboarding");
            lblDeskripsi.setText("Deskripsi Onboarding");
            int maxWidth = txtDeskripsi.getWidth(); // Misalnya, ambil lebar dari komponen
            FontMetrics metrics = txtDeskripsi.getFontMetrics(txtDeskripsi.getFont());
            String formattedDeskripsi = TextUtils.formatTextAreaString(lamaranPelamar.getDeskripsiInformasi(), maxWidth, metrics);
            String tanggalInformasi = dateFormat.format(lamaranPelamar.getTanggalInformasi());
            txtTanggal.setText(tanggalInformasi);
            txtJam.setText(lamaranPelamar.getJamInformasi());
            txtDeskripsi.setText(formattedDeskripsi);
//            lblTanggal.setVisible(true);
//            lblJam.setVisible(true);
//            lblDeskripsi.setVisible(true);
        } else{
            if (lamaranPelamar.getStatus().equalsIgnoreCase(EnumStatus.DIPERIKSA.name())) {
                lblInformasi.setText(catatanStatusDiPeriksa);
                lblTanggal.setVisible(false);
                lblJam.setVisible(false);
                lblDeskripsi.setVisible(false);
                txtTanggal.setVisible(false);
                txtJam.setVisible(false);
                txtDeskripsi.setVisible(false);
                scrollDeskripsi.setVisible(false);
            } else{
                lblInformasi.setText(catatanStatusDiTolak);
                lblTanggal.setVisible(false);
                lblJam.setVisible(false);
                lblDeskripsi.setVisible(false);
                txtTanggal.setVisible(false);
                txtJam.setVisible(false);
                txtDeskripsi.setVisible(false);
                scrollDeskripsi.setVisible(false);
            }
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
        jPanel1 = new javax.swing.JPanel();
        lblDetailLowonganPekerjaan = new javax.swing.JLabel();
        lblPerusahaan = new javax.swing.JLabel();
        lblPosisi = new javax.swing.JLabel();
        lblKualifikasi = new javax.swing.JLabel();
        txtPerusahaan = new javax.swing.JTextField();
        txtPosisi = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtKualifikasi = new javax.swing.JTextArea();
        lblStatus = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTanggal = new javax.swing.JLabel();
        txtTanggal = new javax.swing.JTextField();
        lblJam = new javax.swing.JLabel();
        txtJam = new javax.swing.JTextField();
        lblDeskripsi = new javax.swing.JLabel();
        lblInformasi = new javax.swing.JLabel();
        scrollDeskripsi = new javax.swing.JScrollPane();
        txtDeskripsi = new javax.swing.JTextArea();

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
        jLabel3.setText("PEMBERITAHUAN STATUS LAMARAN");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0, 0));
        jPanel1.setMaximumSize(null);

        lblDetailLowonganPekerjaan.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblDetailLowonganPekerjaan.setForeground(new java.awt.Color(255, 255, 255));
        lblDetailLowonganPekerjaan.setText("DETAIL LOWONGAN PEKERJAAN YANG DILAMAR:");

        lblPerusahaan.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPerusahaan.setForeground(new java.awt.Color(255, 255, 255));
        lblPerusahaan.setText("Perusahaan");

        lblPosisi.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPosisi.setForeground(new java.awt.Color(255, 255, 255));
        lblPosisi.setText("Posisi");

        lblKualifikasi.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblKualifikasi.setForeground(new java.awt.Color(255, 255, 255));
        lblKualifikasi.setText("Kualifikasi");

        txtPerusahaan.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        txtPosisi.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        jScrollPane2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        txtKualifikasi.setColumns(20);
        txtKualifikasi.setRows(5);
        jScrollPane2.setViewportView(txtKualifikasi);

        lblStatus.setBackground(new java.awt.Color(255, 255, 255));
        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDetailLowonganPekerjaan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblPerusahaan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(lblPosisi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblKualifikasi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPerusahaan)
                            .addComponent(txtPosisi)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))))
                .addGap(133, 133, 133))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDetailLowonganPekerjaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPerusahaan)
                    .addComponent(txtPerusahaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPosisi)
                    .addComponent(txtPosisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblKualifikasi)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0, 0)
        );

        lblTanggal.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblTanggal.setForeground(new java.awt.Color(255, 255, 255));
        lblTanggal.setText("Tanggal");

        txtTanggal.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        lblJam.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblJam.setForeground(new java.awt.Color(255, 255, 255));
        lblJam.setText("Jam");

        txtJam.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        lblDeskripsi.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblDeskripsi.setForeground(new java.awt.Color(255, 255, 255));
        lblDeskripsi.setText("Deskripsi");

        lblInformasi.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblInformasi.setForeground(new java.awt.Color(255, 255, 255));
        lblInformasi.setText("INFORMASI:");

        scrollDeskripsi.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        txtDeskripsi.setColumns(20);
        txtDeskripsi.setRows(5);
        scrollDeskripsi.setViewportView(txtDeskripsi);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblInformasi, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                    .addComponent(lblDeskripsi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblJam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTanggal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(txtJam)
                    .addComponent(scrollDeskripsi))
                .addGap(133, 133, 133))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInformasi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTanggal)
                    .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJam)
                    .addComponent(txtJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblDeskripsi)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollDeskripsi, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(215, Short.MAX_VALUE))
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblDeskripsi;
    private javax.swing.JLabel lblDetailLowonganPekerjaan;
    private javax.swing.JLabel lblInformasi;
    private javax.swing.JLabel lblJam;
    private javax.swing.JLabel lblKualifikasi;
    private javax.swing.JLabel lblPerusahaan;
    private javax.swing.JLabel lblPosisi;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JScrollPane scrollDeskripsi;
    private javax.swing.JTextArea txtDeskripsi;
    private javax.swing.JTextField txtJam;
    private javax.swing.JTextArea txtKualifikasi;
    private javax.swing.JTextField txtPerusahaan;
    private javax.swing.JTextField txtPosisi;
    private javax.swing.JTextField txtTanggal;
    // End of variables declaration//GEN-END:variables
}
