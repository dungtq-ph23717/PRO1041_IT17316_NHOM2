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
    public String add(KhuyenMaiModel km) {
        if (km.getMaKM().isEmpty() || km.getTenKM().isEmpty() || km.getHinhThucGG().isEmpty() || km.getMucGiam().isEmpty() || km.getTgBatDau().isEmpty() || km.getTgKetThuc().isEmpty() || km.getMoTa().isEmpty()) {
            return "Khong dc de trong !";
        }
        boolean add = resKM.add(km);
        if (add) {
            return "Succesfully!";
        } else {
            return "Failed!";
        }
    }

    @Override
    public String update(KhuyenMaiModel km, String IDKM) {
        boolean update = resKM.update(km, IDKM);
        if (update) {
            return "Succesfully!";
        } else {
            return "Failed!";
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

}
