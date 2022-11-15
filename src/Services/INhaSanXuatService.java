/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLNhaSanXuat;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public interface INhaSanXuatService {
    public void insert(QLNhaSanXuat nsx);
    
    public void update(String id, QLNhaSanXuat nsx);
    
    public void delete(String id);
    
    public ArrayList<QLNhaSanXuat> getALl();
}
