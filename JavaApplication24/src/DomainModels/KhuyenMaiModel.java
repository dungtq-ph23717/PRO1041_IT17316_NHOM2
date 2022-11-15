/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author vietv
 */
public class KhuyenMaiModel {

    private String ID;
    private String maKM;
    private String tenKM;
    private String hinhThucGG;
    private String mucGiam;
    private String tgBatDau;
    private String tgKetThuc;
    private String moTa;

    public KhuyenMaiModel() {
    }

    public KhuyenMaiModel(String ID, String maKM, String tenKM, String hinhThucGG, String mucGiam, String tgBatDau, String tgKetThuc, String moTa) {
        this.ID = ID;
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.hinhThucGG = hinhThucGG;
        this.mucGiam = mucGiam;
        this.tgBatDau = tgBatDau;
        this.tgKetThuc = tgKetThuc;
        this.moTa = moTa;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public String getHinhThucGG() {
        return hinhThucGG;
    }

    public void setHinhThucGG(String hinhThucGG) {
        this.hinhThucGG = hinhThucGG;
    }

    public String getMucGiam() {
        return mucGiam;
    }

    public void setMucGiam(String mucGiam) {
        this.mucGiam = mucGiam;
    }

    public String getTgBatDau() {
        return tgBatDau;
    }

    public void setTgBatDau(String tgBatDau) {
        this.tgBatDau = tgBatDau;
    }

    public String getTgKetThuc() {
        return tgKetThuc;
    }

    public void setTgKetThuc(String tgKetThuc) {
        this.tgKetThuc = tgKetThuc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

}
