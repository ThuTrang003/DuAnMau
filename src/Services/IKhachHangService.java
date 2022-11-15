/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.KhachHang;
import ViewModels.QLKhachHang;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public interface IKhachHangService {

    public void insert(KhachHang kh);

    public void update(String id, KhachHang kh);

    public void delete(String id);

    public ArrayList<QLKhachHang> getAll();

}
