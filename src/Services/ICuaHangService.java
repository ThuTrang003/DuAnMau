/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLCuaHang;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public interface ICuaHangService {
    public void insert(QLCuaHang cv);
    
    public void update(String ma, QLCuaHang cv);
    
    public void delete(String ma);
    
    public ArrayList<QLCuaHang> getAll();
}
