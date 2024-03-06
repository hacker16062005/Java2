/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daipc;

/**
 *
 * @author DaiPc
 */
public class NhanVien {
    private String maNV;
    private String hoten;
    private String date;
    private Boolean gioiTinh;
    private String chucVu;

    public NhanVien() {
    }

    public NhanVien(String maNV, String hoten, String date, Boolean gioiTinh, String chucVu) {
        this.maNV = maNV;
        this.hoten = hoten;
        this.date = date;
        this.gioiTinh = gioiTinh;
        this.chucVu = chucVu;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
    
    
}
