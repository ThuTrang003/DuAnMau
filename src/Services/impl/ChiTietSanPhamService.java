/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.ChiTietSP;
import Repositories.ChiTietSanPhamRepository;
import Services.IChiTietSanPhamService;
import ViewModels.QLChiTietSP;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class ChiTietSanPhamService implements IChiTietSanPhamService{

    private ChiTietSanPhamRepository ctRepo;
    public ChiTietSanPhamService() {
        this.ctRepo = new ChiTietSanPhamRepository();
    }

    @Override
    public void insert(QLChiTietSP qlCT) {
        this.ctRepo.insert(new ChiTietSP(qlCT.getId(), qlCT.getSanPham(), qlCT.getNhaSanXuat(), qlCT.getMauSac(), qlCT.getDongSP(), qlCT.getNamBH(), qlCT.getMoTa(), qlCT.getSoLuongTon(), qlCT.getGiaNhap(), qlCT.getGiaBan()));
    }

    @Override
    public void update(String id, QLChiTietSP qlCT) {
        this.ctRepo.update(id, new ChiTietSP(qlCT.getId(), qlCT.getSanPham(), qlCT.getNhaSanXuat(), qlCT.getMauSac(), qlCT.getDongSP(), qlCT.getNamBH(), qlCT.getMoTa(), qlCT.getSoLuongTon(), qlCT.getGiaNhap(), qlCT.getGiaBan()));
    }

    @Override
    public void delete(String id) {
        this.ctRepo.delete(id);
    }

    @Override
    public ArrayList<QLChiTietSP> getAll() {
        ArrayList<QLChiTietSP> lst = new ArrayList<>();
        var lstCtsp = this.ctRepo.getAll();
        for (ChiTietSP x : lstCtsp) {
            lst.add(new QLChiTietSP(x.getId(), x.getSanPham(), x.getNhaSanXuat(), x.getMauSac(), x.getDongSP(), x.getNamBH(), x.getMoTa(), x.getSoLuongTon(), x.getGiaNhap(), x.getGiaBan()));
        }
        return lst;
    }

    @Override
    public void save(QLChiTietSP ctsp) {
        this.ctRepo.save(ctsp);
    }

    @Override
    public ArrayList<QLChiTietSP> search(int namBH) {
        return this.ctRepo.search(namBH);
    }
    
    public ArrayList<QLChiTietSP> getAll1() {
        return this.ctRepo.getAll1();
    }
    
    public void update1(String id, QLChiTietSP qlCT) {
        this.ctRepo.update1(id, new ChiTietSP(qlCT.getId(), qlCT.getSanPham(), qlCT.getNhaSanXuat(), qlCT.getMauSac(), qlCT.getDongSP(), qlCT.getNamBH(), qlCT.getMoTa(), qlCT.getSoLuongTon(), qlCT.getGiaNhap(), qlCT.getGiaBan()));
    }
}
