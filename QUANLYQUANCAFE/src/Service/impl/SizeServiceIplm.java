/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import DomainModels.SizeModels;
import Service.SizeService;
import ViewModels.Size;
import java.util.List;

/**
 *
 * @author vietv
 */
public class SizeServiceIplm implements SizeService {

    private Repository.SizeRepository res = new Repository.SizeRepository();

    @Override
    public List<Size> getAll() {
        return res.getAll();
    }

    @Override
    public String add(SizeModels s) {
        boolean add = res.add(s);
        if (add) {
            return "Succesfully!";
        } else {
            return "Failed!";
        }
    }

    @Override
    public String update(SizeModels s, String idS) {
        boolean update = res.update(s, idS);
        if (update) {
            return "Succesfully!";
        } else {
            return "Failed!";
        }
    }

    @Override
    public String delete(String idS) {
        boolean xoa = res.xoa(idS);
        if (xoa) {
            return "Succesfully!";
        } else {
            return "Failed!";
        }
    }

}
