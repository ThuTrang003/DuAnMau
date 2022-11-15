/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.MauSac;
import Repositories.MauSacRepository;
import Services.IMauSacService;
import ViewModels.QLMauSac;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class MauSacService implements IMauSacService{
    
    private MauSacRepository msRepo;

    public MauSacService() {
        this.msRepo = new MauSacRepository();
    }

    @Override
    public void insert(QLMauSac qlms) {
        this.msRepo.insert(new MauSac(qlms.getId(), qlms.getMa(), qlms.getTen()));
    }

    @Override
    public void update(String id, QLMauSac qlms) {
        this.msRepo.update(id, new MauSac(qlms.getId(), qlms.getMa(), qlms.getTen()));
    }

    @Override
    public void delete(String id) {
        this.msRepo.delete(id);
    }

    @Override
    public ArrayList<QLMauSac> getAll() {
        ArrayList<QLMauSac> lst = new ArrayList<>();
        var lstMauSac = this.msRepo.getAll();
        for (MauSac x : lstMauSac) {
            lst.add(new QLMauSac(x.getId(), x.getMa(), x.getTen()));
        }
        return lst;
    }
    
}
