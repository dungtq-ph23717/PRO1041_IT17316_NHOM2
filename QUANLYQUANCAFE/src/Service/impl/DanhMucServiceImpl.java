/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import Repository.DanhMucRepository;
import Service.DanhMucService;
import ViewModels.DanhMuc;
import java.util.List;

/**
 *
 * @author ACER
 */
public class DanhMucServiceImpl implements DanhMucService {

    private DanhMucRepository rps = new DanhMucRepository();

    @Override
    public List<DanhMuc> getAll() {
        return rps.getAll();
    }

    @Override
    public DanhMuc getOne(String ma) {
        return rps.getOne(ma);
    }

}
