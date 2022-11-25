/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import DomainModels.NhanVienModel;
import Repository.NhanVienRepository;
import Service.NhanVienService;
import ViewModels.NhanVienViewModel;
import java.util.List;

/**
 *
 * @author hdo48
 */
public class NhanVienServiceImpl implements NhanVienService {

    private NhanVienRepository nhanVienRepository = new NhanVienRepository();

    @Override
    public List<NhanVienViewModel> getAll() {
        return nhanVienRepository.getAll();
    }

    @Override
    public String add(NhanVienModel nhanVien) {
        if(nhanVien.getMaNV().isEmpty()||nhanVien.getDiaChi().isEmpty()||nhanVien.getNgaySinh().isEmpty()||nhanVien.getSDT().isEmpty()||nhanVien.getTenNV().isEmpty()){
            return "dữ liệu còn trống !";
        }else{
             boolean add = nhanVienRepository.add(nhanVien);
        if (add) {
            return "ADD THÀNH CÔNG";
        } else {
            return "ADD THẤT BẠI";
        }
        }
       
    }

  

    @Override
    public String update(NhanVienModel nhanVien, String id) {
        boolean update = nhanVienRepository.update(nhanVien, id);

        if (update) {
            return "UPDATE THÀNH CÔNG";
        } else {
            return "UPDATE THẤT BẠI";
        }
    }

    @Override
    public List<NhanVienViewModel> getTimkiem(String ma) {
        List<NhanVienViewModel> listtk = nhanVienRepository.timkiem(ma);
    return listtk;
    }

   


    @Override
    public String deleteTT(String id) {
        boolean delete=nhanVienRepository.DELETETt(id);
       if(delete){
           return "DELETE THÀNH CÔNG";
       }else{
           return "DELETE THẤT BẠI";
       }
    }

    @Override
    public List<NhanVienViewModel> locChucVu(String ten) {
       List<NhanVienViewModel> listchucvu=nhanVienRepository.locCHucvu(ten);
       return listchucvu;
    }

    
}
