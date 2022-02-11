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
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 정도윤(Doyun Jung)
 */
public class ReservationStatusFrm extends javax.swing.JFrame {

    /**
     * Creates new form ReservationStatusFrm
     */
    public ReservationStatusFrm() {
        
        initComponents();
        dbConn.setSid("XE");
        loadReservation();              // 예약현황 불러오기
        jReservation_Tbl_Resize();      // 예약 테이블 크기 정렬
        setLocationRelativeTo(null);    // 폼 가운데 정렬
        
        loadDept();
        loadCusDate();
        
        /*
        for (int i = 0; i < str.length; i++)
            vecDept.addElement(str[i]);
        
        jList_Dept.setListData(vecDept);
        */
        
    }
    
    
    private void loadDept(){
        
        Connection conn = null;
        try {
            vecDept = new Vector();
            
            String query = "select * from hosp_dept order by dept_id";
            
            CreateConnection createConn = new CreateConnection(dbConn);
            String driverName = createConn.getOracleDriver();
            Class.forName(driverName);
            conn = DriverManager.getConnection(createConn.getOracleUrl(),
                    dbConn.getUsername(), dbConn.getPasswd());
            
            System.out.println("성공");

            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while(rs.next()){
                vecDept.addElement(rs.getString("dept_name"));
            }

            jList_Dept.setListData(vecDept);
            DbUtil.dbClose(rs, pstmt, conn);
        } catch (SQLException ex) {
            Logger.getLogger(ReservationStatusFrm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservationStatusFrm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex){
            Logger.getLogger(ReservationStatusFrm.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            DbUtil.dbClose(rs, pstmt, conn);
        }
        
    }
    
    private void loadCusDate(){
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar c1 = Calendar.getInstance();
        String strToday = sdf.format(c1.getTime());
        
        this.jLbl_CusDate.setText(strToday);
        
        
    }
    
    private void jReservation_Tbl_Resize(){
        
        // 컬럼 길이 조절
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(110);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(110);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(30);
        
        
    }
    
    private void loadReservation(){
        
        String[] tmpArr = {"번호","학과번호","학과명","예약일자","생년월일", "접수일자", "이름", "연락처"};   // 컬럼명
        colNames = new String[tmpArr.length];
        
        int i = 0;
        for (String strTxt : tmpArr){
            colNames[i++] = strTxt;
        }
        
        String[][] datas = new String[0][colNames.length];
        DefaultTableModel model = new DefaultTableModel(datas, colNames); //  테이블 데이터 모델 객체 생성
        
        jTable1.setModel(model);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_Dept = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBtn_SelectedShow = new javax.swing.JButton();
        jBtn_SelectedRemove = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLbl_currentResDate = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLbl_currentDeptName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jBtn_Read = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLbl_currentBirthDate = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLbl_currentRegidate = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTxt_CusName = new javax.swing.JTextField();
        jTxt_CusPhone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLbl_currentID = new javax.swing.JLabel();
        jBtn_ModifyDept = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLbl_CusDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("금일 예약 현황");

        jList_Dept.setFont(new java.awt.Font("나눔고딕 ExtraBold", 0, 24)); // NOI18N
        jList_Dept.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList_Dept.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jList_Dept.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList_DeptValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList_Dept);

        jTable1.setFont(new java.awt.Font("나눔고딕", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jTable1);

        jBtn_SelectedShow.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jBtn_SelectedShow.setText("출력");
        jBtn_SelectedShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_SelectedShowActionPerformed(evt);
            }
        });

        jBtn_SelectedRemove.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jBtn_SelectedRemove.setText("삭제");
        jBtn_SelectedRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_SelectedRemoveActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLbl_currentResDate.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jLabel3.setText("예약일자");

        jLbl_currentDeptName.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jLabel2.setText("현재 학과명");

        jBtn_Read.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jBtn_Read.setText("값 읽기");
        jBtn_Read.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_ReadActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jLabel4.setText("생년월일");

        jLbl_currentBirthDate.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jLabel5.setText("접수일자");

        jLbl_currentRegidate.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jLabel6.setText("성명");

        jTxt_CusName.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N

        jTxt_CusPhone.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jLabel7.setText("연락처");

        jLabel8.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jLabel8.setText("번호");

        jLbl_currentID.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N

        jBtn_ModifyDept.setFont(new java.awt.Font("나눔고딕", 0, 12)); // NOI18N
        jBtn_ModifyDept.setText("학과 수정(내과로 수정)");
        jBtn_ModifyDept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_ModifyDeptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLbl_currentID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLbl_currentResDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLbl_currentDeptName, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLbl_currentBirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLbl_currentRegidate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTxt_CusName))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTxt_CusPhone)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBtn_Read, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtn_ModifyDept, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtn_Read)
                    .addComponent(jBtn_ModifyDept))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLbl_currentID, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLbl_currentDeptName, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLbl_currentResDate, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLbl_currentBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLbl_currentRegidate, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTxt_CusName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTxt_CusPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtn_SelectedShow, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtn_SelectedRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtn_SelectedShow)
                            .addComponent(jBtn_SelectedRemove))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)))
        );

        jLabel1.setFont(new java.awt.Font("나눔고딕 ExtraBold", 0, 24)); // NOI18N
        jLabel1.setText("금일 예약 현황");

        jLbl_CusDate.setFont(new java.awt.Font("나눔고딕 ExtraBold", 1, 24)); // NOI18N
        jLbl_CusDate.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLbl_CusDate, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLbl_CusDate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jList_DeptValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList_DeptValueChanged

        loadDeptTable();

    }//GEN-LAST:event_jList_DeptValueChanged

    private void loadDeptTable(){
        
        
        String tmp_txt = "";
        
        if ( model == null){
            String[][] datas = new String[0][colNames.length];
            model = new DefaultTableModel(datas, colNames); //  테이블 데이터 모델 객체 생성
        }
        
        /*
        if(!evt.getValueIsAdjusting()) {	//이거 없으면 mouse 눌릴때, 뗄때 각각 한번씩 호출되서 총 두번 호출
                System.out.println("selected :"+ jList_Dept.getSelectedValue());
        }
        */
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c1 = Calendar.getInstance();
        String strToday = sdf.format(c1.getTime());
        
        String query = "select hosp_reservation.id as \"id\", hosp_reservation.dept_id as \"dept_id\", hosp_dept.dept_name as \"dept_name\", " +
                    "    hosp_reservation.res_date as \"res_date\", hosp_reservation.birth_date as \"birth_date\", " +
                    "    hosp_reservation.regi_date as \"regi_date\", hosp_reservation.cus_name as \"cus_name\", " +
                    "    hosp_reservation.cus_phone as \"cus_phone\" " +
                    "    from hosp_reservation, hosp_dept where hosp_reservation.dept_id = hosp_dept.dept_id and " +
                    "    ( dept_name = ? and " +
                    "      res_date BETWEEN TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS') " +
                    "                   AND TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS')  ) order by id";
    
        CreateConnection createConn = new CreateConnection(dbConn);
        
        Connection conn = null;
        String driverName = createConn.getOracleDriver();
        
        int i = 0;
        
        try {
            Class.forName(driverName);
            
            //System.out.println(createConn.getOracleUrl());
            conn = DriverManager.getConnection(createConn.getOracleUrl(), 
                    dbConn.getUsername(), dbConn.getPasswd());
            //System.out.println("성공");
            //System.out.println(query);
            
            
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, jList_Dept.getSelectedValue() );
            pstmt.setString(2, strToday + " 00:00:00");
            pstmt.setString(3, strToday + " 23:59:59");
            
            //System.out.println(jList_Dept.getSelectedValue() + "/할랄/" + strToday );
            
            rs = pstmt.executeQuery();

            model.setNumRows(0);                            //  (화면 버그 개선) 테이블 초기화
            
            //System.out.println( rs.isFirst() );
            
            while(rs.next()){
                
                //System.out.println("i번:" + i);
                i++;
                
                String tmp_txt_birth_date = TxtUtil.shortDate(rs.getString("birth_date"));
                String tmp_txt_name = TxtUtil.personSecName(rs.getString("cus_name"));
                String tmp_txt_phone = TxtUtil.shortLastPhoneNumber(rs.getString("cus_phone"));
                
                String[] tmp_arr =  {rs.getString("id"), rs.getString("dept_id"),
                    rs.getString("dept_name"), rs.getString("res_date"),
                    tmp_txt_birth_date, rs.getString("regi_date"),
                    tmp_txt_name, tmp_txt_phone };
                                
                model.addRow(tmp_arr);
                //System.out.println(rs.getString("dept_name") + "/" + rs.getString("cus_name") );
                
            }
            
            //model.fireTableDataChanged();
            jTable1.setModel(model);    // 갱신
            jReservation_Tbl_Resize();  // 크기 조절
            //jTable1.updateUI();
            
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
    
    private void jBtn_SelectedShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_SelectedShowActionPerformed
        
        int row = this.jTable1.getSelectedRow();
        int col = this.jTable1.getSelectedColumn();
        
        // 선택
        if ( row != -1 && col != -1 )
        {
            Object value = this.jTable1.getValueAt(row, col);
            JOptionPane.showMessageDialog(null, value);   
        }
        
    }//GEN-LAST:event_jBtn_SelectedShowActionPerformed

    private void jBtn_SelectedRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_SelectedRemoveActionPerformed

        int row = this.jTable1.getSelectedRow();
        int col = 0;
        
        Object value = "";
        
        // 선택된 값 일 때
        if ( row != -1 && col != -1 ){
            value = this.jTable1.getValueAt(row, col);
        }
                
        String query = "delete from hosp_reservation where id = ?";
    
        CreateConnection createConn = new CreateConnection(dbConn);
        
        Connection conn = null;
        String driverName = createConn.getOracleDriver();
        
        int i = 0;
        
        try {
            Class.forName(driverName);
            
            //System.out.println(createConn.getOracleUrl());
            conn = DriverManager.getConnection(createConn.getOracleUrl(), 
                    dbConn.getUsername(), dbConn.getPasswd());
            //System.out.println("성공");
            //System.out.println(query);
            
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, value.toString() );
            
            int cnt = pstmt.executeUpdate();
            //jTable1.updateUI();
            
            JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.");
            loadDeptTable();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservationStatusFrm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReservationStatusFrm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex){
            Logger.getLogger(ReservationStatusFrm.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            DbUtil.dbClose(rs, pstmt, conn);
        }
        
    }//GEN-LAST:event_jBtn_SelectedRemoveActionPerformed

    private void jBtn_ReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_ReadActionPerformed

        
        int row = this.jTable1.getSelectedRow();
        int col = COLUMN_ID ;
        
        Object value = "";
        
        if ( row != -1 ){

            value = this.jTable1.getValueAt(row, COLUMN_ID);
            this.jLbl_currentID.setText(value.toString());

            value = this.jTable1.getValueAt(row, COLUMN_DEPTNAME);
            this.jLbl_currentDeptName.setText(value.toString());

            value = this.jTable1.getValueAt(row, COLUMN_RESERVATION_DATE);
            this.jLbl_currentResDate.setText(value.toString());

            value = this.jTable1.getValueAt(row, COLUMN_BIRTH_DATE);
            this.jLbl_currentBirthDate.setText(value.toString());

            value = this.jTable1.getValueAt(row, COLUMN_REGI_DATE);
            this.jLbl_currentRegidate.setText(value.toString());

            value = this.jTable1.getValueAt(row, COLUMN_CUS_NAME);
            this.jTxt_CusName.setText( value.toString() );

            value = this.jTable1.getValueAt(row, COLUMN_CUS_PHONE);
            this.jTxt_CusPhone.setText( value.toString() );

        }
        else{
            JOptionPane.showMessageDialog(null, "데이터 값을 선택하세요.");
        }

    }//GEN-LAST:event_jBtn_ReadActionPerformed

    private void jBtn_ModifyDeptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_ModifyDeptActionPerformed

        
        int row = this.jTable1.getSelectedRow();
        int col = 0;
        
        Object value = "";
        
        // 선택된 값 일 때
        if ( row != -1 && col != -1 ){
            value = this.jTable1.getValueAt(row, col);
        }
                
        String query = "update hosp_reservation set dept_id = ? where id = ?";
    
        CreateConnection createConn = new CreateConnection(dbConn);
        
        Connection conn = null;
        String driverName = createConn.getOracleDriver();
        
        int i = 0;
        
        try {
            Class.forName(driverName);
            
            //System.out.println(createConn.getOracleUrl());
            conn = DriverManager.getConnection(createConn.getOracleUrl(), 
                    dbConn.getUsername(), dbConn.getPasswd());
            //System.out.println("성공");
            //System.out.println(query);
            
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "1" );
            pstmt.setString(2, this.jLbl_currentID.getText());
            
            int cnt = pstmt.executeUpdate();
            //jTable1.updateUI();
            
            JOptionPane.showMessageDialog(null, "수정이 완료되었습니다.");
            loadDeptTable();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservationStatusFrm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReservationStatusFrm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex){
            Logger.getLogger(ReservationStatusFrm.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            DbUtil.dbClose(rs, pstmt, conn);
        }
        
    }//GEN-LAST:event_jBtn_ModifyDeptActionPerformed

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
            java.util.logging.Logger.getLogger(ReservationStatusFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservationStatusFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservationStatusFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservationStatusFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservationStatusFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtn_ModifyDept;
    private javax.swing.JButton jBtn_Read;
    private javax.swing.JButton jBtn_SelectedRemove;
    private javax.swing.JButton jBtn_SelectedShow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLbl_CusDate;
    private javax.swing.JLabel jLbl_currentBirthDate;
    private javax.swing.JLabel jLbl_currentDeptName;
    private javax.swing.JLabel jLbl_currentID;
    private javax.swing.JLabel jLbl_currentRegidate;
    private javax.swing.JLabel jLbl_currentResDate;
    private javax.swing.JList<String> jList_Dept;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxt_CusName;
    private javax.swing.JTextField jTxt_CusPhone;
    // End of variables declaration//GEN-END:variables
    private Vector vecDept;
    
    private DbConn dbConn = new DbConn("hr", "123456", "localhost", "1521");
        
    private PreparedStatement pstmt = null;     
    private ResultSet rs = null;                // 결과값 반환
    
    // private String[] str = {"내과3", "내과1", "신경과"};
    private String[] colNames;  // 열 이름
    private DefaultTableModel model;            // 테이블 모델
    
    
    private final int COLUMN_ID = 0;                    // 열_일련번호
    private final int COLUMN_DEPTNAME = 2;              // 열_학과명
    private final int COLUMN_RESERVATION_DATE = 3;      // 열_예약일자
    private final int COLUMN_BIRTH_DATE = 4;            // 열_생년월일
    private final int COLUMN_REGI_DATE = 5;             // 열_등록일자
    private final int COLUMN_CUS_NAME = 6;              // 열_이름
    private final int COLUMN_CUS_PHONE = 7;             // 열_연락처
    
}
