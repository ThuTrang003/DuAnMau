/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.HoaDonCTResponse;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public interface IHoaDonCtService {
    
    ArrayList<HoaDonCTResponse> search(String id);
    
    String pay(ArrayList<HoaDonCTResponse> list);
    
    HoaDonCTResponse searchById(String idHD, String idCtsp);
}
