/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLSanPham;
import ViewModels.SanPhamResponse;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public interface ISanPhamService {
    
    public void insert(QLSanPham qlSP);

    public void update(String id, QLSanPham qlSP);

    public void delete(String id);

    public ArrayList<QLSanPham> getAll();
    
    public ArrayList<SanPhamResponse> getAllByName(String name);
}
