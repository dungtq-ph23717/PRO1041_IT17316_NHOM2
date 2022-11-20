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

    private String TenSP;
    private String MAHD;
    private int soLuong;
    private double giaTien;
    private String ghiChu;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String TenSP, String MAHD, int soLuong, double giaTien, String ghiChu) {
        this.TenSP = TenSP;
        this.MAHD = MAHD;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.ghiChu = ghiChu;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getMAHD() {
        return MAHD;
    }

    public void setMAHD(String MAHD) {
        this.MAHD = MAHD;
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

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "TenSP=" + TenSP + ", MAHD=" + MAHD + ", soLuong=" + soLuong + ", giaTien=" + giaTien + ", ghiChu=" + ghiChu + '}';
    }

    
    public Object[]toRowdata(){
        return new Object[]{TenSP,MAHD,soLuong,giaTien,ghiChu};
    }
    

}
