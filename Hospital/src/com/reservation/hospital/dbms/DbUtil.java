/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reservation.hospital.dbms;

import java.sql.*;

/**
 *
 * @author 정도윤(Doyun Jung)
 */
public class DbUtil {
        
    // DB 연결 종료
    public static void dbClose(Statement st, ResultSet rs, PreparedStatement ps, Connection conn) {
        
        try {
            if (st != null)
                st.close();
            if (rs != null)
                dbClose(rs, ps, conn);
            if (ps != null)
                dbClose(ps, conn);
            if (conn != null)
                dbClose(conn);
                
        } catch (Exception e) {
            System.out.println(e + "=> 연결종료 실패");
        }
    }
    
    // DB 연결 종료
    public static void dbClose(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            if (rs!= null)
                rs.close();
            if (ps != null)
                dbClose(ps, conn);
            if (conn != null)
                dbClose(conn);
        } catch (Exception e) {
            System.out.println(e + "=> 연결종료 실패");
        }
        
    }
    
    // DB 연결 종료
    public static void dbClose(PreparedStatement ps, Connection conn) {
        try {
            if (ps != null)
                ps.close();
            if (conn != null)
                dbClose(conn);
        } catch (Exception e) {
            System.out.println(e + "=> 연결종료 실패");
        }
        
    }
    
    // DB 연결 종료
    public static void dbClose(Connection conn) {
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            System.out.println(e + "=> 연결종료 실패");
        }
        
    }
    
}
