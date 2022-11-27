/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import Service.ComboService;
import ViewModels.ComboReponse;
import java.util.ArrayList;
import java.util.List;
import DomainModels.ComboModel;
import DomainModels.SanPhamModel;
import Repository.ComboRepository;

public class ComboServiceImp implements ComboService {

    private ComboRepository _ComboRepository = new ComboRepository();

    @Override
    public List<ComboModel> get_all() {

        return _ComboRepository.get_all();
    }

    @Override
    public String add(ComboModel a) {
        if(a.getMaCB().isEmpty()||a.getTenCB().isEmpty()||String.valueOf(a.getGiaBan()).isEmpty()){
            return "dữ liệu còn trống!";
    }
        ComboModel ma = _ComboRepository.checkTrung(a.getMaCB());
        if (ma != null) {
            return "Mã SP đã tồn tại!";
        }
        if (_ComboRepository.add_cb(a)) {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String delete(ComboModel a) {
        if (_ComboRepository.delete_cb(a)) {
            return "Xóa thành công";
        }
        return "Xóa thất bại";
    }

    @Override
    public String update(ComboModel a, String id) {
        boolean update = _ComboRepository.update_cb(a, id);
        if (update) {
            return "UPDATE THÀNH CÔNG";

        } else {
            return "UPDATE THẤT BẠI";
        }
    }

    @Override
    public SanPhamModel getOne(String ten) {
       return _ComboRepository.getOne(ten);
    }

   
}
