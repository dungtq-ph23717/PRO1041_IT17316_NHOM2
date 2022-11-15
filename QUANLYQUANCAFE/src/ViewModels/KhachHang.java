package ViewModels;

public class KhachHang {

    private String id;
    private String maKH;
    private String tenKH;
    private String SDT;
    private String email;

    public KhachHang(String id, String maKH, String tenKH, String SDT, String email) {
        this.id = id;
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.SDT = SDT;
        this.email = email;
    }

    public KhachHang() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "KhachHangModel{" + "id=" + id + ", maKH=" + maKH + ", tenKH=" + tenKH + ", SDT=" + SDT + ", email=" + email + '}';
    }

}
