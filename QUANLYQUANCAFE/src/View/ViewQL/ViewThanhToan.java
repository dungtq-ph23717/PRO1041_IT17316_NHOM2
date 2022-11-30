/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View.ViewQL;

import DomainModels.BanModel;
import DomainModels.ComboModel;
import DomainModels.HoaDonChiTietModel;
import DomainModels.HoaDonModel;
import DomainModels.KhuVucModel;
import DomainModels.KhuyenMaiModel;
import View.ViewNV.*;
import Service.impl.BanServiceImpl;
import Service.impl.ComBoSPServiceImpl;
import Service.impl.ComboServiceImp;
import Service.impl.DanhMucServiceImpl;
import Service.impl.HoaDonChiTietServiceIblm;
import Service.impl.HoaDonServiceIblm;
import Service.impl.KhuyenMaiServiceIblm;
import Service.impl.NhanVienServiceImpl;
import Service.impl.SanPhamServiceImpl;
import ViewModels.Ban;
import ViewModels.DanhMuc;
import ViewModels.HoaDon;
import ViewModels.HoaDonChiTiet;
import ViewModels.KhuVuc;
import ViewModels.KhuyenMai;
import ViewModels.NhanVienViewModel;
import ViewModels.SanPham;
import java.awt.Color;
import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ViewThanhToan extends javax.swing.JInternalFrame {

    private DefaultTableModel dtmBan = new DefaultTableModel();
    private DefaultTableModel dtmGioHang = new DefaultTableModel();
    private DefaultTableModel dtmSanPham = new DefaultTableModel();
    private DefaultTableModel dtmHoaDon = new DefaultTableModel();
    private DefaultTableModel dtmCB = new DefaultTableModel();
    private DefaultComboBoxModel boxModelGG = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxModelDM = new DefaultComboBoxModel();
    private List<Ban> listBan = new ArrayList<>();
    private List<DanhMuc> listDM = new ArrayList<>();
    private List<ComboModel> listCB = new ArrayList<>();
    private List<NhanVienViewModel> listNV = new ArrayList<>();
    private List<KhuyenMai> listKhuyenMai = new ArrayList<>();
    private List<HoaDon> listHoaDon = new ArrayList<>();
    private List<SanPham> listSanPham = new ArrayList<>();
    private List<HoaDonChiTiet> listHDCT = new ArrayList<>();
    private KhuyenMaiServiceIblm implKM = new KhuyenMaiServiceIblm();
    private BanServiceImpl implBan = new BanServiceImpl();
    private SanPhamServiceImpl implSP = new SanPhamServiceImpl();
    private HoaDonServiceIblm implHD = new HoaDonServiceIblm();
    private NhanVienServiceImpl implNV = new NhanVienServiceImpl();
    private HoaDonChiTietServiceIblm implHDCT = new HoaDonChiTietServiceIblm();
    private ComboServiceImp implCB = new ComboServiceImp();
    private DefaultComboBoxModel boxKM = new DefaultComboBoxModel();
    private DanhMucServiceImpl implDM = new DanhMucServiceImpl();

    /**
     * Creates new form Menu1
     */
    public ViewThanhToan() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI uI = (BasicInternalFrameUI) this.getUI();
        uI.setNorthPane(null);

        String[] headersBan = {"Tên bàn", "Loại bàn", "Trạng thái"};
        tbBan.setModel(dtmBan);
        dtmBan.setColumnIdentifiers(headersBan);
        listBan = implBan.getAllTT();
        showDataBan(listBan);

        String[] headersHD = {"Mã HD", "Ngày lập", "Nhân viên", "Trạng thái"};
        tbHD.setModel(dtmHoaDon);
        dtmHoaDon.setColumnIdentifiers(headersHD);
        showDataHD(listHoaDon);

        tbSP.setModel(dtmSanPham);
        String[] headersSP = {"Mã SP", "Tên SP", "Giá Bán", "Danh Mục", "Trạng Thái", "Mô tả", "Size"};
        dtmSanPham.setColumnIdentifiers(headersSP);
        listSanPham = implSP.getAllTT();
        showDataSP(listSanPham);

//        String[] headersCB = {"ID", "Mã CB", "Tên CB", "Giá bán"};
//        tbHD1.setModel(dtmCB);
//        dtmCB.setColumnIdentifiers(headersCB);
//        listCB = implCB.get_all();
//        showDataCB(listCB);
        String[] headersGH = {"Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Tổng tiền"};
        tbGH.setModel(dtmGioHang);
        dtmGioHang.setColumnIdentifiers(headersGH);
//        listHDCT = implHDCT.getAll();
        showDataHDCT(listHDCT);

        listKhuyenMai = implKM.getAll();
        boxModelGG.addElement("Chọn");
        cbbGG.setModel(boxModelGG);
        for (KhuyenMai x : listKhuyenMai) {
            boxModelGG.addElement(x.getMaKM());
        }
        listDM = implDM.getAll();
        boxModelDM.addElement("All");
        cbbLocDanhMuc.setModel(boxModelDM);
        for (DanhMuc danhMuc : listDM) {
            boxModelDM.addElement(danhMuc.getTenDanhMuc());
        }
        cbbPhuongThucThanhToan.setModel(boxKM);
        boxKM.addElement("Tiền mặt");
        boxKM.addElement("ATM");
        //
    }

//    public String Fomat(double gia) {
//        Locale locale = new Locale("vi", "VN");
////        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
////        format.setRoundingMode(RoundingMode.HALF_UP);
//        DecimalFormat format = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
//        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
//        decimalFormatSymbols.setGroupingSeparator(',');
//        decimalFormatSymbols.setCurrencySymbol("");
//        format.setDecimalFormatSymbols(decimalFormatSymbols);
//        return format.format(gia);
//    }
    private void showDataHDCT(List<HoaDonChiTiet> list) {
        dtmGioHang.setRowCount(0);
        for (HoaDonChiTiet x : list) {
            dtmGioHang.addRow(new Object[]{x.getIdSP().getMaSP(), x.getIdSP().getTenSP(), x.getSoLuong(), x.getIdSP().getGiaBan(), x.getGiaTien()});
        }
    }

    private void showDataCB(List<ComboModel> list) {
        dtmCB.setRowCount(0);
        for (ComboModel x : list) {
            dtmCB.addRow(x.toRowData());
        }
    }

    private void showDataBan(List<Ban> list) {
        dtmBan.setRowCount(0);
        for (Ban x : list) {
            dtmBan.addRow(x.toRowDataTT());
        }
    }

    private void showDataSP(List<SanPham> list) {
        dtmSanPham.setRowCount(0);
        for (SanPham sp : list) {
            dtmSanPham.addRow(new Object[]{sp.getMaSP(), sp.getTenSP(), sp.getGiaBan(), sp.getDanhMuc().getTenDanhMuc(), sp.getTrangThai(), sp.getMoTa(), sp.getSize().getSize()});
        }
    }

    private void showDataHD(List<HoaDon> list) {
        dtmHoaDon.setRowCount(0);
        for (HoaDon x : list) {
            dtmHoaDon.addRow(new Object[]{x.getMaHD(), x.getNgayLapHD(), x.getTenNV().getTenNV(), x.getTinhTrang()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        puBan = new javax.swing.JPopupMenu();
        gopBan = new javax.swing.JMenuItem();
        tachBan = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        updateSL = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbGH = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbSP = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txtSearchTenSP = new javax.swing.JTextField();
        cbbLocDanhMuc = new javax.swing.JComboBox<>();
        PHoaDon = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMa = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtBan = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNhanVien = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNgay = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTienKhachTra = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        bltThanhToan = new javax.swing.JButton();
        btHuyDon = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbbPhuongThucThanhToan = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbbGG = new javax.swing.JComboBox<>();
        txtTongTien = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbInHD = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPrint = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        txtTienGiam = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbBan = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbHD = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();

        gopBan.setText("Gộp bàn");
        gopBan.setToolTipText("");
        gopBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gopBanActionPerformed(evt);
            }
        });
        puBan.add(gopBan);

        tachBan.setText("Tách bàn");
        tachBan.setToolTipText("");
        tachBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tachBanActionPerformed(evt);
            }
        });
        puBan.add(tachBan);

        updateSL.setText("Update số lượng");
        updateSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSLActionPerformed(evt);
            }
        });
        jPopupMenu1.add(updateSL);

        jMenuItem1.setText("Xoá sản phẩm");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ hàng"));

        tbGH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbGH.setComponentPopupMenu(jPopupMenu1);
        tbGH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbGHMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbGH);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản phẩm"));

        tbSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSPMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbSP);

        jLabel12.setText("TÌM KIẾM SẢN PHẨM:");

        txtSearchTenSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchTenSPKeyReleased(evt);
            }
        });

        cbbLocDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbLocDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocDanhMucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearchTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(cbbLocDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 35, Short.MAX_VALUE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtSearchTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLocDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        PHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin thanh toán")));

        jLabel2.setText("Mã hoá đơn");

        txtMa.setText("__");

        jLabel3.setText("Bàn");

        txtBan.setText("__");

        jLabel5.setText("Nhân viên");

        txtNhanVien.setText("__");

        jLabel8.setText("Ngày");

        txtNgay.setText("__");

        jLabel4.setText("Tổng tiền");

        jLabel7.setText("Tiền khách trả");

        txtTienKhachTra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachTraKeyReleased(evt);
            }
        });

        jLabel6.setText("Tiền thừa");

        bltThanhToan.setText("Thanh toán");
        bltThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bltThanhToanActionPerformed(evt);
            }
        });

        btHuyDon.setText("Huỷ đơn");
        btHuyDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHuyDonActionPerformed(evt);
            }
        });

        jButton2.setText("Tạo hoá đơn");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Phương thức thanh toán");
        jLabel1.setToolTipText("");

        jLabel11.setText("Mã giảm giá");
        jLabel11.setToolTipText("");

        cbbGG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbGG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbGGActionPerformed(evt);
            }
        });

        txtTongTien.setText("0");

        txtTienThua.setText("0");

        jLabel9.setText("VND");

        jLabel10.setText("VND");

        cbInHD.setText("In hóa đơn");
        cbInHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbInHDActionPerformed(evt);
            }
        });

        txtPrint.setColumns(20);
        txtPrint.setRows(5);
        jScrollPane1.setViewportView(txtPrint);

        jLabel13.setText("Mức giảm:");

        txtTienGiam.setText("0");

        jLabel14.setText("VND");

        javax.swing.GroupLayout PHoaDonLayout = new javax.swing.GroupLayout(PHoaDon);
        PHoaDon.setLayout(PHoaDonLayout);
        PHoaDonLayout.setHorizontalGroup(
            PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PHoaDonLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PHoaDonLayout.createSequentialGroup()
                        .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PHoaDonLayout.createSequentialGroup()
                        .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PHoaDonLayout.createSequentialGroup()
                                .addComponent(bltThanhToan)
                                .addGap(18, 18, 18)
                                .addComponent(cbInHD))
                            .addGroup(PHoaDonLayout.createSequentialGroup()
                                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbbGG, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PHoaDonLayout.createSequentialGroup()
                                            .addComponent(txtTienThua)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel10))
                                        .addGroup(PHoaDonLayout.createSequentialGroup()
                                            .addComponent(txtTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel9))
                                        .addComponent(txtTienKhachTra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PHoaDonLayout.createSequentialGroup()
                                        .addComponent(txtTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14))))
                            .addGroup(PHoaDonLayout.createSequentialGroup()
                                .addComponent(btHuyDon, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addGroup(PHoaDonLayout.createSequentialGroup()
                                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))
                                .addGap(25, 25, 25)
                                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNgay)
                                    .addComponent(txtNhanVien)
                                    .addComponent(txtBan)
                                    .addComponent(txtMa)))
                            .addGroup(PHoaDonLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbPhuongThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );
        PHoaDonLayout.setVerticalGroup(
            PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PHoaDonLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMa))
                .addGap(18, 18, 18)
                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBan))
                .addGap(18, 18, 18)
                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNhanVien))
                .addGap(18, 18, 18)
                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNgay))
                .addGap(18, 18, 18)
                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbbPhuongThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbbGG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTongTien)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTienGiam)
                    .addComponent(jLabel14))
                .addGap(22, 22, 22)
                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTienThua)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btHuyDon)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bltThanhToan)
                    .addComponent(cbInHD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Bàn"));

        tbBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbBan.setComponentPopupMenu(puBan);
        tbBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBanMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbBan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Hoá đơn"));

        tbHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHDMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbHD);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );

        setBounds(0, 0, 1093, 735);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTienKhachTraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachTraKeyReleased
        try {
            for (KhuyenMai x : listKhuyenMai) {
                if (cbbGG.getSelectedItem() == x.getMaKM()) {
                    txtTienGiam.setText(String.valueOf(x.getMucGiam()));
                    int row = tbGH.getSelectedRow();
                    String ma = tbGH.getValueAt(row, 0).toString();
                    HoaDonChiTiet hd = implHDCT.getOne(ma);
                    Double tienGiam = Double.valueOf(x.getMucGiam());
                    Double tien = (Double) tbGH.getValueAt(row, 4) - tienGiam;
                    Double tienKhach = Double.valueOf(txtTienKhachTra.getText());
                    Double tienThua = tienKhach - tien;
                    txtTienThua.setText(String.valueOf(tienThua));
                } else if (cbbGG.getSelectedItem() == "Chọn") {
                    int row = tbGH.getSelectedRow();
                    String ma = tbGH.getValueAt(row, 0).toString();
                    HoaDonChiTiet hd = implHDCT.getOne(ma);
                    Double tien = (Double) tbGH.getValueAt(row, 4);
                    Double tienKhach = Double.valueOf(txtTienKhachTra.getText());
                    Double tienThua = tienKhach - tien;
                    txtTienThua.setText(String.valueOf(tienThua));
                }
            }
        } catch (Exception e) {
            txtTienThua.setText("0");
        }
    }//GEN-LAST:event_txtTienKhachTraKeyReleased

    private void tbSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSPMouseClicked
        try {
            if (txtMa.getText() == "__") {
                JOptionPane.showMessageDialog(this, "Chưa chọn hoá đơn");
            } else {
                int rowSP = tbSP.getSelectedRow();
                String maSP = tbSP.getValueAt(rowSP, 0).toString();
                SanPham sp = implSP.getOne(maSP);
                HoaDon idHD = implHD.getOne(txtMa.getText());
                String id = sp.getId();
                int slt = Integer.parseInt(JOptionPane.showInputDialog("Mời bạn nhập số lượng:"));
                if (slt <= 0) {
                    JOptionPane.showMessageDialog(this, "Bạn phải nhập đúng định dạng");
                    return;
                }
                HoaDonChiTietModel hdct = new HoaDonChiTietModel(id, idHD.getID(), slt);
                implHDCT.add(hdct);
                listHDCT = implHDCT.getAllviewGH(idHD.getID());
                showDataHDCT(listHDCT);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bỏ chọn sản phẩm");
        }
    }//GEN-LAST:event_tbSPMouseClicked

    private void tbHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHDMouseClicked
        int row = tbHD.getSelectedRow();
        fillDataHD(row);
        String ma = tbHD.getValueAt(row, 0).toString();
        HoaDon hd = implHD.getOne(ma);
        listHDCT = implHDCT.getAllviewGH(hd.getID());
        showDataHDCT(listHDCT);
    }//GEN-LAST:event_tbHDMouseClicked

    private void tbGHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGHMouseClicked
        int row = tbGH.getSelectedRow();
        fillDataGH(row);
    }//GEN-LAST:event_tbGHMouseClicked
    private void tbBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBanMouseClicked
        int row = tbBan.getSelectedRow();
        fillDataBan(row);
        String ten = tbBan.getValueAt(row, 0).toString();
        Ban b = implBan.getOne(ten);
        listHoaDon = implHD.getAllTTViewHD(b.getId());
        showDataHD(listHoaDon);
    }//GEN-LAST:event_tbBanMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (txtBan.getText() == "__") {
            JOptionPane.showMessageDialog(this, "Chưa chọn bàn");
        } else {
            Ban b = implBan.getOne(txtBan.getText());
            Random r = new Random();
            int x = r.nextInt(100);
            long millis = System.currentTimeMillis();
            String name;
            HoaDonModel hd = new HoaDonModel(b.getId());
            implHD.add(hd, x + "");
            BanModel b2 = new BanModel("Đang sử dụng");
            implBan.updateTT(b2, b.getId());
            listBan = implBan.getAllTT();
            showDataBan(listBan);
            listHoaDon = implHD.getAllTTViewHD(b.getId());
            showDataHD(listHoaDon);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    private void gopBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gopBanActionPerformed

    }//GEN-LAST:event_gopBanActionPerformed

    private void txtSearchTenSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchTenSPKeyReleased
        if (txtSearchTenSP.getText().equalsIgnoreCase("")) {
            showDataSP(listSanPham);
        } else {
            List<SanPham> searchTenSP = implSP.search(txtSearchTenSP.getText());
            showDataSP(searchTenSP);
        }
    }//GEN-LAST:event_txtSearchTenSPKeyReleased

    private void bltThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bltThanhToanActionPerformed
        if (cbInHD.isSelected() == true) {
            int row1 = tbGH.getSelectedRow();
            String maGH = tbGH.getValueAt(row1, 0).toString();
            HoaDonChiTiet hd1 = implHDCT.getOne(maGH);
            Double tien = hd1.getGiaTien();
            Double tienKhach = Double.valueOf(txtTienKhachTra.getText());
            Double tienThua = tienKhach - tien;
            if (tienThua >= 0) {
                if (tbHD.getRowCount() <= 1) {
                    txtPrint.append("\t\t HÓA ĐƠN THANH TOÁN \n\n\n\n"
                            + "\tMã Hóa Đơn:\t\t\t" + txtMa.getText()
                            + "\t\n=============================================================\n"
                            + "\tBàn:\t\t\t" + txtBan.getText() + "\n\n"
                            + "\tNhân viên:\t\t\t" + txtNhanVien.getText() + "\n\n"
                            + "\tNgày:\t\t\t" + txtNgay.getText() + "\n\n"
                            + "\tPhương thức thanh toán:\t\t" + cbbPhuongThucThanhToan.getSelectedItem().toString() + "\n\n"
                            + "\tMã giảm giá:\t\t\t" + cbbGG.getSelectedItem().toString() + "\n\n"
                            + "\tTổng tiền:\t\t\t" + txtTongTien.getText() + " " + "VND" + "\n\n"
                            + "\t\n=============================================================\n"
                            + "\tTiền khách trả:\t\t\t" + txtTienKhachTra.getText() + " " + "VND" + "\n\n"
                            + "\tTiền thừa:\t\t\t" + txtTienThua.getText() + " " + "VND" + "\n\n\n\n"
                            + "\t=====Chúc quý khách một ngày vui vẻ!=====\n\n\n\n\n"
                    );
                    try {
                        txtPrint.print();
                    } catch (PrinterException ex) {
                        Logger.getLogger(ViewThanhToan.class.getName()).log(Level.SEVERE, "In thất bại!", ex);
                    }
                    JOptionPane.showMessageDialog(this, "Print done!");

                    String ma = txtMa.getText();
                    HoaDonModel hd = new HoaDonModel(ma, ma);
                    JOptionPane.showMessageDialog(this, implHD.update(hd, ma, "Đã thanh toán"));
                    int row = tbBan.getSelectedRow();
                    String ten = tbBan.getValueAt(row, 0).toString();
                    Ban b = implBan.getOne(ten);
                    BanModel b2 = new BanModel("Trống");
                    implBan.updateTT(b2, b.getId());
                    listHoaDon = implHD.getAllTTViewHD(b.getId());
                    showDataHD(listHoaDon);
                    listBan = implBan.getAllTT();
                    showDataBan(listBan);
                    listHDCT = implHDCT.getAllviewGH("");
                    showDataHDCT(listHDCT);
                } else {
                    String ma = txtMa.getText();
                    HoaDonModel hd = new HoaDonModel(ma, ma);
                    JOptionPane.showMessageDialog(this, implHD.update(hd, ma, "Đã thanh toán"));
                    int row = tbBan.getSelectedRow();
                    String ten = tbBan.getValueAt(row, 0).toString();
                    Ban b = implBan.getOne(ten);
                    listHoaDon = implHD.getAllTTViewHD(b.getId());
                    showDataHD(listHoaDon);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không đủ tiền");
            }

        } else {
            int row1 = tbGH.getSelectedRow();
            String maGH = tbGH.getValueAt(row1, 0).toString();
            HoaDonChiTiet hd1 = implHDCT.getOne(maGH);
            Double tien = hd1.getGiaTien();
            Double tienKhach = Double.valueOf(txtTienKhachTra.getText());
            Double tienThua = tienKhach - tien;
            if (tienThua >= 0) {
                if (tbHD.getRowCount() <= 1) {
                    String ma = txtMa.getText();
                    HoaDonModel hd = new HoaDonModel(ma, ma);
                    JOptionPane.showMessageDialog(this, implHD.update(hd, ma, "Đã thanh toán"));
                    int row = tbBan.getSelectedRow();
                    String ten = tbBan.getValueAt(row, 0).toString();
                    Ban b = implBan.getOne(ten);
                    BanModel b2 = new BanModel("Trống");
                    implBan.updateTT(b2, b.getId());
                    listHoaDon = implHD.getAllTTViewHD(b.getId());
                    showDataHD(listHoaDon);
                    listBan = implBan.getAllTT();
                    showDataBan(listBan);
                    listHDCT = implHDCT.getAllviewGH("");
                    showDataHDCT(listHDCT);
                } else {
                    String ma = txtMa.getText();
                    HoaDonModel hd = new HoaDonModel(ma, ma);
                    JOptionPane.showMessageDialog(this, implHD.update(hd, ma, "Đã thanh toán"));
                    int row = tbBan.getSelectedRow();
                    String ten = tbBan.getValueAt(row, 0).toString();
                    Ban b = implBan.getOne(ten);
                    listHoaDon = implHD.getAllTTViewHD(b.getId());
                    showDataHD(listHoaDon);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không đủ tiền");
            }

        }
    }//GEN-LAST:event_bltThanhToanActionPerformed

    private void cbbGGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbGGActionPerformed
        try {
            if (cbbGG.getSelectedItem().toString().equalsIgnoreCase("Chọn")) {
                txtTienGiam.setText("0");
                int row = tbGH.getSelectedRow();
                fillDataGH(row);
            } else {
                for (KhuyenMai x : listKhuyenMai) {
                    if (cbbGG.getSelectedItem() == x.getMaKM()) {
                        txtTienGiam.setText(String.valueOf(x.getMucGiam()));
                        int row = tbGH.getSelectedRow();
                        String ma = tbGH.getValueAt(row, 0).toString();
                        HoaDonChiTiet hd = implHDCT.getOne(ma);
                        Double tienGiam = Double.valueOf(x.getMucGiam());
                        Double tien = hd.getGiaTien() - tienGiam;
                        txtTongTien.setText(String.valueOf(tien));
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm");
            txtTienGiam.setText("0");
        }
    }//GEN-LAST:event_cbbGGActionPerformed

    private void cbbLocDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocDanhMucActionPerformed
        if (cbbLocDanhMuc.getSelectedItem().toString().equalsIgnoreCase("All")) {
            listSanPham = implSP.getAllTT();
            showDataSP(listSanPham);
        } else {
            List<SanPham> listSearchTenDanhMuc = implSP.searchTenDanhMuc((String) cbbLocDanhMuc.getSelectedItem());
            showDataSP(listSearchTenDanhMuc);
        }
    }//GEN-LAST:event_cbbLocDanhMucActionPerformed

    private void cbInHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbInHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbInHDActionPerformed

    private void btHuyDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHuyDonActionPerformed

        if (tbHD.getRowCount() <= 1) {
            String ma = txtMa.getText();
            HoaDonModel hd = new HoaDonModel(ma, ma);
            implHD.update(hd, ma, "Huỷ");
            JOptionPane.showMessageDialog(this, "Huỷ thành công");
            int row = tbBan.getSelectedRow();
            String ten = tbBan.getValueAt(row, 0).toString();
            Ban b = implBan.getOne(ten);
            BanModel b2 = new BanModel("Trống");
            implBan.updateTT(b2, b.getId());
            listHoaDon = implHD.getAllTTViewHD(b.getId());
            showDataHD(listHoaDon);
            listBan = implBan.getAllTT();
            showDataBan(listBan);
            listHDCT.clear();
            showDataHDCT(listHDCT);
        } else {
            String ma = txtMa.getText();
            HoaDonModel hd = new HoaDonModel(ma, ma);
            implHD.update(hd, ma, "Huỷ");
            JOptionPane.showMessageDialog(this, "Huỷ thành công");
            int row = tbBan.getSelectedRow();
            String ten = tbBan.getValueAt(row, 0).toString();
            Ban b = implBan.getOne(ten);
            listHoaDon = implHD.getAllTTViewHD(b.getId());
            showDataHD(listHoaDon);
            listHDCT.clear();
            showDataHDCT(listHDCT);
        }
    }//GEN-LAST:event_btHuyDonActionPerformed

    private void updateSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSLActionPerformed
        int rowSP = tbGH.getSelectedRow();
        String maSP = tbGH.getValueAt(rowSP, 0).toString();
        SanPham sp = implSP.getOne(maSP);
        HoaDon idHD = implHD.getOne(txtMa.getText());
        String id = sp.getId();
        int slt = Integer.parseInt(JOptionPane.showInputDialog("Mời bạn nhập số lượng:"));
        if (slt <= 0) {
            JOptionPane.showMessageDialog(this, "Bạn phải nhập đúng định dạng");
            return;
        }
        HoaDonChiTietModel hdct = new HoaDonChiTietModel(slt);
        implHDCT.update(hdct, idHD.getID(), id);
        listHDCT = implHDCT.getAllviewGH(idHD.getID());
        showDataHDCT(listHDCT);
    }//GEN-LAST:event_updateSLActionPerformed

    private void tachBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tachBanActionPerformed
        int row = tbBan.getSelectedRow();
        String ten = txtBan.getText();
        Ban idKV = implBan.getOne(ten);
        BanModel ban = new BanModel(ten + "-tách", "Nhỏ", "Trống");
        JOptionPane.showMessageDialog(this, "Tách bàn thành công");
        implBan.add(ban);
        listBan = implBan.getAllTT();
        showDataBan(listBan);
        Ban b = listBan.get(row);
        ViewTachBan v = new ViewTachBan();
        v.setVisible(true);
    }//GEN-LAST:event_tachBanActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        HoaDon idHD = implHD.getOne(txtMa.getText());
        int rowSP = tbGH.getSelectedRow();
        String maSP = tbGH.getValueAt(rowSP, 0).toString();
        SanPham sp = implSP.getOne(maSP);
        implHDCT.delete(idHD.getID(), sp.getId());
        listHDCT = implHDCT.getAllviewGH(sp.getId());
        showDataHDCT(listHDCT);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void fillDataGH(int index) {
        HoaDonChiTiet hdct = listHDCT.get(index);
        txtTongTien.setText(String.valueOf(hdct.getGiaTien()));
    }

    private void fillDataBan(int index) {
        Ban b = listBan.get(index);
        txtBan.setText(b.getTenBan());
    }

    private void fillDataHD(int index) {
        HoaDon hd = listHoaDon.get(index);
        txtMa.setText(hd.getMaHD());
        txtNgay.setText(hd.getNgayLapHD());
        txtNhanVien.setText(hd.getTenNV().getTenNV());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PHoaDon;
    private javax.swing.JButton bltThanhToan;
    private javax.swing.JButton btHuyDon;
    private javax.swing.JCheckBox cbInHD;
    private javax.swing.JComboBox<String> cbbGG;
    private javax.swing.JComboBox<String> cbbLocDanhMuc;
    private javax.swing.JComboBox<String> cbbPhuongThucThanhToan;
    private javax.swing.JMenuItem gopBan;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPopupMenu puBan;
    private javax.swing.JMenuItem tachBan;
    private javax.swing.JTable tbBan;
    private javax.swing.JTable tbGH;
    private javax.swing.JTable tbHD;
    private javax.swing.JTable tbSP;
    private javax.swing.JLabel txtBan;
    private javax.swing.JLabel txtMa;
    private javax.swing.JLabel txtNgay;
    private javax.swing.JLabel txtNhanVien;
    private javax.swing.JTextArea txtPrint;
    private javax.swing.JTextField txtSearchTenSP;
    private javax.swing.JLabel txtTienGiam;
    private javax.swing.JTextField txtTienKhachTra;
    private javax.swing.JLabel txtTienThua;
    private javax.swing.JLabel txtTongTien;
    private javax.swing.JMenuItem updateSL;
    // End of variables declaration//GEN-END:variables
}
