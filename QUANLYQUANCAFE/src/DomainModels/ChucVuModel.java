package DomainModels;

public class ChucVuModel {

    private String id;
    private String maCV;
    private String ten;

    public ChucVuModel() {
    }

    public ChucVuModel(String id, String maCV, String ten) {
        this.id = id;
        this.maCV = maCV;
        this.ten = ten;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

}
