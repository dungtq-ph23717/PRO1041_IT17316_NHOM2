/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.HoaDonModel;
import Utilities.DBContext;
import ViewModels.HoaDon;
import ViewModels.HoaDonChiTiet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vietv
 */
public class HoaDonChiTietRepository {

    public List<HoaDonChiTiet> getAll() {
        String query = "SELECT [IDSP]\n"
                + "      ,[IDHD]\n"
                + "      ,[Soluong]\n"
                + "      ,[Giatien]\n"
                + "      ,[Ghichu]\n"
                + "  FROM [dbo].[HoaDonChiTiet]";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<HoaDonChiTiet> list = new ArrayList<>();
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet(rs.getInt(1), rs.getDouble(2), rs.getString(3));
                list.add(hdct);
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
                + "           ,[PhuongThucThanhToan])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd.getMaHD());
            ps.setObject(2, hd.getNgayLapHD());
            ps.setObject(3, hd.getThanhTien());
            ps.setObject(4, hd.getPhuongThucThanhToan());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(HoaDonModel hd, String ma) {
        String query = "UPDATE [dbo].[HoaDon]\n"
                + "   SET [MaHD] = ?\n"
                + "      ,[NgayLapHD] = ?\n"
                + "      ,[ThanhTien] = ?\n"
                + "      ,[PhuongThucThanhToan] = ?\n"
                + " WHERE MaHD = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd.getMaHD());
            ps.setObject(2, hd.getNgayLapHD());
            ps.setObject(3, hd.getThanhTien());
            ps.setObject(4, hd.getPhuongThucThanhToan());
            ps.setObject(5, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[HoaDon]\n"
                + "      WHERE MaHD = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        HoaDonModel hd = new HoaDonModel("hh", "ddc", "02/01/2002", 1, "chuyen khoan", "", "", "");
        boolean add = new HoaDonRepository().add(hd);
        //boolean update = new HoaDonRepository().update(hd, "cc");
        //boolean delete = new HoaDonRepository().delete("ddc");
        List<HoaDon> a = new HoaDonRepository().getAll();
        for (HoaDon hoaDon : a) {
            System.out.println(hoaDon.toString());
        }
//        System.out.println(add);
    }
}
