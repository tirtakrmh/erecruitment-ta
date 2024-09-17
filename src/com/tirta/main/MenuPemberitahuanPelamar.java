package com.tirta.main;

import com.tirta.dao.LamaranDAO;
import com.tirta.dao.LowonganDAO;
import com.tirta.dao.PelamarDAO;
import com.tirta.model.EnumStatus;
import com.tirta.model.ModelLamaran;
import com.tirta.model.ModelLamaranPelamar;
import com.tirta.model.ModelLowongan;
import com.tirta.model.ModelPelamar;
import java.awt.FontMetrics;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MenuPemberitahuanPelamar extends javax.swing.JPanel {
    private final DefaultTableModel tblModel;
    private int userID;
    private int lamaranPelamarID;
    
    private LamaranDAO lamaranDAO = new LamaranDAO();
    private PelamarDAO pelamarDAO = new PelamarDAO();
    
    private List<ModelLamaranPelamar> lamaranPelamars = new ArrayList<>();
    private ModelPelamar pelamar = new ModelPelamar();
    
    public MenuPemberitahuanPelamar(int userID) {
        this.userID = userID;
        initComponents();
        tblListLamaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Lamaran", "Perusahaan", "Posisi", "Status Lamaran", "Lamaran Dibuat"
            }
        ));
        jScrollPane1.setViewportView(tblListLamaran);
        tblModel = (DefaultTableModel) tblListLamaran.getModel(); // Initialize table model
        // Sembunyikan kolom ID (misalnya kolom pertama)
        tblListLamaran.getColumnModel().getColumn(0).setMinWidth(0);
        tblListLamaran.getColumnModel().getColumn(0).setMaxWidth(0);
        loadPelamarData();
        populateLamaranTable(txtPosisi.getText().trim(), (int) pelamar.getId()); // Initial population with all vacancies
    }
    
    private void populateLamaranTable(String likePosisi ,int pelamarID) {
        // Clear existing rows
        tblModel.setRowCount(0);

        // Fetch vacancies from database
        try {
            lamaranPelamars = lamaranDAO.getListLamaranByPelamarID(likePosisi, pelamarID);

            // SimpleDateFormat untuk tanggal dalam format "dd, MMMM yyyy"
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd, MMMM yyyy", new Locale("id", "ID")); // Format untuk bahasa Indonesia

            // Populate table rows
            for (ModelLamaranPelamar lamaranPelamar : lamaranPelamars) {
                String lamaranDibuat = dateFormat.format(lamaranPelamar.getCreatedAt());

                tblModel.addRow(new Object[] {
                    lamaranPelamar.getId(),
                    lamaranPelamar.getPerusahaan(),
                    lamaranPelamar.getPosisi(),
                    lamaranPelamar.getStatus(),
                    lamaranDibuat
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error Get Data Lamaran");
            System.out.println("ERR: "+ex.getMessage());
        }
    }
    
    private void loadPelamarData() {
        try {
            pelamar = pelamarDAO.selectPelamar(userID);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error Get Data Pelamar");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListLamaran = new javax.swing.JTable();
        lblPosisi = new javax.swing.JLabel();
        txtPosisi = new javax.swing.JTextField();
        btnSearch = new javax.swing.JLabel();
        lblPosisi1 = new javax.swing.JLabel();

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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PEMBERITAHUAN");

        tblListLamaran.setModel(new javax.swing.table.DefaultTableModel(
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
        tblListLamaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListLamaranMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListLamaran);

        lblPosisi.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPosisi.setForeground(new java.awt.Color(255, 255, 255));
        lblPosisi.setText("Cari Posisi");

        txtPosisi.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtPosisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPosisiActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tirta/icon/search.png"))); // NOI18N
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        lblPosisi1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPosisi1.setForeground(new java.awt.Color(255, 255, 255));
        lblPosisi1.setText("DAFTAR LOWONGAN PEKERJAAN YANG DILAMAR:");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(lblPosisi1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPosisi, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPosisi, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch)
                        .addGap(19, 19, 19))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1279, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblPosisi)
                                .addComponent(txtPosisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPosisi1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(222, Short.MAX_VALUE))
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

    private void txtPosisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPosisiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPosisiActionPerformed

    private void tblListLamaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListLamaranMouseClicked
        // TODO add your handling code here:
        int rowIndex = tblListLamaran.getSelectedRow();
    
        // Ensure a valid row is selected
        if (rowIndex != -1 && rowIndex < lamaranPelamars.size()) {
            // Get the selected ModelLowongan object
            ModelLamaranPelamar selectedLamaranPelamar = lamaranPelamars.get(rowIndex);

            lamaranPelamarID = (int)selectedLamaranPelamar.getId();
            
            for (ModelLamaranPelamar lamaranPelamar : lamaranPelamars) {
                if (lamaranPelamar.getId() == selectedLamaranPelamar.getId()) {
                    System.out.println("DATA LAMARAN PELAMAR: "+lamaranPelamar.toString());
                    boolean isStatus = lamaranPelamar.getStatus().equalsIgnoreCase(EnumStatus.INTERVIEW.name()) || lamaranPelamar.getStatus().equalsIgnoreCase(EnumStatus.DITERIMA.name());
                    if (lamaranPelamar.getTanggalInformasi() == null && isStatus ) {
                        JOptionPane.showMessageDialog(this, "Mohon maaf informasi pemberitahuan belum tersedia");
                        return;
                    }
                    new PopupPemberitahuanPelamar(lamaranPelamar).setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_tblListLamaranMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        // TODO add your handling code here:
        String posisi = txtPosisi.getText().trim();
        populateLamaranTable(posisi, (int) pelamar.getId());
    }//GEN-LAST:event_btnSearchMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblPosisi;
    private javax.swing.JLabel lblPosisi1;
    private javax.swing.JTable tblListLamaran;
    private javax.swing.JTextField txtPosisi;
    // End of variables declaration//GEN-END:variables
}
