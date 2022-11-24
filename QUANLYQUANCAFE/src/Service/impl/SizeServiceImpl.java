/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import ViewModels.Size;
import Repository.SizeRepostory;
import Service.SizeService;
import java.util.List;

/**
 *
 * @author ADMIN5
 */
public class SizeServiceImpl implements SizeService {

    private SizeRepostory rp = new SizeRepostory();

    @Override
    public List<Size> getAll() {
        return rp.getAll();
    }

}
