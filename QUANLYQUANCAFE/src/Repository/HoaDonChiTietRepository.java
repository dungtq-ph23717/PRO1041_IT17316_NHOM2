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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vietv
 */
public class HoaDonChiTietRepository {

    public List<HoaDonChiTiet> getAll() {
        String query = "SELECT"
                + "      [Soluong]\n"
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
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(HoaDonChiTietModel hdct) {
        String query = "INSERT INTO [dbo].[HoaDonChiTiet]\n"
                + "           ([Soluong]\n"
                + "           ,[Giatien]\n"
                + "           ,[Ghichu])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdct.getSoLuong());
            ps.setObject(2, hdct.getGiaTien());
            ps.setObject(3, hdct.getGhiChu());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(HoaDonChiTietModel hdct, String maHD) {
        String query = "UPDATE [dbo].[HoaDonChiTiet]\n"
                + "   SET [Soluong] = ?\n"
                + "      ,[Giatien] = ?\n"
                + "      ,[Ghichu] = ?\n"
                + "	   FROM HoaDon HD JOIN HoaDonChiTiet HDCT\n"
                + "ON HD.ID = HDCT.IDHD\n"
                + " WHERE MaHD";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hdct.getSoLuong());
            ps.setObject(2, hdct.getGiaTien());
            ps.setObject(3, hdct.getGhiChu());
            ps.setObject(4, maHD);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String maHD) {
        String query = "DELETE FROM [dbo].[HoaDonChiTiet]\n"
                + "FROM HoaDon HD JOIN HoaDonChiTiet HDCT\n"
                + "		ON HD.ID = HDCT.IDHD\n"
                + "      WHERE MaHD = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maHD);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {

    }
}
