/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DomainModels.Combo_SanPham;
import Utilities.DBContext;

/**
 *
 * @author hdo48
 */
public class Combo_SanPhamRepository {

    public boolean add(Combo_SanPham combo_SanPham) {
        String query = "INSERT INTO [dbo].[Combo_SP]\n"
                + "           ([IDCB]\n"
                + "           ,[IDSP]\n"
                + "           ,[Soluong])\n"
                + "     VALUES   (?,?,?)";
        int check = 0;
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, combo_SanPham.getIdcv());
            ps.setObject(2, combo_SanPham.getIdsp());
            ps.setObject(3, combo_SanPham.getSoLuong());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public static void main(String[] args) {
        System.out.println(new Combo_SanPhamRepository().add(new Combo_SanPham("C2259DAD-AC84-434B-8A66-9329C6408565", "64E38E57-1447-483D-A82F-08C6DD36AE74", 1)));
    }
}
