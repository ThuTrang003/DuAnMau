/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class QLGioHang {
    private String id;
    
    private String tenKH;
    
    private String tenNV;
    
    private String ma;
    
    private Date ngayTao;
    
    private Date ngayThanhToan;
    
    private String idtenNguoiNhan;
    
    private String diaChi;
    
    private String sdt;
    
    private int tinhTrang;

    public QLGioHang() {
    }

    public QLGioHang(String id, String tenKH, String tenNV, String ma, Date ngayTao, Date ngayThanhToan, String idtenNguoiNhan, String diaChi, String sdt, int tinhTrang) {
        this.id = id;
        this.tenKH = tenKH;
        this.tenNV = tenNV;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.idtenNguoiNhan = idtenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.tinhTrang = tinhTrang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getIdtenNguoiNhan() {
        return idtenNguoiNhan;
    }

    public void setIdtenNguoiNhan(String idtenNguoiNhan) {
        this.idtenNguoiNhan = idtenNguoiNhan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    
}
