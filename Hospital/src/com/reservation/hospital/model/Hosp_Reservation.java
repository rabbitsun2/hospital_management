/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reservation.hospital.model;

import java.sql.Date;

/**
 *
 * @author 정도윤(Doyun Jung)
 */
public class Hosp_Reservation {
    
    private int id;
    private int dept_id;
    private Date res_date;
    private Date birth_date;
    private Date regi_date;
    private String cus_name;

    public int getId() {
        return id;
    }

    public int getDept_id() {
        return dept_id;
    }

    public Date getRes_date() {
        return res_date;
    }

    public Date getBirth_date() {
        return birth_date;
    }
    
    public Date getRegi_date() {
        return regi_date;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public void setRes_date(Date res_date) {
        this.res_date = res_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public void setRegi_date(Date regi_date) {
        this.regi_date = regi_date;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }
    
}
