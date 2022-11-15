/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.ChiTietSP;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import Repositories.ChiTietSanPhamRepository;
import Repositories.HoaDonCTRepository;
import Repositories.HoaDonRepository;
import Services.IHoaDonCtService;
import ViewModels.HoaDonCTResponse;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class HoaDonCTService implements IHoaDonCtService{

    private HoaDonCTRepository hdctRepo;
    private HoaDonRepository hdRepo;
    private ChiTietSanPhamRepository ctSpRepo;
    
    public HoaDonCTService() {
        this.hdctRepo = new HoaDonCTRepository();
        this.hdRepo = new HoaDonRepository();
        this.ctSpRepo = new ChiTietSanPhamRepository();
    }

    
    @Override
    public String pay(ArrayList<HoaDonCTResponse> list) {
        try {
            boolean check = true;
            check = hdRepo.updateTinhTrang(list.get(0).getIdHoaDon(), 1);
            for (HoaDonCTResponse item : list) {
                check = ctSpRepo.updateSoLuong(item.getSoLuongSP(), item.getIdChiTietSP());
            }
            for (HoaDonCTResponse item : list) {
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                ChiTietSP chiTietSP = new ChiTietSP();
                HoaDon hoaDon = new HoaDon();
                
                chiTietSP.setId(item.getIdChiTietSP());
                hoaDonChiTiet.setIdChiTietSP(chiTietSP);
                
                hoaDon.setId(item.getIdHoaDon());
                
                hoaDonChiTiet.setIdHoaDon(hoaDon);
                hoaDonChiTiet.setSoLuong(item.getSoLuongSP());
                hoaDonChiTiet.setDonGia(item.getDonGia());
                check = hdctRepo.save(hoaDonChiTiet);
            }
            if (check == false) {                
                return "Thanh toán thất bại";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Thanh toán thất bại";
        }
        return "Thanh toán thành công";
    }

    @Override
    public ArrayList<HoaDonCTResponse> search(String id) {
        return hdctRepo.search(id);
    }

    @Override
    public HoaDonCTResponse searchById(String idHD, String idCtsp) {
        return hdctRepo.searchById(idHD, idCtsp);
    }
    
}
