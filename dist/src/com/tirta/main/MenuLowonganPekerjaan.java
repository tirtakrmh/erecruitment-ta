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
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MenuLowonganPekerjaan extends javax.swing.JPanel {
    private final DefaultTableModel tblModel;
    private int userID;
    private int lowonganID;
    
    private LowonganDAO lowonganDAO = new LowonganDAO();
    private LamaranDAO lamaranDAO = new LamaranDAO();
    private PelamarDAO pelamarDAO = new PelamarDAO();
    
    private List<ModelLowongan> lowongans = new ArrayList<>();
    private ModelLamaran lamaran;
    private ModelPelamar pelamar = new ModelPelamar();
    
    public MenuLowonganPekerjaan(int userID) {
        this.userID = userID;
        initComponents();
        txtPerusahaan.setEditable(false);
        txtPosisi2.setEditable(false);
        txtKualifikasi.setEditable(false);
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
        tblListLowongan.getColumnModel().getColumn(0).setMinWidth(0);
        tblListLowongan.getColumnModel().getColumn(0).setMaxWidth(0);
        populateLowonganTable(""); // Initial population with all vacancies
        loadPelamarData();
    }
    
    private void populateLowonganTable(String likeQuery) {
        // Clear existing rows
        tblModel.setRowCount(0);

        // Fetch vacancies from database
        try {
            lowongans = lowonganDAO.getListLowonganByPosisi(likeQuery);

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
        tblListLowongan = new javax.swing.JTable();
        lblPosisi = new javax.swing.JLabel();
        txtPosisi = new javax.swing.JTextField();
        btnSearch = new javax.swing.JLabel();
        lblDetailLowonganPekerjaan = new javax.swing.JLabel();
        txtPosisi2 = new javax.swing.JTextField();
        lblKualifikasi = new javax.swing.JLabel();
        txtPerusahaan = new javax.swing.JTextField();
        lblPosisi2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtKualifikasi = new javax.swing.JTextArea();
        lblPerusahaan = new javax.swing.JLabel();
        lblDetailLowonganPekerjaan1 = new javax.swing.JLabel();
        btnUbahPassword = new com.tirta.swing.Button();

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
        jLabel3.setText("LOWONGAN PEKERJAAN");

        tblListLowongan.setForeground(new java.awt.Color(0, 0, 0));
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

        lblPosisi.setBackground(new java.awt.Color(255, 255, 255));
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

        lblDetailLowonganPekerjaan.setBackground(new java.awt.Color(255, 255, 255));
        lblDetailLowonganPekerjaan.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblDetailLowonganPekerjaan.setForeground(new java.awt.Color(255, 255, 255));
        lblDetailLowonganPekerjaan.setText("DETAIL LOWONGAN PEKERJAAN:");

        txtPosisi2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        lblKualifikasi.setBackground(new java.awt.Color(255, 255, 255));
        lblKualifikasi.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblKualifikasi.setForeground(new java.awt.Color(255, 255, 255));
        lblKualifikasi.setText("Kualifikasi");

        txtPerusahaan.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        lblPosisi2.setBackground(new java.awt.Color(255, 255, 255));
        lblPosisi2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPosisi2.setForeground(new java.awt.Color(255, 255, 255));
        lblPosisi2.setText("Posisi");

        jScrollPane2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        txtKualifikasi.setColumns(20);
        txtKualifikasi.setRows(5);
        jScrollPane2.setViewportView(txtKualifikasi);

        lblPerusahaan.setBackground(new java.awt.Color(255, 255, 255));
        lblPerusahaan.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPerusahaan.setForeground(new java.awt.Color(255, 255, 255));
        lblPerusahaan.setText("Perusahaan");

        lblDetailLowonganPekerjaan1.setBackground(new java.awt.Color(255, 255, 255));
        lblDetailLowonganPekerjaan1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblDetailLowonganPekerjaan1.setForeground(new java.awt.Color(255, 255, 255));
        lblDetailLowonganPekerjaan1.setText("DAFTAR LOWONGAN PEKERJAAN:");

        btnUbahPassword.setForeground(new java.awt.Color(56, 109, 126));
        btnUbahPassword.setText("LAMAR");
        btnUbahPassword.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnUbahPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahPasswordActionPerformed(evt);
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
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(lblDetailLowonganPekerjaan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(100, 100, 100))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblKualifikasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPosisi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblDetailLowonganPekerjaan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPerusahaan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPerusahaan)
                                    .addComponent(txtPosisi2)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(btnUbahPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(312, 312, 312))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(lblPosisi, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(txtPosisi, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch)
                        .addGap(14, 14, 14)))
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
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
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(lblKualifikasi)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnUbahPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDetailLowonganPekerjaan1)
                        .addComponent(lblPosisi))
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPosisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
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
    
        // Ensure a valid row is selected
        if (rowIndex != -1 && rowIndex < lowongans.size()) {
            // Get the selected ModelLowongan object
            ModelLowongan selectedLowongan = lowongans.get(rowIndex);

            lowonganID = (int)selectedLowongan.getId();
            
            // Populate text fields with selected lowongan details
            txtPerusahaan.setText(selectedLowongan.getPerusahaan());
            txtPosisi2.setText(selectedLowongan.getPosisi());
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

    private void btnUbahPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahPasswordActionPerformed
        // TODO add your handling code here:
        if (lowonganID == 0) {
            JOptionPane.showMessageDialog(this, "Silahkan pilih lamaran terlebih dahulu.");
            return;
        }
        try {
            pelamar = pelamarDAO.selectPelamar(userID);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error Get Data Pelamar");
            return;
        }
        
        int response = JOptionPane.showConfirmDialog(this, "Apakah anda yakin ingin melamar posisi ini?", "Konfirmasi Lamaran", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            lamaran = new ModelLamaran();
            lamaran.setLowonganId(lowonganID);
            lamaran.setPelamarId((int)pelamar.getId());
            lamaran.setStatus(EnumStatus.DIPERIKSA.name());
            
            try {
                ModelLamaranPelamar l = lamaranDAO.getLamaranByPelamarIDANDLowonganID((int)pelamar.getId(), lowonganID);
                if (l.getId() != 0){
                    System.out.println("DATA LAMARAN:"+l.toString());
                    JOptionPane.showMessageDialog(this, "Kamu sudah melamar lowongan ini.");
                    return;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error get data lamaran: " + ex.getMessage());
                return;
            }

            try {
                lamaranDAO.insertLamaran(lamaran);
                JOptionPane.showMessageDialog(this, "Berhasil mengajukan lamaran.");
                return;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error inserting lamaran: " + ex.getMessage());
                return;
            }
        }
    }//GEN-LAST:event_btnUbahPasswordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnSearch;
    private com.tirta.swing.Button btnUbahPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblDetailLowonganPekerjaan;
    private javax.swing.JLabel lblDetailLowonganPekerjaan1;
    private javax.swing.JLabel lblKualifikasi;
    private javax.swing.JLabel lblPerusahaan;
    private javax.swing.JLabel lblPosisi;
    private javax.swing.JLabel lblPosisi2;
    private javax.swing.JTable tblListLowongan;
    private javax.swing.JTextArea txtKualifikasi;
    private javax.swing.JTextField txtPerusahaan;
    private javax.swing.JTextField txtPosisi;
    private javax.swing.JTextField txtPosisi2;
    // End of variables declaration//GEN-END:variables
}
