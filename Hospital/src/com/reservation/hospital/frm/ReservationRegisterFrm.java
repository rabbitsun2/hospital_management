/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.reservation.hospital.frm;

import com.reservation.hospital.dbms.CreateConnection;
import com.reservation.hospital.dbms.DbConn;
import com.reservation.hospital.dbms.DbUtil;
import com.reservation.hospital.util.TxtUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 정도윤(Doyun Jung)
 */
public class ReservationRegisterFrm extends javax.swing.JFrame {

    /**
     * Creates new form ReservationRegisterFrm
     */
    public ReservationRegisterFrm() {
        initComponents();
        setLocationRelativeTo(null);    // 폼 가운데 정렬
        dbConn.setSid("XE");
        initResField();
        initHospDept();
    }
    
    private void initResField(){
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

        Calendar c1 = Calendar.getInstance();
        String strToday = sdf.format(c1.getTime());
        
        // 년도 초기화
        this.jCmb_Res_Year.removeAllItems();    // 예약 월
        this.jCmb_Birth_Year.removeAllItems();  // 생년 월
        
        for ( int i = Integer.valueOf(strToday) - 105; 
                i <= Integer.valueOf(strToday);
                i++){
         
            this.jCmb_Res_Year.addItem( String.valueOf(i) );
            this.jCmb_Birth_Year.addItem( String.valueOf(i) );
            
        }
        
        this.jCmb_Res_Year.setSelectedItem(strToday);
        this.jCmb_Birth_Year.setSelectedItem(strToday);
        
        // 월 초기화
        this.jCmb_Res_Month.removeAllItems();
        this.jCmb_Birth_Month.removeAllItems();
        
        for ( int i = 1; i <= 12; i++ ){
            
            this.jCmb_Res_Month.addItem( String.valueOf(i) );
            this.jCmb_Birth_Month.addItem( String.valueOf(i) );
            
        }
        
        sdf = new SimpleDateFormat("M");
        c1 = Calendar.getInstance();
        strToday = sdf.format(c1.getTime());
        
        this.jCmb_Res_Month.setSelectedItem(strToday);
        this.jCmb_Birth_Month.setSelectedItem(strToday);
        
        // 일 초기화
        this.jCmb_Res_Day.removeAllItems();
        this.jCmb_Birth_Day.removeAllItems();
        
        for ( int i = 1; i <= 31; i++ ){
            
            this.jCmb_Res_Day.addItem( String.valueOf( i ) );
            this.jCmb_Birth_Day.addItem( String.valueOf(i) );
        }
        
        sdf = new SimpleDateFormat("d");
        c1 = Calendar.getInstance();
        strToday = sdf.format(c1.getTime());
        
        this.jCmb_Res_Day.setSelectedItem(strToday);
        this.jCmb_Birth_Day.setSelectedItem(strToday);
        
        // 시 초기화
        this.jCmb_Res_Hour.removeAllItems();
        
        for (int i = 0; i < 24; i++){
            
            if ( i < 10 ){
                this.jCmb_Res_Hour.addItem("0" + String.valueOf(i) );
            }else{
                this.jCmb_Res_Hour.addItem( String.valueOf(i) );
            }
            
        }
        
        this.jCmb_Res_Hour.setSelectedItem("00");
        
        // 분 초기화
        this.jCmb_Res_Min.removeAllItems();
        
        for (int i = 0; i < 60; i++){
            
            if ( i < 10 ){
                this.jCmb_Res_Min.addItem("0" + String.valueOf(i) );
            }else{
                this.jCmb_Res_Min.addItem( String.valueOf(i) );
            }
            
        }
        
        this.jCmb_Res_Min.setSelectedItem("00");
        
    }
    
    private void initHospDept(){
        
        String query = "select hosp_dept.dept_id as \"dept_id\", hosp_dept.dept_name as \"dept_name\", hosp_dept.professor_id as \"professor_id\",\n" +
                "    hosp_professor.professor_name as \"professor_name\", hosp_professor.professor_email as \"professor_email\",\n" +
                "    hosp_professor.professor_position as \"professor_position\" from hosp_dept, hosp_professor " + 
                "    where dept_id = hosp_professor.id order by dept_id";
    
        CreateConnection createConn = new CreateConnection(dbConn);
        
        Connection conn = null;
        String driverName = createConn.getOracleDriver();
        
        this.jCmb_Hosp_Dept.removeAllItems();   // 진료학과 초기화
        
        int i = 0;
        
        try {
            Class.forName(driverName);
            
            //System.out.println(createConn.getOracleUrl());
            conn = DriverManager.getConnection(createConn.getOracleUrl(), 
                    dbConn.getUsername(), dbConn.getPasswd());
            System.out.println("성공");
            System.out.println(query);
            
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                
                this.jCmb_Hosp_Dept.addItem( 
                        rs.getString("dept_id") + "/" +
                        rs.getString("dept_name") + "/" + 
                        rs.getString("professor_name") );
                
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservationStatusFrm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReservationStatusFrm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex){
            Logger.getLogger(ReservationStatusFrm.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            DbUtil.dbClose(rs, pstmt, conn);
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jCmb_Res_Year = new javax.swing.JComboBox<>();
        jCmb_Res_Month = new javax.swing.JComboBox<>();
        jCmb_Res_Day = new javax.swing.JComboBox<>();
        jCmb_Res_Hour = new javax.swing.JComboBox<>();
        jCmb_Res_Min = new javax.swing.JComboBox<>();
        jCmb_Birth_Day = new javax.swing.JComboBox<>();
        jCmb_Birth_Month = new javax.swing.JComboBox<>();
        jCmb_Birth_Year = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCmb_Hosp_Dept = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTxt_CusName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTxt_CusPhone = new javax.swing.JTextField();
        jBtn_Register = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("병원 예약");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("나눔고딕 ExtraBold", 0, 24)); // NOI18N
        jLabel1.setText("병원 예약");

        jLabel2.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jLabel2.setText("예약일자");

        jCmb_Res_Year.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jCmb_Res_Year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCmb_Res_Month.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jCmb_Res_Month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCmb_Res_Day.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jCmb_Res_Day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCmb_Res_Hour.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jCmb_Res_Hour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCmb_Res_Min.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jCmb_Res_Min.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCmb_Birth_Day.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jCmb_Birth_Day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCmb_Birth_Month.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jCmb_Birth_Month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCmb_Birth_Year.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jCmb_Birth_Year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jLabel3.setText("생년월일");

        jLabel4.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jLabel4.setText("진료학과");

        jCmb_Hosp_Dept.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jCmb_Hosp_Dept.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jLabel5.setText("환자명");

        jTxt_CusName.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jLabel6.setText("연락처");

        jTxt_CusPhone.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N

        jBtn_Register.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jBtn_Register.setText("예약");
        jBtn_Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_RegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtn_Register, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCmb_Res_Year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCmb_Res_Month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCmb_Res_Day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCmb_Res_Hour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCmb_Res_Min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTxt_CusPhone))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTxt_CusName))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCmb_Hosp_Dept, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCmb_Birth_Year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCmb_Birth_Month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCmb_Birth_Day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCmb_Res_Year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCmb_Res_Month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCmb_Res_Day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCmb_Res_Hour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCmb_Res_Min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jCmb_Birth_Year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCmb_Birth_Month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCmb_Birth_Day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCmb_Hosp_Dept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxt_CusName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxt_CusPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jBtn_Register)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtn_RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_RegisterActionPerformed


        String query = "insert into hosp_reservation(dept_id, res_date, birth_date, regi_date, cus_name, cus_phone) " +
            "values(?, to_date(?, 'YYYY-MM-DD HH24:MI:SS'), " +
            "          to_date(?, 'YYYY-MM-DD HH24:MI:SS'), " +
            "          to_date(?, 'YYYY-MM-DD HH24:MI:SS'), " +
            "          ?, ?)";
                
        // 현재 날짜/시간
        LocalDateTime now = LocalDateTime.now();
        // 포맷팅
        String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        
        //System.out.println( TxtUtil.getDeptCode( this.jCmb_Hosp_Dept.getSelectedItem().toString() ) + "선택항목" );
        
        String deptCode = TxtUtil.getDeptCode( this.jCmb_Hosp_Dept.getSelectedItem().toString() );
        String strResDate = this.jCmb_Res_Year.getSelectedItem() + "-" +
                        this.jCmb_Res_Month.getSelectedItem() + "-" +
                        this.jCmb_Res_Day.getSelectedItem() + " " +
                        this.jCmb_Res_Hour.getSelectedItem() + ":" +
                        this.jCmb_Res_Min.getSelectedItem() + ":" +
                        "00";
                         
        String strBirthDate = this.jCmb_Birth_Year.getSelectedItem() + "-" +
                        this.jCmb_Birth_Month.getSelectedItem() + "-" +
                        this.jCmb_Birth_Day.getSelectedItem() + " " +
                        "00:00:00";
        
        CreateConnection createConn = new CreateConnection(dbConn);
        
        Connection conn = null;
        String driverName = createConn.getOracleDriver();
        
        try {
            Class.forName(driverName);
            
            //System.out.println(createConn.getOracleUrl());
            conn = DriverManager.getConnection(createConn.getOracleUrl(), 
                    dbConn.getUsername(), dbConn.getPasswd());
            System.out.println("성공");
            System.out.println(query);
            
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, deptCode);
            pstmt.setString(2, strResDate);
            pstmt.setString(3, strBirthDate);
            pstmt.setString(4, formatedNow);
            pstmt.setString(5, this.jTxt_CusName.getText() );
            pstmt.setString(6, this.jTxt_CusPhone.getText() );
            
            int cnt = pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "성공적으로 등록이 완료되었습니다.");
            this.dispose();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservationStatusFrm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReservationStatusFrm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex){
            Logger.getLogger(ReservationStatusFrm.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            DbUtil.dbClose(rs, pstmt, conn);
        }
        
        
    }//GEN-LAST:event_jBtn_RegisterActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReservationRegisterFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservationRegisterFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservationRegisterFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservationRegisterFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservationRegisterFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtn_Register;
    private javax.swing.JComboBox<String> jCmb_Birth_Day;
    private javax.swing.JComboBox<String> jCmb_Birth_Month;
    private javax.swing.JComboBox<String> jCmb_Birth_Year;
    private javax.swing.JComboBox<String> jCmb_Hosp_Dept;
    private javax.swing.JComboBox<String> jCmb_Res_Day;
    private javax.swing.JComboBox<String> jCmb_Res_Hour;
    private javax.swing.JComboBox<String> jCmb_Res_Min;
    private javax.swing.JComboBox<String> jCmb_Res_Month;
    private javax.swing.JComboBox<String> jCmb_Res_Year;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTxt_CusName;
    private javax.swing.JTextField jTxt_CusPhone;
    // End of variables declaration//GEN-END:variables
    
    private DbConn dbConn = new DbConn("hr", "123456", "localhost", "1521");
        
    private PreparedStatement pstmt = null;     
    private ResultSet rs = null;                // 결과값 반환
    
}
