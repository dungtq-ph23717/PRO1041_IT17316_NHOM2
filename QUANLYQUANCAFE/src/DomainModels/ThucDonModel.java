package DomainModels;

public class ThucDonModel {

    private String id;
    private String maTD;
    private String ten;
    private String giaBan;
    private String idSP;
    private String idCB;

    public ThucDonModel() {
    }

    public ThucDonModel(String id, String maTD, String ten, String giaBan, String idSP, String idCB) {
        this.id = id;
        this.maTD = maTD;
        this.ten = ten;
        this.giaBan = giaBan;
        this.idSP = idSP;
        this.idCB = idCB;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaTD() {
        return maTD;
    }

    public void setMaTD(String maTD) {
        this.maTD = maTD;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getIdCB() {
        return idCB;
    }

    public void setIdCB(String idCB) {
        this.idCB = idCB;
    }

    @Override
    public String toString() {
        return "ThucDonModel{" + "id=" + id + ", maTD=" + maTD + ", ten=" + ten + ", giaBan=" + giaBan + ", idSP=" + idSP + ", idCB=" + idCB + '}';
    }

}
