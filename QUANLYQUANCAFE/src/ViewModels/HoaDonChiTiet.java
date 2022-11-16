package ViewModels;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author vietv
 */
public class HoaDonChiTiet {

    private String IDSP;
    private String IDHD;
    private int soLuong;
    private double giaTien;
    private String ghiChu;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String IDSP, String IDHD, int soLuong, double giaTien, String ghiChu) {
        this.IDSP = IDSP;
        this.IDHD = IDHD;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.ghiChu = ghiChu;
    }

    public HoaDonChiTiet(int soLuong, double giaTien, String ghiChu) {
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.ghiChu = ghiChu;
    }

    public String getIDSP() {
        return IDSP;
    }

    public void setIDSP(String IDSP) {
        this.IDSP = IDSP;
    }

    public String getIDHD() {
        return IDHD;
    }

    public void setIDHD(String IDHD) {
        this.IDHD = IDHD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

}
