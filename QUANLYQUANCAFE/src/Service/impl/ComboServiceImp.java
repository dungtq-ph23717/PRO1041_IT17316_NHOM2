/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import Service.ComboService;
import ViewModels.ComboReponse;
import java.util.ArrayList;
import java.util.List;
import DomainModels.Combo;
import Repository.ComboRepository;
/**
 *
 * @author Lee Tuan
 */
public class ComboServiceImp implements ComboService{
    
        private ComboRepository _ComboRepository=new ComboRepository();
        
        
           @Override
    public List<ComboReponse> get_all() {
        return _ComboRepository.get_all();
    }

    @Override
    public String add(Combo a) {
        if (_ComboRepository.add_cb(a)) {
            return "Thêm thành công";
        }return "Thêm thất bại";
    }

    @Override
    public String update(Combo a) {
       if (_ComboRepository.update_cb(a)) {
            return "Sửa thành công";
        }return "Sửa thất bại";
    }

    @Override
    public String delete(Combo a) {
         if (_ComboRepository.delete_cb(a)) {
            return "Xóa thành công";
        }return "Xóa thất bại";
    }

    @Override
    public ComboReponse getById(String id) {
        for (ComboReponse o : _ComboRepository.get_all()) {
            if (o.getId().equals(id)) {
                return o;
            }
        }
        return null;
    }
}
