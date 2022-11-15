/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModels.ComboReponse;
import DomainModels.ComboModel;
import java.util.List;
/**
 *
 * @author Lee Tuan
 */
public interface ComboService {
     List<ComboReponse>get_all();
    String add(ComboModel a);
    String update(ComboModel a);
    String delete(ComboModel a);   
    ComboReponse getById(String id);
}
