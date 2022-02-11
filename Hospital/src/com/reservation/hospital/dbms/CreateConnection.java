/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reservation.hospital.dbms;

/**
 *
 * @author 정도윤(Doyun Jung)
 */
public class CreateConnection {
    
    private DbConn dbConn ;
    private String driverName;
    private String url ;
    
    public CreateConnection(){
        this.dbConn = null ;
        this.url = "";
    }
    
    public CreateConnection(DbConn dbConn){
        this.dbConn = dbConn;
        this.url = "";
    }

    public DbConn getDbConn() {
        return dbConn;
    }

    public String getUrl() {
        return url;
    }

    public void setDbConn(DbConn dbConn) {
        this.dbConn = dbConn;
    }
    
    public String getOracleDriver(){
        driverName = "oracle.jdbc.driver.OracleDriver";
        return driverName;
    }
    
    public String getOracleUrl(){
        
        String serverName = this.dbConn.getHostname();
        String serverPort = this.dbConn.getPort();
        String sid = this.dbConn.getSid();
        
        url = "jdbc:oracle:thin:@" + serverName;
        url = url + ":" + serverPort + ":" + sid;
        
        return url;
        
    }
    
}
