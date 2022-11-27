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
    private NhanVienViewModel tenNV;
    private String tinhTrang;

    public HoaDon() {
    }

    public HoaDon(String maHD) {
        this.maHD = maHD;
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
        this.tenNV = tenNV;
    }


    public HoaDon(String ID, String maHD, String ngayLapHD, NhanVienViewModel tenNV, String tinhTrang) {
        this.ID = ID;
        this.maHD = maHD;
        this.ngayLapHD = ngayLapHD;
        this.tenNV = tenNV;
        this.tinhTrang = tinhTrang;
    }

    public HoaDon(String maHD, String ngayLapHD, NhanVienViewModel tenNV, String tinhTrang) {
        this.maHD = maHD;
        this.ngayLapHD = ngayLapHD;
        this.tenNV = tenNV;
        this.tinhTrang = tinhTrang;

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

    @Override
    public String toString() {

        return "HoaDon{" + "ID=" + ID + ", maHD=" + maHD + ", ngayLapHD=" + ngayLapHD + ", thanhTien=" + thanhTien + ", phuongThucThanhToan=" + phuongThucThanhToan + ", MAKM=" + MAKM + ", MANV=" + MANV + ", MABan=" + MABan + ", tenNV=" + tenNV + ", tinhTrang=" + tinhTrang + '}';

    }

    public Object[] toRowData() {
        return new Object[]{maHD, ngayLapHD, thanhTien, phuongThucThanhToan, tinhTrang, MAKM, MANV, MABan};
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }


    public NhanVienViewModel getTenNV() {
        return tenNV;
    }

    public void setTenNV(NhanVienViewModel tenNV) {
        this.tenNV = tenNV;
    }

}
