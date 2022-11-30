/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View.ViewQL;

import DomainModels.ComboModel;
import DomainModels.SanPhamModel;
import Service.DanhMucService;
import Service.impl.ComboServiceImp;
import Service.impl.DanhMucServiceImpl;
import Service.impl.SanPhamServiceImpl;
import Service.impl.SizeServiceImpl;
import ViewModels.DanhMuc;
import ViewModels.SanPham;
import ViewModels.Size;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ViewQuanLySanPham extends javax.swing.JInternalFrame {

    private DefaultTableModel dtm = new DefaultTableModel();
    private List<DanhMuc> listDanhMuc = new ArrayList<>();
    private List<SanPham> listSanPham = new ArrayList<>();
    private List<Size> listSize = new ArrayList<>();
    private List<ComboModel> listCB = new ArrayList<>();
    private SanPhamServiceImpl spService = new SanPhamServiceImpl();
    private DanhMucService danhMucService = new DanhMucServiceImpl();
    private Service.impl.ComboServiceImp comBoImpl = new ComboServiceImp();
    private SizeServiceImpl impl = new SizeServiceImpl();
    private DefaultComboBoxModel dcm = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcm1 = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcm2 = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxCB = new DefaultComboBoxModel();

    /**
     * Creates new form ViewQuanLyBan
     */
    public ViewQuanLySanPham() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI uI = (BasicInternalFrameUI) this.getUI();
        uI.setNorthPane(null);
        jTable1.setModel(dtm);
        String[] header = {"Mã SP", "Tên SP", "Giá Bán", "Danh Mục", "Trạng Thái", "Mô tả", "Size"};
        dtm.setColumnIdentifiers(header);
        listCB = comBoImpl.get_all();
        listDanhMuc = danhMucService.getAll();
        listSanPham = spService.getAll();
        listSize = impl.getAll();
        showCBB(listDanhMuc);
        showCBBLoc(listDanhMuc);
        showData(listSanPham);
        showCBBSize(listSize);
        showCBBComBo(listCB);
    }

    private void showCBBComBo(List<ComboModel> list) {
        cbbComBo.setModel(boxCB);
        for (ComboModel x : list) {
            boxCB.addElement(x.getTenCB());
        }
    }

    private void showData(List<SanPham> list) {
        dtm.setRowCount(0);
        for (SanPham sp : list) {
            dtm.addRow(new Object[]{sp.getMaSP(), sp.getTenSP(), sp.getGiaBan(), sp.getDanhMuc().getTenDanhMuc(), sp.getTrangThai(), sp.getMoTa(), sp.getSize().getSize()});
        }
    }

    private void showCBB(List<DanhMuc> list) {
        cbbDanhMuc.setModel(dcm);
        for (DanhMuc danhMuc : list) {
            dcm.addElement(danhMuc.getTenDanhMuc());
        }
    }

    private void showCBBSize(List<Size> list) {
        cbbSize.setModel(dcm2);
        for (Size Size : list) {
            dcm2.addElement(Size.getSize());
        }
    }

    private void showCBBLoc(List<DanhMuc> list) {
        cbbLocDanhMuc.setModel(dcm1);
        for (DanhMuc danhMuc : list) {
            dcm1.addElement(danhMuc.getTenDanhMuc());
        }
    }

    private void fillData(int index) {
        SanPham sp = listSanPham.get(index);
        txtMa.setText(sp.getMaSP());
        txtName.setText(sp.getTenSP());
        txtGia.setText(String.valueOf(sp.getGiaBan()));
        txtMota.setText(sp.getMoTa());
        cbbDanhMuc.setSelectedItem(sp.getDanhMuc().getTenDanhMuc());
        cbbSize.setSelectedItem(sp.getSize().getSize());
        String tt = sp.getTrangThai();
        if (tt.equalsIgnoreCase("Đang bán")) {
            rdoDangBan.setSelected(true);
        } else {
            rdoNgungBan.setSelected(true);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtMota = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        cbbDanhMuc = new javax.swing.JComboBox<>();
        bltDanhMuc = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbbSize = new javax.swing.JComboBox<>();
        bltSize = new javax.swing.JButton();
        rdoNgungBan = new javax.swing.JRadioButton();
        rdoDangBan = new javax.swing.JRadioButton();
        bltLamMoiDM = new javax.swing.JButton();
        bltLamMoiSize = new javax.swing.JButton();
        cbbComBo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        bltCombo = new javax.swing.JButton();
        bltLamMoiComBo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        cbbLocDanhMuc = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnXoas = new javax.swing.JButton();
        btCapNhat = new javax.swing.JButton();
        btThem = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sản phẩm"));

        jLabel2.setText("Mã");

        jLabel3.setText("Tên");

        jLabel4.setText("Mô tả");

        jLabel5.setText("Danh Mục:");

        jLabel6.setText("Trạng thái");

        jLabel7.setText("Giá bán");

        cbbDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bltDanhMuc.setBackground(new java.awt.Color(0, 0, 0));
        bltDanhMuc.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bltDanhMuc.setForeground(new java.awt.Color(102, 255, 51));
        bltDanhMuc.setText("+");
        bltDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bltDanhMucActionPerformed(evt);
            }
        });

        jLabel9.setText("Size:");

        cbbSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bltSize.setBackground(new java.awt.Color(0, 0, 0));
        bltSize.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bltSize.setForeground(new java.awt.Color(102, 255, 0));
        bltSize.setText("+");
        bltSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bltSizeActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNgungBan);
        rdoNgungBan.setText("Ngừng bán");

        buttonGroup1.add(rdoDangBan);
        rdoDangBan.setText("Đang bán");

        bltLamMoiDM.setBackground(new java.awt.Color(0, 0, 0));
        bltLamMoiDM.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        bltLamMoiDM.setForeground(new java.awt.Color(102, 255, 51));
        bltLamMoiDM.setText("Refesh");
        bltLamMoiDM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bltLamMoiDMActionPerformed(evt);
            }
        });

        bltLamMoiSize.setBackground(new java.awt.Color(0, 0, 0));
        bltLamMoiSize.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        bltLamMoiSize.setForeground(new java.awt.Color(102, 255, 51));
        bltLamMoiSize.setText("Refesh");
        bltLamMoiSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bltLamMoiSizeActionPerformed(evt);
            }
        });

        cbbComBo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("COMBO:");

        bltCombo.setBackground(new java.awt.Color(0, 0, 0));
        bltCombo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bltCombo.setForeground(new java.awt.Color(102, 255, 0));
        bltCombo.setText("+");
        bltCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bltComboActionPerformed(evt);
            }
        });

        bltLamMoiComBo.setBackground(new java.awt.Color(0, 0, 0));
        bltLamMoiComBo.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        bltLamMoiComBo.setForeground(new java.awt.Color(102, 255, 51));
        bltLamMoiComBo.setText("Refesh");
        bltLamMoiComBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bltLamMoiComBoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(58, 58, 58))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(42, 42, 42)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cbbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(bltDanhMuc)
                                        .addGap(18, 18, 18)
                                        .addComponent(bltLamMoiDM))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bltSize)
                                        .addGap(18, 18, 18)
                                        .addComponent(bltLamMoiSize))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(rdoDangBan)
                                .addGap(27, 27, 27)
                                .addComponent(rdoNgungBan)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(cbbComBo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bltCombo)
                        .addGap(18, 18, 18)
                        .addComponent(bltLamMoiComBo)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bltDanhMuc)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addComponent(bltLamMoiDM, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(bltSize)
                                .addComponent(bltLamMoiSize, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbbComBo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(bltCombo)
                                .addComponent(bltLamMoiComBo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(rdoDangBan)
                            .addComponent(rdoNgungBan)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản Phẩm"));
        jPanel3.setPreferredSize(new java.awt.Dimension(814, 678));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc"));

        cbbLocDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbLocDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocDanhMucActionPerformed(evt);
            }
        });

        jLabel8.setText("Danh Mục");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(cbbLocDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbLocDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Sản Phẩm");

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnXoas.setText("Xoá");
        btnXoas.setToolTipText("");
        btnXoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoasActionPerformed(evt);
            }
        });

        btCapNhat.setText("Câp nhật");
        btCapNhat.setToolTipText("");
        btCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCapNhatActionPerformed(evt);
            }
        });

        btThem.setText("Thêm");
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btnClear.setText("Làm mới");
        btnClear.setToolTipText("");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(btnXoas)
                .addGap(18, 18, 18)
                .addComponent(btThem)
                .addGap(18, 18, 18)
                .addComponent(btCapNhat)
                .addGap(18, 18, 18)
                .addComponent(btnClear)
                .addGap(63, 63, 63))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCapNhatActionPerformed
        String ma = txtMa.getText();
        String ten = txtName.getText();
        String gia = txtGia.getText();
        String moTa = txtMota.getText();
        String danhMuc = (String) cbbDanhMuc.getSelectedItem();
        boolean tt = rdoDangBan.isSelected();
        String status = "";
        if (tt) {
            status = "Đang bán";
        } else {
            status = "Ngừng bán";
        }
        String size = (String) cbbSize.getSelectedItem();
        Size sizeImpl = impl.getOne(cbbSize.getSelectedItem().toString());
        DanhMuc dm = danhMucService.getOne(cbbDanhMuc.getSelectedItem().toString());
        SanPhamModel sp = new SanPhamModel(ma, ten, Double.valueOf(gia), moTa, sizeImpl.getId(), dm.getId(), status);
        JOptionPane.showMessageDialog(this, spService.update(sp, ma));
        listDanhMuc = danhMucService.getAll();
        listSanPham = spService.getAll();
        showData(listSanPham);
    }//GEN-LAST:event_btCapNhatActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased

        List<SanPham> listSearch = spService.search(txtSearch.getText());
        showData(listSearch);

    }//GEN-LAST:event_txtSearchKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        fillData(row);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        // TODO add your handling code hereString id = txtId.getText();
        String ma = txtMa.getText();
        String ten = txtName.getText();
        String gia = txtGia.getText();
        String moTa = txtMota.getText();
        String danhMuc = (String) cbbDanhMuc.getSelectedItem();
        boolean tt = rdoDangBan.isSelected();
        String status = "";
        if (tt) {
            status = "Đang bán";
        } else {
            status = "Ngừng bán";
        }
        String size = (String) cbbSize.getSelectedItem();
        Size sizeImpl = impl.getOne(cbbSize.getSelectedItem().toString());
        DanhMuc dm = danhMucService.getOne(cbbDanhMuc.getSelectedItem().toString());
        SanPhamModel sp = new SanPhamModel(ma, ten, Double.valueOf(gia), moTa, sizeImpl.getId(), dm.getId(), status);
        JOptionPane.showMessageDialog(this, spService.add(sp));
        listDanhMuc = danhMucService.getAll();
        listSanPham = spService.getAll();
        showData(listSanPham);
    }//GEN-LAST:event_btThemActionPerformed

    private void btnXoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoasActionPerformed
        JOptionPane.showMessageDialog(this, spService.delete(txtMa.getText()));
        listDanhMuc = danhMucService.getAll();
        listSanPham = spService.getAll();
        showData(listSanPham);
    }//GEN-LAST:event_btnXoasActionPerformed

    private void cbbLocDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocDanhMucActionPerformed
        // TODO add your handling code here:
        List<SanPham> listSearchTenDanhMuc = spService.searchTenDanhMuc((String) cbbLocDanhMuc.getSelectedItem());
        showData(listSearchTenDanhMuc);
    }//GEN-LAST:event_cbbLocDanhMucActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtMa.setText("");
        txtName.setText("");
        txtMota.setText("");
        txtGia.setText("");
        cbbDanhMuc.setSelectedIndex(0);
        cbbSize.setSelectedIndex(0);
        rdoDangBan.setSelected(true);
        rdoNgungBan.setSelected(false);
    }//GEN-LAST:event_btnClearActionPerformed

    private void bltDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bltDanhMucActionPerformed
        ViewDanhMuc viewDM = new ViewDanhMuc();
        viewDM.setVisible(true);
    }//GEN-LAST:event_bltDanhMucActionPerformed

    private void bltSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bltSizeActionPerformed
        ViewSize viewS = new ViewSize();
        viewS.setVisible(true);
    }//GEN-LAST:event_bltSizeActionPerformed

    private void bltLamMoiDMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bltLamMoiDMActionPerformed
        listDanhMuc = danhMucService.getAll();
        showCBB(listDanhMuc);
    }//GEN-LAST:event_bltLamMoiDMActionPerformed

    private void bltLamMoiSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bltLamMoiSizeActionPerformed
        listSize = impl.getAll();
        showCBBSize(listSize);
    }//GEN-LAST:event_bltLamMoiSizeActionPerformed

    private void bltComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bltComboActionPerformed
        ViewComBoSP viewSP = new ViewComBoSP();
        viewSP.setVisible(true);
    }//GEN-LAST:event_bltComboActionPerformed

    private void bltLamMoiComBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bltLamMoiComBoActionPerformed
        listCB = comBoImpl.get_all();
        showCBBComBo(listCB);
    }//GEN-LAST:event_bltLamMoiComBoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bltCombo;
    private javax.swing.JButton bltDanhMuc;
    private javax.swing.JButton bltLamMoiComBo;
    private javax.swing.JButton bltLamMoiDM;
    private javax.swing.JButton bltLamMoiSize;
    private javax.swing.JButton bltSize;
    private javax.swing.JButton btCapNhat;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnXoas;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JComboBox<String> cbbComBo;
    private javax.swing.JComboBox<String> cbbDanhMuc;
    private javax.swing.JComboBox<String> cbbLocDanhMuc;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rdoDangBan;
    private javax.swing.JRadioButton rdoNgungBan;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMota;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
