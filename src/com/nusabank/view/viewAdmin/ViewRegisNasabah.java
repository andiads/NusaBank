/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.view.viewAdmin;

import com.toedter.calendar.JDateChooser;
import com.nusabank.helper.Function;
import com.nusabank.controller.CRegisNasabah;
import com.nusabank.controller.CRegisRekening;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author User
 */
public class ViewRegisNasabah extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    private String IdAdmin;
    private Function func;
    private CRegisNasabah nc;
    private CRegisRekening rc;
    private ViewMenuAdmin vma;
    private String fileName;
    private String sourcePath;
    private String destPath;
    
    /**
     * Creates new form ViewRegisNasabah
     */
    public ViewRegisNasabah() {
    
        initComponents();
        todayDateInit();
        noIdAdmin();
        setLocationRelativeTo(null);
        setIdAdmin(ViewMenuAdmin.lbIdAdmin.getText());
        dcTglLahir.setDate(new Date());
        func = new Function();
        nc = new CRegisNasabah(this);
        rc = new CRegisRekening(this);
        System.out.println(System.getProperty("user.dir"));
        
        
    }
    public void noIdAdmin(){
        lbIdAdmin.setText(IdAdmin);
    }
    
    public void setIdAdmin(String id){
        this.IdAdmin=id;
    }

    public void todayDateInit() {
        todayDate.setText(LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }
    
    public void resetPendapatan() {
        if (txtPendapatan.getText().isEmpty()){
            txtPendapatan.setText("0");
        }
    }
    
    public JLabel getLbNoIdAdmin(){
        return lbIdAdmin;
    }
    
    public JLabel getLbTodayDate() {
        return todayDate;
    }
   
    public JTextArea getTxtAreaValidation() {
        return txtAreaValidation;
    }
    
    public JTextField getTxtEmail() {
        return txtEmail;
    }
    
    public String getFileName(){
        return this.fileName;
    }
    
    public String getSrcPath(){
        return this.sourcePath;
    }
    
    public String getDestPath() {
        return this.destPath;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public void setDestPath(String destPath) {
        this.destPath = destPath;
    }
    
    public JTextField getTxtNama() {
        return txtNamaNasabah;
    }
    
    public JTextField getTxtNIK() {
        return txtNIK;
    }
    
    public JDateChooser getTxtLahir() {
        return dcTglLahir;
    }
    
    public JTextArea getTxtAlamat() {
        return txtAlamat;
    }
    
    public JComboBox<String> getCmbJenisKelamin() {
        return cmbJenisKelamin;
    }
    
    public JTextField getTxtNoHP() {
        return txtNoHP;
    }

    public JLabel getLbFoto() {
        return lbFoto;
    }

    public JComboBox<String> getCmbStatus() {
        return cmbStatus;
    }

    public JTextArea getTxtAlamatKantor() {
        return txtAlamatKantor;
    }    
    
    public JTextField getTxtNamaIbu() {
        return txtNamaIbu;
    }

    public JPasswordField getTxtPassword() {
        return txtPassword;
    }

    public JTextField getTxtPekerjaan() {
        return txtPekerjaan;
    }

    public JTextField getTxtPendapatan() {
        return txtPendapatan;
    }

    public JPasswordField getTxtRePassword() {
        return txtRePassword;
    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public JLabel getLbNamaNasabah() {
        return lbNamaNasabah;
    }

    public JTextField getTxtIdRekening() {
        return txtIdRekening;
    }


    public JPasswordField getTxtNoPIN() {
        return txtNoPIN;
    }
    
    public JTextField getTxtNoRekening() {
        return txtNoRekening;
    }

    public JTextField getTxtSaldo() {
        return txtSaldo;
    }

    public JComboBox<String> getCmbJenisRekening() {
        return cmbJenisRekening;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNamaNasabah = new javax.swing.JTextField();
        txtNIK = new javax.swing.JTextField();
        txtNoHP = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbJenisKelamin = new javax.swing.JComboBox<>();
        txtPekerjaan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPendapatan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNamaIbu = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        btnBrowsePhoto = new javax.swing.JButton();
        cmbJenisRekening = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAlamatKantor = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtNoRekening = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtIdRekening = new javax.swing.JTextField();
        lbNamaNasabah = new javax.swing.JLabel();
        lbFoto = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtRePassword = new javax.swing.JPasswordField();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        todayDate = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtNoPIN = new javax.swing.JPasswordField();
        jLabel20 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaValidation = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        lbIdAdmin = new javax.swing.JLabel();
        dcTglLahir = new com.toedter.calendar.JDateChooser();
        jLabel25 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nusa Bank - New Customer Account Registration");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("No Contact");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 379, 103, 27));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Identity No");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 123, 103, 27));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Full Name");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 85, 103, 27));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Home Address");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 247, 103, 27));
        getContentPane().add(txtNamaNasabah, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 90, 250, -1));
        getContentPane().add(txtNIK, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 128, 250, -1));
        getContentPane().add(txtNoHP, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 384, 250, -1));

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        jScrollPane1.setViewportView(txtAlamat);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 247, 250, 88));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Gender");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 341, 103, 27));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Bank Account Registration");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 220, 30));

        jLabel2.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        jLabel2.setText("Nusa Bank");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 252, 55));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("DOB");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 161, 103, 27));

        cmbJenisKelamin.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cmbJenisKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Choose -", "Male", "Female" }));
        getContentPane().add(cmbJenisKelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 344, 250, -1));
        getContentPane().add(txtPekerjaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 429, 250, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Job Position");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 424, 103, 27));

        txtPendapatan.setText("0");
        txtPendapatan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPendapatanKeyReleased(evt);
            }
        });
        getContentPane().add(txtPendapatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 467, 250, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Income");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 462, 103, 27));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Status");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 594, 103, 27));
        getContentPane().add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 128, 254, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Username");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 123, 116, 27));

        txtNamaIbu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaIbuActionPerformed(evt);
            }
        });
        getContentPane().add(txtNamaIbu, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 260, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Mother Name");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 240, 110, 27));

        cmbStatus.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Choose -", "Single", "Maried", "Single Parent" }));
        getContentPane().add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 594, 250, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Password");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 161, 116, 27));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Re-Type Password");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 199, 116, 27));

        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 400, -1, -1));

        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 400, 63, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Passport Photo");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 85, 116, 27));

        btnBrowsePhoto.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnBrowsePhoto.setText("- Browse -");
        btnBrowsePhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowsePhotoActionPerformed(evt);
            }
        });
        getContentPane().add(btnBrowsePhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 87, -1, -1));

        cmbJenisRekening.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cmbJenisRekening.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Choose -", "Reguler", "Gold", "Platinum", "VVIP", "" }));
        getContentPane().add(cmbJenisRekening, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 253, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Type of Account");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 117, 27));

        txtAlamatKantor.setColumns(20);
        txtAlamatKantor.setRows(5);
        jScrollPane2.setViewportView(txtAlamatKantor);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 507, 250, 69));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Work Address");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 507, 103, 27));

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        txtNoRekening.setBackground(new java.awt.Color(204, 255, 204));
        txtNoRekening.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel18.setText("Your Account No:");

        jLabel22.setText("ID No: ");

        txtIdRekening.setEditable(false);
        txtIdRekening.setBackground(new java.awt.Color(255, 204, 51));
        txtIdRekening.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtIdRekening.setText("0");

        lbNamaNasabah.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbNamaNasabah.setText("Your Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNoRekening)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbNamaNasabah, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 34, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdRekening, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtIdRekening, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(lbNamaNasabah, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNoRekening, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 110, 374, -1));

        lbFoto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbFoto.setText("file...");
        getContentPane().add(lbFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(651, 85, 157, 27));
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 166, 254, -1));
        getContentPane().add(txtRePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 204, 254, -1));

        jLabel21.setText("Your Debit Card:");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 90, 85, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("First Tiime Deposit");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 117, 27));

        txtSaldo.setText("0");
        getContentPane().add(txtSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 320, 247, -1));

        todayDate.setText("tglSekarang");
        getContentPane().add(todayDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 50, 139, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("PIN (Default)");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 117, 27));

        txtNoPIN.setText("123456");
        txtNoPIN.setEnabled(false);
        getContentPane().add(txtNoPIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, 247, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("E-mail");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 199, 103, 27));
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 204, 250, -1));

        txtAreaValidation.setEditable(false);
        txtAreaValidation.setBackground(new java.awt.Color(0, 0, 0));
        txtAreaValidation.setColumns(20);
        txtAreaValidation.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        txtAreaValidation.setForeground(new java.awt.Color(255, 102, 102));
        txtAreaValidation.setRows(17);
        txtAreaValidation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Form Validation Messages:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 102, 102))); // NOI18N
        jScrollPane3.setViewportView(txtAreaValidation);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, 780, 200));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1220, 10));

        lbIdAdmin.setText("UID");
        getContentPane().add(lbIdAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 50, 90, -1));

        dcTglLahir.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(dcTglLahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 250, -1));

        jLabel25.setText("Admin ID:");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 50, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamaIbuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaIbuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaIbuActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       
       
       boolean nasabahValidCheck = nc.validateForm();
       boolean rekeningValidCheck = rc.validateForm();
       nc.validateForm();
       rc.validateForm();
       if (nasabahValidCheck == true && rekeningValidCheck == true) {
           String noRekening = func.generateNoRek(
               txtNamaNasabah.getText().replace(" ", ""),
               dcTglLahir.getDateFormatString(), 
               todayDate.getText()
            );
            txtNoRekening.setText(noRekening);
            rc.insert();
            nc.insert();
            
            rc.reset();
            nc.reset();
       } else {
           JOptionPane.showMessageDialog(this, "There's validation error occured."
                   + "\nPlease contact the developer about this issue!", "Validation Error", JOptionPane.ERROR_MESSAGE);
           txtAreaValidation.setText(nc.getAllMsgValidation());
       }
       
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnBrowsePhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowsePhotoActionPerformed
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        // invoke the showsOpenDialog function to show the open dialog 
        int r = j.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            this.setFileName(j.getSelectedFile().getName());
            this.setSourcePath(j.getSelectedFile().getAbsolutePath());
            lbFoto.setText(this.getSrcPath());
        }
    }//GEN-LAST:event_btnBrowsePhotoActionPerformed

    private void txtPendapatanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPendapatanKeyReleased
        resetPendapatan();
    }//GEN-LAST:event_txtPendapatanKeyReleased

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        nc.reset();
        rc.reset();
    }//GEN-LAST:event_btnResetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewRegisNasabah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewRegisNasabah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewRegisNasabah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewRegisNasabah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewRegisNasabah().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowsePhoto;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbJenisKelamin;
    private javax.swing.JComboBox<String> cmbJenisRekening;
    private javax.swing.JComboBox<String> cmbStatus;
    private com.toedter.calendar.JDateChooser dcTglLahir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbFoto;
    private javax.swing.JLabel lbIdAdmin;
    private javax.swing.JLabel lbNamaNasabah;
    private javax.swing.JLabel todayDate;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextArea txtAlamatKantor;
    private javax.swing.JTextArea txtAreaValidation;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdRekening;
    private javax.swing.JTextField txtNIK;
    private javax.swing.JTextField txtNamaIbu;
    private javax.swing.JTextField txtNamaNasabah;
    private javax.swing.JTextField txtNoHP;
    private javax.swing.JPasswordField txtNoPIN;
    private javax.swing.JTextField txtNoRekening;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPekerjaan;
    private javax.swing.JTextField txtPendapatan;
    private javax.swing.JPasswordField txtRePassword;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    
}
