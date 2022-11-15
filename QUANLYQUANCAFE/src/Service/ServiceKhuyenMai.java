/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.KhuyenMaiModel;
import ViewModels.KhuyenMai;
import java.util.List;

/**
 *
 * @author vietv
 */
public interface ServiceKhuyenMai {

    List<ViewModels.KhuyenMai> getAll();

    boolean add(KhuyenMaiModel km);

    boolean update(KhuyenMaiModel km, String maKM);

    List<ViewModels.KhuyenMai> searchTheoTenKM(String tenKM);
}
