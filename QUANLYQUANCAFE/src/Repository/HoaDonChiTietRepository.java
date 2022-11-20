/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.HoaDonChiTietModel;
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
        String query = "SELECT dbo.SanPham.TenSP, dbo.HoaDon.MaHD, dbo.HoaDonChiTiet.Soluong, dbo.HoaDonChiTiet.Giatien, dbo.HoaDonChiTiet.Ghichu\n"
                + "FROM   dbo.SanPham INNER JOIN\n"
                + "             dbo.HoaDon ON dbo.SanPham.ID = dbo.HoaDon.ID INNER JOIN\n"
                + "             dbo.HoaDonChiTiet ON dbo.SanPham.ID = dbo.HoaDonChiTiet.IDSP AND dbo.HoaDon.ID = dbo.HoaDonChiTiet.IDHD";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<HoaDonChiTiet> list = new ArrayList<>();
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5));
                list.add(hdct);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(HoaDonChiTietModel hd) {
        String query = "INSERT INTO [dbo].[HoaDonChiTiet]\n"
                + "           ([IDSP]\n"
                + "           ,[IDHD]\n"
                + "           ,[Soluong]\n"
                + "           ,[Giatien]\n"
                + "           ,[Ghichu])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        int check = 0;
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd.getIDSP());
            ps.setObject(2, hd.getIDHD());
            ps.setObject(3, hd.getSoLuong());
            ps.setObject(4, hd.getGiaTien());
            ps.setObject(5, hd.getGiaTien());
            
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(HoaDonModel hd, String ma) {
        String query = "";
        int check = 0;
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
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
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

   
    
}
