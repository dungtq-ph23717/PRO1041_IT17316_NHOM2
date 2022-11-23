package Repository;

import DomainModels.BanModel;
import DomainModels.Ban_HoaDonModel;
import DomainModels.KhuVucModel;
import DomainModels.SanPhamModel;
import Utilities.DBContext;
import ViewModels.Ban;
import ViewModels.KhuVuc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BanRepostory {

    public List<Ban> getAll() {
        String query = "Select MaBan,TenBan,Mota, Loaiban, TenKV\n"
                + "From Ban \n"
                + "inner join KhuVuc on Ban.IDKV = KhuVuc.ID";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<Ban> list = new ArrayList<>();
            while (rs.next()) {
                KhuVuc kv = new KhuVuc(rs.getString(5));
                Ban ban = new Ban(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), kv);
                list.add(ban);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<Ban> getAllTT() {
        String query = "Select TenBan,Loaiban\n"
                + "From Ban \n"
                + "inner join KhuVuc on Ban.IDKV = KhuVuc.ID";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<Ban> list = new ArrayList<>();
            while (rs.next()) {
                Ban ban = new Ban(rs.getString(1), rs.getString(2));
                list.add(ban);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<Ban> Search(String ma) {
        String query = "Select MaBan,TenBan,Mota, Loaiban, TenKV\n"
                + "From Ban \n"
                + "inner join KhuVuc on Ban.IDKV = KhuVuc.ID\n"
                + "where TenBan like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, "%" + ma + "%");
            ResultSet rs = ps.executeQuery();
            List<Ban> list = new ArrayList<>();
            while (rs.next()) {
                KhuVuc kv = new KhuVuc(rs.getString(5));
                Ban ban = new Ban(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), kv);
                list.add(ban);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<Ban> SearchKV(String TenKV) {
        String query = "Select MaBan,TenBan,Mota, Loaiban, TenKV\n"
                + "From Ban \n"
                + "inner join KhuVuc on Ban.IDKV = KhuVuc.ID\n"
                + "where TenKV like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, "%" + TenKV + "%");
            ResultSet rs = ps.executeQuery();
            List<Ban> list = new ArrayList<>();
            while (rs.next()) {
                KhuVuc kv = new KhuVuc(rs.getString(5));
                Ban ban = new Ban(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), kv);
                list.add(ban);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<Ban> SearchTen(String ten) {
        String query = "Select MaBan,TenBan,Mota, Loaiban, TenKV\n"
                + "From Ban \n"
                + "inner join KhuVuc on Ban.IDKV = KhuVuc.ID\n"
                + "where TenBan like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, "%" + ten + "%");
            ResultSet rs = ps.executeQuery();
            List<Ban> list = new ArrayList<>();
            while (rs.next()) {
                KhuVuc kv = new KhuVuc(rs.getString(5));
                Ban ban = new Ban(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), kv);
                list.add(ban);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<Ban> SearchLoaiBan(String loai) {
        String query = "Select MaBan,TenBan,Mota, Loaiban, TenKV\n"
                + "From Ban \n"
                + "inner join KhuVuc on Ban.IDKV = KhuVuc.ID\n"
                + "where Loaiban like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, "%" + loai + "%");
            ResultSet rs = ps.executeQuery();
            List<Ban> list = new ArrayList<>();
            while (rs.next()) {
                KhuVuc kv = new KhuVuc(rs.getString(5));
                Ban ban = new Ban(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), kv);
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
        List<Ban> list = new BanRepostory().SearchKV("Tầng 1");
        for (Ban x : list) {
            System.out.println(x.toString());
        }
//        boolean add = new BanRepostory().delete("74021EA2-43FE-4472-B795-1EA8B5714FF2");
//        System.out.println(add);
    }
}
