/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DbContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.TaiKhoan;

/**
 *
 * @author bener
 */
public class TaiKhoanDao {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    public TaiKhoan DangNhap(String TenDangNhap,String MatKhau) throws SQLException{
        TaiKhoan kq=null;
        String sql="select * from TaiKhoan where TenDangNhap =? and MatKhau=?";
        conn=DbContext.getConnection();
        try{
            ps=conn.prepareStatement(sql);
            ps.setString(1,TenDangNhap);
            ps.setString(2,MatKhau);
            rs=ps.executeQuery();
            if(rs.next()){
                kq=new TaiKhoan(rs.getString(1),rs.getString(2));
            }
        }catch(Exception ex){
            System.out.println("loi"+ex.toString());
        }
        return kq;
    }

    public TaiKhoan kiemTraTonTai(String tendangnhap, String matkhau) {
        TaiKhoan kq =null;
        String sql = "select * from TaiKhoan where TenDangNhap=? and MatKhau=?";
        conn= DbContext.getConnection();
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1,tendangnhap);
            ps.setString(2,matkhau);
            rs= ps.executeQuery();
            if(rs.next()){
                kq= new TaiKhoan(rs.getString(1),rs.getString(2));
            }
        }catch(Exception ex){
            System.out.println("loi"+ex.toString());
        }
        return kq;
    }

    public boolean Update(TaiKhoan tk) {
        String sql="update taikhoan set matkhau=? where tendangnhap=?";
        conn= DbContext.getConnection();
        try{
            ps= conn.prepareStatement(sql);
            ps.setString(1, tk.getMatkhau());
            ps.setString(2,tk.getTendangnhap());
            int kq = ps.executeUpdate();
            if(kq>0){
                return true;
            }
        }catch (Exception ex){
            System.out.println("loi"+ex.toString());
        }
        return false;
    }
    public static void main(String[] args){
        TaiKhoanDao tkDao = new TaiKhoanDao();
        TaiKhoan tk = tkDao.kiemTraTonTai("quanly", "quanly123");
        if(tk!=null){
            System.out.println("Thành công");
        }else
        {
            System.out.println("Thất bại");
        }
    }
}
