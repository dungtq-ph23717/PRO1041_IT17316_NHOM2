/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.HoaDonChiTietModel;
import DomainModels.HoaDonModel;
import ViewModels.HoaDon;
import java.util.List;

/**
 *
 * @author vietv
 */
public interface ServiceHoaDon {

    List<ViewModels.HoaDon> getAll();

    List<ViewModels.HoaDon> getAllTT();

    HoaDon getOne(String ma);

    String add(HoaDonModel hd, HoaDonChiTietModel hdct);

    String update(HoaDonModel hd, HoaDonChiTietModel hdct, String maHD);


    String delete(String maHD);
   

}
