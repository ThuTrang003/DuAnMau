/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.ChucVu;
import ViewModels.QLCHucVu;
import java.util.ArrayList;

public interface IChucVuService {
    public void insert(QLCHucVu cv);
    
    public void update(String ma, QLCHucVu cv);
    
    public void delete(String ma);
    
    public ArrayList<QLCHucVu> getAll();
}
