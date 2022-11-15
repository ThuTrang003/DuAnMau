/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.MauSac;
import DomainModels.SanPham;
import Utilities.DBContext;
import ViewModels.SanPhamResponse;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class SanPhamRepository {

    public void insert(SanPham sp) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "insert into SanPham(Ma, Ten) values (?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, sp.getMa());
            ps.setString(2, sp.getTen());

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(String id, SanPham sp) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "update SanPham set Ma = ?, Ten = ? where Id = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, sp.getMa());
            ps.setString(2, sp.getTen());
            ps.setString(3, id);

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "delete from SanPham where Id = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<SanPhamResponse> getAllByName(String name) {
        ArrayList<SanPhamResponse> lst = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String query = "Select ct.Id, sp.Ma, sp.Ten, ct.NamBH, ct.MoTa, ct.SoLuongTon, ct.GiaNhap, ct.GiaBan \n"
                    + "from SanPham sp join ChiTietSP ct on sp.Id = ct.IdSP where sp.Ten like '%" + name + "%'";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString(1);
                String maSP = rs.getString(2);
                String tenSP = rs.getString(3);
                int namBH = rs.getInt(4);
                String moTa = rs.getString(5);
                int SoLuongTon = rs.getInt(6);
                BigDecimal giaNhap = rs.getBigDecimal(7);
                BigDecimal giaBan = rs.getBigDecimal(8);

                SanPhamResponse sp = new SanPhamResponse(id, maSP, tenSP, namBH, moTa, SoLuongTon, giaNhap, giaBan);
                lst.add(sp);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<SanPham> getAll() {
        ArrayList<SanPham> lst = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String query = "select Id, Ma, Ten from SanPham";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);

                SanPham sp = new SanPham(id, ma, ten);
                lst.add(sp);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
