/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author bener
 */
public class TaiKhoan {
    private String tenDN;
    private String MK;

    public TaiKhoan() {
    }

    public TaiKhoan(String tenDN, String MK) {
        this.tenDN = tenDN;
        this.MK = MK;
    }

    public String getTendangnhap() {
        return tenDN;
    }

    public void setTendangnhap(String tenDN) {
        this.tenDN = tenDN;
    }

    public String getMatkhau() {
        return MK;
    }

    public void setMatkhau(String MK) {
        this.MK = MK;
    }
    
    @Override
    public String toString(){
        return "TaiKhoan{" + "ten\u0110N=" + tenDN + ", MK=" + MK + '}';
    }

    public void setMatKhau(String newpass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
