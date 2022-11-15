/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.CuaHang;
import DomainModels.DongSP;
import Utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class DongSPRepository {
    public void insert(DongSP dSP) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "insert into DongSP(Ma, Ten) values (?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, dSP.getMa());
            ps.setString(2, dSP.getTen());
            
            ps.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(String id, DongSP dSP) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "update DongSP set Ma = ?, Ten = ? where Id = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, dSP.getMa());
            ps.setString(2, dSP.getTen());
            ps.setString(3, id);
            
            ps.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(String id) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "delete from DongSP where id = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);
            
            ps.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<DongSP> getAll() {
        ArrayList<DongSP> lst = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String query = "select Id, Ma, Ten from DongSP";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            while (rs.next()) { 
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                
                DongSP dSP = new DongSP(id, ma, ten);
                lst.add(dSP);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
