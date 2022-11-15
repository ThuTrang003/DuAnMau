/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.KhachHang;
import Repositories.KhachHangRepository;
import Services.IKhachHangService;
import ViewModels.QLKhachHang;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class KhachHangService implements IKhachHangService{

    private KhachHangRepository khRepo;
    public KhachHangService() {
        this.khRepo = new KhachHangRepository();
    }

    
    @Override
    public void insert(KhachHang kh) {
        this.khRepo.insert(kh);
    }

    @Override
    public void update(String id, KhachHang kh) {
        this.khRepo.update(id, kh);
    }

    @Override
    public void delete(String id) {
        this.khRepo.delete(id);
    }

    @Override
    public ArrayList<QLKhachHang> getAll() {
        ArrayList<QLKhachHang> lst = new ArrayList<>();
        var lstKhachHang = this.khRepo.getAll();
        for (KhachHang x : lstKhachHang) {
            lst.add(new QLKhachHang(x.getId(), x.getMa(), x.getTen(), x.getTendem(), x.getHo(), x.getNgaySinh(), x.getSdt(), x.getDiaChi(), x.getThanhPho(), x.getQuocGia(), x.getMatKhau()));
        }
        return lst;
    }
    
}
