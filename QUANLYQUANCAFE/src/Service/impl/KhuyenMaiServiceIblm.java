/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import DomainModels.KhuyenMaiModel;
import Service.ServiceKhuyenMai;
import ViewModels.KhuyenMai;
import java.util.List;

/**
 *
 * @author vietv
 */
public class KhuyenMaiServiceIblm implements ServiceKhuyenMai {

    private Repository.KhuyenMaiRepository resKM = new Repository.KhuyenMaiRepository();

    @Override
    public List<KhuyenMai> getAll() {
        return resKM.getAll();
    }

    @Override
    public List<KhuyenMai> searchTheoMaKM(String maKM) {
        return resKM.searchMaKM(maKM);
    }

    @Override
    public String addTST(KhuyenMaiModel km) {
        if (km.getMaKM().isEmpty() || km.getTenKM().isEmpty() || km.getHinhThucGG().isEmpty() || km.getMucGiam().isEmpty() || km.getTgBatDau().isEmpty() || km.getTgKetThuc().isEmpty() || km.getMoTa().isEmpty()) {
            return "Không được để trống !";
        }
        if (km.getMucGiam().matches("[a-z A-Z]+") == false) {
            return "Mức giảm phải là số và lớn hơn 0";
        }
        KhuyenMaiModel ma = resKM.checkTrung(km.getMaKM());
        if (ma != null) {
            return "Mã khuyến mãi đã tồn tại!";
        }
        boolean add = resKM.addTST(km);
        if (add) {
            return "Thêm thành công!";
        } else {
            return "Thêm thất bại!";
        }
    }

    @Override
    public String updateTST(KhuyenMaiModel km, String IDKM) {
        boolean update = resKM.updateTST(km, IDKM);
        if (update) {
            return "Sửa thành công!";
        } else {
            return "Sửa thất bại!";
        }
    }

    @Override
    public String delete(String IDKM) {
        boolean delete = resKM.xoa(IDKM);
        if (delete) {
            return "Succesfully!";
        } else {
            return "Failed!";
        }
    }

    @Override
    public List<KhuyenMai> searchTheoHinhThucGG(String htgg) {
        return resKM.searchTheoHinhThucGG(htgg);
    }

    @Override
    public KhuyenMai getOne(String ten) {
        return resKM.getOne(ten);
    }

    @Override
    public String addTPT(KhuyenMaiModel km) {
        if (km.getMaKM().isEmpty() || km.getTenKM().isEmpty() || km.getHinhThucGG().isEmpty() || km.getMucGiam().isEmpty() || km.getTgBatDau().isEmpty() || km.getTgKetThuc().isEmpty() || km.getMoTa().isEmpty()) {
            return "Không được để trống !";
        }
        if (km.getMucGiam().matches("[a-z A-Z]+") == false) {
            return "Mức giảm phải là số và lớn hơn 0";
        }
        KhuyenMaiModel ma = resKM.checkTrung(km.getMaKM());
        if (ma != null) {
            return "Mã khuyến mãi đã tồn tại!";
        }
        boolean add = resKM.addTPT(km);
        if (add) {
            return "Thêm thành công!";
        } else {
            return "Thêm thất bại!";
        }
    }

    @Override
    public String updateTPT(KhuyenMaiModel km, String IDKM) {
        boolean update = resKM.updateTPT(km, IDKM);
        if (update) {
            return "Sửa thành công!";
        } else {
            return "Sửa thất bại!";
        }
    }
}
