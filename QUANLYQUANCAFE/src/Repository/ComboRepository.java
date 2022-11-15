/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

//import repositores.DBContext;
import DomainModels.ComboModel;
import Utilities.DBContext;
import ViewModels.ComboReponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lee Tuan
 */
public class ComboRepository {

    public boolean add_cb(ComboModel cb) {
        try ( Connection conn = DBContext.getConnection()) {
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

    public boolean update_cb(ComboModel cb) {
        try ( Connection conn = DBContext.getConnection()) {
            Statement st = conn.createStatement();
            String sql = "UPDATE Combo SET MACB = '" + cb.getMaCB() + "',TenCB = '" + cb.getTenCB() + "',GiaBan = '" + cb.getGiaBan() + "' WHERE ID = '" + cb.getId() + "'";
            st.execute(sql);
            return true;
        } catch (Exception e) {
            System.out.println("Error update");
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete_cb(ComboModel obj) {
        try ( Connection conn = DBContext.getConnection()) {
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

    public List<ComboReponse> get_all() {
        String sql = "SELECT * FROM Combo";
        ArrayList<ComboReponse> lst_cb = new ArrayList<>();
        try ( Connection conn = DBContext.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                lst_cb.add(new ComboReponse(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
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

    public static void main(String[] args) {
        ComboRepository cbr = new ComboRepository();
////        SanPham sp1=new SanPham("sp01", "laptop");
//        spr.add_sp(sp1);
//            System.out.println(sp1.toString());
        for (var o : cbr.get_all()) {
            System.out.println(o.toString());
        }
    }
}
