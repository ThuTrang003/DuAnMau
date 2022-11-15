package Views;

import DomainModels.ChucVu;
import DomainModels.CuaHang;
import Services.impl.ChucVuService;
import Services.impl.CuaHangService;
import Services.impl.NhanVienService;
import ViewModels.QLCHucVu;
import ViewModels.QLCuaHang;
import ViewModels.QLNhanVien;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NhanVienJFrame extends javax.swing.JFrame {

    private ChucVuService cvSv;
    private CuaHangService chSv;
    private NhanVienService nvSv;

    public NhanVienJFrame() {
        initComponents();
        this.cvSv = new ChucVuService();
        this.chSv = new CuaHangService();
        this.nvSv = new NhanVienService();
        this.addCbChucVu();
        this.addCbCuaHang();
        this.loadTable();
    }

    public void addCbChucVu() {
        ArrayList<QLCHucVu> categories = this.cvSv.getAll();
        cbbChucVu.setModel(new DefaultComboBoxModel((categories.toArray())));
    }

    public void addCbCuaHang() {
//        DefaultComboBoxModel defaultComboBoxModel = (DefaultComboBoxModel) cbbCuaHang.getModel();
//        for (QLCuaHang ch : lst) {
//            defaultComboBoxModel.addElement(ch.getTen());
//        }
        ArrayList<QLCuaHang> categories = this.chSv.getAll();
        cbbCuaHang.setModel(new DefaultComboBoxModel((categories.toArray())));
    }
    
    private int findIndexComboboxById(String id) {
        int total = this.cbbChucVu.getMaximumRowCount();
        for(int i = 0; i < total; i++) {
            QLCHucVu cv = this.cbbChucVu.getItemAt(i);
//            if (id.equals(cv.)) {
//                return i;
//            }
        }
        return -1;
    }
    
    private int findIndexComboboxById2(String id) {
        int total = this.cbbCuaHang.getMaximumRowCount();
        for(int i = 0; i < total; i++) {
            CuaHang cv = this.cbbCuaHang.getItemAt(i);
            if (id.equals(cv.getId())) {
                return i;
            }
        }
        return -1;
    }

    public void clearForm() {
        this.txtDiaCHi.setText("");
        this.txtHo.setText("");
        this.txtMa.setText("");
        this.txtMatKhau.setText("");
        this.txtNgaySinh.setText("");
        this.txtSdt.setText("");
        this.txtTen.setText("");
        this.txtTendem.setText("");
        this.rdoLam.setSelected(true);
        this.rdoNghi.setSelected(true);
    }

    private void loadTable() {
        ArrayList<QLNhanVien> lst = this.nvSv.getAll();
        DefaultTableModel dtm = (DefaultTableModel) this.tblNhanVien.getModel();
        dtm.setRowCount(0);
        int i = 1;
        for (QLNhanVien x : lst) {
            
            QLNhanVien nv = (QLNhanVien) x;
            dtm.addRow(new Object[]{
                i++,
                nv.getMa(),
                nv.getTen(),
                nv.getTenDem(),
                nv.getHo(),
                nv.getGioiTinh(),
                nv.getNgaySinh(),
                nv.getDiaChi(),
                nv.getSdt(),
                nv.getMatKhau(),
                nv.getChucVu().getTen(),
                nv.getCuaHang().getTen(),
                nv.getTrangThai()
            });
        }
    }

    private QLNhanVien getFormData() {
        String ma = this.txtMa.getText().trim();
        String ten = this.txtTen.getText().trim();
        String tenDem = this.txtTendem.getText().trim();
        String ho = this.txtHo.getText().trim();
        String gioiTinh = this.rdoNam.isSelected() == true ? "Nam" : "Nữ";
        String ngaySinh = this.txtNgaySinh.getText().trim();
        String diaChi = this.txtDiaCHi.getText().trim();
        String sdt = this.txtSdt.getText().trim();
        String matKhau = this.txtMatKhau.getText().trim();

        QLCHucVu cv = (QLCHucVu) this.cbbChucVu.getSelectedItem();
        QLCuaHang ch = (QLCuaHang) this.cbbCuaHang.getSelectedItem();
        int trangThai = this.rdoLam.isSelected() == true ? 1 : 0;

        if (tenDem.length() == 0 || ma.length() == 0 || ten.length() == 0 || ho.length() == 0 || ngaySinh.length() == 0 || diaChi.length() == 0 || sdt.length() == 0 || matKhau.length() == 0) {
            JOptionPane.showMessageDialog(this, "Các trường thông tin không được để trống");
            return null;
        }
        Date date = null;
        Date dayNow = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(ngaySinh);
            if (date.getTime() > dayNow.getTime()) {
                JOptionPane.showMessageDialog(this, "Ngày sinh không tồn tại");
                return null;
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Sai định dạng ngày của ngày sinh phiếu");
            ex.printStackTrace();
        }

        ChucVu chucVu = new ChucVu("", cv.getMa(), cv.getTen());
        CuaHang cuaHang = new CuaHang("", ch.getMa(), ch.getTen(), ch.getDiaChi(), ch.getThanhPho(), ch.getQuocGia());
        QLNhanVien nv = new QLNhanVien(ma, ten, tenDem, ho, gioiTinh, date, diaChi, sdt, matKhau, chucVu, cuaHang, trangThai);
        return nv;
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
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCLear = new javax.swing.JButton();
        txtMa = new javax.swing.JTextField();
        txtDiaCHi = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtHo = new javax.swing.JTextField();
        txtTendem = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JTextField();
        rdoLam = new javax.swing.JRadioButton();
        rdoNghi = new javax.swing.JRadioButton();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        cbbCuaHang = new javax.swing.JComboBox<>();
        cbbChucVu = new javax.swing.JComboBox<QLCHucVu>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mã:");

        jLabel2.setText("Địa chỉ:");

        jLabel3.setText("Tên");

        jLabel4.setText("Sdt");

        jLabel5.setText("Tên đệm");

        jLabel6.setText("Mật khẩu");

        jLabel7.setText("Họ");

        jLabel8.setText("Chức vụ");

        jLabel9.setText("Cửa hàng");

        jLabel10.setText("Ngày sinh:");

        jLabel11.setText("Giới tính:");

        jLabel12.setText("Trạng thái");

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Tên", "Tên đệm", "Họ", "Giới tính", "Ngày sinh", "Địa chỉ", "SĐT", "Mật khẩu", "Chức vụ", "Cửa hàng", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        jLabel13.setText("Quản Lý Nhân VIên");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");

        btnXoa.setText("Xóa");

        btnCLear.setText("CLear");

        rdoLam.setText("Làm");

        rdoNghi.setText("Nghĩ");

        rdoNam.setText("Nam");

        rdoNu.setText("Nữ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(322, 322, 322)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(78, 78, 78)
                                        .addComponent(rdoNu)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTendem, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel8)
                                                    .addComponent(jLabel9)
                                                    .addComponent(jLabel12)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(132, 132, 132)
                                                .addComponent(jLabel4)
                                                .addGap(0, 0, Short.MAX_VALUE))))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(rdoNam)))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdoLam)
                                .addGap(37, 37, 37)
                                .addComponent(rdoNghi))
                            .addComponent(txtDiaCHi)
                            .addComponent(txtSdt)
                            .addComponent(txtMatKhau)
                            .addComponent(cbbCuaHang, 0, 200, Short.MAX_VALUE)
                            .addComponent(cbbChucVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnCLear))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaCHi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtTendem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cbbCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(rdoLam)
                    .addComponent(rdoNghi)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem)
                        .addGap(44, 44, 44)
                        .addComponent(btnSua)
                        .addGap(52, 52, 52)
                        .addComponent(btnXoa)
                        .addGap(43, 43, 43)
                        .addComponent(btnCLear)
                        .addGap(65, 65, 65))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        QLNhanVien nv = this.getFormData();
        if (nv == null) {
            return;
        }
        
        this.nvSv.insert(nv);
        this.loadTable();
        this.clearForm();
        JOptionPane.showMessageDialog(this, "Thêm thành công");
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        // TODO add your handling code here:
        int row = this.tblNhanVien.getSelectedRow();
        
        String ma = this.tblNhanVien.getValueAt(row, 1).toString();
        String ten = this.tblNhanVien.getValueAt(row, 2).toString();
        String tendem = this.tblNhanVien.getValueAt(row, 3).toString();
        String ho = this.tblNhanVien.getValueAt(row, 4).toString();
        String gioiTinh = this.tblNhanVien.getValueAt(row, 5).toString();
        String ngaySinh = this.tblNhanVien.getValueAt(row, 6).toString();
        String diaChi = this.tblNhanVien.getValueAt(row, 7).toString();
        String SDT = this.tblNhanVien.getValueAt(row, 8).toString();
        String matKhau = this.tblNhanVien.getValueAt(row, 9).toString();
        ChucVu chucVu = (ChucVu) this.tblNhanVien.getValueAt(row, 10);
        CuaHang cuaHang = (CuaHang) this.tblNhanVien.getValueAt(row, 11);
        String trangThai = this.tblNhanVien.getValueAt(row, 12).toString();
        
        int cv = findIndexComboboxById(chucVu.getId());
        int ch = findIndexComboboxById(cuaHang.getId());
        
        this.txtMa.setText(ma);
        this.txtDiaCHi.setText(diaChi);
        this.txtHo.setText(ho);
        this.txtMatKhau.setText(matKhau);
        this.txtNgaySinh.setText(ngaySinh);
        this.txtSdt.setText(SDT);
        this.txtTen.setText(ten);
        this.txtTendem.setText(tendem);
        this.cbbChucVu.setSelectedItem(cv);
        this.cbbCuaHang.setSelectedItem(ch);
        
        if (ngaySinh.equals("Nam")) {
            this.rdoNam.setSelected(true);
        } else {
            this.rdoNu.setSelected(true);
        }
        
        if (trangThai.equals("Đang làm")) {
            this.rdoLam.setSelected(true);
        } else {
            this.rdoNghi.setSelected(true);
        }
        
    }//GEN-LAST:event_tblNhanVienMouseClicked

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
            java.util.logging.Logger.getLogger(NhanVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanVienJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCLear;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<QLCHucVu> cbbChucVu;
    private javax.swing.JComboBox<CuaHang> cbbCuaHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JRadioButton rdoLam;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNghi;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtDiaCHi;
    private javax.swing.JTextField txtHo;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTendem;
    // End of variables declaration//GEN-END:variables
}
