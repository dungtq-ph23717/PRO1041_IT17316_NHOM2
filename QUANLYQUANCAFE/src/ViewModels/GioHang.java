package ViewModels;

import DomainModels.*;

public class GioHang {
    private String id;
    private String ma;
    private String ngayTao;
    private String thanhToan;
    private String tinhTrang;

    public GioHang() {
    }

    public GioHang(String id, String ma, String ngayTao, String thanhToan, String tinhTrang) {
        this.id = id;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.thanhToan = thanhToan;
        this.tinhTrang = tinhTrang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(String thanhToan) {
        this.thanhToan = thanhToan;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "GioHangModel{" + "id=" + id + ", ma=" + ma + ", ngayTao=" + ngayTao + ", thanhToan=" + thanhToan + ", tinhTrang=" + tinhTrang + '}';
    }
    
    
}
