/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModels.Size;
import java.util.List;

/**
 *
 * @author ADMIN5
 */
public interface SizeService {

    List<Size> getAll();
    
    Size getOne(String ten);
}
