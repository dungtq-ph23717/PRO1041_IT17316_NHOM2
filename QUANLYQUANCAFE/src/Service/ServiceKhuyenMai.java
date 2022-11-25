/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.KhuyenMaiModel;
import ViewModels.KhuyenMai;
import java.util.List;

/**
 *
 * @author vietv
 */
public interface ServiceKhuyenMai {

    List<ViewModels.KhuyenMai> getAll();

    KhuyenMai getOne(String ten);

    String addTST(KhuyenMaiModel km);

    String addTPT(KhuyenMaiModel km);

    String updateTST(KhuyenMaiModel km, String IDKM);

    String updateTPT(KhuyenMaiModel km, String IDKM);

    String delete(String IDKM);

    List<ViewModels.KhuyenMai> searchTheoMaKM(String maKM);

    List<ViewModels.KhuyenMai> searchTheoHinhThucGG(String htgg);

}
