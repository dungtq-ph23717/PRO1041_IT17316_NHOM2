/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;


import DomainModels.HoaDonModel;
import java.util.List;

/**
 *
 * @author vietv
 */
public interface ServiceHoaDon {

    List<ViewModels.HoaDon> getAll();

    String add(HoaDonModel hd);

    String update(HoaDonModel hd, String maHD);

    String delete(String maHD);

  
}
