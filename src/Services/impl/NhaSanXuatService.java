/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.CuaHang;
import DomainModels.NhaSanXuat;
import Repositories.NhaSanXuatRepository;
import Services.INhaSanXuatService;
import ViewModels.QLCuaHang;
import ViewModels.QLNhaSanXuat;
import java.util.ArrayList;

public class NhaSanXuatService implements INhaSanXuatService{

    private NhaSanXuatRepository nsxRepo;

    public NhaSanXuatService() {
        this.nsxRepo = new NhaSanXuatRepository();
    }
    
    @Override
    public void insert(QLNhaSanXuat nsx) {
        this.nsxRepo.insert(new NhaSanXuat(nsx.getId(), nsx.getMa(), nsx.getTen()));
    }

    @Override
    public void update(String id, QLNhaSanXuat nsx) {
        this.nsxRepo.update(id, new NhaSanXuat(nsx.getId(), nsx.getMa(), nsx.getTen()));
    }

    @Override
    public void delete(String id) {
        this.nsxRepo.delete(id);
    }

    @Override
    public ArrayList<QLNhaSanXuat> getALl() {
        ArrayList<QLNhaSanXuat> lst = new ArrayList<>();
        var lstNSX = this.nsxRepo.getALl();
        for (NhaSanXuat x : lstNSX) {
            lst.add(new QLNhaSanXuat(x.getId(), x.getMa(), x.getTen()));
        }
        return lst;
    }
    
}
