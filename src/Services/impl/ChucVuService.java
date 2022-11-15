/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModels.ChucVu;
import Repositories.ChucVuRepository;
import Services.IChucVuService;
import ViewModels.QLCHucVu;
import java.util.ArrayList;

public class ChucVuService implements IChucVuService {

    private ChucVuRepository cvRepo;

    public ChucVuService() {
        this.cvRepo = new ChucVuRepository();
    }

    @Override
    public void insert(QLCHucVu cv) {
        ChucVu chucVu = new ChucVu();
        chucVu.setMa(cv.getMa());
        chucVu.setTen(cv.getTen());
        cvRepo.insert(chucVu);
    }

    @Override
    public void update(String ma, QLCHucVu cv) {
        ChucVu chucVu = new ChucVu();
        chucVu.setMa(cv.getMa());
        chucVu.setTen(cv.getTen());
        cvRepo.update(ma, chucVu);
    }

    @Override
    public void delete(String ma) {
        this.cvRepo.delete(ma);
    }

    @Override
    public ArrayList<QLCHucVu> getAll() {
        ArrayList<QLCHucVu> lstQLChucVu = new ArrayList<>();
        var chucVu = cvRepo.getAll();
        for (ChucVu x : chucVu) {
            lstQLChucVu.add(new QLCHucVu(x.getMa(), x.getTen()));
        }
        return lstQLChucVu;
    }
}
