/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.SanPham;
import Repositories.SanPhamRepository;
import Services.ISanPhamService;
import ViewModels.QLSanPham;
import ViewModels.SanPhamResponse;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class SanPhamService implements ISanPhamService{
    private SanPhamRepository spRepo;

    public SanPhamService() {
        this.spRepo = new SanPhamRepository();
    }

    @Override
    public void insert(QLSanPham qlSP) {
        this.spRepo.insert(new SanPham(qlSP.getId(), qlSP.getMa(), qlSP.getTen()));
    }

    @Override
    public void update(String id, QLSanPham qlSP) {
        this.spRepo.update(id, new SanPham(qlSP.getId(), qlSP.getMa(), qlSP.getTen()));
    }

    @Override
    public void delete(String id) {
        this.spRepo.delete(id);
    }

    @Override
    public ArrayList<QLSanPham> getAll() {
        ArrayList<QLSanPham> lst = new ArrayList<>();
        var lstSP = this.spRepo.getAll();
        for (SanPham x : lstSP) {
            lst.add(new QLSanPham(x.getId(), x.getMa(), x.getTen()));
        }
        return lst;
    }

    @Override
    public ArrayList<SanPhamResponse> getAllByName(String name) {
        return this.spRepo.getAllByName(name);
    }
    
}
