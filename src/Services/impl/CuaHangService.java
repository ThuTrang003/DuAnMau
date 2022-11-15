/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.CuaHang;
import Repositories.CuaHangRepository;
import Services.ICuaHangService;
import ViewModels.QLCuaHang;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class CuaHangService implements ICuaHangService{

    private CuaHangRepository chRepo;
    public CuaHangService() {
        this.chRepo = new CuaHangRepository();
    }

    @Override
    public void insert(QLCuaHang cv) {
        this.chRepo.insert(new CuaHang("", cv.getMa(), cv.getTen(), cv.getDiaChi(), cv.getThanhPho(), cv.getQuocGia()));
    }

    @Override
    public void update(String ma, QLCuaHang cv) {
        this.chRepo.update(ma, new CuaHang("", cv.getMa(), cv.getTen(), cv.getDiaChi(), cv.getThanhPho(), cv.getQuocGia()));
    }

    @Override
    public void delete(String ma) {
        this.chRepo.delete(ma);
    }

    @Override
    public ArrayList<QLCuaHang> getAll() {
        ArrayList<QLCuaHang> lst = new ArrayList<>();
        var lstCuaHang = this.chRepo.getAll();
        for (CuaHang x : lstCuaHang) {
            lst.add(new QLCuaHang(x.getMa(), x.getTen(), x.getDiaChi(), x.getThanhPho(), x.getQuocGia()));
        }
        return lst;
    }
    
}
