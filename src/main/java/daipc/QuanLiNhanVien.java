/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daipc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author DaiPc
 */
public class QuanLiNhanVien {
    ArrayList<NhanVien> nhanViens = new ArrayList<>();
    private static Connection connection;
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL = "jdbc:sqlserver://DESKTOP-E3ST970\\SQLEXPRESS:1433;databaseName=QuanLiNhanVien;encrypt=true;trustServerCertificate=true;";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";
    
    public QuanLiNhanVien(){
        getConnection();
    }
    
    public void fixedData(){
        try{
            PreparedStatement preStmt = connection.prepareStatement("select * from NhanVien");
            ResultSet rs = preStmt.executeQuery();
            if(!rs.next()){
                System.out.println("Rong");
                preStmt = connection.prepareStatement("insert into NhanVien values (?, ?, ?, ?, ?)"); 
                Object[][] obj = new Object[][]{
                    {"NV001", "Mạc Vũ Anh Đại", "2005-08-10", true, "Giám đốc"},
                    {"NV002", "Nguyễn Ngọc Minh", "2005-08-10", false, "Phó phòng"},
                    {"NV003", "Khâu Văn Phú", "2005-08-10", true, "Trưởng phòng"},
                    {"NV004", "Tống Hải Đăng", "2005-12-27", true, "Bảo vệ"},
                    {"NV005", "Nguyễn Phương Anh", "2005-06-16", false, "Nhân viên"}
                };
            
                for (int i = 0; i < 5; i++) {
                    preStmt.setString(1, (String) obj[i][0]);
                    preStmt.setString(2, (String) obj[i][1]);
                    preStmt.setString(3, (String) obj[i][2]);
                    preStmt.setBoolean(4, (Boolean) obj[i][3]);
                    preStmt.setString(5, (String) obj[i][4]);

                    preStmt.addBatch();
                }
                preStmt.executeBatch();
            }
            
            preStmt = connection.prepareStatement("select * from NhanVien");
            rs = preStmt.executeQuery();
            while(rs.next()){
                nhanViens.add(new NhanVien(rs.getString("maNV"), 
                        rs.getString("hoTenNV"), rs.getDate("ngaySinh").toString(), 
                        rs.getBoolean("gioiTinh"), rs.getString("chucVu"))
                );
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public Boolean ADD(NhanVien nv){
        try{
            nhanViens.add(nv);
            NhanVien nVien = nhanViens.get(nhanViens.size() - 1);
            int i = 1;
            PreparedStatement preStmt = connection.prepareStatement("insert into NhanVien values (?, ?, ?, ?, ?)");
            preStmt.setString(i++, nVien.getMaNV());
            preStmt.setString(i++, nVien.getHoten());
            preStmt.setString(i++, nVien.getDate());
            preStmt.setBoolean(i++, nVien.getGioiTinh());
            preStmt.setString(i, nVien.getChucVu());
            preStmt.executeUpdate();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public Boolean EDIT(NhanVien nv, int id){
        try{
            nv.setMaNV(String.format("NV%03d", id + 1));
            nhanViens.set(id, nv);
            int i = 1;
            String sql = "UPDATE NhanVien SET hoTenNV = ?, ngaySinh = ?, gioiTinh = ?, chucVu = ? where maNV = ?";
            PreparedStatement preStmt = connection.prepareStatement(sql);
            preStmt.setString(i++, nv.getHoten());
            preStmt.setString(i++, nv.getDate());
            preStmt.setBoolean(i++, nv.getGioiTinh());
            preStmt.setString(i++, nv.getChucVu());
            preStmt.setString(i, nv.getMaNV());
            preStmt.executeUpdate();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public Boolean REMOVE(int id){
        try{
            PreparedStatement preStmt = connection.prepareStatement("delete from NhanVien where maNV = ?");
            preStmt.setString(1, nhanViens.get(id).getMaNV());
            preStmt.executeUpdate();
            nhanViens.remove(id);
            return true;
        }catch(Exception e){
            e.getStackTrace();
        }
        return false;
    }
    
    public Boolean CLEAR(){
        try{
            PreparedStatement preStmt = connection.prepareStatement("delete from NhanVien");
            preStmt.executeUpdate();
            nhanViens.removeAll(nhanViens);
            return true;
        }catch(Exception e){
            e.getStackTrace();
        }
        return false;
    }
    
    public void getConnection(){
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
