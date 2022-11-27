/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.HoaDonModel;
import Utilities.DBContext;
import ViewModels.HoaDon;
import ViewModels.NhanVienViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vietv
 */
public class HoaDonRepository {

    public List<HoaDon> getAll() {
        String query = "SELECT dbo.HoaDon.ID, dbo.HoaDon.MaHD, dbo.HoaDon.NgayLapHD, dbo.HoaDon.ThanhTien, dbo.HoaDon.PhuongThucThanhToan, dbo.KhuyenMai.MaKM, dbo.NhanVien.MaNV, dbo.Ban.MaBan\n"
                + "FROM   dbo.HoaDon INNER JOIN\n"
                + "             dbo.KhuyenMai ON dbo.HoaDon.IDKM = dbo.KhuyenMai.ID INNER JOIN\n"
                + "             dbo.NhanVien ON dbo.HoaDon.IDNV = dbo.NhanVien.ID INNER JOIN\n"
                + "             dbo.Ban ON dbo.HoaDon.ID = dbo.Ban.ID";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<HoaDon> list = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public HoaDon getOne(String ma) {
        String query = "Select HoaDon.ID, MaHD,NgayLapHD,TenNV, TinhTrang\n"
                + "from HoaDon \n"
                + "inner join NhanVien on NhanVien.ID = HoaDon.IDNV where MaHD like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienViewModel nv = new NhanVienViewModel(rs.getString(4));
                return new HoaDon(rs.getString(1), rs.getString(2),rs.getString(3), nv,rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDon> getAllTT() {
        String query = "Select MaHD,NgayLapHD,TenNV, TinhTrang\n"
                + "from HoaDon \n"
                + "inner join NhanVien on NhanVien.ID = HoaDon.IDNV";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<HoaDon> list = new ArrayList<>();
            while (rs.next()) {
                NhanVienViewModel nv = new NhanVienViewModel(rs.getString(3));

                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), nv,rs.getString(4));

                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(HoaDonModel hd) {
        String query = "INSERT INTO [dbo].[HoaDon]\n"
                + "           ([MaHD]\n"
                + "           ,[NgayLapHD]\n"
                + "           ,[ThanhTien]\n"
                + "           ,[PhuongThucThanhToan]\n"
                + "           ,[IDNV]\n"
                + "           ,[IDKM]\n"
                + "           ,[IDBan]\n"
                + "           ,[TinhTrang])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?)";
        int check = 0;
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd.getMaHD());
            ps.setObject(2, hd.getNgayLapHD());
            ps.setObject(3, hd.getThanhTien());
            ps.setObject(4, hd.getPhuongThucThanhToan());
            ps.setObject(5, hd.getIDKM());
            ps.setObject(6, hd.getIDNV());
            ps.setObject(7, hd.getIDBan());
            ps.setObject(8, hd.getTinhhTrang());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(HoaDonModel hd, String ID) {
        String query = "UPDATE [dbo].[HoaDon]\n"
                + "   SET [ID] = ?\n"
                + "      ,[MaHD] = ?\n"
                + "      ,[NgayLapHD] = ?\n"
                + "      ,[ThanhTien] = ?\n"
                + "      ,[PhuongThucThanhToan] = ?\n"
                + "      ,[IDNV] = ?\n"
                + "      ,[IDKM] = ?\n"
                + "      ,[IDBan] = ?\n"
                + "      ,[TinhTrang] = ?\n"
                + " WHERE ID = ?";
        int check = 0;
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd.getMaHD());
            ps.setObject(2, hd.getNgayLapHD());
            ps.setObject(3, hd.getThanhTien());
            ps.setObject(4, hd.getPhuongThucThanhToan());
            ps.setObject(5, hd.getIDKM());
            ps.setObject(6, hd.getIDNV());
            ps.setObject(7, hd.getIDBan());
            ps.setObject(8, hd.getTinhhTrang());
            ps.setObject(9, ID);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ID) {
        String query = "DELETE FROM [dbo].[HoaDon]\n"
                + "      WHERE  MaHD=?";
        int check = 0;
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ID);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {

//        List<HoaDon> rp = new HoaDonRepository().getAllTT();
//        for (HoaDon hoaDon : rp) {
//            System.out.println(hoaDon.toString());
//        }
        HoaDon hd = new HoaDonRepository().getOne("HD2");
        System.out.println(hd);
    }

    public List<HoaDonModel> getListChuaThanhToan() {
        String query = "SELECT [ID]\n"
                + "      ,[MaHD]\n"
                + "      ,[NgayLapHD]\n"
                + "      ,[ThanhTien]\n"
                + "      ,[PhuongThucThanhToan]\n"
                + "      ,[IDNV]\n"
                + "      ,[IDKM]\n"
                + "      ,[IDBan]\n"
                + "      ,[TinhTrang]\n"
                + "  FROM [dbo].[HoaDon]\n"
                + "  where TinhTrang='Chưa thanh toán'";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            List<HoaDonModel> glistHD = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

               HoaDonModel hdm= new HoaDonModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
            }
            return glistHD;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
