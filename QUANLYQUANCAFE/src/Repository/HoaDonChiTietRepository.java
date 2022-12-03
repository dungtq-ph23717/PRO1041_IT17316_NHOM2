/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.HoaDonChiTietModel;
import Utilities.DBContext;
import ViewModels.HoaDonChiTiet;
import ViewModels.SanPham;
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
        String query = "select	MaSP,TenSP,Giaban,Soluong, Soluong * Giaban as Tongtien\n"
                + "from HoaDonChiTiet \n"
                + "inner join SanPham on SanPham.ID = HoaDonChiTiet.IDSP";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<HoaDonChiTiet> list = new ArrayList<>();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getDouble(3));
                HoaDonChiTiet hdct = new HoaDonChiTiet(sp, rs.getInt(4), rs.getDouble(5));
                list.add(hdct);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDonChiTiet> getAllviewGH(String id) {
        String query = "select	MaSP,TenSP,Giaban,Soluong, Soluong * Giaban as Tongtien\n"
                + "from HoaDonChiTiet\n"
                + "inner join SanPham on SanPham.ID = HoaDonChiTiet.IDSP\n"
                + "where IDHD like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            List<HoaDonChiTiet> list = new ArrayList<>();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getDouble(3));
                HoaDonChiTiet hdct = new HoaDonChiTiet(sp, rs.getInt(4), rs.getDouble(5));
                list.add(hdct);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public HoaDonChiTiet getOne(String ma) {
        String query = "select	MaSP,TenSP,Giaban,Soluong, Soluong * Giaban as Tongtien\n"
                + "from HoaDonChiTiet\n"
                + "inner join SanPham on SanPham.ID = HoaDonChiTiet.IDSP\n"
                + "where MaSP like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getDouble(3));
                return new HoaDonChiTiet(sp, rs.getInt(4), rs.getDouble(5));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(HoaDonChiTietModel hd) {
        String query = "INSERT INTO [dbo].[HoaDonChiTiet]\n"
                + "           ([IDSP]\n"
                + "           ,[IDHD]\n"
                + "           ,[Soluong])\n"
                + "     VALUES(?,?,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd.getIDSP());
            ps.setObject(2, hd.getIDHD());
            ps.setObject(3, hd.getSoLuong());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(HoaDonChiTietModel hd, String idHD, String idSP) {
        String query = "UPDATE [dbo].[HoaDonChiTiet]\n"
                + "   SET [Soluong] = ?\n"
                + " WHERE IDHD like ? and IDSP like ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd.getSoLuong());
            ps.setObject(2, idHD);
            ps.setObject(3, idSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateIDHD(String idHD, int soLuong, String idSP) {
        String query = "UPDATE [dbo].[HoaDonChiTiet]\n"
                + "   SET [IDHD] = ?\n"
                + "      ,[Soluong] = ?\n"
                + " WHERE IDSP like ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idHD);
            ps.setObject(2, soLuong);
            ps.setObject(3, idSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean gopHD(String idHD, String idSP) {
        String query = "UPDATE [dbo].[HoaDonChiTiet]\n"
                + "   SET [IDHD] = ?\n"
                + " WHERE IDSP like ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idHD);
            ps.setObject(2, idSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

       public HoaDonChiTietModel checkTrung(String idSp) {
        String query = "SELECT idSP FROM SANPHAM WHERE idSp = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idSp);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTietModel sp = new HoaDonChiTietModel(rs.getString(1));
                return sp;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public boolean delete(String idHD, String idSP) {
        String query = "DELETE FROM [dbo].[HoaDonChiTiet]\n"
                + "      WHERE IDHD like ? and IDSP like ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idHD);
            ps.setObject(2, idSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
//        List<HoaDonChiTiet> list = new HoaDonChiTietRepository().getAllviewGH("44a3f36c-64bb-4c28-9290-4b1e63ff7dd5");
//        for (HoaDonChiTiet x : list) {
//            System.out.println(x.toString());
//        }
//        HoaDonChiTiet hd = new HoaDonChiTietRepository().getOne("SP1");
//        System.out.println(hd);
        HoaDonChiTietModel hd = new HoaDonChiTietModel(5);
        boolean add = new HoaDonChiTietRepository().updateIDHD("eeaf53e9-e542-444a-86b5-f088b1bdff3e", 3, "6a0c96e8-fe13-4e56-80b8-1a294978cc7b");
        System.out.println(add);
    }
}
