/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.HoaDonChiTietModel;
import ViewModels.HoaDonChiTiet;
import java.util.List;

/**
 *
 * @author vietv
 */
public interface ServiceHoaDonChiTiet {

    List<ViewModels.HoaDonChiTiet> getAll();

    List<ViewModels.HoaDonChiTiet> getAllviewGH(String id);

    HoaDonChiTiet getOne(String ma);

    String add(HoaDonChiTietModel hd);

    String update(HoaDonChiTietModel hd, String maHD);

    String delete(String idHD, String idSP);
    String deletehdct(String idhd);
    String thanhtoan(HoaDonChiTiet hdct);
    String deletehd(String ma);
}
