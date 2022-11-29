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
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
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
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
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
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
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
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd.getIDSP());
            ps.setObject(2, hd.getIDHD());
            ps.setObject(3, hd.getSoLuong());

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

    public boolean delete(String idHD, String idSP) {
        String query = "DELETE FROM [dbo].[HoaDonChiTiet]\n"
                + "      WHERE IDHD like ? and IDSP like ?";
        int check = 0;
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idHD);
            ps.setObject(2, idSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean deletehdct(String idHD) {
        String query = "DELETE FROM [dbo].[HoaDonChiTiet]\n"
                + "      WHERE IDHD like ?";
        int check = 0;
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idHD);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public String thanhToan(HoaDonChiTiet hdct) {
        String query = "INSERT INTO [dbo].[HoaDonChiTiet]\n"
                + "           ([IDSP]\n"
                + "           ,[IDHD]\n"
                + "           ,[Soluong]\n"
                + "           ,[Giatien])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {

            ps.setObject(1, hdct.getIdSP());
            ps.setObject(2, hdct.getIdHD());
            ps.setObject(3, hdct.getSoLuong());
            ps.setObject(4, hdct.getGiaTien());

            if (ps.executeUpdate() > 0) {
                return "Thanh toán thành công";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Thanh toán thất bại";
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[HoaDon]\n"
                + "      WHERE ID=?";
        int check = 0;

        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);

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
        HoaDonChiTiet hd = new HoaDonChiTietRepository().getOne("SP1");
        System.out.println(hd);
//        HoaDonChiTietModel hd = new HoaDonChiTietModel("6a0c96e8-fe13-4e56-80b8-1a294978cc7b", "44a3f36c-64bb-4c28-9290-4b1e63ff7dd5", 1);
        boolean add = new HoaDonChiTietRepository().delete("218FB055-1C8F-4CDE-97C4-7743EAA406C2", "6A0C96E8-FE13-4E56-80B8-1A294978CC7B");
        System.out.println(add);
    }
}
