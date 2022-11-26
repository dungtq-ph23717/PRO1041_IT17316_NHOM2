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
public class HoaDonChiTietServiceIblm implements ServiceHoaDonChiTiet{

    private HoaDonChiTietRepository rp = new HoaDonChiTietRepository();
    @Override
    public List<HoaDonChiTiet> getAll() {
        return rp.getAll();
    }

    @Override
    public boolean add(HoaDonChiTietModel hd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(HoaDonChiTietModel hd, String maHD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String maHD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
