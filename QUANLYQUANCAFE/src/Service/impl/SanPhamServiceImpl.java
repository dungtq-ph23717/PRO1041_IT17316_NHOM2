/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import DomainModels.SanPhamModel;
import java.util.List;
import Repository.SanPhamRepository;
import Service.SanPhamService;
import ViewModels.SanPham;

/**
 *
 * @author ACER
 */
public class SanPhamServiceImpl implements SanPhamService {

    private SanPhamRepository rps = new SanPhamRepository();

    @Override
    public List<SanPham> getAll() {
        return rps.getAll();
    }

    @Override
    public String add(SanPhamModel sp) {
        if (sp.getMaSP().isEmpty()) {
            return "Không được để trống";
        }
        boolean add = rps.add(sp);
        if (add) {
            return "add thành công";
        } else {
            return "add thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        boolean add = rps.delete(ma);
        if (add) {
            return "delete thành công";
        } else {
            return "delete thất bại";
        }
    }

    @Override
    public String update(SanPhamModel sp, String ma) {
        boolean add = rps.update(sp, ma);
        if (add) {
            return "update thành công";
        } else {
            return "update thất bại";
        }
    }

    @Override
    public List<SanPham> search(String ma) {
        return rps.search(ma);
    }

}
