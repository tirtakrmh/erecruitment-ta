package com.tirta.main;

import com.tirta.connection.DatabaseConnection;
import com.tirta.dao.KaryawanDAO;
import com.tirta.model.ModelKaryawan;
import com.tirta.util.DateUtils;
import com.tirta.util.ImageInputStreamUtils;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class MenuTentangKaryawan extends javax.swing.JPanel {
    private final DefaultTableModel tblModel;
    private int userID;
    private int karyawanID;
    private Connection con = null;
    
    private KaryawanDAO karyawanDAO = new KaryawanDAO();
    
    private ModelKaryawan karyawan = new ModelKaryawan();
    private List<ModelKaryawan> karyawans = new ArrayList<>();
    
    public MenuTentangKaryawan(int userID) {
        this.con = DatabaseConnection.getInstance().getConnection();
        this.userID = userID;
        initComponents();
        tblListKaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Departemen", "Email", "No Telpon", "Role"
            }
        ));
        jScrollPane1.setViewportView(tblListKaryawan);
        tblModel = (DefaultTableModel) tblListKaryawan.getModel(); // Initialize table model
        // Sembunyikan kolom ID (misalnya kolom pertama)
        tblListKaryawan.getColumnModel().getColumn(0).setMinWidth(0);
        tblListKaryawan.getColumnModel().getColumn(0).setMaxWidth(0);
        populateLowonganTable(""); // Initial population with all vacancies
    }
    
    private void populateLowonganTable(String likeQuery) {
        // Clear existing rows
        tblModel.setRowCount(0);

        // Fetch vacancies from database
        try {
            karyawans = karyawanDAO.getListKaryawan(likeQuery);
            
            // Populate table rows
            for (ModelKaryawan karyawan : karyawans) {

                tblModel.addRow(new Object[] {
                    karyawan.getId(),
                    karyawan.getNama(),
                    karyawan.getDepartemen(),
                    karyawan.getEmail(),
                    karyawan.getNoTelepon(),
                    karyawan.getRole(),
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error Get Data Karyawan");
            System.out.println("ERR: "+ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListKaryawan = new javax.swing.JTable();
        lblDepartmen2 = new javax.swing.JLabel();
        txtDepartemen2 = new javax.swing.JTextField();
        btnSearch = new javax.swing.JLabel();
        lblPembaruanKaryawan = new javax.swing.JLabel();
        lblDepartemen = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        cbxRole = new javax.swing.JComboBox<>();
        txtEmail = new javax.swing.JTextField();
        txtDepartemen = new javax.swing.JTextField();
        lblNoTelp = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        btnUbah = new com.tirta.swing.Button();
        txtNoTelp = new javax.swing.JTextField();
        btnSimpan = new com.tirta.swing.Button();
        txtNama = new javax.swing.JTextField();
        lblPembaruanKaryawan1 = new javax.swing.JLabel();
        btnCetak = new com.tirta.swing.Button();

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
        jLabel3.setText("TENTANG KARYAWAN");

        tblListKaryawan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblListKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListKaryawanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListKaryawan);

        lblDepartmen2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblDepartmen2.setForeground(new java.awt.Color(255, 255, 255));
        lblDepartmen2.setText("Departemen");

        txtDepartemen2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtDepartemen2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartemen2ActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tirta/icon/search.png"))); // NOI18N
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        lblPembaruanKaryawan.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPembaruanKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        lblPembaruanKaryawan.setText("PEMBARUAN KARYAWAN:");

        lblDepartemen.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblDepartemen.setForeground(new java.awt.Color(255, 255, 255));
        lblDepartemen.setText("Departemen");

        lblRole.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblRole.setForeground(new java.awt.Color(255, 255, 255));
        lblRole.setText("Role");

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Email");

        cbxRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "hrd", "manager" }));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        txtDepartemen.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtDepartemen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartemenActionPerformed(evt);
            }
        });

        lblNoTelp.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblNoTelp.setForeground(new java.awt.Color(255, 255, 255));
        lblNoTelp.setText("No. Telpon");

        lblNama.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblNama.setForeground(new java.awt.Color(255, 255, 255));
        lblNama.setText("Nama");

        btnUbah.setText("UBAH");
        btnUbah.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        txtNoTelp.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtNoTelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoTelpActionPerformed(evt);
            }
        });

        btnSimpan.setText("SIMPAN");
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        txtNama.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        lblPembaruanKaryawan1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPembaruanKaryawan1.setForeground(new java.awt.Color(255, 255, 255));
        lblPembaruanKaryawan1.setText("DAFTAR KARYAWAN:");

        btnCetak.setText("CETAK");
        btnCetak.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1279, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(lblPembaruanKaryawan1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDepartmen2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDepartemen2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch)
                        .addGap(16, 16, 16))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblPembaruanKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addComponent(lblNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addComponent(lblDepartemen, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)
                                    .addComponent(txtDepartemen, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(lblRole, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbxRole, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPembaruanKaryawan)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNama)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNoTelp)
                    .addComponent(txtNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepartemen)
                    .addComponent(txtDepartemen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRole))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDepartemen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDepartmen2)
                        .addComponent(lblPembaruanKaryawan1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
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

    private void txtDepartemen2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartemen2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartemen2ActionPerformed

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        // TODO add your handling code here:
        String posisi = txtDepartemen2.getText().trim();
        populateLowonganTable(posisi);
    }//GEN-LAST:event_btnSearchMouseClicked

    private void tblListKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListKaryawanMouseClicked
        // TODO add your handling code here:
        int rowIndex = tblListKaryawan.getSelectedRow();
    
        // Ensure a valid row is selected
        if (rowIndex != -1 && rowIndex < karyawans.size()) {
            ModelKaryawan selectedKaryawan = karyawans.get(rowIndex);

            karyawanID = (int)selectedKaryawan.getId();
            
            txtNama.setText(selectedKaryawan.getNama());
            txtEmail.setText(selectedKaryawan.getEmail());
            txtNoTelp.setText(selectedKaryawan.getNoTelepon());
            txtDepartemen.setText(selectedKaryawan.getDepartemen());
            cbxRole.setSelectedItem(selectedKaryawan.getRole());
        }
    }//GEN-LAST:event_tblListKaryawanMouseClicked

    private void txtNoTelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoTelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoTelpActionPerformed

    private void txtDepartemenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartemenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartemenActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        try {
            ModelKaryawan karyawan = new ModelKaryawan();
            karyawan.setNama(txtNama.getText());
            karyawan.setEmail(txtEmail.getText());
            karyawan.setNoTelepon(txtNoTelp.getText());
            karyawan.setDepartemen(txtDepartemen.getText());
            karyawan.setRole(cbxRole.getSelectedItem().toString());
            karyawan.setPassword("password");

            karyawanDAO.insertKaryawan(karyawan);
            
            populateLowonganTable("");
            JOptionPane.showMessageDialog(this, "Berhasil menyimpan data karyawan.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data karyawan: " + ex.getMessage());
        } 
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // Ensure a row is selected in tblListLowongan
        int rowIndex = tblListKaryawan.getSelectedRow();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Silahkan pilih karyawan yang akan diubah.");
            return;
        }
        

        ModelKaryawan selectedKaryawan = karyawans.get(rowIndex);

        // Retrieve updated values from text fields or components
        String nama = txtNama.getText();
        String email = txtEmail.getText();
        String noTelp = txtNoTelp.getText();
        String departemen = txtDepartemen.getText();
        String role = cbxRole.getSelectedItem().toString(); // Assuming JComboBox<String> cbxStatus

        // You may want to validate the updated values here as needed

        // Update the selected ModelLowongan object
        selectedKaryawan.setNama(nama);
        selectedKaryawan.setEmail(email);
        selectedKaryawan.setNoTelepon(noTelp);
        selectedKaryawan.setDepartemen(departemen);
        selectedKaryawan.setRole(role);

        // Perform update operation
        try {
            if (karyawanDAO.updateKaryawan(selectedKaryawan)) {
                JOptionPane.showMessageDialog(this, "Berhasil mengubah karyawan.");
                populateLowonganTable("");
            } else {
                JOptionPane.showMessageDialog(this, "Gagal mengubah karyawan.");
            }
        } catch (SQLException | IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        try{
            String jasperPath = "src/com/tirta/report/report_karyawan_terdaftar.jasper";
            String logoPath = "/com/tirta/icon/pt.png";
            InputStream logo = ImageInputStreamUtils.getImageInputStream(logoPath);
            String tanggal = DateUtils.getFormattedCurrentDate();
            
            HashMap parameter = new HashMap();
            parameter.put("logo", logo);
            parameter.put("tanggal", tanggal);
            File report_file = new File(jasperPath);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameter, con);
            JasperViewer.viewReport(jasperPrint, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        }catch(Exception err){
            JOptionPane.showMessageDialog(null, "Gagal print Data" + err.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.tirta.swing.Button btnCetak;
    private javax.swing.JLabel btnSearch;
    private com.tirta.swing.Button btnSimpan;
    private com.tirta.swing.Button btnUbah;
    private javax.swing.JComboBox<String> cbxRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblDepartemen;
    private javax.swing.JLabel lblDepartmen2;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNoTelp;
    private javax.swing.JLabel lblPembaruanKaryawan;
    private javax.swing.JLabel lblPembaruanKaryawan1;
    private javax.swing.JLabel lblRole;
    private javax.swing.JTable tblListKaryawan;
    private javax.swing.JTextField txtDepartemen;
    private javax.swing.JTextField txtDepartemen2;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNoTelp;
    // End of variables declaration//GEN-END:variables
}
