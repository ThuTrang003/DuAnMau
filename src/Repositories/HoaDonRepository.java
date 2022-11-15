/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.HoaDon;
import Utilities.DBContext;
import ViewModels.HoaDonResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class HoaDonRepository {
    public ArrayList<HoaDonResponse> getListHD(){
        ArrayList<HoaDonResponse> lst = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String query = "select hd.Ma, NgayTao, TinhTrang, hd.Id from HoaDon as hd";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            while (rs.next()) { 
                String ma = rs.getString(1);
                Date ngayTao = rs.getDate(2);
                int tinhTrang = rs.getInt(3);
                String id = rs.getString(4);
                
                HoaDonResponse hd = new HoaDonResponse();
                hd.setMa(ma);
                hd.setNgayTao(ngayTao);
                hd.setTinhTrang(tinhTrang);
                hd.setId(id);
                
                lst.add(hd);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean updateTinhTrang(String id, int tinhTrang){
        
        try {
            Connection conn = DBContext.getConnection();
            String query = "UPDATE HoaDon SET tinhTrang = ? where Id = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, tinhTrang);
            ps.setString(2, id);
            
            if (ps.executeUpdate() < 1) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public HoaDon save(HoaDon hoaDon) {
        
        try {
            Connection conn = DBContext.getConnection();
            String query = "insert into HoaDon(Ma, NgayTao, TinhTrang) values (?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, hoaDon.getMa());
            java.sql.Date date = new java.sql.Date(hoaDon.getNgayTao().getTime());
            ps.setDate(2, date);
            ps.setInt(3, hoaDon.getTinhTrang());
            
            ps.execute();
            HoaDon hd = new HoaDon();
            hd.setId(hoaDon.getId());
            hd.setMa(hoaDon.getMa());
            hd.setNgayTao(hoaDon.getNgayTao());
            hd.setTinhTrang(hoaDon.getTinhTrang());
            return hd;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }  
    
    public ArrayList<HoaDonResponse> findByTinhTrang(int tinhTrang) {        
        ArrayList<HoaDonResponse> list = new ArrayList<>();
        try {            
            Connection conn = DBContext.getConnection();
            String query = "select Id, Ma, NgayTao, TinhTrang from HoaDon where TinhTrang = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, tinhTrang);
            
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) { 
                String ma = rs.getString(2);
                Date ngayTao = rs.getDate(3);
                String id = rs.getString(1);
                
                HoaDonResponse hd = new HoaDonResponse();
                hd.setMa(ma);
                hd.setNgayTao(ngayTao);
                hd.setTinhTrang(tinhTrang);
                hd.setId(id);
                
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
