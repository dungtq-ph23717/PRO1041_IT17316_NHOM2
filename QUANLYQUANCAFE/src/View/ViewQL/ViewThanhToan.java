/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View.ViewQL;

import DomainModels.BanModel;
import DomainModels.ComboModel;
import DomainModels.HoaDonChiTietModel;
import DomainModels.HoaDonModel;
import DomainModels.KhuyenMaiModel;
import View.ViewNV.*;
import Service.impl.BanServiceImpl;
import Service.impl.ComBoSPServiceImpl;
import Service.impl.ComboServiceImp;
import Service.impl.HoaDonChiTietServiceIblm;
import Service.impl.HoaDonServiceIblm;
import Service.impl.KhuyenMaiServiceIblm;
import Service.impl.NhanVienServiceImpl;
import Service.impl.SanPhamServiceImpl;
import ViewModels.Ban;
import ViewModels.HoaDon;
import ViewModels.HoaDonChiTiet;
import ViewModels.KhuyenMai;
import ViewModels.NhanVienViewModel;
import ViewModels.SanPham;
import java.awt.Color;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SingleSelectionModel;
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
    private List<Ban> listBan = new ArrayList<>();
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

        String[] headersCB = {"ID", "Mã CB", "Tên CB", "Giá bán"};
        tbHD1.setModel(dtmCB);
        dtmCB.setColumnIdentifiers(headersCB);
        listCB = implCB.get_all();
        showDataCB(listCB);

        String[] headersGH = {"Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Tổng tiền"};
        tbGH.setModel(dtmGioHang);
        dtmGioHang.setColumnIdentifiers(headersGH);
//        listHDCT = implHDCT.getAll();
        showDataHDCT(listHDCT);

        listKhuyenMai = implKM.getAll();
        cbbGG.setModel(boxModelGG);
        for (KhuyenMai x : listKhuyenMai) {
            boxModelGG.addElement(x.getMucGiam());
        }

        tachBan.setText("Tách bàn");
        gopban.setText("Gộp bàn");
        tachHD.setText("Tách hoá đơn");
        gopHD.setText("Gộp hoá đơn");
    }

    public String Fomat(double gia) {
        Locale locale = new Locale("vi", "VN");
//        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
//        format.setRoundingMode(RoundingMode.HALF_UP);
        DecimalFormat format = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setGroupingSeparator(',');
        decimalFormatSymbols.setCurrencySymbol("");
        format.setDecimalFormatSymbols(decimalFormatSymbols);
        return format.format(gia);
    }

    private void showDataHDCT(List<HoaDonChiTiet> list) {
        dtmGioHang.setRowCount(0);
        for (HoaDonChiTiet x : list) {
            dtmGioHang.addRow(new Object[]{x.getIdSP().getMaSP(), x.getIdSP().getTenSP(), x.getSoLuong(), Fomat(x.getIdSP().getGiaBan()), Fomat(x.getGiaTien())});
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
            dtmSanPham.addRow(new Object[]{sp.getMaSP(), sp.getTenSP(), Fomat(sp.getGiaBan()), sp.getDanhMuc().getTenDanhMuc(), sp.getTrangThai(), sp.getMoTa(), sp.getSize().getSize()});
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
        tachBan = new javax.swing.JMenuItem();
        gopban = new javax.swing.JMenuItem();
        puHD = new javax.swing.JPopupMenu();
        tachHD = new javax.swing.JMenuItem();
        gopHD = new javax.swing.JMenuItem();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbGH = new javax.swing.JTable();
        btXoaSP = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
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
        btThanhToan = new javax.swing.JButton();
        btHuyHoaDon = new javax.swing.JButton();
        btTaoHoadon = new javax.swing.JButton();
        ckbIn = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbbGG = new javax.swing.JComboBox<>();
        txtTongTien = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbBan = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbHD = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        tbCB = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbSP = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txtSearchTenSP = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbHD1 = new javax.swing.JTable();

        tachBan.setText("jMenuItem1");
        tachBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tachBanActionPerformed(evt);
            }
        });
        puBan.add(tachBan);

        gopban.setText("jMenuItem1");
        gopban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gopbanActionPerformed(evt);
            }
        });
        puBan.add(gopban);

        tachHD.setText("jMenuItem1");
        tachHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tachHDActionPerformed(evt);
            }
        });
        puHD.add(tachHD);

        gopHD.setText("jMenuItem2");
        gopHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gopHDActionPerformed(evt);
            }
        });
        puHD.add(gopHD);

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
        tbGH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbGHMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbGH);

        btXoaSP.setText("Xoá sản phẩm");
        btXoaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btXoaSP)
                .addGap(72, 72, 72))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btXoaSP)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin thanh toán")));

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

        btThanhToan.setText("Thanh toán");
        btThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThanhToanActionPerformed(evt);
            }
        });

        btHuyHoaDon.setText("Huỷ đơn");
        btHuyHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHuyHoaDonActionPerformed(evt);
            }
        });

        btTaoHoadon.setText("Tạo hoá đơn");
        btTaoHoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTaoHoadonActionPerformed(evt);
            }
        });

        ckbIn.setText("In");
        ckbIn.setToolTipText("");

        jLabel1.setText("Phương thức thanh toán");
        jLabel1.setToolTipText("");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Chuyển khoản" }));

        jLabel11.setText("Mã giảm giá");
        jLabel11.setToolTipText("");

        cbbGG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtTongTien.setText("0");

        txtTienThua.setText("0");

        jLabel9.setText("VND");

        jLabel10.setText("VND");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNgay)
                                    .addComponent(txtNhanVien)
                                    .addComponent(txtBan)
                                    .addComponent(txtMa)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btHuyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btTaoHoadon))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btThanhToan)
                                .addGap(18, 18, 18)
                                .addComponent(ckbIn))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbbGG, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                            .addComponent(txtTienThua)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel10))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                            .addComponent(txtTongTien)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9))
                                        .addComponent(txtTienKhachTra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(52, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMa))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBan))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNhanVien))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNgay))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbbGG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTongTien)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTienThua)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btHuyHoaDon)
                    .addComponent(btTaoHoadon))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThanhToan)
                    .addComponent(ckbIn))
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
        tbHD.setComponentPopupMenu(puHD);
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
            .addGap(0, 251, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tbCB.setToolTipText("");

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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtSearchTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tbCB.addTab("Sản phẩm", jPanel7);

        tbHD1.setModel(new javax.swing.table.DefaultTableModel(
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
        tbHD1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHD1MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbHD1);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        );

        tbCB.addTab("Combo", jPanel8);

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
                    .addComponent(tbCB))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tbCB, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1093, 735);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTienKhachTraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachTraKeyReleased
        try {
            int row = tbGH.getSelectedRow();
            String ma = tbGH.getValueAt(row, 0).toString();
            HoaDonChiTiet hd = implHDCT.getOne(ma);
            Double tien = hd.getGiaTien();
            Double tienKhach = Double.valueOf(txtTienKhachTra.getText());
            Double tienThua = tienKhach - tien;
            txtTienThua.setText(String.valueOf(Fomat(Double.valueOf(tienThua))));
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

    private void btXoaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaSPActionPerformed
        HoaDon idHD = implHD.getOne(txtMa.getText());
        int rowSP = tbGH.getSelectedRow();
        String maSP = tbGH.getValueAt(rowSP, 0).toString();
        SanPham sp = implSP.getOne(maSP);
        implHDCT.delete(idHD.getID(), sp.getId());
        listHDCT = implHDCT.getAllviewGH(sp.getId());
        showDataHDCT(listHDCT);
    }//GEN-LAST:event_btXoaSPActionPerformed

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


    private void btTaoHoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTaoHoadonActionPerformed
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
    }//GEN-LAST:event_btTaoHoadonActionPerformed
    private void tachBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tachBanActionPerformed
        JOptionPane.showMessageDialog(this, "Tách bàn");
    }//GEN-LAST:event_tachBanActionPerformed

    private void gopbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gopbanActionPerformed
        JOptionPane.showMessageDialog(this, "Gộp bàn");
    }//GEN-LAST:event_gopbanActionPerformed

    private void tachHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tachHDActionPerformed
        JOptionPane.showMessageDialog(this, "Tách hoá đơn");
    }//GEN-LAST:event_tachHDActionPerformed

    private void gopHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gopHDActionPerformed
        JOptionPane.showMessageDialog(this, "Gộp hoá đơn");
    }//GEN-LAST:event_gopHDActionPerformed

    private void txtSearchTenSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchTenSPKeyReleased
        if (txtSearchTenSP.getText().equalsIgnoreCase("")) {
            showDataSP(listSanPham);
        } else {
            List<SanPham> searchTenSP = implSP.search(txtSearchTenSP.getText());
            showDataSP(searchTenSP);
        }
    }//GEN-LAST:event_txtSearchTenSPKeyReleased

//        JOptionPane.showMessageDialog(this, implHD.delete(txtMa.getText()));
//    }
    private void btHuyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHuyHoaDonActionPerformed
        int index = tbHD.getSelectedRow();

        int sl = listHDCT.size();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "VUI LÒNG CHỌN HÓA ĐƠN MUỐN HỦY");
        } else {
            var temp = JOptionPane.showConfirmDialog(this, "BẠN CÓ CHẮC CHẮN MUỐN HỦY THANH TOÁN KHÔNG?");
            if (temp == 0) {
                HoaDonChiTiet hdct = listHDCT.get(index);
                HoaDon hd = listHoaDon.get(index);
                String idhd = hdct.getIdHD();
                implHDCT.deletehdct(idhd);
                implHDCT.deletehd(idhd);
                listSanPham = implSP.getAll();
                listHoaDon = implHD.getAll();
                listHDCT = (List<HoaDonChiTiet>) implHDCT.getOne(idhd);
                showDataHD(listHoaDon);
                showDataHDCT(listHDCT);
                showDataSP(listSanPham);
//               
//                }

            }
        }


    }//GEN-LAST:event_btHuyHoaDonActionPerformed

    private void tbHD1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHD1MouseClicked

//        try{
//
//            if (txtMa.getText() == "__") {
//                JOptionPane.showMessageDialog(this, "Chưa chọn hoá đơn");
//            } else {
//                int rowcb = tbHD1.getSelectedRow();
//                String macb = tbHD1.getValueAt(rowcb, 1).toString();
//                ComboModel cm1 = implCB.getOne(macb);
//                HoaDon idHD = implHD.getOne(txtMa.getText());
//                String id = cm1.getMaCB();
//                int slt = Integer.parseInt(JOptionPane.showInputDialog("Mời bạn nhập số lượng:"));
//                if (slt <= 0) {
//                    JOptionPane.showMessageDialog(this, "Bạn phải nhập đúng định dạng");
//                    return;
//                }
//                HoaDonChiTietModel hdct = new HoaDonChiTietModel(id, idHD.getID(), slt);
//                implHDCT.add(hdct);
//                listHDCT = implHDCT.getAll();
//                showDataHDCT(listHDCT);
//            }
//            }catch (Exception e) {
//            txtTienThua.setText("0");
//        }

    }//GEN-LAST:event_tbHD1MouseClicked

    private void btThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThanhToanActionPerformed
        if (txtTienKhachTra.getText().equals("") || txtTienKhachTra.getText().matches("\\s+")) {
            JOptionPane.showMessageDialog(this, "vui lòng nhập đầy đủ thông tin");
            txtTienKhachTra.setText("");
            
        } else {
                
            String mahd = txtMa.getText();
            HoaDon hd = new HoaDon("Đã thanh toán");
            implHD.updatetinhtrang(hd, mahd);
            listHoaDon = implHD.getALLCho();
            showDataHD(listHoaDon);
            

            String tenban = txtBan.getText();
            BanModel ban = new BanModel();
            implBan.updateTT(ban, mahd);
            listBan = implBan.getAllTT();
            showDataBan(listBan);
        }

    }//GEN-LAST:event_btThanhToanActionPerformed

    private void fillDataGH(int index) {
        HoaDonChiTiet hdct = listHDCT.get(index);
        txtTongTien.setText(String.valueOf(Fomat(hdct.getGiaTien())));
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
    private javax.swing.JButton btHuyHoaDon;
    private javax.swing.JButton btTaoHoadon;
    private javax.swing.JButton btThanhToan;
    private javax.swing.JButton btXoaSP;
    private javax.swing.JComboBox<String> cbbGG;
    private javax.swing.JCheckBox ckbIn;
    private javax.swing.JMenuItem gopHD;
    private javax.swing.JMenuItem gopban;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPopupMenu puBan;
    private javax.swing.JPopupMenu puHD;
    private javax.swing.JMenuItem tachBan;
    private javax.swing.JMenuItem tachHD;
    private javax.swing.JTable tbBan;
    private javax.swing.JTabbedPane tbCB;
    private javax.swing.JTable tbGH;
    private javax.swing.JTable tbHD;
    private javax.swing.JTable tbHD1;
    private javax.swing.JTable tbSP;
    private javax.swing.JLabel txtBan;
    private javax.swing.JLabel txtMa;
    private javax.swing.JLabel txtNgay;
    private javax.swing.JLabel txtNhanVien;
    private javax.swing.JTextField txtSearchTenSP;
    private javax.swing.JTextField txtTienKhachTra;
    private javax.swing.JLabel txtTienThua;
    private javax.swing.JLabel txtTongTien;
    // End of variables declaration//GEN-END:variables
}
