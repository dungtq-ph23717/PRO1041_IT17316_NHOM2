/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author ACER
 */
public class SanPhamModel {

    private String id;
    private String maSP;
    private String tenSP;
    private Integer soLuong;
    private double giaBan;
    private String idQL;
    private String idSize;
    private String idCB;
    private String idDM;
    private DanhMucModel tenDM;

    public SanPhamModel() {
    }

    public SanPhamModel(String id, String maSP, String tenSP, Integer soLuong, double giaBan, String idQL, String idSize, String idDM) {
        this.id = id;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.idQL = idQL;
        this.idSize = idSize;
        this.idDM = idDM;
    }

    public SanPhamModel(String maSP, String tenSP, Integer soLuong, double giaBan, String idDM, DanhMucModel tenDM) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.idDM = idDM;
        this.tenDM = tenDM;
    }

    public String getIdDM() {
        return idDM;
    }

    public void setIdDM(String idDM) {
        this.idDM = idDM;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public String getIdQL() {
        return idQL;
    }

    public void setIdQL(String idQL) {
        this.idQL = idQL;
    }

    public String getIdSize() {
        return idSize;
    }

    public void setIdSize(String idSize) {
        this.idSize = idSize;
    }

}
