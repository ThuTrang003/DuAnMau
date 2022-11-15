/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.ChucVu;
import DomainModels.HoaDonChiTiet;
import Utilities.DBContext;
import ViewModels.HoaDonCTResponse;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class HoaDonCTRepository {

    public ArrayList<HoaDonCTResponse> search(String id) {
        ArrayList<HoaDonCTResponse> list = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String query = "select a.IdChiTietSP, a.IdHoaDon, c.Ma, c.Ten, a.SoLuong, a.DonGia from HoaDonChiTiet a join ChiTietSP b on a.IdChiTietSP = b.Id \n"
                    + "join SanPham c on b.IdSP = c.Id \n"
                    + "where a.IdHoaDon = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String idCTSP = rs.getString(1);
                String idHD = rs.getString(2);
                String maSP = rs.getString(3);
                String tenSP = rs.getString(4);
                int soLuong = rs.getInt(5);
                BigDecimal donGia = rs.getBigDecimal(6);

                HoaDonCTResponse hd = new HoaDonCTResponse(idCTSP, idHD, maSP, tenSP, soLuong, donGia);

                list.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public HoaDonCTResponse searchById(String idHD, String idCtsp) {
        HoaDonCTResponse hd = new HoaDonCTResponse();
        try {
            Connection conn = DBContext.getConnection();
            String query = "select IdHoaDon, IdChiTietSP, SoLuong, DonGia from HoaDonChiTiet where IdHoaDon = ? and IdChiTietSP = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, idHD);
            ps.setString(2, idCtsp);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String maSP = rs.getString(4);
                String tenSP = rs.getString(5);
                int soLuong = rs.getInt(6);
                BigDecimal donGia = rs.getBigDecimal(7);

                hd = new HoaDonCTResponse(idCtsp, idHD, maSP, tenSP, soLuong, donGia);

            }
            return hd;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }

    public boolean save(HoaDonChiTiet hoaDonChiTiet) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "insert into HoaDonChiTiet(IdHoaDon, IdChiTietSP, SoLuong, DonGia) values (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, hoaDonChiTiet.getIdHoaDon().getId());
            ps.setString(2, hoaDonChiTiet.getIdChiTietSP().getId());
            ps.setInt(3, hoaDonChiTiet.getSoLuong());
            ps.setBigDecimal(4, hoaDonChiTiet.getDonGia());
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
