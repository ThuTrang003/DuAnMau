/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.ChiTietSP;
import DomainModels.ChucVu;
import DomainModels.DongSP;
import DomainModels.MauSac;
import DomainModels.NhaSanXuat;
import DomainModels.SanPham;
import Utilities.DBContext;
import ViewModels.QLChiTietSP;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class ChiTietSanPhamRepository {

    public void insert(ChiTietSP ctSP) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "insert into ChiTietSP(IdSP, IdNsx, IdMauSac, IdDongSP, NamBH, MoTa, SoLuongTon, GiaNhap, GiaBan) \n"
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, ctSP.getSanPham().getId());
            ps.setString(2, ctSP.getNhaSanXuat().getId());
            ps.setString(3, ctSP.getMauSac().getId());
            ps.setString(4, ctSP.getDongSP().getId());
            ps.setInt(5, ctSP.getNamBH());
            ps.setString(6, ctSP.getMoTa());
            ps.setInt(7, ctSP.getSoLuongTon());
            ps.setBigDecimal(8, ctSP.getGiaNhap());
            ps.setBigDecimal(9, ctSP.getGiaBan());

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(QLChiTietSP qlCT) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "insert into ChiTietSP(NamBH, MoTa, SoLuongTon, GiaNhap) \n"
                    + "values (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, qlCT.getNamBH());
            ps.setString(2, qlCT.getMoTa());
            ps.setInt(3, qlCT.getSoLuongTon());
            ps.setBigDecimal(4, qlCT.getGiaNhap());

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(String id, ChiTietSP ctSP) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "update ChiTietSP set IdSP = ?, IdNsx = ?, IdMauSac = ?, IdDongSP = ?, NamBH = ?, MoTa = ?, SoLuongTon = ?, GiaNhap = ?, GiaBan = ? where Id = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, ctSP.getSanPham().getId());
            ps.setString(2, ctSP.getNhaSanXuat().getId());
            ps.setString(3, ctSP.getMauSac().getId());
            ps.setString(4, ctSP.getDongSP().getId());
            ps.setInt(5, ctSP.getNamBH());
            ps.setString(6, ctSP.getMoTa());
            ps.setInt(7, ctSP.getSoLuongTon());
            ps.setBigDecimal(8, ctSP.getGiaNhap());
            ps.setBigDecimal(9, ctSP.getGiaBan());
            ps.setString(10, id);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update1(String id, ChiTietSP ctSP) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "update ChiTietSP set NamBH = ?, MoTa = ?, SoLuongTon = ?, GiaNhap = ? where Id = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, ctSP.getNamBH());
            ps.setString(2, ctSP.getMoTa());
            ps.setInt(3, ctSP.getSoLuongTon());
            ps.setBigDecimal(4, ctSP.getGiaNhap());
            ps.setString(5, id);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "delete from ChiTietSP where Id = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ChiTietSP> getAll() {
        ArrayList<ChiTietSP> lst = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String query = "select ct.Id, sp.Id, sp.Ten, nsx.Id, nsx.Ten, ms.Id, ms.Ten, dsp.Id, dsp.Ten, NamBH, MoTa, SoLuongTon, GiaNhap, GiaBan\n"
                    + "from ChiTietSP as ct join SanPham as sp on ct.IdSP = sp.Id\n"
                    + "	join NSX as nsx on ct.IdNsx = nsx.Id\n"
                    + "	join MauSac as ms on ct.IdMauSac = ms.Id\n"
                    + "	join DongSP as dsp on ct.IdDongSP = dsp.Id";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString(1);
                int namBH = rs.getInt(10);
                String moTa = rs.getString(11);
                int slTon = rs.getInt(12);
                BigDecimal giaNhap = rs.getBigDecimal(13);
                BigDecimal giaBan = rs.getBigDecimal(14);

                String idsp = rs.getString(2);
                String tenSP = rs.getString(3);

                String idNSX = rs.getString(4);
                String tenNSX = rs.getString(5);

                String idMS = rs.getString(6);
                String tenMS = rs.getString(7);

                String idDSP = rs.getString(8);
                String tenDSP = rs.getString(9);

                SanPham sp = new SanPham(idsp, "", tenSP);

                NhaSanXuat nsx = new NhaSanXuat(idNSX, "", tenNSX);

                MauSac ms = new MauSac(idMS, "", tenMS);

                DongSP dsp = new DongSP(idDSP, "", tenDSP);

                ChiTietSP ct = new ChiTietSP(id, sp, nsx, ms, dsp, namBH, moTa, slTon, giaNhap, giaBan);
                lst.add(ct);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateSoLuong(int soLuong, String id) {

        try {
            Connection conn = DBContext.getConnection();
            String query = "update ChiTietSP set SoLuongTon = SoLuongTon - ? where Id = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, soLuong);
            ps.setString(2, id);

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<QLChiTietSP> search(int namBH) {
        ArrayList<QLChiTietSP> lst = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String query = "select ct.Id, NamBH, MoTa, SoLuongTon, GiaNhap\n"
                    + " from ChiTietSP as ct where NamBH = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, namBH);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString(1);
                String moTa = rs.getString(3);
                int slTon = rs.getInt(4);
                BigDecimal giaNhap = rs.getBigDecimal(5);


                QLChiTietSP ct = new QLChiTietSP();
                ct.setId(id);
                ct.setNamBH(namBH);
                ct.setMoTa(moTa);
                ct.setSoLuongTon(slTon);
                ct.setGiaNhap(giaNhap);
                lst.add(ct);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<QLChiTietSP> getAll1() {
        ArrayList<QLChiTietSP> lst = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String query = "select ct.Id, NamBH, MoTa, SoLuongTon, GiaNhap\n"
                    + " from ChiTietSP as ct";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString(1);
                int namBH = rs.getInt(2);
                String moTa = rs.getString(3);
                int slTon = rs.getInt(4);
                BigDecimal giaNhap = rs.getBigDecimal(5);


                QLChiTietSP ct = new QLChiTietSP();
                ct.setId(id);
                ct.setNamBH(namBH);
                ct.setMoTa(moTa);
                ct.setSoLuongTon(slTon);
                ct.setGiaNhap(giaNhap);
                lst.add(ct);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
