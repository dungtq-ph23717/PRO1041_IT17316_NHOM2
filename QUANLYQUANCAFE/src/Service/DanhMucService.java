/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModels.DanhMuc;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface DanhMucService {

    List<DanhMuc> getAll();

    DanhMuc getOne(String ma);
}
