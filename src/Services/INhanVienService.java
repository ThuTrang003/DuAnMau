/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLNhanVien;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public interface INhanVienService {
    public void insert(QLNhanVien nv);
    
    public void update(String ma, QLNhanVien nv);
    
    public void delete(String ma);
    
    public ArrayList<QLNhanVien> getAll();
}
