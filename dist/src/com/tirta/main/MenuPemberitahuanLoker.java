package com.tirta.main;

import com.tirta.connection.DatabaseConnection;
import com.tirta.dao.LamaranDAO;
import com.tirta.dao.LowonganDAO;
import com.tirta.model.EnumStatus;
import com.tirta.model.ModelLamaran;
import com.tirta.model.ModelLowongan;
import com.tirta.model.ModelPelamarLamaran;
import com.tirta.model.ModelUserLogin;
import com.tirta.util.DateUtils;
import com.tirta.util.ImageInputStreamUtils;
import com.tirta.util.TextUtils;
import java.awt.FontMetrics;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class MenuPemberitahuanLoker extends javax.swing.JPanel {
    private final DefaultTableModel tblModel;
    private boolean enableButtonInformasi = false;
    private ModelUserLogin user;
    private int userID;
    private int pelamarID = 0;
    private int lowonganID;
    private Connection con = null;
    
    private LamaranDAO lamaranDAO = new LamaranDAO();
    private LowonganDAO lowonganDAO = new LowonganDAO();
    
    private List<ModelPelamarLamaran> pelamars = new ArrayList<>();
    private ModelLamaran lamaran = new ModelLamaran();
    
    private ModelLowongan lowongan = new ModelLowongan();
    
    public MenuPemberitahuanLoker(ModelUserLogin user, int userID, int lowonganID, boolean enableButtonInformasi) {
        this.con = DatabaseConnection.getInstance().getConnection();
        this.user = user;
        this.userID = userID;
        this.lowonganID = lowonganID;
        this.enableButtonInformasi = enableButtonInformasi;
        initComponents();
        btnBuatInformasi.setVisible(this.enableButtonInformasi);
        btnBuatInformasi.setEnabled(this.enableButtonInformasi);
        txtNama.setEditable(false);
        txtTentangDiri.setEditable(false);
        txtPengalaman.setEditable(false);
        txtPendidikan.setEditable(false);
        txtSertifikasi.setEditable(false);
        tblListPelamar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Email", "Status", "Perusahaan", "Posisi", "Tanggal Melamar"
            }
        ));
        jScrollPane1.setViewportView(tblListPelamar);
        tblModel = (DefaultTableModel) tblListPelamar.getModel(); // Initialize table model
        populatePelamarTable("", lowonganID); // Initial population with all vacancies
        permissionUser();
        btnBuatInformasi.setVisible(isBuatInformasi());
        btnBuatInformasi.setEnabled(isBuatInformasi());
    }
    
    private void permissionUser(){
        if (this.user.getRole().equalsIgnoreCase("manager")) {
            btnBuatInformasi.setVisible(false);
            btnDitolak.setVisible(false);
            btnInterviewDiterima.setVisible(false);
        }
    }
    
    private void clear() {
        txtNama.setText("");
        txtPendidikan.setText("");
        txtPengalaman.setText("");
        txtSertifikasi.setText("");
        txtStatus.setText("");
        txtTentangDiri.setText("");
        populatePelamarTable("", lowonganID);
    }

    
    private boolean isBuatInformasi(){
        try {
            lowongan = lowonganDAO.getByLowonganID(lowonganID);
            if (lowongan.getStatus().equalsIgnoreCase(EnumStatus.CLOSED.name())) {
                btnBuatInformasi.setText("INFO ONBOARDING");
            }
            return lowongan.getTanggalTutup().before(new Date());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error Get Data lowongan"+ ex.getMessage());
            System.out.println("ERR: "+ex.getMessage());
        }
        return false;
    }
    
    private void populatePelamarTable(String likeStatus, int lowonganID) {
        // Clear existing rows in pelamar table model
        tblModel.setRowCount(0);

        try {
            pelamars = lamaranDAO.getListPelamarByLowonganID(likeStatus, lowonganID);

            // SimpleDateFormat untuk tanggal dalam format "dd, MMMM yyyy"
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd, MMMM yyyy", new Locale("id", "ID"));

            // Populate table rows
            for (ModelPelamarLamaran pelamar : pelamars) {
                String tanggalMelamar = dateFormat.format(pelamar.getTanggalMelamar());

                tblModel.addRow(new Object[]{
                    pelamar.getPelamarId(),
                    pelamar.getPelamarNama(),
                    pelamar.getPelamarEmail(),
                    pelamar.getStatus(),
                    pelamar.getPerusahaan(),
                    pelamar.getPosisi(),
                    tanggalMelamar
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error Get Data list Pelamar lamaran"+ ex.getMessage());
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
        tblListPelamar = new javax.swing.JTable();
        lblStatus = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        btnSearch = new javax.swing.JLabel();
        lblDataPelamar = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        lblTentangDiri = new javax.swing.JLabel();
        lblPengalaman = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPengalaman = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtTentangDiri = new javax.swing.JTextArea();
        lblPendidikan = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtPendidikan = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtSertifikasi = new javax.swing.JTextArea();
        lblSertifikasi = new javax.swing.JLabel();
        btnDitolak = new com.tirta.swing.Button();
        btnInterviewDiterima = new com.tirta.swing.Button();
        btnBuatInformasi = new com.tirta.swing.Button();
        lblDataPelamar1 = new javax.swing.JLabel();
        btnRefresh = new com.tirta.swing.Button();
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
        jLabel3.setText("PEMBERITAHUAN LOKER");

        tblListPelamar.setModel(new javax.swing.table.DefaultTableModel(
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
        tblListPelamar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListPelamarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListPelamar);

        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(255, 255, 255));
        lblStatus.setText("Cari Status");

        txtStatus.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tirta/icon/search.png"))); // NOI18N
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        lblDataPelamar.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblDataPelamar.setForeground(new java.awt.Color(255, 255, 255));
        lblDataPelamar.setText("DATA PELAMAR:");

        lblNama.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblNama.setForeground(new java.awt.Color(255, 255, 255));
        lblNama.setText("Nama");

        lblTentangDiri.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblTentangDiri.setForeground(new java.awt.Color(255, 255, 255));
        lblTentangDiri.setText("Tentang Diri");

        lblPengalaman.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPengalaman.setForeground(new java.awt.Color(255, 255, 255));
        lblPengalaman.setText("Pengalaman");

        txtNama.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        jScrollPane2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        txtPengalaman.setColumns(20);
        txtPengalaman.setRows(5);
        jScrollPane2.setViewportView(txtPengalaman);

        jScrollPane3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        txtTentangDiri.setColumns(20);
        txtTentangDiri.setRows(5);
        jScrollPane3.setViewportView(txtTentangDiri);

        lblPendidikan.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPendidikan.setForeground(new java.awt.Color(255, 255, 255));
        lblPendidikan.setText("Pendidikan");

        jScrollPane4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        txtPendidikan.setColumns(20);
        txtPendidikan.setRows(5);
        jScrollPane4.setViewportView(txtPendidikan);

        jScrollPane6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        txtSertifikasi.setColumns(20);
        txtSertifikasi.setRows(5);
        jScrollPane6.setViewportView(txtSertifikasi);

        lblSertifikasi.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblSertifikasi.setForeground(new java.awt.Color(255, 255, 255));
        lblSertifikasi.setText("Sertifikasi");

        btnDitolak.setForeground(new java.awt.Color(56, 109, 126));
        btnDitolak.setText("DITOLAK");
        btnDitolak.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnDitolak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDitolakActionPerformed(evt);
            }
        });

        btnInterviewDiterima.setForeground(new java.awt.Color(56, 109, 126));
        btnInterviewDiterima.setText("INTERVIEW");
        btnInterviewDiterima.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnInterviewDiterima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInterviewDiterimaActionPerformed(evt);
            }
        });

        btnBuatInformasi.setForeground(new java.awt.Color(56, 109, 126));
        btnBuatInformasi.setText("INFO INTERVIEW");
        btnBuatInformasi.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnBuatInformasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuatInformasiActionPerformed(evt);
            }
        });

        lblDataPelamar1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblDataPelamar1.setForeground(new java.awt.Color(255, 255, 255));
        lblDataPelamar1.setText("DAFTAR PELAMAR:");

        btnRefresh.setForeground(new java.awt.Color(56, 109, 126));
        btnRefresh.setText("REFRESH");
        btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnCetak.setForeground(new java.awt.Color(56, 109, 126));
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
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(lblTentangDiri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblDataPelamar, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lblPengalaman, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                                            .addComponent(jScrollPane2)
                                            .addComponent(txtNama)))
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(lblPendidikan, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane4))
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(lblSertifikasi, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                                .addComponent(btnDitolak, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnInterviewDiterima, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 161, Short.MAX_VALUE))
                                            .addComponent(jScrollPane6))))
                                .addGap(18, 18, 18)
                                .addComponent(btnBuatInformasi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 209, Short.MAX_VALUE))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(lblDataPelamar1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch)
                        .addGap(20, 20, 20))))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addGap(41, 41, 41)
                .addComponent(lblDataPelamar)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNama)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTentangDiri)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPengalaman)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPendidikan)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSertifikasi)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuatInformasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDitolak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInterviewDiterima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblStatus)
                        .addComponent(lblDataPelamar1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
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

    private void txtStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStatusActionPerformed

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        // TODO add your handling code here:
        String status = txtStatus.getText().trim();
        populatePelamarTable(status, lowonganID);
    }//GEN-LAST:event_btnSearchMouseClicked

    private void tblListPelamarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListPelamarMouseClicked
        // TODO add your handling code here:
        int rowIndex = tblListPelamar.getSelectedRow();
         // SimpleDateFormat untuk tanggal dalam format "dd, MMMM yyyy"
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
    
        // Ensure a valid row is selected
        if (rowIndex != -1 && rowIndex < pelamars.size()) {
            // Get the selected ModelLowongan object
            ModelPelamarLamaran selectedPelamars = pelamars.get(rowIndex);

            pelamarID = (int)selectedPelamars.getPelamarId();
            int maxWidth = txtTentangDiri.getWidth(); // Get the width of the text area
            FontMetrics metrics = txtTentangDiri.getFontMetrics(txtTentangDiri.getFont());
            
            String tentangDiri = TextUtils.formatTextAreaString(selectedPelamars.getPelamarTentangDiri(), maxWidth, metrics);
            String pendidikan = TextUtils.formatTextAreaString(selectedPelamars.getPelamarPendidikan(), maxWidth, metrics);
            String pengalaman = TextUtils.formatTextAreaString(selectedPelamars.getPelamarPengalaman(), maxWidth, metrics);
            String sertifikasi = TextUtils.formatTextAreaString(selectedPelamars.getPelamarSertifikasi(), maxWidth, metrics);
            
            txtNama.setText(selectedPelamars.getPelamarNama());
            txtTentangDiri.setText(tentangDiri);
            txtPendidikan.setText(pendidikan);
            txtPengalaman.setText(pengalaman);
            txtSertifikasi.setText(sertifikasi);
            
            btnDitolak.setEnabled(true);
            btnDitolak.setVisible(true);
            btnInterviewDiterima.setEnabled(true);
            btnInterviewDiterima.setVisible(true);
            
            if (selectedPelamars.getStatus().equalsIgnoreCase(EnumStatus.DITERIMA.name()) || selectedPelamars.getStatus().equalsIgnoreCase(EnumStatus.DITOLAK.name())) {
                btnDitolak.setEnabled(false);
                btnDitolak.setVisible(false);
                btnInterviewDiterima.setEnabled(false);
                btnInterviewDiterima.setVisible(false);
            }
            
            if (selectedPelamars.getStatus().equalsIgnoreCase(EnumStatus.DIPERIKSA.name())) {
                btnInterviewDiterima.setText(EnumStatus.INTERVIEW.name());
            }
            
            if (selectedPelamars.getStatus().equalsIgnoreCase(EnumStatus.INTERVIEW.name())) {
                btnInterviewDiterima.setText(EnumStatus.DITERIMA.name());
            }
            
            lamaran.setId(selectedPelamars.getLamaranId());
            lamaran.setPelamarId((int)selectedPelamars.getPelamarId());
        }
    }//GEN-LAST:event_tblListPelamarMouseClicked

    private void btnDitolakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDitolakActionPerformed
        int confirmed = JOptionPane.showConfirmDialog(this, 
        "Anda yakin ingin " + btnDitolak.getText() + "  pelamar ini?", "Konfirmasi",
        JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
            try {
                lamaran.setStatus(EnumStatus.DITOLAK.name());
                lamaranDAO.updateLamaran(lamaran);
                // Tambahkan logika atau update UI jika diperlukan setelah berhasil
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error Update Data lamaran pelamar: " + ex.getMessage());
                System.out.println("btnDitolakActionPerformed ERR: " + ex.getMessage());
            }
        }
        clear();
    }//GEN-LAST:event_btnDitolakActionPerformed

    private void btnInterviewDiterimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInterviewDiterimaActionPerformed
        // TODO add your handling code here:
        int confirmed = JOptionPane.showConfirmDialog(this, 
        "Anda yakin ingin " + btnInterviewDiterima.getText() + "  pelamar ini?", "Konfirmasi",
        JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
            try {
                lamaran.setStatus(btnInterviewDiterima.getText());
                lamaranDAO.updateLamaran(lamaran);
                // Tambahkan logika atau update UI jika diperlukan setelah berhasil
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error Update Data lamaran pelamar: " + ex.getMessage());
                System.out.println("btnInterviewDiterimaActionPerformed ERR: " + ex.getMessage());
            }
        }
        clear();
    }//GEN-LAST:event_btnInterviewDiterimaActionPerformed

    private void btnBuatInformasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuatInformasiActionPerformed
        // TODO add your handling code here:
        new PopupMembuatInformasi(lowongan).setVisible(true);
    }//GEN-LAST:event_btnBuatInformasiActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        try{
            String jasperPath = "src/com/tirta/report/report_pelamar_terdaftar.jasper";
            String logoPath = "/com/tirta/icon/pt.png";
            InputStream logo = ImageInputStreamUtils.getImageInputStream(logoPath);
            String tanggal = DateUtils.getFormattedCurrentDate();
            
            HashMap parameter = new HashMap();
            parameter.put("logo", logo);
            parameter.put("tanggal", tanggal);
            parameter.put("id_lowongan", lowonganID);
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
    private com.tirta.swing.Button btnBuatInformasi;
    private com.tirta.swing.Button btnCetak;
    private com.tirta.swing.Button btnDitolak;
    private com.tirta.swing.Button btnInterviewDiterima;
    private com.tirta.swing.Button btnRefresh;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblDataPelamar;
    private javax.swing.JLabel lblDataPelamar1;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblPendidikan;
    private javax.swing.JLabel lblPengalaman;
    private javax.swing.JLabel lblSertifikasi;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTentangDiri;
    private javax.swing.JTable tblListPelamar;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextArea txtPendidikan;
    private javax.swing.JTextArea txtPengalaman;
    private javax.swing.JTextArea txtSertifikasi;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextArea txtTentangDiri;
    // End of variables declaration//GEN-END:variables
}
