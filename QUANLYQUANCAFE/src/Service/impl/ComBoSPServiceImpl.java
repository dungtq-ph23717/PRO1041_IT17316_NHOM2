/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import DomainModels.ComboModel;
import DomainModels.Combo_SanPham;
import Repository.Combo_SanPhamRepository;
import Service.ComBoSPService;
import Service.ComboService;
import java.util.List;

/**
 *
 * @author hdo48
 */
public class ComBoSPServiceImpl implements ComBoSPService{
private Combo_SanPhamRepository combo_SanPhamRepository= new Combo_SanPhamRepository();

    @Override
    public String add(Combo_SanPham combo_SanPham) {
        boolean add=combo_SanPhamRepository.add(combo_SanPham);
        if(add){
            return "ADD THÀNH CÔNG SẢN PHẨM VÀO COMBO";
        }else{
            return "ADD THẤT BẠI SẢN PHẨM VÀO COMBO";
    }

    }

   
    
}
