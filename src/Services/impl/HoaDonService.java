/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.HoaDon;
import Repositories.HoaDonRepository;
import Services.IHoaDonService;
import ViewModels.HoaDonResponse;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class HoaDonService implements IHoaDonService {

    private HoaDonRepository hdRepo;

    public HoaDonService() {
        this.hdRepo = new HoaDonRepository();
    }

    @Override
    public void insert(HoaDon hd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(String id, HoaDon hd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<HoaDonResponse> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<HoaDonResponse> getListHD() {
        return this.hdRepo.getListHD();
    }

    @Override
    public HoaDon creatBill() {
        double so = Math.random() * 1000000;
        int ma = (int) so;
        String maHd = "HD" + ma;
        HoaDon hoaDon = new HoaDon();
        hoaDon.setMa(maHd);
        hoaDon.setNgayTao(new Date(new java.util.Date().getTime()));
        hoaDon.setTinhTrang(0);
        
        HoaDon check = hdRepo.save(hoaDon);
        return check;
    }

    @Override
    public ArrayList<HoaDonResponse> search(int tinhTrang) {
        return hdRepo.findByTinhTrang(tinhTrang);
    }

}
