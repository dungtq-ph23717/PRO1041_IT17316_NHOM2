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
        String query = "";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
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
                return new HoaDon(rs.getString(1), rs.getString(2), rs.getString(3), nv, rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDon> getAllTT() {
        String query = "Select MaHD,NgayLapHD,TenNV,TinhTrang\n"
                + "from HoaDon \n"
                + "inner join NhanVien on NhanVien.ID = HoaDon.IDNV\n"
                + "Where TinhTrang like N'Chờ'";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<HoaDon> list = new ArrayList<>();
            while (rs.next()) {
                NhanVienViewModel nv = new NhanVienViewModel(rs.getString(3));
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), nv, rs.getString(4));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDon> getAllTTViewHD(String id) {
        String query = "Select MaHD,NgayLapHD,TenNV, hoadon.TinhTrang\n"
                + "from HoaDon\n"
                + "inner join NhanVien on NhanVien.ID = HoaDon.IDNV\n"
                + "inner join Ban on HoaDon.IDBan = Ban.ID\n"
                + "Where IDBan like ? and hoadon.TinhTrang like N'Chờ'";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            List<HoaDon> list = new ArrayList<>();
            while (rs.next()) {
                NhanVienViewModel nv = new NhanVienViewModel(rs.getString(3));
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), nv, rs.getString(4));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(HoaDonModel hd, String ma) {
        String query = "INSERT INTO [dbo].[HoaDon]([MaHD],[NgayLapHD],[IDNV],[IDBan],[TinhTrang])\n"
                + "VALUES('HD'+?,GETDATE(),'5dc424c8-d86a-4aa9-9b6a-399678fd5ae5',?,N'Chờ')";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            ps.setObject(2, hd.getIDBan());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(HoaDonModel hd, String ma, String tinhTrang) {
        String query = "UPDATE [dbo].[HoaDon]\n"
                + "   SET [MaHD] = ?\n"
                + "      ,[TinhTrang] = ?\n"
                + " WHERE MaHD = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd.getMaHD());
            ps.setObject(2, tinhTrang);
            ps.setObject(3, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateSL(HoaDonModel hd, String ma, String tinhTrang) {
        String query = "UPDATE [dbo].[HoaDon]\n"
                + "   SET [MaHD] = ?\n"
                + "      ,[TinhTrang] = ?\n"
                + " WHERE MaHD = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd.getMaHD());
            ps.setObject(2, tinhTrang);
            ps.setObject(3, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateID(String id, String maHD) {
        String query = "UPDATE [dbo].[HoaDon]\n"
                + "   SET [IDBan] = ?\n"
                + " WHERE MaHD like ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ps.setObject(2, maHD);
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
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
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
//        HoaDonModel hd = new HoaDonModel("HD1", "1");
//        boolean add = new HoaDonRepository().updateID("15d13f6e-71b8-44be-8560-213d2f84002a", "HD31");
//        System.out.println(add);
//        HoaDon hd = new HoaDonRepository().getOne("HD2");
//        System.out.println(hd);
        List<HoaDon> getall = new Repository.HoaDonRepository().getAll();
        for (HoaDon x : getall) {
            System.out.println(x);
        }
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
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<HoaDonModel> glistHD = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                HoaDonModel hdm = new HoaDonModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            }
            return glistHD;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
