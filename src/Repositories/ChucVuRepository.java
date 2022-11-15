package Repositories;

import DomainModels.ChucVu;
import Utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ChucVuRepository {
    
    public void insert(ChucVu cv) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "insert into ChucVu(Ma, Ten) values (?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cv.getMa());
            ps.setString(2, cv.getTen());
            
            ps.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(String ma,ChucVu cv) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "update ChucVu set Ten = ? where Ma = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(2, cv.getMa());
            ps.setString(1, cv.getTen());
            
            ps.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(String ma) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "delete from ChucVu where Ma = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, ma);
            ps.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//    public ChucVu getById(String ma) {
//        this.cvRepo.insert(cv);
//    } 
    
    public ArrayList<ChucVu> getAll() {
        ArrayList<ChucVu> lst = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String query = "select Ma, Ten from ChucVu";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            while (rs.next()) { 
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                
                ChucVu cv = new ChucVu();
                cv.setMa(ma);
                cv.setTen(ten);
                lst.add(cv);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
