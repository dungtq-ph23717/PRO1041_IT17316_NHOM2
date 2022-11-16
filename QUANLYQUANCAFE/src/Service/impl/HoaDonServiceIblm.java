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
import ViewModels.HoaDonChiTiet;

/**
 *
 * @author vietv
 */
public class HoaDonServiceIblm implements ServiceHoaDon {

    private HoaDonRepository rps = new HoaDonRepository();

    @Override
    public List<HoaDon> getAll() {
        return rps.getAll();
    }

    @Override
    public String add(HoaDonModel hd, HoaDonChiTietModel hdct) {
        boolean add = rps.add(hd, hdct);
        if (add) {
            return "add thanh cong";
        } else {
            return "add that bai";
        }
    }

    @Override
    public String update(HoaDonModel hd, HoaDonChiTietModel hdct, String maHD) {
        boolean update = rps.update(hd, hdct, maHD);
        if (update) {
            return "update thành công";
        } else {
            return "update thất bại";
        }
    }

    @Override
    public String delete(String maHD) {
        boolean delete = rps.delete(maHD);
        if (delete) {
            return "delete thành công";
        } else {
            return "delete thất bại";
        }
    }

}
