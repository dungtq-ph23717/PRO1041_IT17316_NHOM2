/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.SizeModels;
import ViewModels.Size;
import java.util.List;

/**
 *
 * @author vietv
 */
public interface SizeService {

    List<Size> getAll();

    String add(SizeModels s);

    String update(SizeModels s, String idS);

    String delete(String idS);
}
