/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLDongSP;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public interface IDongSPService {
    public void insert(QLDongSP qldsp);

    public void update(String id, QLDongSP qldsp);

    public void delete(String id);

    public ArrayList<QLDongSP> getAll();
}
