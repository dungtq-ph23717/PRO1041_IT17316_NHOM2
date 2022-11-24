package Repository;

import Utilities.DBContext;
import ViewModels.Size;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SizeRepostory {

    public List<Size> getAll() {
        String query = "SELECT [ID]\n"
                + "      ,[Size]\n"
                + "  FROM [dbo].[Size]";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<Size> list = new ArrayList<>();
            while (rs.next()) {
                Size s = new Size(rs.getString(1), rs.getString(2));
                list.add(s);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(Size s) {
        String query = "INSERT INTO [dbo].[Size]\n"
                + "          ([Size])\n"
                + "     VALUES\n"
                + "           (?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, s.getSize());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public Size getOne(String size) {
        String query = "SELECT [ID]\n"
                + "      ,[Size]\n"
                + "  FROM [dbo].[Size]"
                + "WHERE LIKE ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, size);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Size(rs.getString(1), rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean update(Size s, String ID) {
        String query = "UPDATE [dbo].[Size]\n"
                + "   SET [Size] = ?\n"
                + " WHERE ID = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, s.getSize());
            ps.setObject(2, ID);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        Size s = new SizeRepostory().getOne("L");
//        for (Size x : list) {
//            System.out.println(x);
//        }
        System.out.println(s);
    }
}
