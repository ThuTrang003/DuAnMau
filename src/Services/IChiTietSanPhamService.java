/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.ChiTietSP;
import ViewModels.QLChiTietSP;
import ViewModels.QLCuaHang;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public interface IChiTietSanPhamService {

    public void insert(QLChiTietSP qlCT);
    
    public void save(QLChiTietSP ctsp);

    public void update(String id, QLChiTietSP qlCT);

    public void delete(String id);

    public ArrayList<QLChiTietSP> getAll();
    
    public ArrayList<QLChiTietSP> search(int namBH);
}
