/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import DomainModels.HoaDonChiTietModel;
import Repository.HoaDonChiTietRepository;
import Service.ServiceHoaDonChiTiet;
import ViewModels.HoaDonChiTiet;
import java.util.List;

/**
 *
 * @author vietv
 */
public class HoaDonChiTietServiceIblm implements ServiceHoaDonChiTiet {

    private HoaDonChiTietRepository rp = new HoaDonChiTietRepository();

    @Override
    public List<HoaDonChiTiet> getAll() {
        return rp.getAll();
    }

    @Override
    public String add(HoaDonChiTietModel hd) {
        boolean add = rp.add(hd);
        if (add) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

    @Override
    public String update(HoaDonChiTietModel hd, String maHD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String delete(String idHD, String idSP) {
        boolean delete = rp.delete(idHD, idSP);
        if (delete) {
            return "Delete thành công";
        } else {
            return "Delete thất bại";
        }
    }

    @Override

    public List<HoaDonChiTiet> getAllviewGH(String id) {
        return rp.getAllviewGH(id);
    }

    @Override
    public HoaDonChiTiet getOne(String ma) {
        return rp.getOne(ma);
    }

    @Override
    public String deletehdct(String idhd) {
      boolean dele=rp.delete(idhd);
      if(dele){
          return "hủy thành công";
      }else{
          return "hủy thất bại";
      }
    }

    @Override
    public String thanhtoan(HoaDonChiTiet hdct) {
       return rp.thanhToan(hdct);
    }

    @Override
    public String deletehd(String ma) {
        boolean delete=rp.delete(ma);
    if (delete){
        
        return "Hủy thành công";
    }else{
        return "hủy thất bại";
    }
       
    }

}
