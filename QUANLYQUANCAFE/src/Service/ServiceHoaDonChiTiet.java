/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.HoaDonChiTietModel;
import java.util.List;

/**
 *
 * @author vietv
 */
public interface ServiceHoaDonChiTiet {

    List<ViewModels.HoaDonChiTiet> getAll();

    String add(HoaDonChiTietModel hd);

    String update(HoaDonChiTietModel hd, String maHD);

    String delete(String idHD, String idSP);

}
