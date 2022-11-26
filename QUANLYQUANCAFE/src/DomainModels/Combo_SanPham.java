/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author hdo48
 */
public class Combo_SanPham {
    private String idcv;
    private String idsp;
    private int soLuong;

    public Combo_SanPham() {
    }

    public Combo_SanPham(String idcv, String idsp, int soLuong) {
        this.idcv = idcv;
        this.idsp = idsp;
        this.soLuong = soLuong;
    }

    public String getIdcv() {
        return idcv;
    }

    public void setIdcv(String idcv) {
        this.idcv = idcv;
    }

    public String getIdsp() {
        return idsp;
    }

    public void setIdsp(String idsp) {
        this.idsp = idsp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "Combo_SanPham{" + "idcv=" + idcv + ", idsp=" + idsp + ", soLuong=" + soLuong + '}';
    }
    
}
