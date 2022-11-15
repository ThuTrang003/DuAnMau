/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.DongSP;
import Repositories.DongSPRepository;
import Services.IDongSPService;
import ViewModels.QLDongSP;
import java.util.ArrayList;

public class DongSPService implements IDongSPService{
    
    private DongSPRepository dSpRepo;

    public DongSPService() {
        this.dSpRepo = new DongSPRepository();
    }
    

    @Override
    public void insert(QLDongSP qldsp) {
        this.dSpRepo.insert(new DongSP(qldsp.getId(), qldsp.getMa(), qldsp.getTen()));
    }

    @Override
    public void update(String id, QLDongSP qldsp) {
        this.dSpRepo.update(id, new DongSP(qldsp.getId(), qldsp.getMa(), qldsp.getTen()));
    }

    @Override
    public void delete(String id) {
        this.dSpRepo.delete(id);
    }

    @Override
    public ArrayList<QLDongSP> getAll() {
        ArrayList<QLDongSP> lst = new ArrayList<>();
        var lstDongSP = this.dSpRepo.getAll();
        for (DongSP x : lstDongSP) {
            lst.add(new QLDongSP(x.getId(), x.getMa(), x.getTen()));
        }
        return lst;
    }
    
}
