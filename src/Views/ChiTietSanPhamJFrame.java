/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DomainModels.DongSP;
import DomainModels.MauSac;
import DomainModels.NhaSanXuat;
import DomainModels.SanPham;
import Services.impl.ChiTietSanPhamService;
import Services.impl.DongSPService;
import Services.impl.MauSacService;
import Services.impl.NhaSanXuatService;
import Services.impl.SanPhamService;
import ViewModels.QLChiTietSP;
import ViewModels.QLDongSP;
import ViewModels.QLMauSac;
import ViewModels.QLNhaSanXuat;
import ViewModels.QLSanPham;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class ChiTietSanPhamJFrame extends javax.swing.JFrame {

    private ChiTietSanPhamService ctSVc;
    private NhaSanXuatService nsxSVC;
    private SanPhamService spSVC;
    private MauSacService msSVc;
    private DongSPService dSpSVc;
    
    public ChiTietSanPhamJFrame() {
        initComponents();
        this.ctSVc = new ChiTietSanPhamService();
        this.nsxSVC = new NhaSanXuatService();
        this.spSVC = new SanPhamService();
        this.msSVc = new MauSacService();
        this.dSpSVc = new DongSPService();
        this.loadTable();
        this.loadCbbNSX();
        this.loadCbbDSP();
        this.loadCbbMauSac();
        this.loadCbbSP();
    }
    
    private void clearForm(){
        this.txtGiaBan.setText("");
        this.txtGiaNhap.setText("");
        this.txtMoTa.setText("");
        this.txtNamBH.setText("");
        this.txtSoLuongTon.setText("");
        this.lblID.setText("__");
        this.cbbDongSp.setSelectedIndex(0);
        this.cbbMauSac.setSelectedIndex(0);
        this.cbbNhaSanXuat.setSelectedIndex(0);
        this.cbbSanPham.setSelectedIndex(0);
    }

    public void loadTable(){
        ArrayList<QLChiTietSP> lst = this.ctSVc.getAll();
        DefaultTableModel dtm = (DefaultTableModel) this.tblChiTietSP.getModel();
        dtm.setRowCount(0);
        for (QLChiTietSP x : lst) {
            QLChiTietSP ct = (QLChiTietSP) x;
            dtm.addRow(new Object[] {
                ct.getId(),
                ct.getSanPham(),
                ct.getNhaSanXuat(),
                ct.getMauSac(), 
                ct.getDongSP(),
                ct.getNamBH(), 
                ct.getMoTa(),
                ct.getSoLuongTon(),
                ct.getGiaNhap(),
                ct.getGiaBan()
            });
        }
    }
    
    private void loadCbbNSX() {
        ArrayList<QLNhaSanXuat> lstNSX = this.nsxSVC.getALl();
        for (QLNhaSanXuat x : lstNSX) {
            cbbNhaSanXuat.addItem(x);
        }
    }
    
    private void loadCbbSP() {
        ArrayList<QLSanPham> lstSP = this.spSVC.getAll();
        for (QLSanPham x : lstSP) {
            cbbSanPham.addItem(x);
        }
    }
    
    private void loadCbbMauSac() {
        ArrayList<QLMauSac> lstMS = this.msSVc.getAll();
        for (QLMauSac x : lstMS) {
            cbbMauSac.addItem(x);
        }
    }
    
    private void loadCbbDSP() {
        ArrayList<QLDongSP> lstDsp = this.dSpSVc.getAll();
        for (QLDongSP x : lstDsp) {
            cbbDongSp.addItem(x);
        }
    }
    
    private QLChiTietSP getFormData(){
        String namBH = this.txtNamBH.getText().trim();
        String mota = this.txtMoTa.getText().trim();
        String slTon = this.txtSoLuongTon.getText().trim();
        String giaNhapStr = this.txtGiaNhap.getText().trim();
        String giaBanStr = this.txtGiaBan.getText().trim();
        QLSanPham qlsp = (QLSanPham) this.cbbSanPham.getSelectedItem();
        QLNhaSanXuat qlnsx = (QLNhaSanXuat) this.cbbNhaSanXuat.getSelectedItem();
        QLMauSac qlms = (QLMauSac) this.cbbMauSac.getSelectedItem();
        QLDongSP qldSP = (QLDongSP) this.cbbDongSp.getSelectedItem();
        
        if (namBH.length() == 0 || mota.length() == 0 || slTon.length() == 0 || giaBanStr.length() == 0 || giaBanStr.length() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn không được để trống các trường thông tin");
            return null;
        }
        int nambh = -1;
        int slt = -1;
        try {
            nambh = Integer.parseInt(namBH);
            if (nambh <= 0) {
                JOptionPane.showMessageDialog(this, "Năm bảo hành phải lớn hơn 0");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Giá nhập phải là số");
            return null;
        }
        try {
            slt = Integer.parseInt(slTon);
            if (slt <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng tồn phải lớn hơn 0");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Số lượng tồn phải là số");
            return null;
        }
        
        double giaNhap = -1;
        double giaBan = -1;
        try {
            giaNhap = Double.parseDouble(giaNhapStr);
            if (giaNhap < 0) {
                JOptionPane.showMessageDialog(this, "Giá nhập phải lớn hơn hoặc bằng 0");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Giá nhập phải là số");
            return null;
        }
        
        try {
            giaBan = Double.parseDouble(giaBanStr);
            if (giaBan < 0) {
                JOptionPane.showMessageDialog(this, "Giá bán phải lớn hơn hoặc bằng 0");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Giá bán phải là số");
            return null;
        }
        SanPham sp = new SanPham(qlsp.getId(), qlsp.getMa(), qlsp.getTen());
        NhaSanXuat nsx = new NhaSanXuat(qlnsx.getId(), qlnsx.getMa(), qlnsx.getTen());
        MauSac ms = new MauSac(qlms.getId(), qlms.getMa(), qlms.getTen());
        DongSP dSP = new DongSP(qldSP.getId(), qldSP.getMa(), qldSP.getTen());
        QLChiTietSP ctsp = new QLChiTietSP("", sp, nsx, ms, dSP, nambh, mota, slt, BigDecimal.valueOf(giaNhap), BigDecimal.valueOf(giaBan));
        return ctsp;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChiTietSP = new javax.swing.JTable();
        lblID = new javax.swing.JLabel();
        cbbSanPham = new javax.swing.JComboBox<QLSanPham>();
        cbbDongSp = new javax.swing.JComboBox<QLDongSP>();
        cbbNhaSanXuat = new javax.swing.JComboBox<QLNhaSanXuat>();
        cbbMauSac = new javax.swing.JComboBox<QLMauSac>();
        txtNamBH = new javax.swing.JTextField();
        txtSoLuongTon = new javax.swing.JTextField();
        txtMoTa = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        txtGiaNhap = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Chi Tiết Sản Phẩm");

        jLabel2.setText("ID:");

        jLabel3.setText("Sản phẩm");

        jLabel4.setText("Nhà sản xuất");

        jLabel5.setText("Dòng sản phẩm");

        jLabel6.setText("Năm bảo hành");

        jLabel7.setText("Màu sắc");

        jLabel8.setText("Số lượng tồn");

        jLabel9.setText("Mô tả");

        jLabel10.setText("Giá bán");

        jLabel11.setText("Giá nhập");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        tblChiTietSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Sản phẩm", "Nhà sản xuất", "Màu sắc", "Dòng sản phẩm", "Năm bảo hành", "Mô tả", "Số lượng tồn", "Giá nhập", "Giá bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChiTietSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblChiTietSP);

        lblID.setText("__");

        cbbSanPham.setModel(new javax.swing.DefaultComboBoxModel<QLSanPham>());

        cbbDongSp.setModel(new javax.swing.DefaultComboBoxModel<QLDongSP>());

        cbbNhaSanXuat.setModel(new javax.swing.DefaultComboBoxModel<QLNhaSanXuat>());

        cbbMauSac.setModel(new javax.swing.DefaultComboBoxModel<QLMauSac>());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(388, 388, 388)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(btnThem)
                                .addGap(58, 58, 58)
                                .addComponent(btnSua)
                                .addGap(73, 73, 73)
                                .addComponent(btnXoa)
                                .addGap(69, 69, 69)
                                .addComponent(btnClear))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11))
                                .addGap(416, 416, 416)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                        .addComponent(cbbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel10))
                                        .addGap(25, 25, 25)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbbDongSp, 0, 279, Short.MAX_VALUE)
                                            .addComponent(txtNamBH)
                                            .addComponent(txtSoLuongTon)
                                            .addComponent(txtGiaBan))))))
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(80, 80, 80)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbbNhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(lblID)
                    .addComponent(cbbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(cbbDongSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbNhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnClear))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int row = this.tblChiTietSP.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn cần chọn môt dòng trên table");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa");
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        String id = (String) this.tblChiTietSP.getValueAt(row, 0);
        this.ctSVc.delete(id);
        this.loadTable();
        JOptionPane.showMessageDialog(this, "Xóa thành công");
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblChiTietSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietSPMouseClicked
        // TODO add your handling code here:
        int row = this.tblChiTietSP.getSelectedRow();
        
        String id = this.tblChiTietSP.getValueAt(row, 0).toString();
        SanPham sp = (SanPham) this.tblChiTietSP.getValueAt(row, 1);
        NhaSanXuat nsx = (NhaSanXuat) this.tblChiTietSP.getValueAt(row, 2);
        MauSac ms = (MauSac) this.tblChiTietSP.getValueAt(row, 3);
        DongSP dSP = (DongSP) this.tblChiTietSP.getValueAt(row, 4);
        String namBH = this.tblChiTietSP.getValueAt(row, 5).toString();
        String mota = this.tblChiTietSP.getValueAt(row, 6).toString();
        String slTon = this.tblChiTietSP.getValueAt(row, 7).toString();
        String giaNhap = this.tblChiTietSP.getValueAt(row, 8).toString();
        String giaBan = this.tblChiTietSP.getValueAt(row, 9).toString();
        
        this.txtGiaBan.setText(giaBan);
        this.txtGiaNhap.setText(giaNhap);
        this.txtMoTa.setText(mota);
        this.txtNamBH.setText(namBH);
        this.txtSoLuongTon.setText(slTon);
        this.lblID.setText(id);
        
        int slSP = this.cbbSanPham.getItemCount();
        for (int i = 0; i < slSP; i++) {
            QLSanPham qlsp = cbbSanPham.getItemAt(i);
            
            if (qlsp.getId().equals(sp.getId())) {
                cbbSanPham.setSelectedIndex(i);
            }
        }
        
        int slNSX = this.cbbNhaSanXuat.getItemCount();
        for (int i = 0; i < slNSX; i++) {
            QLNhaSanXuat qlnsx = cbbNhaSanXuat.getItemAt(i);
            
            if (qlnsx.getId().equals(nsx.getId())) {
                cbbNhaSanXuat.setSelectedIndex(i);
            }
        }
        
        int slMS = this.cbbMauSac.getItemCount();
        for (int i = 0; i < slMS; i++) {
            QLMauSac qlms = cbbMauSac.getItemAt(i);
            
            if (qlms.getId().equals(ms.getId())) {
                cbbMauSac.setSelectedIndex(i);
            }
        }
        
        int sldsp = this.cbbDongSp.getItemCount();
        for (int i = 0; i < sldsp; i++) {
            QLDongSP qldsp = cbbDongSp.getItemAt(i);
            
            if (qldsp.getId().equals(dSP.getId())) {
                cbbDongSp.setSelectedIndex(i);
            }
        }
    }//GEN-LAST:event_tblChiTietSPMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        QLChiTietSP ctSP = this.getFormData();
        if (ctSP == null) {
            return;
        }
        this.ctSVc.insert(ctSP);
        this.loadTable();
        this.clearForm();
        JOptionPane.showMessageDialog(this, "Thêm thành công");
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        this.clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int row = this.tblChiTietSP.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn cần chọn một dòng trên table");
            return;
        }
        QLChiTietSP ctSP = this.getFormData();
        if (ctSP == null) {
            return;
        }
        String id = this.tblChiTietSP.getValueAt(row, 0).toString();
        this.ctSVc.update(id, ctSP);
        this.loadTable();
        this.clearForm();
        JOptionPane.showMessageDialog(this, "Cập nhật thành công");
    }//GEN-LAST:event_btnSuaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChiTietSanPhamJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietSanPhamJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietSanPhamJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietSanPhamJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChiTietSanPhamJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<QLDongSP> cbbDongSp;
    private javax.swing.JComboBox<QLMauSac> cbbMauSac;
    private javax.swing.JComboBox<QLNhaSanXuat> cbbNhaSanXuat;
    private javax.swing.JComboBox<QLSanPham> cbbSanPham;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private javax.swing.JTable tblChiTietSP;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtNamBH;
    private javax.swing.JTextField txtSoLuongTon;
    // End of variables declaration//GEN-END:variables
}
