/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.HoaDon;
import ViewModels.HoaDonResponse;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public interface IHoaDonService {
    public void insert(HoaDon hd);
    
    public void update(String id, HoaDon hd);
    
    public void delete(String id);
    
    public ArrayList<HoaDonResponse> getAll();
    
    public ArrayList<HoaDonResponse> getListHD();
    
    public HoaDon creatBill();
    
    public ArrayList<HoaDonResponse> search(int tinhTrang);
}
