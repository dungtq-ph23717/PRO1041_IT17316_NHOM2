/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author Lee Tuan
 */
public class ComboModel {

    private String id;
    private String maCB;
    private String tenCB;
    private double giaBan;

    public ComboModel() {
    }

    public ComboModel(String id, String maCB, String tenCB, double giaBan) {
        this.id = id;
        this.maCB = maCB;
        this.tenCB = tenCB;
        this.giaBan = giaBan;
    }

    public ComboModel(String maCB) {
        this.maCB = maCB;
    }

   

  
    
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaCB() {
        return maCB;
    }

    public void setMaCB(String maCB) {
        this.maCB = maCB;
    }

    public String getTenCB() {
        return tenCB;
    }

    public void setTenCB(String tenCB) {
        this.tenCB = tenCB;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "Combo{" + "id=" + id + ", maCB=" + maCB + ", tenCB=" + tenCB + ", giaBan=" + giaBan + '}';
    }
    public Object[] toRowData(){
        return new Object[]{id,maCB,tenCB,giaBan};
        
}

}
