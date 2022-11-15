/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModels.ComboReponse;
import DomainModels.Combo;
import java.util.List;
/**
 *
 * @author Lee Tuan
 */
public interface ComboService {
     List<ComboReponse>get_all();
    String add(Combo a);
    String update(Combo a);
    String delete(Combo a);   
    ComboReponse getById(String id);
}
