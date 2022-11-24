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
import ViewModels.DanhMuc;
import ViewModels.Size;

/**
 *
 * @author ACER
 */
public class SanPhamRepository {

    public List<SanPham> getAll() {
        String query = "SELECT MaSP, TenSP, Giaban, MoTa, DanhMuc.TenDM, TrangThai, Size FROM SanPham\n"
                + "INNER JOIN DanhMuc ON SanPham.IDDM = DanhMuc.ID\n"
                + "inner join Size on SanPham.IDSize = Size.ID";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<SanPham> list = new ArrayList<>();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), new DanhMuc(rs.getString(5)), rs.getString(6), new Size(rs.getString(7)));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<SanPham> getAllKM() {
        String query = "SELECT MaSP, TenSP FROM SanPham";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<SanPham> list = new ArrayList<>();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<SanPham> search(String ten) {
        String query = "SELECT MaSP, TenSP, Giaban, MoTa, DanhMuc.TenDM, TrangThai FROM SanPham\n"
                + "INNER JOIN DanhMuc ON SanPham.IDDM = DanhMuc.ID\n"
                + "WHERE SanPham.TenSP like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, "%" + ten + "%");
            ResultSet rs = ps.executeQuery();
            List<SanPham> list = new ArrayList<>();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), new DanhMuc(rs.getString(5)), rs.getString(6));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<SanPham> searchTenDanhMuc(String tenDanhMuc) {
        String query = "SELECT MaSP,TenSP,Giaban,MoTa,dm.TenDM,TrangThai FROM SanPham sp\n"
                + "INNER JOIN DanhMuc dm ON dm.ID = sp.IDDM\n"
                + "WHERE dm.TenDM like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, "%" + tenDanhMuc + "%");
            ResultSet rs = ps.executeQuery();
            List<SanPham> list = new ArrayList<>();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), new DanhMuc(rs.getString(5)), rs.getString(6));
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
                + "           ,[Giaban]\n"
                + "           ,[MoTa]\n"
                + "           ,[Anh]\n"
                + "           ,[IDDM]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, sp.getMaSP());
            ps.setObject(2, sp.getTenSP());
            ps.setObject(3, sp.getGiaBan());
            ps.setObject(4, sp.getMoTa());
            ps.setObject(5, sp.getAnh());
            ps.setObject(6, sp.getIdDM());
            ps.setObject(7, sp.getTrangThai());
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
                + "      ,[Giaban] = ?\n"
                + "      ,[MoTa] = ?\n"
                + "      ,[Anh] = ?\n"
                + "      ,[IDDM] =?\n"
                + "      ,[TrangThai] =?\n"
                + " WHERE MaSP = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, sp.getMaSP());
            ps.setObject(2, sp.getTenSP());
            ps.setObject(3, sp.getGiaBan());
            ps.setObject(4, sp.getMoTa());
            ps.setObject(5, sp.getAnh());
            ps.setObject(6, sp.getIdDM());
            ps.setObject(7, sp.getTrangThai());
            ps.setObject(8, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean addID(SanPhamModel sp, String ma) {
        String query = "UPDATE [dbo].[SanPham]\n"
                + "   SET [IDKM] = ?\n"
                + " WHERE MaSP like ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, sp.getIdKM());
            ps.setObject(2, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
//        List<SanPham> list = new SanPhamRepository().getAllKM();
//        for (SanPham x : list) {
//            System.out.println(x.toString());
//        }
        SanPhamModel sp = new SanPhamModel("ae539fd9-0cd8-4818-addd-87cce30342d9");
        boolean add = new SanPhamRepository().addID(sp, "SP1");
        System.out.println(add);

//        List<SanPham> list = new SanPhamRepository().search("Bạc Xỉu");
//        for (SanPham x : list) {
//            System.out.println(x);
//        }
//        List<SanPham> list = new SanPhamRepository().searchTenDanhMuc("Topping");
//        for (SanPham x : list) {
//            System.out.println(x);
//        }
    }
}
