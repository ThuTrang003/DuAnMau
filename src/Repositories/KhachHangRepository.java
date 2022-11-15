/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.KhachHang;
import Utilities.DBContext;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class KhachHangRepository {

    public void insert(KhachHang kh) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "insert into KhachHang(Ma, Ten, TenDem, Ho, NgaySinh, Sdt, DiaChi, ThanhPho, QuocGia, MatKhau) \n"
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, kh.getMa());
            ps.setString(2, kh.getTen());
            ps.setString(3, kh.getTendem());
            ps.setString(4, kh.getHo());
            java.sql.Date date = new java.sql.Date(kh.getNgaySinh().getTime());
            ps.setDate(5, date);
            ps.setString(6, kh.getSdt());
            ps.setString(7, kh.getDiaChi());
            ps.setString(8, kh.getThanhPho());
            ps.setString(9, kh.getQuocGia());
            ps.setString(10, kh.getMatKhau());

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(String id, KhachHang kh) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "update KhachHang set Ma= ?, Ten = ?, TenDem = ?, Ho = ?, NgaySinh = ?, Sdt = ?, DiaChi = ?, ThanhPho = ?, QuocGia = ?, MatKhau = ? where Id = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, kh.getMa());
            ps.setString(2, kh.getTen());
            ps.setString(3, kh.getTendem());
            ps.setString(4, kh.getHo());
            java.sql.Date date = new java.sql.Date(kh.getNgaySinh().getTime());
            ps.setDate(5, date);
            ps.setString(6, kh.getSdt());
            ps.setString(7, kh.getDiaChi());
            ps.setString(8, kh.getThanhPho());
            ps.setString(9, kh.getQuocGia());
            ps.setString(10, kh.getMatKhau());
            ps.setString(11, id);

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "delete from KhachHang where id = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<KhachHang> getAll() {
        ArrayList<KhachHang> lst = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String query = "select * from KhachHang";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                String tenDem = rs.getString(4);
                String ho = rs.getString(5);
                Date ngaySinh = rs.getDate(6);
                String sdt = rs.getString(7);
                String diaChi = rs.getString(8);
                String thanhPho = rs.getString(9);
                String quocGia = rs.getString(10);
                String matKhau = rs.getString(10);

                KhachHang kh = new KhachHang(id, ma, ten, tenDem, ho, ngaySinh, sdt, diaChi, thanhPho, quocGia, matKhau);
                lst.add(kh);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
