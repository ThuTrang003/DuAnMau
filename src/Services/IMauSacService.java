/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLMauSac;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public interface IMauSacService {

    public void insert(QLMauSac qlms);

    public void update(String id, QLMauSac qlms);

    public void delete(String id);

    public ArrayList<QLMauSac> getAll();
}
