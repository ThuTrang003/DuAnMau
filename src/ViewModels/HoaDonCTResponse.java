/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.math.BigDecimal;

/**
 *
 * @author ADMIN
 */
public class HoaDonCTResponse {
    
    private String idChiTietSP;
    private String idHoaDon;
    private String maSP;
    private String tenSP;
    private Integer soLuongSP;
    private BigDecimal donGia;

    public HoaDonCTResponse(String idChiTietSP, String idHoaDon, String maSP, String tenSP, Integer soLuongSP, BigDecimal donGia) {
        this.idChiTietSP = idChiTietSP;
        this.idHoaDon = idHoaDon;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuongSP = soLuongSP;
        this.donGia = donGia;
    }

    public HoaDonCTResponse() {
    }

    public String getIdChiTietSP() {
        return idChiTietSP;
    }

    public void setIdChiTietSP(String idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
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

    public Integer getSoLuongSP() {
        return soLuongSP;
    }

    public void setSoLuongSP(Integer soLuongSP) {
        this.soLuongSP = soLuongSP;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }
    
    public Object[] toDataRow(int index) {
        return new Object[]{index, maSP, tenSP, soLuongSP, donGia,new BigDecimal(soLuongSP).multiply(donGia)};
    }
}
