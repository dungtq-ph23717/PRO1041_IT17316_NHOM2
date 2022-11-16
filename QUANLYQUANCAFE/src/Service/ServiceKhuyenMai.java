/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.KhuyenMaiModel;
import java.util.List;

/**
 *
 * @author vietv
 */
public interface ServiceKhuyenMai {

    List<ViewModels.KhuyenMai> getAll();

    String add(KhuyenMaiModel km);

    String update(KhuyenMaiModel km, String maKM);

    String delete(String maKM);

    List<ViewModels.KhuyenMai> searchTheoMaKM(String maKM);
}
