/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.SanPhamModel;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface SanPhamService {

    List<ViewModels.SanPham> getAll();

    String add(SanPhamModel sp);

    String delete(String ma);

    String update(SanPhamModel sp, String ma);
    
     List<ViewModels.SanPham> search(String ma);
}
