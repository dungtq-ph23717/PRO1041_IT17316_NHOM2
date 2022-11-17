/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author Admin
 */
public class BanModel {

    private String id;
    private String maBan;
    private String tenBan;
    private String moTa;
    private String loaiBan;
    private String IDKV;
    private KhuVucModel tenKV;

    public BanModel() {
    }

    public BanModel(String id, String maBan, String tenBan, String moTa, String loaiBan, String IDKV, KhuVucModel tenKV) {
        this.id = id;
        this.maBan = maBan;
        this.tenBan = tenBan;
        this.moTa = moTa;
        this.loaiBan = loaiBan;
        this.IDKV = IDKV;
        this.tenKV = tenKV;
    }

    public BanModel(String maBan, String tenBan, String moTa, String loaiBan, String IDKV, KhuVucModel tenKV) {
        this.maBan = maBan;
        this.tenBan = tenBan;
        this.moTa = moTa;
        this.loaiBan = loaiBan;
        this.IDKV = IDKV;
        this.tenKV = tenKV;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getLoaiBan() {
        return loaiBan;
    }

    public void setLoaiBan(String loaiBan) {
        this.loaiBan = loaiBan;
    }

    public String getIDKV() {
        return IDKV;
    }

    public void setIDKV(String IDKV) {
        this.IDKV = IDKV;
    }

    public KhuVucModel getTenKV() {
        return tenKV;
    }

    public void setTenKV(KhuVucModel tenKV) {
        this.tenKV = tenKV;
    }

    @Override
    public String toString() {
        return "Ban{" + "id=" + id + ", maBan=" + maBan + ", tenBan=" + tenBan + ", moTa=" + moTa + ", loaiBan=" + loaiBan + ", IDKV=" + IDKV + '}';
    }

}
