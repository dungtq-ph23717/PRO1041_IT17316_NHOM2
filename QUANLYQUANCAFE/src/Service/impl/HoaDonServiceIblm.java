/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import DomainModels.HoaDonChiTietModel;
import DomainModels.HoaDonModel;
import Repository.HoaDonRepository;
import Service.ServiceHoaDon;
import java.util.List;
import ViewModels.HoaDon;

/**
 *
 * @author vietv
 */
public class HoaDonServiceIblm implements ServiceHoaDon {

    private HoaDonRepository rps = new HoaDonRepository();

//    @Override
//    public List<HoaDon> getAll() {
//        return rps.getAll();
//    }

    @Override
    public String delete(String maHD) {
        boolean delete = rps.delete(maHD);
        if (delete) {
            return "delete thành công";
        } else {
            return "delete thất bại";
        }
    }

  
    @Override
    public List<HoaDon> getAllTT() {
        return rps.getAllTT();
    }

    @Override
    public HoaDon getOne(String ma) {
        return rps.getOne(ma);
    }

    @Override
    public String add(HoaDonModel hd, HoaDonChiTietModel hdct) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String update(HoaDonModel hd, HoaDonChiTietModel hdct, String maHD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HoaDon> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
