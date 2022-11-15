/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.math.BigDecimal;
import java.util.UUID;

/**
 *
 * @author ADMIN
 */
public class SanPhamResponse {
    private String id;
    private String maSP;
    private String tenSP;
    private Integer namBH;
    private String moTa;
    private Integer soLuongSPTon;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;

    public SanPhamResponse() {
    }

    public SanPhamResponse(String id, String maSP, String tenSP, Integer namBH, String moTa, Integer soLuongSPTon, BigDecimal giaNhap, BigDecimal giaBan) {
        this.id = id;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongSPTon = soLuongSPTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Integer getNamBH() {
        return namBH;
    }

    public void setNamBH(Integer namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getSoLuongSPTon() {
        return soLuongSPTon;
    }

    public void setSoLuongSPTon(Integer soLuongSPTon) {
        this.soLuongSPTon = soLuongSPTon;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }
    
    public Object[] toDataRow(int index) {
        return new Object[]{index, maSP, tenSP, namBH, moTa, soLuongSPTon, giaNhap, giaBan};
    }
}
