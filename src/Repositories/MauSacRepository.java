/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.CuaHang;
import DomainModels.MauSac;
import Utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class MauSacRepository {
    public void insert(MauSac ms) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "insert into MauSac(Ma, Ten) values (?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, ms.getMa());
            ps.setString(2, ms.getTen());
            
            ps.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(String id, MauSac ms) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "update MauSac set Ma = ?, Ten = ? where Id = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, ms.getMa());
            ps.setString(2, ms.getTen());
            ps.setString(3, id);
            
            ps.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(String id) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "delete from MauSac where Id = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);
            
            ps.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<MauSac> getAll() {
        ArrayList<MauSac> lst = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String query = "select Id, Ma, Ten from MauSac";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            while (rs.next()) { 
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                
                MauSac ms = new MauSac(id, ma, ten);
                lst.add(ms);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
