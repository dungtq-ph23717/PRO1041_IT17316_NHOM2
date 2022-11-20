/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.SanPhamModel;
import java.util.List;
import ViewModels.SanPham;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import Utilities.DBContext;

/**
 *
 * @author ACER
 */
public class SanPhamRepository {

    public List<SanPham> getAll() {
        String query = "SELECT [MaSP]\n"
                + "      ,[TenSP]\n"
                + "      ,[Soluong]\n"
                + "      ,[Giaban]\n"
                + "\n"
                + "  FROM [dbo].[SanPham]";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<SanPham> list = new ArrayList<>();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<SanPham> search(String ma) {
        String query = "SELECT [MaSP]\n"
                + "      ,[TenSP]\n"
                + "      ,[Soluong]\n"
                + "      ,[Giaban]\n"
                + "  FROM [dbo].[SanPham]\n"
                + "  WHERE MaSP like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, "%" + ma + "%");
            ResultSet rs = ps.executeQuery();
            List<SanPham> list = new ArrayList<>();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(SanPhamModel sp) {
        String query = "INSERT INTO [dbo].[SanPham]\n"
                + "           ([MaSP]\n"
                + "           ,[TenSP]\n"
                + "           ,[Soluong]\n"
                + "           ,[Giaban])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, sp.getMaSP());
            ps.setObject(2, sp.getTenSP());
            ps.setObject(3, sp.getSoLuong());
            ps.setObject(4, sp.getGiaBan());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[SanPham]\n"
                + "      WHERE MaSP = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(SanPhamModel sp, String ma) {
        String query = "UPDATE [dbo].[SanPham]\n"
                + "   SET [MaSP] = ?\n"
                + "      ,[TenSP] = ?\n"
                + "      ,[Soluong] = ?\n"
                + "      ,[Giaban] = ?\n"
                + " WHERE MaSP = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, sp.getMaSP());
            ps.setObject(2, sp.getTenSP());
            ps.setObject(3, sp.getSoLuong());
            ps.setObject(4, sp.getGiaBan());
            ps.setObject(5, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        List<SanPham> list = new SanPhamRepository().search("SP2");
        for (SanPham x : list) {
            System.out.println(x.toString());
        }
//        SanPhamModel sp = new SanPhamModel("Sp001", "Tra`", 100, 10000);
//        boolean add = new SanPhamRepository().add(sp);
//        System.out.println(add);
//    }
//        List<SanPham> list = new SanPhamRepository().search("SP1");
//        for (SanPham x : list) {
//            System.out.println(x);
//        }
    }
}
