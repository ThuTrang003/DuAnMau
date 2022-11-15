package Repositories;

import DomainModels.ChucVu;
import DomainModels.CuaHang;
import Utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CuaHangRepository {
    public void insert(CuaHang ch) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "insert into CuaHang(Ma, Ten, DiaChi, ThanhPho, QuocGia) values (?, ?, ?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, ch.getMa());
            ps.setString(2, ch.getTen());
            ps.setString(3, ch.getDiaChi());
            ps.setString(4, ch.getThanhPho());
            ps.setString(5, ch.getQuocGia());
            
            ps.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(String ma, CuaHang ch) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "update CuaHang set Ten = ?, DiaChi = ?, ThanhPho = ?, QuocGia = ? where Ma = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(5, ch.getMa());
            ps.setString(1, ch.getTen());
            ps.setString(2, ch.getDiaChi());
            ps.setString(3, ch.getThanhPho());
            ps.setString(4, ch.getQuocGia());
            
            ps.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(String ma) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "delete from CuaHang where Ma = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, ma);
            
            ps.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<CuaHang> getAll() {
        ArrayList<CuaHang> lst = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String query = "select Ma, Ten, DiaChi, ThanhPho, QuocGia from CuaHang";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            while (rs.next()) { 
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                String diaChi = rs.getString(3);
                String thanhPho = rs.getString(4);
                String quocGia = rs.getString(5);
                
                CuaHang ch = new CuaHang("", ma, ten, diaChi, thanhPho, quocGia);
                lst.add(ch);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
