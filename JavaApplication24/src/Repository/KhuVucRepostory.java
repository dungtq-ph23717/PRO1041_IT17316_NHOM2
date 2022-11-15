/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.KhuVucModel;
import Utilities.DBContext;
import ViewModels.KhuVuc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhuVucRepostory {

    public List<KhuVuc> getAll() {
        String query = "SELECT [ID]\n"
                + "      ,[MaKV]\n"
                + "      ,[TenKV]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[KhuVuc]";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<KhuVuc> list = new ArrayList<>();
            while (rs.next()) {
                KhuVuc ban = new KhuVuc(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(ban);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(KhuVucModel kv) {
        String query = "INSERT INTO [dbo].[KhuVuc]\n"
                + "           ([MaKV]\n"
                + "           ,[TenKV]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, kv.getMaKV());
            ps.setObject(2, kv.getTenKV());
            ps.setObject(3, kv.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[KhuVuc]\n"
                + "      WHERE MaKV = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(KhuVucModel kv, String ma) {
        String query = "UPDATE [dbo].[KhuVuc]\n"
                + "   SET [MaKV] = ?\n"
                + "      ,[TenKV] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + " WHERE MaKV like ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, kv.getMaKV());
            ps.setObject(2, kv.getTenKV());
            ps.setObject(3, kv.getTrangThai());
            ps.setObject(4, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
//        List<KhuVucModel> list = new KhuVucRepostory().getAll();
//        for (KhuVucModel x : list) {
//            System.out.println(x.toString());
//        }
        KhuVucModel ban = new KhuVucModel("kv1", "k", "trong");
        boolean add = new KhuVucRepostory().delete("kv1");
        System.out.println(add);
    }
}
