/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModels.ComboReponse;
import DomainModels.ComboModel;
import DomainModels.SanPhamModel;
import java.util.List;

/**
 *
 * @author Lee Tuan
 */
public interface ComboService {

    List<ComboModel> get_all();

    String add(ComboModel a);

    String update(ComboModel a,String id);

    String delete(ComboModel a);
    SanPhamModel getOne(String ten);

//    ComboReponse getById(String id);
}
