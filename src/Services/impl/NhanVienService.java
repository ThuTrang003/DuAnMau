/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.NhanVien;
import Repositories.NhanVienRepository;
import Services.INhanVienService;
import ViewModels.QLNhanVien;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class NhanVienService implements INhanVienService{

    private NhanVienRepository nvRepo;
    public NhanVienService() {
        this.nvRepo = new NhanVienRepository();
    }

    @Override
    public void insert(QLNhanVien nv) {
        NhanVien nhanVien = new NhanVien("", nv.getMa(), nv.getTen(), nv.getTenDem(), nv.getHo(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getDiaChi(), nv.getSdt(), nv.getMatKhau(), nv.getChucVu(), nv.getCuaHang(), nv.getTrangThai());
        this.nvRepo.insert(nhanVien);
    }

    @Override
    public void update(String ma, QLNhanVien nv) {
        NhanVien nhanVien = new NhanVien("", nv.getMa(), nv.getTen(), nv.getTenDem(), nv.getHo(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getDiaChi(), nv.getSdt(), nv.getMatKhau(), nv.getChucVu(), nv.getCuaHang(), nv.getTrangThai());
        this.nvRepo.update(ma, nhanVien);
    }

    @Override
    public void delete(String ma) {
        this.nvRepo.delete(ma);
    }

    @Override
    public ArrayList<QLNhanVien> getAll() {
        ArrayList<QLNhanVien> lst = new ArrayList<>();
        var lstNhanVien = this.nvRepo.getAll();
        for (NhanVien x : lstNhanVien) {
            lst.add(new QLNhanVien(x.getMa(), x.getTen(), x.getTenDem(), x.getHo(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getMatKhau(), x.getChucVu(), x.getCuaHang(), x.getTrangThai()));
        }
        return lst;
    }
    
}
