/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

//import repositores.DBContext;
import DomainModels.ComboModel;
import DomainModels.DanhMucModel;
import DomainModels.SanPhamModel;
import DomainModels.SizeModel;
import Utilities.DBContext;
import ViewModels.ComboReponse;
import ViewModels.SanPham;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lee Tuan
 */
public class ComboRepository {

    public boolean add_cb(ComboModel cb) {
        try (Connection conn = DBContext.getConnection()) {
            String sql = "insert into Combo(MaCB,TenCB,GiaBan)values(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cb.getMaCB());
            ps.setString(2, cb.getTenCB());
            ps.setDouble(3, cb.getGiaBan());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error add");
            e.printStackTrace();
            return false;
        }
    }

    public boolean update_cb(ComboModel cb, String id) {

        String sql = "UPDATE [dbo].[Combo]\n"
                + "   SET [MaCB] = ?\n"
                + "      ,[TenCB] = ?\n"
                + "      ,[GiaBan] = ?\n"
                + " WHERE ID=?";
        int check = 0;
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(1, cb.getMaCB());
            ps.setObject(2, cb.getTenCB());
            ps.setObject(3, cb.getGiaBan());
            ps.setObject(4, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;

    }

    public boolean delete_cb(ComboModel obj) {
        try (Connection conn = DBContext.getConnection()) {
            Statement st = conn.createStatement();
            String DELETE_COMBO = "DELETE FROM COMBO WHERE ID = '" + obj.getId() + "'";
            System.out.println(DELETE_COMBO);
            st.executeUpdate(DELETE_COMBO);
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi không thể kết nối vào CSDL tại Delete()");
            return false;
        }
    }

    public List<ComboModel> get_all() {
        String sql = "SELECT * FROM Combo";
        ArrayList<ComboModel> lst_cb = new ArrayList<>();
        try (Connection conn = DBContext.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                lst_cb.add(new ComboModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
            }
            conn.close();
            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Error getall");
            e.printStackTrace();
        }
        return lst_cb;
    }

    public ComboModel checkTrung(String macb) {
        String query = "select MaCB  from Combo where MaCB=?";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, macb);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ComboModel cb = new ComboModel(rs.getString(1));
                return cb;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public SanPhamModel getOne(String ten) {
        String query = "SELECT [ID]\n"
                + "      ,[MaSP]\n"
                + "      ,[TenSP]\n"
                + "      ,[Giaban]\n"
                + "      ,[MoTa]\n"
                + "      ,[Anh]\n"
                + "      ,[IDSize]\n"
                + "      ,[IDCB]\n"
                + "      ,[IDDM]\n"
                + "      ,[TrangThai]\n"
                + "  FROM sanpham\n"
                + "  where TenSP like ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new SanPhamModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getString(8), rs.getString(9),rs.getString(10));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new ComboRepository().update_cb(new ComboModel("EAE68394-711E-4CB0-A515-79E79DF4A019", "cb1", "cà phê+khô gà", 10000), "EAE68394-711E-4CB0-A515-79E79DF4A019"));
    }
}
