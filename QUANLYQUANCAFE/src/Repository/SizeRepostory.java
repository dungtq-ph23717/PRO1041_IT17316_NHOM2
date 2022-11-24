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

    public Size getOne(String ten) {
        String query = "SELECT [ID]\n"
                + "      ,[Size]\n"
                + "  FROM [dbo].[Size]"
                + "  WHERE Size like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Size(rs.getString(1), rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
