/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author hdo48
 */
public class Combo_SanPham {
    private String tencombo;
    private String tenSP;
    private int soLUONG;

    public Combo_SanPham() {
    }

    public Combo_SanPham(String tencombo, String tenSP, int soLUONG) {
        this.tencombo = tencombo;
        this.tenSP = tenSP;
        this.soLUONG = soLUONG;
    }

    public String getTencombo() {
        return tencombo;
    }

    public void setTencombo(String tencombo) {
        this.tencombo = tencombo;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLUONG() {
        return soLUONG;
    }

    public void setSoLUONG(int soLUONG) {
        this.soLUONG = soLUONG;
    }

    @Override
    public String toString() {
        return "Combo_SanPham{" + "tencombo=" + tencombo + ", tenSP=" + tenSP + ", soLUONG=" + soLUONG + '}';
    }
    public Object[] toRowData(){
        return new Object[]{tencombo,tencombo,soLUONG};
    }
}
