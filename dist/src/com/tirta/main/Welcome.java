package com.tirta.main;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Welcome extends javax.swing.JPanel {
    public Welcome() {
        initComponents();
        txtInfo.setBorder(null);
        jScrollPane1.setBorder(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInfo = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1291, 1000));
        setMinimumSize(new java.awt.Dimension(1291, 1000));
        setPreferredSize(new java.awt.Dimension(1291, 1000));

        kGradientPanel1.setBackground(new java.awt.Color(56, 109, 126));
        kGradientPanel1.setForeground(new java.awt.Color(56, 109, 126));
        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(56, 109, 126));
        kGradientPanel1.setkStartColor(new java.awt.Color(56, 109, 126));
        kGradientPanel1.setMaximumSize(new java.awt.Dimension(1291, 1091));
        kGradientPanel1.setMinimumSize(new java.awt.Dimension(1291, 1091));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1291, 1091));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SELAMAT DATANG DI E-RECRUITMENT");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tirta/icon/logo.png"))); // NOI18N

        txtInfo.setBackground(new java.awt.Color(56, 109, 126));
        txtInfo.setColumns(20);
        txtInfo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtInfo.setForeground(new java.awt.Color(255, 255, 255));
        txtInfo.setRows(5);
        txtInfo.setText("PT. MITRA ABADI KARYA berdiri  pada tahun 1989  dengan kualifikasi usaha kecil  sebagai salah satu perusahaan di Jakarta\nyang fokus bergerak dibidang Jasa Kebersihan (Cleaning Services) , Jasa Keamanan Swasta , Aktivitas Perparkiran di Luar\nBadan Jalan (Off dan On  Street Parking).\n\nPT MITRA ABADI KARYA  memiliki kelengkapan dokumen dan  telah bekerjasama dengan berbagai Kementerian atau\nInstansi Pemerintah dan juga swasta dalam berbagai bentuk pekerjaan sesuai dengan keahlian dan kemampuan\nperusahaan kami. \n\nPT. MITRA ABADI KARYA  mengedepankan pelayanan dan service dalam pelaksanaan pekerjaannya. Untuk itu kami terus\nmengembangkan kemampuan kami melalui berbagai  pelatihan dan training bagi para karyawan kami untuk memberikan\nhasil yang maksimal kepada para client .  Pengalaman Kerjasama yang kami bangun merupakan bukti kepercayaan para\nclient kepada perusahaan kami.\n\n\n\nVISI \nMenjadi salah satu perusahaan yang berintegritas, terpercaya, berkualitas, keselamatan kerja dan terbaik. \n\nMISI \nProfesional dan komitmen adalah landasan untuk melayani dengan baik.");
        txtInfo.setCaretColor(new java.awt.Color(0, 0, 0, 0)
        );
        txtInfo.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtInfo.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtInfo.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(txtInfo);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("KONTAK KAMI");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tirta/icon/pt.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Alamat Kantor : Jl. Jatinegara Timur VII (AWAB) No.1 Kel. Balimester Kec. Jatinegara, Jakarta Timur ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Telepon            : (021) 22326299");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Email                : pt.mitrabadikarya@gmail.com  ");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(495, 495, 495)
                .addComponent(jLabel2)
                .addGap(0, 504, Short.MAX_VALUE))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(72, 72, 72)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)))
                .addContainerGap(205, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JTextArea txtInfo;
    // End of variables declaration//GEN-END:variables
}
