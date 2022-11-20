package ViewModels;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author vietv
 */
public class HoaDon {

    private String ID;
    private String maHD;
    private String ngayLapHD;
    private double thanhTien;
    private String phuongThucThanhToan;
    private String MAKM;
    private String MANV;
    private String MABan;

    public HoaDon() {
    }

    public HoaDon(String ID, String maHD, String ngayLapHD, double thanhTien, String phuongThucThanhToan, String MAKM, String MANV, String MABan) {
        this.ID = ID;
        this.maHD = maHD;
        this.ngayLapHD = ngayLapHD;
        this.thanhTien = thanhTien;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.MAKM = MAKM;
        this.MANV = MANV;
        this.MABan = MABan;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgayLapHD() {
        return ngayLapHD;
    }

    public void setNgayLapHD(String ngayLapHD) {
        this.ngayLapHD = ngayLapHD;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public String getMAKM() {
        return MAKM;
    }

    public void setMAKM(String MAKM) {
        this.MAKM = MAKM;
    }

    public String getMANV() {
        return MANV;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }

    public String getMABan() {
        return MABan;
    }

    public void setMABan(String MABan) {
        this.MABan = MABan;
    }

  

    public Object[] toRowData() {
        return new Object[]{maHD, ngayLapHD, thanhTien, phuongThucThanhToan, MAKM, MANV, MABan};
    }

}
