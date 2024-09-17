package com.tirta.main;

import com.tirta.connection.DatabaseConnection;
import com.tirta.dao.LowonganDAO;
import com.tirta.model.ModelLamaran;
import com.tirta.model.ModelLowongan;
import com.tirta.model.ModelUserLogin;
import com.tirta.service.ServiceUser;
import com.tirta.util.DateUtils;
import com.tirta.util.ImageInputStreamUtils;
import java.awt.FontMetrics;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class MenuTentangLoker extends javax.swing.JPanel {
    private final DefaultTableModel tblModel;
    private int userID;
    private ModelUserLogin user;
    private int lowonganID = 0;
    private boolean enableInformasi = false;
    private Connection con = null;
    
    private LowonganDAO lowonganDAO = new LowonganDAO();
    
    private List<ModelLowongan> lowongans = new ArrayList<>();
//    private ModelLamaran lamaran;
    
    public MenuTentangLoker(int userID, ModelUserLogin user) {
        this.con = DatabaseConnection.getInstance().getConnection();
        this.userID = userID;
        this.user = user;
        initComponents();
        permissionUser();
        tblListLowongan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Posisi", "Perusahaan", "Status", "Tanggal Buka", "Tanggal Tutup"
            }
        ));
        jScrollPane1.setViewportView(tblListLowongan);
        tblModel = (DefaultTableModel) tblListLowongan.getModel(); // Initialize table model
        // Sembunyikan kolom ID (misalnya kolom pertama)
        populateLowonganTable(""); // Initial population with all vacancies
    }
    
    private void permissionUser(){
        if (user.getRole().equalsIgnoreCase("manager")) {
            btnUbah.setVisible(false);
            btnSimpan.setVisible(false);
            
            btnUbah.setEnabled(false);
            btnSimpan.setEnabled(false);
            txtPerusahaan.setEditable(false);
            txtPosisi2.setEditable(false);
            txtKualifikasi.setEditable(false);
            txtTanggalBuka.setEditable(false);
            txtTanggalTutup.setEditable(false);
            cbxStatus.setEnabled(false);
        }
    }
    
    private void clear() {
        txtKualifikasi.setText("");
        txtPerusahaan.setText("");
        txtPosisi.setText("");
        txtPosisi2.setText("");
        txtTanggalBuka.setText("");
        txtTanggalTutup.setText("");
        cbxStatus.setSelectedIndex(0);
        populateLowonganTable("");
    }

    
    private void populateLowonganTable(String likeQuery) {
        // Clear existing rows
        tblModel.setRowCount(0);

        // Fetch vacancies from database
        try {
            lowongans = lowonganDAO.getAllListLowonganByPosisi(likeQuery);

            // SimpleDateFormat untuk tanggal dalam format "dd, MMMM yyyy"
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd, MMMM yyyy", new Locale("id", "ID")); // Format untuk bahasa Indonesia

            // Populate table rows
            for (ModelLowongan lowongan : lowongans) {
                String tanggalBuka = dateFormat.format(lowongan.getTanggalBuka());
                String tanggalTutup = dateFormat.format(lowongan.getTanggalTutup());

                tblModel.addRow(new Object[] {
                    lowongan.getId(),
                    lowongan.getPosisi(),
                    lowongan.getPerusahaan(),
                    lowongan.getStatus(),
                    tanggalBuka,
                    tanggalTutup
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error Get Data Lowongan");
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
        tblListLowongan = new javax.swing.JTable();
        lblPosisi = new javax.swing.JLabel();
        txtPosisi = new javax.swing.JTextField();
        btnSearch = new javax.swing.JLabel();
        lblTanggalBuka1 = new javax.swing.JLabel();
        btnSimpan = new com.tirta.swing.Button();
        lblPerusahaan = new javax.swing.JLabel();
        lblDetailLowonganPekerjaan = new javax.swing.JLabel();
        cbxStatus = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtKualifikasi = new javax.swing.JTextArea();
        txtPerusahaan = new javax.swing.JTextField();
        lblKualifikasi = new javax.swing.JLabel();
        txtTanggalTutup = new javax.swing.JTextField();
        lblTanggalBuka2 = new javax.swing.JLabel();
        btnUbah = new com.tirta.swing.Button();
        lblTanggalBuka = new javax.swing.JLabel();
        txtTanggalBuka = new javax.swing.JTextField();
        btnDetail = new com.tirta.swing.Button();
        lblPosisi2 = new javax.swing.JLabel();
        txtPosisi2 = new javax.swing.JTextField();
        lblDetailLowonganPekerjaan1 = new javax.swing.JLabel();
        btnCetak = new com.tirta.swing.Button();
        lblPerusahaan1 = new javax.swing.JLabel();
        lblPerusahaan2 = new javax.swing.JLabel();
        btnRefresh = new com.tirta.swing.Button();

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
        jLabel3.setText("TENTANG LOKER");

        tblListLowongan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblListLowongan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListLowonganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListLowongan);

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

        lblTanggalBuka1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblTanggalBuka1.setForeground(new java.awt.Color(255, 255, 255));
        lblTanggalBuka1.setText("Tanggal Tutup");

        btnSimpan.setForeground(new java.awt.Color(56, 109, 126));
        btnSimpan.setText("SIMPAN");
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        lblPerusahaan.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPerusahaan.setForeground(new java.awt.Color(255, 255, 255));
        lblPerusahaan.setText("Perusahaan");

        lblDetailLowonganPekerjaan.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblDetailLowonganPekerjaan.setForeground(new java.awt.Color(255, 255, 255));
        lblDetailLowonganPekerjaan.setText("INFORMASI LOWONGAN PEKERJAAN:");

        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OPEN", "CLOSED" }));

        jScrollPane2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        txtKualifikasi.setColumns(20);
        txtKualifikasi.setRows(5);
        jScrollPane2.setViewportView(txtKualifikasi);

        txtPerusahaan.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        lblKualifikasi.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblKualifikasi.setForeground(new java.awt.Color(255, 255, 255));
        lblKualifikasi.setText("Kualifikasi");

        txtTanggalTutup.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtTanggalTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTanggalTutupActionPerformed(evt);
            }
        });

        lblTanggalBuka2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblTanggalBuka2.setForeground(new java.awt.Color(255, 255, 255));
        lblTanggalBuka2.setText("Status");

        btnUbah.setForeground(new java.awt.Color(56, 109, 126));
        btnUbah.setText("UBAH");
        btnUbah.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        lblTanggalBuka.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblTanggalBuka.setForeground(new java.awt.Color(255, 255, 255));
        lblTanggalBuka.setText("Tanggal Buka");

        txtTanggalBuka.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtTanggalBuka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTanggalBukaActionPerformed(evt);
            }
        });

        btnDetail.setForeground(new java.awt.Color(56, 109, 126));
        btnDetail.setText("DETAIL");
        btnDetail.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });

        lblPosisi2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPosisi2.setForeground(new java.awt.Color(255, 255, 255));
        lblPosisi2.setText("Posisi");

        txtPosisi2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        lblDetailLowonganPekerjaan1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblDetailLowonganPekerjaan1.setForeground(new java.awt.Color(255, 255, 255));
        lblDetailLowonganPekerjaan1.setText("DAFTAR LOWONGAN PEKERJAAN:");

        btnCetak.setForeground(new java.awt.Color(56, 109, 126));
        btnCetak.setText("CETAK");
        btnCetak.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        lblPerusahaan1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPerusahaan1.setForeground(new java.awt.Color(255, 255, 255));
        lblPerusahaan1.setText("*dd-mm-yy");

        lblPerusahaan2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPerusahaan2.setForeground(new java.awt.Color(255, 255, 255));
        lblPerusahaan2.setText("*dd-mm-yy");

        btnRefresh.setForeground(new java.awt.Color(56, 109, 126));
        btnRefresh.setText("REFRESH");
        btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
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
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1279, Short.MAX_VALUE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTanggalBuka2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTanggalBuka1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTanggalBuka, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblKualifikasi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPosisi2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPerusahaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDetailLowonganPekerjaan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPerusahaan)
                                .addComponent(txtPosisi2)
                                .addComponent(jScrollPane2)
                                .addComponent(txtTanggalBuka)
                                .addComponent(txtTanggalTutup)
                                .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPerusahaan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPerusahaan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(btnDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(lblDetailLowonganPekerjaan1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPosisi, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPosisi, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(lblDetailLowonganPekerjaan)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPerusahaan)
                    .addComponent(txtPerusahaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPosisi2)
                    .addComponent(txtPosisi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKualifikasi)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTanggalBuka)
                    .addComponent(txtTanggalBuka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPerusahaan1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTanggalBuka1)
                    .addComponent(txtTanggalTutup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPerusahaan2))
                .addGap(24, 24, 24)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTanggalBuka2)
                    .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDetailLowonganPekerjaan1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPosisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPosisi)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
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

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        // TODO add your handling code here:
        String posisi = txtPosisi.getText().trim();
        populateLowonganTable(posisi);
    }//GEN-LAST:event_btnSearchMouseClicked

    private void tblListLowonganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListLowonganMouseClicked
        // TODO add your handling code here:
        int rowIndex = tblListLowongan.getSelectedRow();
         // SimpleDateFormat untuk tanggal dalam format "dd, MMMM yyyy"
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
        // Ensure a valid row is selected
        if (rowIndex != -1 && rowIndex < lowongans.size()) {
            // Get the selected ModelLowongan object
            ModelLowongan selectedLowongan = lowongans.get(rowIndex);
            
            // Check if tanggalTutup is not null and before current date
            if (selectedLowongan.getTanggalTutup() != null && selectedLowongan.getTanggalTutup().before(new Date())) {
               enableInformasi = true;
            }

            lowonganID = (int)selectedLowongan.getId();
            String tanggalBuka = dateFormat.format(selectedLowongan.getTanggalBuka());
            String tanggalTutup = dateFormat.format(selectedLowongan.getTanggalTutup());
            
            // Populate text fields with selected lowongan details
            txtPerusahaan.setText(selectedLowongan.getPerusahaan());
            txtPosisi2.setText(selectedLowongan.getPosisi());
            txtTanggalBuka.setText(tanggalBuka);
            txtTanggalTutup.setText(tanggalTutup);
            cbxStatus.setSelectedItem(selectedLowongan.getStatus());
            // Format kualifikasi text
            String kualifikasi = selectedLowongan.getKualifikasi();
            if (kualifikasi.length() > 20) {
                // Calculate maximum characters per line based on text area width
                int maxWidth = txtKualifikasi.getWidth(); // Get the width of the text area
                FontMetrics metrics = txtKualifikasi.getFontMetrics(txtKualifikasi.getFont());
                int charWidth = metrics.charWidth('A'); // Get the width of character 'A'
                int maxCharsPerLine = maxWidth / charWidth; // Calculate maximum characters per line

                // Use StringTokenizer to split words
                StringTokenizer tokenizer = new StringTokenizer(kualifikasi, " ");
                StringBuilder formattedKualifikasi = new StringBuilder();
                int currentLineLength = 0;

                // Append words to StringBuilder
                while (tokenizer.hasMoreTokens()) {
                    String word = tokenizer.nextToken();
                    int wordLength = word.length();

                    // Check if adding this word exceeds the maxCharsPerLine
                    if (currentLineLength + wordLength > maxCharsPerLine) {
                        formattedKualifikasi.append("\n"); // Start a new line
                        currentLineLength = 0; // Reset line length counter
                    }

                    // Append the word to StringBuilder
                    formattedKualifikasi.append(word).append(" "); // Add a space after each word
                    currentLineLength += wordLength + 1; // Update current line length
                }

                // Set formatted text to text area
                txtKualifikasi.setText(formattedKualifikasi.toString());
            } else {
                txtKualifikasi.setText(kualifikasi);
            }
        }
    }//GEN-LAST:event_tblListLowonganMouseClicked

    private void txtTanggalBukaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTanggalBukaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTanggalBukaActionPerformed

    private void txtTanggalTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTanggalTutupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTanggalTutupActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        // Konversi tglLahir dari String ke java.sql.Date
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date tanggalBukaDate = null;
        java.util.Date tanggalTutupDate = null;
        try {
            tanggalBukaDate = sdf.parse(txtTanggalBuka.getText());
            tanggalTutupDate = sdf.parse(txtTanggalTutup.getText());
        } catch (ParseException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ModelLowongan lowongan = new ModelLowongan();
            lowongan.setPosisi(txtPosisi2.getText());
            lowongan.setPerusahaan(txtPerusahaan.getText());
            lowongan.setKualifikasi(txtKualifikasi.getText());
            lowongan.setStatus(cbxStatus.getSelectedItem().toString()); 
            lowongan.setTanggalBuka(tanggalBukaDate); // Set tanggal buka, you might want to get this from a date picker
            lowongan.setTanggalTutup(tanggalTutupDate); // Set tanggal tutup, you might want to get this from a date picker

            LowonganDAO lowonganDAO = new LowonganDAO();
            lowonganDAO.insertLowongan(lowongan);
            
            populateLowonganTable("");
            JOptionPane.showMessageDialog(this, "Berhasil menyimpan lowongan.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan lowongan: " + ex.getMessage());
        } 
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // Ensure a row is selected in tblListLowongan
        int rowIndex = tblListLowongan.getSelectedRow();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Silahkan pilih loker yang akan diubah.");
            return;
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date tanggalBukaDate = null;
        java.util.Date tanggalTutupDate = null;
        try {
            tanggalBukaDate = sdf.parse(txtTanggalBuka.getText());
            tanggalTutupDate = sdf.parse(txtTanggalTutup.getText());
        } catch (ParseException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Get the selected ModelLowongan object
        ModelLowongan selectedLowongan = lowongans.get(rowIndex);

        // Retrieve updated values from text fields or components
        String posisi = txtPosisi2.getText();
        String perusahaan = txtPerusahaan.getText();
        String kualifikasi = txtKualifikasi.getText();
        String status = cbxStatus.getSelectedItem().toString(); // Assuming JComboBox<String> cbxStatus

        // You may want to validate the updated values here as needed

        // Update the selected ModelLowongan object
        selectedLowongan.setPosisi(posisi);
        selectedLowongan.setPerusahaan(perusahaan);
        selectedLowongan.setKualifikasi(kualifikasi);
        selectedLowongan.setStatus(status);
        selectedLowongan.setTanggalBuka(tanggalBukaDate);
        selectedLowongan.setTanggalTutup(tanggalTutupDate);

        // Perform update operation
        try {
            if (lowonganDAO.updateLowongan(selectedLowongan)) {
                JOptionPane.showMessageDialog(this, "Berhasil mengubah lowongan.");
                populateLowonganTable("");
            } else {
                JOptionPane.showMessageDialog(this, "Gagal mengubah lowongan.");
            }
        } catch (SQLException | IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        // TODO add your handling code here:
        if (lowonganID == 0) {
            JOptionPane.showMessageDialog(this, "Silahkan pilih loker terlebih dahulu.");
            return;
        }
        if (user.getRole().equalsIgnoreCase("manager")) {
             MainSystemManager.refreshFrom(new MenuPemberitahuanLoker(user, userID, lowonganID, enableInformasi));
            return;
        }
        MainSystemHRD.refreshFrom(new MenuPemberitahuanLoker(user, userID, lowonganID, enableInformasi));
    }//GEN-LAST:event_btnDetailActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        try{
            String jasperPath = "src/com/tirta/report/report_lowongan_pekerjaan_terdaftar.jasper";
            if (user.getRole().equalsIgnoreCase("manager")) {
                jasperPath = "src/com/tirta/report/report_perusahaan_terdaftar.jasper";
            }
            
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

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.tirta.swing.Button btnCetak;
    private com.tirta.swing.Button btnDetail;
    private com.tirta.swing.Button btnRefresh;
    private javax.swing.JLabel btnSearch;
    private com.tirta.swing.Button btnSimpan;
    private com.tirta.swing.Button btnUbah;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblDetailLowonganPekerjaan;
    private javax.swing.JLabel lblDetailLowonganPekerjaan1;
    private javax.swing.JLabel lblKualifikasi;
    private javax.swing.JLabel lblPerusahaan;
    private javax.swing.JLabel lblPerusahaan1;
    private javax.swing.JLabel lblPerusahaan2;
    private javax.swing.JLabel lblPosisi;
    private javax.swing.JLabel lblPosisi2;
    private javax.swing.JLabel lblTanggalBuka;
    private javax.swing.JLabel lblTanggalBuka1;
    private javax.swing.JLabel lblTanggalBuka2;
    private javax.swing.JTable tblListLowongan;
    private javax.swing.JTextArea txtKualifikasi;
    private javax.swing.JTextField txtPerusahaan;
    private javax.swing.JTextField txtPosisi;
    private javax.swing.JTextField txtPosisi2;
    private javax.swing.JTextField txtTanggalBuka;
    private javax.swing.JTextField txtTanggalTutup;
    // End of variables declaration//GEN-END:variables
}
