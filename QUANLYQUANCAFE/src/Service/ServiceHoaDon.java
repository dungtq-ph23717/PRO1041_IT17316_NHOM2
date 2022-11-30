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

    List<ViewModels.HoaDon> getAllTTViewHD(String id);

    HoaDon getOne(String ma);

    String add(HoaDonModel hd, String ma);

    String update(HoaDonModel hd, String maHD, String tinhTrang);

    String updateID(String id, String maHD);

    String delete(String maHD);

}
