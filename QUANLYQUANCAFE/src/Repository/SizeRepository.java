/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.KhuyenMaiModel;
import DomainModels.SizeModels;
import Utilities.DBContext;
import ViewModels.KhuyenMai;
import ViewModels.Size;
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
public class SizeRepository {

    public List<Size> getAll() {
        String query = "SELECT [ID]\n"
                + "      ,[Size]\n"
                + "  FROM [dbo].[Size]";
        List<Size> list = new ArrayList<>();
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Size s = new Size(rs.getString(1), rs.getString(2));
                list.add(s);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(SizeModels s) {
        int check = 0;
        String query = "INSERT INTO [dbo].[Size]\n"
                + "([Size])\n"
                + "     VALUES\n"
                + "           (?)";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, s.getSize());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean update(SizeModels s, String IDS) {
        int check = 0;
        String query = "UPDATE [dbo].[Size]\n"
                + "   SET[Size] = ?\n"
                + " WHERE ID =?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, s.getSize());
            ps.setObject(2, IDS);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean xoa(String IDS) {
        int check = 0;
        String query = "DELETE FROM [dbo].[Size]\n"
                + "      WHERE ID = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, IDS);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public static void main(String[] args) {
        List<Size> show = new SizeRepository().getAll();
        for (Size x : show) {
            System.out.println(x);
        }
    }
}
