package com.tirta.component;

import com.tirta.model.ModelLogin;
import com.tirta.model.ModelUser;
import com.tirta.swing.Button;
import com.tirta.swing.MyPasswordField;
import com.tirta.swing.MyTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    public ModelLogin getDataLogin() {
        return dataLogin;
    }

    public ModelUser getUser() {
        return user;
    }

    private ModelUser user;
    private ModelLogin dataLogin;

    public PanelLoginAndRegister(ActionListener eventRegister, ActionListener eventLogin) {
        initComponents();
        initRegister(eventRegister);
        initLogin(eventLogin);
        login.setVisible(false);
        register.setVisible(true);
    }

    private void initRegister(ActionListener eventRegister) {
        register.setLayout(new MigLayout("wrap 1", "push[center]push", "push[]25[]25[]25[]25[]25[]25[]push"));
        JLabel label = new JLabel("BUAT AKUN");
        label.setFont(new Font("sansserif", Font.BOLD, 30));
        label.setForeground(new Color(56, 109, 126));
        register.add(label);

        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/com/tirta/icon/user.png")));
        txtUser.setHint("Nama");
        register.add(txtUser, "w 60%");

        MyTextField txtNoTlp = new MyTextField();
        txtNoTlp.setPrefixIcon(new ImageIcon(getClass().getResource("/com/tirta/icon/telephone.png")));
        txtNoTlp.setHint("No Telp");
        register.add(txtNoTlp, "w 60%");

        MyTextField txtTglLahir = new MyTextField();
        txtTglLahir.setPrefixIcon(new ImageIcon(getClass().getResource("/com/tirta/icon/date-of-birth.png")));
        txtTglLahir.setHint("Tgl Lahir (dd-mm-yyyy)");
        register.add(txtTglLahir, "w 60%");
        
        MyTextField txtAlamat = new MyTextField();
        txtAlamat.setPrefixIcon(new ImageIcon(getClass().getResource("/com/tirta/icon/location.png")));
        txtAlamat.setHint("Alamat");
        register.add(txtAlamat, "w 60%");

        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/tirta/icon/mail.png")));
        txtEmail.setHint("Email");
        register.add(txtEmail, "w 60%");

        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/tirta/icon/pass.png")));
        txtPass.setHint("Password");
        register.add(txtPass, "w 60%");

        Button cmd = new Button();
        cmd.setBackground(new Color(56, 109, 126));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.addActionListener(eventRegister);
        cmd.setText("DAFTAR");
        register.add(cmd, "w 40%, h 40");

        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String userName = txtUser.getText().trim();
                String noTlp = txtNoTlp.getText().trim();
                String tglLahir = txtTglLahir.getText().trim();
                String email = txtEmail.getText().trim();
                String password = String.valueOf(txtPass.getPassword());
                String alamat = txtAlamat.getText();

                if (validateFields(userName, noTlp, tglLahir, email, password)) {
                    user = new ModelUser(0, userName, email, password, noTlp, tglLahir, alamat);
                    System.out.println("MASUKK KE SINI!!");
                }
            }
        });
    }

    private boolean validateFields(String userName, String noTlp, String tglLahir, String email, String password) {
        if (userName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong");
            return false;
        }
        if (noTlp.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No Telp tidak boleh kosong");
            return false;
        }
        if (!isValidDate(tglLahir)) {
            JOptionPane.showMessageDialog(null, "Tanggal Lahir tidak valid. *format dd-MM-yyyy");
            return false;
        }
        if (email.isEmpty() || !email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            JOptionPane.showMessageDialog(null, "Email tidak valid");
            return false;
        }
        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password tidak boleh kosong");
            return false;
        }
        return true;
    }

    private boolean isValidDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }



    private void initLogin(ActionListener eventLogin) {
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("MASUK AKUN");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(56, 109, 126));
        login.add(label);
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/tirta/icon/mail.png")));
        txtEmail.setHint("Email");
        login.add(txtEmail, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/tirta/icon/pass.png")));
        txtPass.setHint("Password");
        login.add(txtPass, "w 60%");
//        JButton cmdForget = new JButton("Lupa Password?");
//        cmdForget.setForeground(new Color(56, 109, 126));
//        cmdForget.setFont(new Font("sansserif", 1, 12));
//        cmdForget.setContentAreaFilled(false);
//        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        login.add(cmdForget);
        Button cmd = new Button();
        cmd.setBackground(new Color(56, 109, 126));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.addActionListener(eventLogin);
        cmd.setText("MASUK");
        login.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String email = txtEmail.getText().trim();
                String password = String.valueOf(txtPass.getPassword());
                dataLogin = new ModelLogin(email, password);
            }
        });
    }

    public void showRegister(boolean show) {
        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
