/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import DomainModels.BanModel;
import Repository.BanRepostory;
import Service.BanService;
import ViewModels.Ban;
import java.util.List;

/**
 *
 * @author Admin
 */
public class BanServiceImpl implements BanService {

    private BanRepostory rp = new BanRepostory();

    @Override
    public List<Ban> getAll() {
        return rp.getAll();
    }

    @Override
    public Ban getOne(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String add(BanModel ban) {
        boolean add = rp.add(ban);
        if (add) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

    @Override
    public String update(BanModel ban, String ma) {
        boolean update = rp.update(ban, ma);
        if (update) {
            return "update thành công";
        } else {
            return "update thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        boolean delete = rp.delete(ma);
        if (delete) {
            return "delete thành công";
        } else {
            return "delete thất bại";
        }
    }

    @Override
    public List<Ban> Search(String ma) {
        return rp.Search(ma);
    }

    @Override
    public List<Ban> SearchKV(String TenKV) {
        return rp.SearchKV(TenKV);
    }

    @Override
    public List<Ban> SearchTen(String ten) {
        return rp.SearchTen(ten);
    }

    @Override
    public List<Ban> SearchLoaiBan(String loai) {
        return rp.SearchLoaiBan(loai);
    }

    @Override
    public List<Ban> getAllTT() {
        return rp.getAllTT();
    }

}
