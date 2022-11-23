/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author Admin
 */
public class Ban {

    private String id;
    private String maBan;
    private String tenBan;
    private String moTa;
    private String loaiBan;
    private KhuVuc IDKV;

    public Ban() {
    }

    public Ban(String tenBan, String loaiBan) {
        this.tenBan = tenBan;
        this.loaiBan = loaiBan;
    }

    public Ban(String id, String maBan, String tenBan, String moTa, String loaiBan, KhuVuc IDKV) {
        this.id = id;
        this.maBan = maBan;
        this.tenBan = tenBan;
        this.moTa = moTa;
        this.loaiBan = loaiBan;
        this.IDKV = IDKV;
    }

    public Ban(String maBan, String tenBan, String moTa, String loaiBan, KhuVuc IDKV) {
        this.maBan = maBan;
        this.tenBan = tenBan;
        this.moTa = moTa;
        this.loaiBan = loaiBan;
        this.IDKV = IDKV;
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

    public KhuVuc getIDKV() {
        return IDKV;
    }

    public void setIDKV(KhuVuc IDKV) {
        this.IDKV = IDKV;
    }

    @Override
    public String toString() {
        return "Ban{" + "id=" + id + ", maBan=" + maBan + ", tenBan=" + tenBan + ", moTa=" + moTa + ", loaiBan=" + loaiBan + ", IDKV=" + IDKV + '}';
    }

    public Object[] toRowData() {
        return new Object[]{maBan, tenBan, moTa, loaiBan, IDKV.getTenKV()};
    }

    public Object[] toRowDataTT() {
        return new Object[]{tenBan, loaiBan};
    }
}
