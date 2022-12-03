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

    List<ViewModels.HoaDon> searchTheoTT(String tt);

    List<ViewModels.HoaDon> searchTheoTenSP(String tenSP);

    List<ViewModels.HoaDon> searchTheoMaHD(String maHD);

    List<ViewModels.HoaDon> searchTheoTenBan(String tenB);

    List<ViewModels.HoaDon> getAllTT();

    List<ViewModels.HoaDon> getAllTTViewHD(String id);

    List<ViewModels.HoaDon> getAllHD(String ma);

    HoaDon getOne(String ma);

    String add(HoaDonModel hd, String ma);

    String update(HoaDonModel hd, String maHD, String tinhTrang);

    String updateID(String id, String maHD);

    String delete(String maHD);

}
