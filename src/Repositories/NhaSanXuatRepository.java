/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.NhaSanXuat;
import Utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class NhaSanXuatRepository {
    
    public void insert(NhaSanXuat nsx) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "insert into NSX(Ma, Ten) values (?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, nsx.getMa());
            ps.setString(2, nsx.getTen());
            
            ps.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(String id, NhaSanXuat nsx) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "update NSX set Ma = ?, Ten = ? where id = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, nsx.getMa());
            ps.setString(2, nsx.getTen());
            ps.setString(3, id);
            
            ps.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(String id) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "delete from NSX where id = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);
            
            ps.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<NhaSanXuat> getALl() {
        ArrayList<NhaSanXuat> lst = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String query = "select Id, Ma, Ten from NSX ";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                
                NhaSanXuat nsx = new NhaSanXuat(id, ma, ten);
                lst.add(nsx);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
