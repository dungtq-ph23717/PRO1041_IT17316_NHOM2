/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View.ViewQL;

import DomainModels.BanModel;
import DomainModels.HoaDonChiTietModel;
import DomainModels.HoaDonModel;
import DomainModels.KhuVucModel;
import DomainModels.KhuyenMaiModel;
import View.ViewNV.*;
import Service.impl.BanServiceImpl;
import Service.impl.DanhMucServiceImpl;
import Service.impl.HoaDonChiTietServiceIblm;
import Service.impl.HoaDonServiceIblm;
import Service.impl.KhuyenMaiServiceIblm;
import Service.impl.NhanVienServiceImpl;
import Service.impl.SanPhamServiceImpl;
import Service.impl.ToppingServiceImpl;
import ViewModels.Ban;
import ViewModels.DanhMuc;
import ViewModels.HoaDon;
import ViewModels.HoaDonChiTiet;
import ViewModels.KhuVuc;
import ViewModels.KhuyenMai;
import ViewModels.NhanVienViewModel;
import ViewModels.SanPham;
import ViewModels.Topping;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfString;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
    private DefaultComboBoxModel boxModelTP = new DefaultComboBoxModel();
    private List<Ban> listBan = new ArrayList<>();
    private List<DanhMuc> listDM = new ArrayList<>();
    private List<Topping> listTP = new ArrayList<>();
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
    private DefaultComboBoxModel boxKM = new DefaultComboBoxModel();
    private DanhMucServiceImpl implDM = new DanhMucServiceImpl();
    private ToppingServiceImpl implTP = new ToppingServiceImpl();

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
        String[] headersGH = {"Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Topping", "Tổng tiền"};
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

        listTP = implTP.getAll();
        cbbTopping.setModel(boxModelTP);
        for (Topping tp : listTP) {
            boxModelTP.addElement(tp.getTopping());
        }
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
            dtmGioHang.addRow(new Object[]{x.getIdSP().getMaSP(), x.getIdSP().getTenSP(), x.getSoLuong(), x.getIdSP().getGiaBan(), x.getIdTopping().getTopping(), x.getGiaTien()});
        }
    }

    private void showDataBan(List<Ban> list) {
        dtmBan.setRowCount(0);
        for (Ban x : list) {
            dtmBan.addRow(x.toRowDataTT());
        }
    }

    private void clear() {
        txtBan.setText("__");
        txtMa.setText("__");
        txtNgay.setText("__");
        txtNhanVien.setText("__");
        cbbGG.setSelectedIndex(0);
        txtTongTien.setText("0");
        txtTienGiam.setText("0");
        txtTienKhachTra.setText("");
        txtGiaTopping.setText("0");
        txtTienThua.setText("0");
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
        xoaSP = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        tachHD = new javax.swing.JMenuItem();
        gopHD = new javax.swing.JMenuItem();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbGH = new javax.swing.JTable();
        cbbTopping = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btDoi = new javax.swing.JButton();
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
        jPanel1 = new javax.swing.JPanel();
        txtTenSP = new javax.swing.JLabel();
        txtSoL = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtGiaTopping = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
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

        xoaSP.setText("Xoá sản phẩm");
        xoaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaSPActionPerformed(evt);
            }
        });
        jPopupMenu1.add(xoaSP);

        tachHD.setText("Tách HD");
        tachHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tachHDActionPerformed(evt);
            }
        });
        jPopupMenu2.add(tachHD);

        gopHD.setText("Gộp HD");
        gopHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gopHDActionPerformed(evt);
            }
        });
        jPopupMenu2.add(gopHD);

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

        cbbTopping.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Chọn topping");

        btDoi.setText("Đổi");
        btDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDoiActionPerformed(evt);
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
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cbbTopping, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btDoi)
                .addGap(39, 39, 39))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbTopping, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btDoi))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
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
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
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

        txtPrint.setColumns(20);
        txtPrint.setRows(5);
        jScrollPane1.setViewportView(txtPrint);

        jLabel13.setText("Mức giảm:");

        txtTienGiam.setText("0");

        jLabel14.setText("VND");

        txtTenSP.setText("jLabel15");

        txtSoL.setText("jLabel15");

        txtDonGia.setText("jLabel15");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtSoL))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenSP)
                            .addComponent(txtDonGia))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTenSP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtDonGia))
        );

        jLabel15.setText("Giá topping");

        txtGiaTopping.setText("0");

        jLabel16.setText("VND");

        javax.swing.GroupLayout PHoaDonLayout = new javax.swing.GroupLayout(PHoaDon);
        PHoaDon.setLayout(PHoaDonLayout);
        PHoaDonLayout.setHorizontalGroup(
            PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PHoaDonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PHoaDonLayout.createSequentialGroup()
                        .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(PHoaDonLayout.createSequentialGroup()
                                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel13))
                                .addGap(25, 25, 25)
                                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNgay)
                                    .addComponent(txtNhanVien)
                                    .addComponent(txtBan)
                                    .addComponent(txtMa)
                                    .addComponent(cbbGG, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel15)
                            .addComponent(jLabel11))
                        .addGap(15, 15, 15))
                    .addGroup(PHoaDonLayout.createSequentialGroup()
                        .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PHoaDonLayout.createSequentialGroup()
                                .addComponent(bltThanhToan)
                                .addGap(18, 18, 18)
                                .addComponent(cbInHD))
                            .addGroup(PHoaDonLayout.createSequentialGroup()
                                .addComponent(btHuyDon, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addGroup(PHoaDonLayout.createSequentialGroup()
                                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(PHoaDonLayout.createSequentialGroup()
                                            .addComponent(txtTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel10))
                                        .addComponent(txtTienKhachTra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PHoaDonLayout.createSequentialGroup()
                                        .addComponent(txtTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14))
                                    .addGroup(PHoaDonLayout.createSequentialGroup()
                                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9))
                                    .addGroup(PHoaDonLayout.createSequentialGroup()
                                        .addComponent(txtGiaTopping, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(PHoaDonLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PHoaDonLayout.setVerticalGroup(
            PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PHoaDonLayout.createSequentialGroup()
                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PHoaDonLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PHoaDonLayout.createSequentialGroup()
                        .addContainerGap()
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
                        .addGap(18, 18, 18)
                        .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtGiaTopping)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
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
                            .addComponent(cbInHD))))
                .addGap(20, 20, 20)
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
        tbHD.setComponentPopupMenu(jPopupMenu2);
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
            .addGap(0, 168, Short.MAX_VALUE)
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
                    .addComponent(PHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
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
//                    txtTienGiam.setText(String.valueOf(x.getMucGiam()));
                    Double tienTP = Double.valueOf(txtGiaTopping.getText());
                    Double tienGiam = Double.valueOf(txtTienGiam.getText());
                    Double tien = Double.valueOf(txtTongTien.getText());
                    Double tienKhach = Double.valueOf(txtTienKhachTra.getText());
                    Double tienThua = tienKhach - tien;
                    txtTienThua.setText(String.valueOf(tienThua));
                } else if (cbbGG.getSelectedItem() == "Chọn") {
                    Double tienTP = Double.valueOf(txtGiaTopping.getText());
                    Double tien = Double.valueOf(txtTongTien.getText()) - tienTP;
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
                String tp = cbbTopping.getSelectedItem().toString();
                Topping idtp = implTP.getOne(tp);
                int slt = Integer.parseInt(JOptionPane.showInputDialog("Mời bạn nhập số lượng:"));
                if (slt <= 0) {
                    JOptionPane.showMessageDialog(this, "Bạn phải nhập đúng định dạng");
                    return;
                }
                HoaDonChiTietModel hdct = new HoaDonChiTietModel(id, idHD.getID(), slt, idtp.getId());
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
        double tong = 0;
        double tienTP = 0;
        for (int i = 0; i < tbGH.getRowCount(); i++) {
            Double tien = Double.valueOf(tbGH.getValueAt(i, 5).toString());
            tong += tien;
            String tp = tbGH.getValueAt(i, 4).toString();
            Topping top = implTP.getOne(tp);
            tienTP += top.getGia();
        }
        double tongTien = tong + tienTP;
        txtTongTien.setText(String.valueOf(tongTien));
        txtGiaTopping.setText(String.valueOf(tienTP));
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
        int row = tbBan.getSelectedRow();
        Ban b = listBan.get(row);
        ViewTachBan v = new ViewTachBan(b);
        v.setVisible(true);
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
            Double tien = Double.valueOf(txtTongTien.getText());
            Double tienKhach = Double.valueOf(txtTienKhachTra.getText());
            Double tienThua = tienKhach - tien;
            if (tienThua >= 0) {
                if (tbHD.getRowCount() <= 1) {
//                    MessageFormat header = new MessageFormat(title);
//                    MessageFormat footer = new MessageFormat("0,number,integer");
//                    try {
//                        PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
//                        set.add(OrientationRequested.LANDSCAPE);
//                        tbGH.print(JTable.PrintMode.FIT_WIDTH, header, footer, true, set, true);
//                        JOptionPane.showMessageDialog(this, "In thành công !");
//                    } catch (Exception e) {
//                        JOptionPane.showMessageDialog(this, "In thất bại !");
//                    }
                    
                    
                    for (int i = 0; i < tbGH.getSelectedRow(); i++) {
                        String tenSP = tbGH.getValueAt(i, 1).toString();
                        String donG = tbGH.getValueAt(i, 2).toString();
                        String soL = tbGH.getValueAt(i, 3).toString();
                        String tenTP = tbGH.getValueAt(i, 4).toString();
                        txtPrint.append("\t\tHÓA ĐƠN THANH TOÁN \n\n\n\n"
                            + "\t\t   Mã Hóa Đơn:  " + txtMa.getText() + "\n"
                            + "\t\n+++--------------------------------------------------------------------------------------------------------+++\n\n"
                            + "\tBàn:\t\t\t" + txtBan.getText() + "\n\n"
                            + "\tNhân Viên:\t\t\t" + txtNhanVien.getText() + "\n\n"
                            + "\tNgày:\t\t\t" + txtNgay.getText() + "\n\n\n"
                            + "\n\n Tên Sản Phẩm:" + tenSP 
                            + "\n\n Tên Sản Phẩm:" + donG
                                + "\n\n Tên Sản Phẩm:" + soL
                                + "\n\n Tên Sản Phẩm:" + tenTP
                            + "\tMã Giảm Giá:\t\t\t" + cbbGG.getSelectedItem().toString() + "\n\n"
                            + "\tMức Giảm:\t\t\t" + txtTienGiam.getText() + " " + "VND" + "\n\n"
                            + "\tGiá Topping:\t\t\t" + txtGiaTopping.getText() + " " + "VND" + "\n\n"
                            + "\t\n================================================================================\n\n"
                            + "\tTổng tiền:\t\t\t" + txtTongTien.getText() + " " + "VND" + "\n\n\n\n\n\n"
                            + "       +++++++=====CHÚC QUÝ KHÁCH 1 NGÀY TỐT LÀNH !=====+++++++\n\n\n"
                    );
                    }
                    

                    try {
                        txtPrint.print();
                    } catch (PrinterException ex) {
                        Logger.getLogger(ViewThanhToan.class.getName()).log(Level.SEVERE, "In thất bại!", ex);
                    }
                    JOptionPane.showMessageDialog(this, "In thành công!");

                    String ma = txtMa.getText();
                    HoaDonModel hd = new HoaDonModel(ma, ma);
                    JOptionPane.showMessageDialog(this, implHD.update(hd, ma, "Đã thanh toán"));
//                    int row = tbBan.getSelectedRow();
//                    String ten = tbBan.getValueAt(row, 0).toString();
                    String ten = txtBan.getText();
                    Ban b = implBan.getOne(ten);
                    BanModel b2 = new BanModel("Trống");
                    implBan.updateTT(b2, b.getId());
                    listHoaDon = implHD.getAllTTViewHD(b.getId());
                    showDataHD(listHoaDon);
                    listBan = implBan.getAllTT();
                    showDataBan(listBan);
                    listHDCT.clear();
                    showDataHDCT(listHDCT);
                    clear();
                } else {
                    String ma = txtMa.getText();
                    HoaDonModel hd = new HoaDonModel(ma, ma);
                    JOptionPane.showMessageDialog(this, implHD.update(hd, ma, "Đã thanh toán"));
//                    int row = tbBan.getSelectedRow();
//                    String ten = tbBan.getValueAt(row, 0).toString();
                    String ten = txtBan.getText();
                    Ban b = implBan.getOne(ten);
                    listHoaDon = implHD.getAllTTViewHD(b.getId());
                    showDataHD(listHoaDon);
                    listHDCT.clear();
                    showDataHDCT(listHDCT);
                    clear();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không đủ tiền");
            }

        } else {
            int row1 = tbGH.getSelectedRow();
            String maGH = tbGH.getValueAt(row1, 0).toString();
            HoaDonChiTiet hd1 = implHDCT.getOne(maGH);
            Double tien = Double.valueOf(txtTongTien.getText());
            Double tienKhach = Double.valueOf(txtTienKhachTra.getText());
            Double tienThua = tienKhach - tien;
            if (tienThua >= 0) {
                if (tbHD.getRowCount() <= 1) {
                    String ma = txtMa.getText();
                    HoaDonModel hd = new HoaDonModel(ma, ma);
                    JOptionPane.showMessageDialog(this, implHD.update(hd, ma, "Đã thanh toán"));
//                    int row = tbBan.getSelectedRow();
//                    String ten = tbBan.getValueAt(row, 0).toString();
                    String ten = txtBan.getText();
                    Ban b = implBan.getOne(ten);
                    BanModel b2 = new BanModel("Trống");
                    implBan.updateTT(b2, b.getId());
                    listHoaDon = implHD.getAllTTViewHD(b.getId());
                    showDataHD(listHoaDon);
                    listBan = implBan.getAllTT();
                    showDataBan(listBan);
                    listHDCT.clear();
                    showDataHDCT(listHDCT);
                    clear();
                } else {
                    String ma = txtMa.getText();
                    HoaDonModel hd = new HoaDonModel(ma, ma);
                    JOptionPane.showMessageDialog(this, implHD.update(hd, ma, "Đã thanh toán"));
//                    int row = tbBan.getSelectedRow();
//                    String ten = tbBan.getValueAt(row, 0).toString();
                    String ten = txtBan.getText();
                    Ban b = implBan.getOne(ten);
                    listHoaDon = implHD.getAllTTViewHD(b.getId());
                    showDataHD(listHoaDon);
                    listHDCT.clear();
                    showDataHDCT(listHDCT);
                    clear();
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
                double tong = 0;
                double tienTP = 0;
                for (int i = 0; i < tbGH.getRowCount(); i++) {
                    Double tien = Double.valueOf(tbGH.getValueAt(i, 5).toString());
                    tong += tien;
                    String tp = tbGH.getValueAt(i, 4).toString();
                    Topping top = implTP.getOne(tp);
                    tienTP += top.getGia();
                }
                double tongTien = tong + tienTP;
                txtTongTien.setText(String.valueOf(tongTien));
                txtGiaTopping.setText(String.valueOf(tienTP));
            } else {
                for (KhuyenMai x : listKhuyenMai) {
                    if (cbbGG.getSelectedItem() == x.getMaKM()) {
                        txtTienGiam.setText(String.valueOf(x.getMucGiam()));
                    }
                }
            }
            Double tongTien = Double.valueOf(txtTongTien.getText());
            Double tienGiam = Double.valueOf(txtTienGiam.getText());
            Double tien = tongTien - tienGiam;
            txtTongTien.setText(String.valueOf(tien));
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

    private void btHuyDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHuyDonActionPerformed

        if (tbHD.getRowCount() <= 1) {
            String ma = txtMa.getText();
            HoaDonModel hd = new HoaDonModel(ma, ma);
            implHD.update(hd, ma, "Huỷ");
            JOptionPane.showMessageDialog(this, "Huỷ thành công");
//            int row = tbBan.getSelectedRow();
//            String ten = tbBan.getValueAt(row, 0).toString();
            String ten = txtBan.getText();
            Ban b = implBan.getOne(ten);
            BanModel b2 = new BanModel("Trống");
            implBan.updateTT(b2, b.getId());
            listHoaDon = implHD.getAllTTViewHD(b.getId());
            showDataHD(listHoaDon);
            listBan = implBan.getAllTT();
            showDataBan(listBan);
            listHDCT.clear();
            showDataHDCT(listHDCT);
            clear();
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
            clear();
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
        ViewTachBan v = new ViewTachBan(b);
        v.setVisible(true);
    }//GEN-LAST:event_tachBanActionPerformed

    private void xoaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaSPActionPerformed
        HoaDon idHD = implHD.getOne(txtMa.getText());
        int rowSP = tbGH.getSelectedRow();
        String maSP = tbGH.getValueAt(rowSP, 0).toString();
        SanPham sp = implSP.getOne(maSP);
        implHDCT.delete(idHD.getID(), sp.getId());
        listHDCT = implHDCT.getAllviewGH(sp.getId());
        showDataHDCT(listHDCT);
    }//GEN-LAST:event_xoaSPActionPerformed

    private void tachHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tachHDActionPerformed
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
        ViewTachHD v = new ViewTachHD();
        v.setVisible(true);
    }//GEN-LAST:event_tachHDActionPerformed

    private void gopHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gopHDActionPerformed
        ViewTachHD v = new ViewTachHD();
        v.setVisible(true);
    }//GEN-LAST:event_gopHDActionPerformed

    private void btDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDoiActionPerformed
        int rowSP = tbGH.getSelectedRow();
        String maSP = tbGH.getValueAt(rowSP, 0).toString();
        SanPham sp = implSP.getOne(maSP);
        String tp = cbbTopping.getSelectedItem().toString();
        Topping tp1 = implTP.getOne(tp);
        HoaDonChiTietModel hd = new HoaDonChiTietModel("", "", 0, tp1.getId());
        JOptionPane.showMessageDialog(this, implHDCT.updateTP(hd, sp.getId()));
        int row = tbHD.getSelectedRow();
        String ma = tbHD.getValueAt(row, 0).toString();
        HoaDon hd1 = implHD.getOne(ma);
        listHDCT = implHDCT.getAllviewGH(hd1.getID());
        showDataHDCT(listHDCT);
    }//GEN-LAST:event_btDoiActionPerformed

    private void fillDataGH(int index) {
        HoaDonChiTiet hdct = listHDCT.get(index);
        SanPham sp = listSanPham.get(index);

        txtTongTien.setText(String.valueOf(hdct.getGiaTien()));
        txtTenSP.setText(sp.getTenSP());
        txtDonGia.setText(String.valueOf(sp.getGiaBan()));
        txtSoL.setText(String.valueOf(hdct.getSoLuong()));

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
    private javax.swing.JButton btDoi;
    private javax.swing.JButton btHuyDon;
    private javax.swing.JCheckBox cbInHD;
    private javax.swing.JComboBox<String> cbbGG;
    private javax.swing.JComboBox<String> cbbLocDanhMuc;
    private javax.swing.JComboBox<String> cbbTopping;
    private javax.swing.JMenuItem gopBan;
    private javax.swing.JMenuItem gopHD;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPopupMenu puBan;
    private javax.swing.JMenuItem tachBan;
    private javax.swing.JMenuItem tachHD;
    private javax.swing.JTable tbBan;
    private javax.swing.JTable tbGH;
    private javax.swing.JTable tbHD;
    private javax.swing.JTable tbSP;
    private javax.swing.JLabel txtBan;
    private javax.swing.JLabel txtDonGia;
    private javax.swing.JLabel txtGiaTopping;
    private javax.swing.JLabel txtMa;
    private javax.swing.JLabel txtNgay;
    private javax.swing.JLabel txtNhanVien;
    private javax.swing.JTextArea txtPrint;
    private javax.swing.JTextField txtSearchTenSP;
    private javax.swing.JLabel txtSoL;
    private javax.swing.JLabel txtTenSP;
    private javax.swing.JLabel txtTienGiam;
    private javax.swing.JTextField txtTienKhachTra;
    private javax.swing.JLabel txtTienThua;
    private javax.swing.JLabel txtTongTien;
    private javax.swing.JMenuItem updateSL;
    private javax.swing.JMenuItem xoaSP;
    // End of variables declaration//GEN-END:variables
}
