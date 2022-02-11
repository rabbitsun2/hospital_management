/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reservation.hospital.dbms;

/**
 *
 * @author 정도윤(Doyun Jung)
 */
public class DbConn {
    
    private String username;
    private String passwd;
    private String hostname;
    private String port;
    private String sid;

    public DbConn(){
        this.username = "";
        this.passwd = "";
        this.hostname = "localhost";
        this.port = "";
        this.sid = "";
    }
    
    public DbConn(String username, String passwd, String sid){
        this.username = username;
        this.passwd = passwd;
        this.sid = sid;
    }
    
    public DbConn(String username, String passwd,  String hostname, String port){
        this.username = username;
        this.passwd = passwd;
        this.hostname = hostname;
        this.port = port;
    }
    
    private void setAccount(String username, String passwd){
        this.username = username;
        this.passwd = passwd;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getHostname() {
        return hostname;
    }
    
    public String getPort() {
        return port;
    }

    public String getSid() {
        return sid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
    
    public void setPort(String port) {
        this.port = port;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
    
}
