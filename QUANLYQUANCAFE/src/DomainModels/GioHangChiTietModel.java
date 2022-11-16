package DomainModels;

public class GioHangChiTietModel {

    private String IDGH;
    private String IDSP;
    private int soLuong;
    private double donGia;
    private double donGiaKhiGiam;

    public GioHangChiTietModel() {
    }

    public GioHangChiTietModel(String IDGH, String IDSP, int soLuong, double donGia, double donGiaKhiGiam) {
        this.IDGH = IDGH;
        this.IDSP = IDSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    public String getIDGH() {
        return IDGH;
    }

    public void setIDGH(String IDGH) {
        this.IDGH = IDGH;
    }

    public String getIDSP() {
        return IDSP;
    }

    public void setIDSP(String IDSP) {
        this.IDSP = IDSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getDonGiaKhiGiam() {
        return donGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(double donGiaKhiGiam) {
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    @Override
    public String toString() {
        return "GioHangChiTietModel{" + "IDGH=" + IDGH + ", IDSP=" + IDSP + ", soLuong=" + soLuong + ", donGia=" + donGia + ", donGiaKhiGiam=" + donGiaKhiGiam + '}';
    }

}
