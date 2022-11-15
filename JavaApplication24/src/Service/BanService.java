/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.BanModel;
import ViewModels.Ban;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface BanService {

    List<Ban> getAll();

    Ban getOne(String ma);

    String add(BanModel ban);

    String update(BanModel ban, String ma);

    String delete(String ma);
}
