/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.ChucVu;
import DomainModels.CuaHang;
import DomainModels.NhanVien;
import Utilities.DBContext;
import ViewModels.QLNhanVien;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class NhanVienRepository {

    public void insert(NhanVien nv) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "insert into NhanVien(Ma, Ten, TenDem, Ho, GioiTinh, NgaySinh, DiaChi, Sdt, MatKhau, IdCH, IdCV, TrangThai) \n"
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, nv.getMa());
            ps.setString(2, nv.getTen());
            ps.setString(3, nv.getTenDem());
            ps.setString(4, nv.getHo());
            ps.setString(5, nv.getGioiTinh());
            
            java.sql.Date date = new java.sql.Date(nv.getNgaySinh().getTime());
            ps.setDate(6, date);
            
            ps.setString(7, nv.getDiaChi());
            ps.setString(8, nv.getSdt());
            ps.setString(9, nv.getMatKhau());

            String idCH = null;
            if (nv.getCuaHang() != null) {
                idCH = nv.getCuaHang().getId();
            }
            ps.setString(10, idCH);
            String idCV = null;
            if (nv.getChucVu() != null) {
                idCH = nv.getChucVu().getId();
            }
            ps.setString(11, idCV);
            ps.setInt(12, nv.getTrangThai());

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(String ma, NhanVien nv) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "update NhanVien set Ten = ?, TenDem = ?, Ho = ?, GioiTinh = ?, NgaySinh = ?, DiaChi = ?, Sdt = ?, MatKhau = ?, IdCH = ?, IdCV = ?, TrangThai = ? where Ma = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(12, ma);
            ps.setString(1, nv.getTen());
            ps.setString(2, nv.getTenDem());
            ps.setString(3, nv.getHo());
            ps.setString(4, nv.getGioiTinh());
            java.sql.Date date = (java.sql.Date) new Date(nv.getNgaySinh().getTime());
            ps.setDate(5, date);
            ps.setString(6, nv.getDiaChi());
            ps.setString(7, nv.getSdt());
            ps.setString(8, nv.getMatKhau());
            ps.setString(9, nv.getCuaHang().getId());
            ps.setString(10, nv.getChucVu().getId());
            ps.setInt(11, nv.getTrangThai());

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String ma) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "delete from NhanVien where Ma = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, ma);

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<NhanVien> getAll() {
        ArrayList<NhanVien> lst = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String query = "select NhanVien.Ma, NhanVien.Ten, TenDem, Ho, GioiTinh, NgaySinh, NhanVien.DiaChi, Sdt, MatKhau,\n"
                    + "       ChucVu.Ten as ten_chuc_vu, CuaHang.Ten as ten_cua_hang, TrangThai\n"
                    + "       from NhanVien left join ChucVu on ChucVu.Id = NhanVien.IdCV\n"
                    + "                    left join CuaHang on CuaHang.Id = NhanVien.IdCH";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                String tendem = rs.getString(3);
                String ho = rs.getString(4);
                String gioiTinh = rs.getString(5);
                Date ngaySinh = rs.getDate(6);
                String diaChi = rs.getString(7);
                String sdt = rs.getString(8);
                String matKhau = rs.getString(9);
                String CH = rs.getString(10);
                String CV = rs.getString(11);
                int trangThai = rs.getInt(12);
                
                ChucVu cv = new ChucVu("", "", CV);
                CuaHang ch = new CuaHang("", "", CH, "", "", "");

                NhanVien nv = new NhanVien("", ma, ten, tendem, ho, gioiTinh, ngaySinh, diaChi, sdt, matKhau, cv, ch, trangThai);
                lst.add(nv);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
