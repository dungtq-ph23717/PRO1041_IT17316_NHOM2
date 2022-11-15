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
    private String IDKH;
    private String IDNV;
    private String IDKM;
    private String IDBan;

    public HoaDon() {
    }

    public HoaDon(String ID, String maHD, String ngayLapHD, double thanhTien, String phuongThucThanhToan, String IDKH, String IDNV, String IDKM, String IDBan) {
        this.ID = ID;
        this.maHD = maHD;
        this.ngayLapHD = ngayLapHD;
        this.thanhTien = thanhTien;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.IDKH = IDKH;
        this.IDNV = IDNV;
        this.IDKM = IDKM;
        this.IDBan = IDBan;
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

    public String getIDKH() {
        return IDKH;
    }

    public void setIDKH(String IDKH) {
        this.IDKH = IDKH;
    }

    public String getIDNV() {
        return IDNV;
    }

    public void setIDNV(String IDNV) {
        this.IDNV = IDNV;
    }

    public String getIDKM() {
        return IDKM;
    }

    public void setIDKM(String IDKM) {
        this.IDKM = IDKM;
    }

    public String getIDBan() {
        return IDBan;
    }

    public void setIDBan(String IDBan) {
        this.IDBan = IDBan;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "ID=" + ID + ", maHD=" + maHD + ", ngayLapHD=" + ngayLapHD + ", thanhTien=" + thanhTien + ", phuongThucThanhToan=" + phuongThucThanhToan + ", IDKH=" + IDKH + ", IDNV=" + IDNV + ", IDKM=" + IDKM + ", IDBan=" + IDBan + '}';
    }

}
