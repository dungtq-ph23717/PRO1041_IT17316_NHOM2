package Repository;

import DomainModels.BanModel;
import DomainModels.Ban_HoaDonModel;
import DomainModels.KhuVucModel;
import DomainModels.SanPhamModel;
import Utilities.DBContext;
import ViewModels.Ban;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BanRepostory {

    public List<Ban> getAll() {
        String query = "SELECT [ID]\n"
                + "      ,[MaBan]\n"
                + "      ,[TenBan]\n"
                + "      ,[Mota]\n"
                + "      ,[Loaiban]\n"
                + "      ,[IDKV]\n"
                + "  FROM [dbo].[Ban]";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<Ban> list = new ArrayList<>();
            while (rs.next()) {
                Ban ban = new Ban(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(ban);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(BanModel ban) {
        String query = "INSERT INTO [dbo].[Ban]\n"
                + "           ([MaBan]\n"
                + "           ,[TenBan]\n"
                + "           ,[Mota]\n"
                + "           ,[Loaiban]\n"
                + "           ,[IDKV])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ban.getMaBan());
            ps.setObject(2, ban.getTenBan());
            ps.setObject(3, ban.getMoTa());
            ps.setObject(4, ban.getLoaiBan());
            ps.setObject(5, ban.getIDKV());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[Ban]\n"
                + "      WHERE MaBan = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(BanModel ban, String ma) {
        String query = "UPDATE [dbo].[Ban]\n"
                + "   SET [MaBan] = ?\n"
                + "      ,[TenBan] = ?\n"
                + "      ,[Mota] = ?\n"
                + "      ,[Loaiban] = ?\n"
                + "      ,[IDKV] = ?\n"
                + " WHERE MaBan like ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ban.getMaBan());
            ps.setObject(2, ban.getTenBan());
            ps.setObject(3, ban.getMoTa());
            ps.setObject(4, ban.getLoaiBan());
            ps.setObject(5, ban.getIDKV());
            ps.setObject(6, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
//        List<Ban> list = new BanRepostory().getAll();
//        for (BanModel x : list) {
//            System.out.println(x.toString());
//        }
        BanModel ban = new BanModel("ban1", "ten2", "trong", "thuong", "0f2c1e5f-47fb-42c3-a158-c77dd3c32b50");
        boolean add = new BanRepostory().delete("ban1");
        System.out.println(add);
    }
}
