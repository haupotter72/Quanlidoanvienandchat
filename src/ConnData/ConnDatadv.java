package ConnData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnDatadv {
   // private Connection con;
    static String url="jdbc:mysql://localhost:3306/quanlidoanvien";
    static String user="root";
    static String password="";
    public static Connection getConnection() {
        // connection function
        Connection connection=null;
        try {
            connection=DriverManager.getConnection(url,user,password);
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }
    public static List<DoanVien> findAll(){
        List<DoanVien>DoanVienList= new ArrayList<>();
        String query="select *from doanvien";
        try {
            Connection connection =getConnection();
            Statement stmt= connection.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()) {
                DoanVien dv=new DoanVien(rs.getInt("MaDV"),rs.getString("Ho_Va_Ten"),rs.getInt("Tuoi"),
                        rs.getInt("Gioi_Tinh"),rs.getString("Chi_Doan"),rs.getFloat("Diem_Phong_Trao"));
                DoanVienList.add(dv);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return DoanVienList;
    }
    public static void insert(DoanVien dv) {
        String query="insert into doanvien(Ho_Va_Ten,Tuoi,Gioi_Tinh,Chi_Doan,Diem_Phong_Trao) values(?,?,?,?,?)";
        try {
            Connection connection =getConnection();
            PreparedStatement pstmt=connection.prepareStatement(query);
            pstmt.setString(1, dv.getHo_Va_Ten());
            pstmt.setInt(2, dv.getTuoi());
            pstmt.setInt(3, dv.getGioi_Tinh());
            pstmt.setString(4, dv.getChi_Doan());
            pstmt.setFloat(5, dv.getDiem_Phong_Trao());
            pstmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public static void delete(DoanVien dv) {
        String query="delete from doanvien where Ho_Va_Ten='"+dv.getHo_Va_Ten()+"'";
        try {
            Connection connection =getConnection();
            PreparedStatement pstmt=connection.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public static void Update(DoanVien dv) {
        String query="Update doanvien set Ho_Va_Ten=?,Tuoi=?,Gioi_Tinh=?,Chi_Doan=?,Diem_Phong_Trao=? where Ho_Va_Ten='"+dv.getHo_Va_Ten()+"'";
        try {
            Connection connection=getConnection();
            PreparedStatement pstmt=connection.prepareStatement(query);
            pstmt.setString(1,  dv.getHo_Va_Ten());
            pstmt.setInt(2,  dv.getTuoi());
            pstmt.setInt(3,  dv.getGioi_Tinh());
            pstmt.setString(4,  dv.getChi_Doan());
            pstmt.setFloat(5,  dv.getDiem_Phong_Trao());
            pstmt.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static List<DoanVien>findByName(DoanVien s) {
        List<DoanVien>DoanVien= new ArrayList<>();
        String query="select*from doanvien where doanvien.Ho_Va_Ten='"+s.getHo_Va_Ten()+"'";
        try {
            Connection connection =getConnection();
            Statement stmt= connection.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()) {
               DoanVien dv=new DoanVien(rs.getInt("MaDV"),rs.getString("Ho_Va_Ten"),rs.getInt("Tuoi"),
                        rs.getInt("Gioi_Tinh"),rs.getString("Chi_Doan"),rs.getFloat("Diem_Phong_Trao"));
             DoanVien.add(dv);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return DoanVien;
    }

}
