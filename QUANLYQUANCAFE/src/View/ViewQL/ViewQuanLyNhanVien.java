/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View.ViewQL;

import DomainModels.ChucVu;
import DomainModels.NhanVienModel;
import Repository.NhanVienRepository;
import Service.ChucVuService;

import Service.NhanVienService;
import Service.impl.ChucVuServiceImpl;
import Service.impl.NhanVienServiceImpl;
import ViewModels.NhanVienViewModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ViewQuanLyNhanVien extends javax.swing.JInternalFrame {

    private DefaultTableModel dtmcv = new DefaultTableModel();
    private List<NhanVienModel> listNV = new ArrayList<>();
    private List<NhanVienViewModel> list = new ArrayList<>();
    private DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
    private DefaultTableModel dtm = new DefaultTableModel();
    private NhanVienService nhanVienService = new NhanVienServiceImpl();
    private List<ChucVu> listcv = new ArrayList<>();
    private ChucVuService chucVuService = new ChucVuServiceImpl();
    private DefaultComboBoxModel modelGT = new DefaultComboBoxModel();

    /**
     * Creates new form ViewNhanVien
     */
    public ViewQuanLyNhanVien() {
        initComponents();

        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI uI = (BasicInternalFrameUI) this.getUI();
        uI.setNorthPane(null);

        txtID.disable();
        tableNhanVien.setModel(dtm);
        String[] header = {"ID", "MÃ NV", "TÊN NV", "NGÀY SINH", "SĐT", "CHỨC VỤ", "Trạng thái", "GIỚI TÍNH", "ĐỊA CHỈ"};
        dtm.setColumnIdentifiers(header);
        listcv = chucVuService.getAll();
        list = nhanVienService.getAll();
        showDATAnv(list);
        showCombOBOX(listcv);
        LocCHUCVU(listcv);

    }

    private void showDATAnv(List<NhanVienViewModel> lits) {

        dtm.setRowCount(0);
        for (NhanVienViewModel nv : lits) {
            dtm.addRow(nv.toRowData());

        }

    }

    private void LocCHUCVU(List<ChucVu> lits) {

        modelGT = (DefaultComboBoxModel) cbbLocCHUCvu.getModel();
        for (ChucVu chucVu : lits) {
            modelGT.addElement(chucVu.getTenCV());

        }
    }

    private NhanVienModel getdata() {
        NhanVienModel nhanVien = new NhanVienModel();
        nhanVien.setMaNV(txtMaNV.getText());
        nhanVien.setTenNV(txtTENNV.getText());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(txtNgaySinh.getDate());
        nhanVien.setNgaySinh(date);
        nhanVien.setSDT(txtSĐT.getText());
        int indextencv = CBBchucVu.getSelectedIndex();
        ChucVu chucVu = listcv.get(indextencv);
        nhanVien.setIdCV(chucVu.getID());
        if (rdoDANGLAM.isSelected()) {
            nhanVien.setTrangThai(true);
        } else {
            nhanVien.setTrangThai(false);
        }

        if (RDONam.isSelected()) {
            nhanVien.setGioiTinh(true);
        } else {
            nhanVien.setGioiTinh(false);
        }

        nhanVien.setDiaChi(txtDiachi.getText());

        return nhanVien;

    }

    private void showCombOBOX(List<ChucVu> listcv) {
        listcv = chucVuService.getAll();
        comboBoxModel = (DefaultComboBoxModel) CBBchucVu.getModel();
        for (ChucVu chucVu : listcv) {
            comboBoxModel.addElement(chucVu.getTenCV());

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

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuBar6 = new javax.swing.JMenuBar();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenuBar7 = new javax.swing.JMenuBar();
        jMenu11 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jMenuBar8 = new javax.swing.JMenuBar();
        jMenu13 = new javax.swing.JMenu();
        jMenu14 = new javax.swing.JMenu();
        jMenuBar9 = new javax.swing.JMenuBar();
        jMenu15 = new javax.swing.JMenu();
        jMenu16 = new javax.swing.JMenu();
        jMenuBar10 = new javax.swing.JMenuBar();
        jMenu17 = new javax.swing.JMenu();
        jMenu18 = new javax.swing.JMenu();
        jMenuBar11 = new javax.swing.JMenuBar();
        jMenu19 = new javax.swing.JMenu();
        jMenu20 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuBar12 = new javax.swing.JMenuBar();
        jMenu21 = new javax.swing.JMenu();
        jMenu22 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        txtNgAYSINH = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        txtTENNV = new javax.swing.JTextField();
        CBBchucVu = new javax.swing.JComboBox<>();
        txtDiachi = new javax.swing.JTextField();
        txtSĐT = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        RDONam = new javax.swing.JRadioButton();
        RDONu = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        rdoDANGLAM = new javax.swing.JRadioButton();
        RDODaNghiViec = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        BTADD = new javax.swing.JButton();
        btUPDATE = new javax.swing.JButton();
        BTDELETE = new javax.swing.JButton();
        BTCLEAR = new javax.swing.JButton();
        btChucVu = new javax.swing.JButton();
        BTRESET = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        cbbLocCHUCvu = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        txtTimKIEM = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableNhanVien = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar3.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar3.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar4.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar4.add(jMenu6);

        jMenu7.setText("File");
        jMenuBar5.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar5.add(jMenu8);

        jMenu9.setText("File");
        jMenuBar6.add(jMenu9);

        jMenu10.setText("Edit");
        jMenuBar6.add(jMenu10);

        jMenu11.setText("File");
        jMenuBar7.add(jMenu11);

        jMenu12.setText("Edit");
        jMenuBar7.add(jMenu12);

        jMenu13.setText("File");
        jMenuBar8.add(jMenu13);

        jMenu14.setText("Edit");
        jMenuBar8.add(jMenu14);

        jMenu15.setText("File");
        jMenuBar9.add(jMenu15);

        jMenu16.setText("Edit");
        jMenuBar9.add(jMenu16);

        jMenu17.setText("File");
        jMenuBar10.add(jMenu17);

        jMenu18.setText("Edit");
        jMenuBar10.add(jMenu18);

        jMenu19.setText("File");
        jMenuBar11.add(jMenu19);

        jMenu20.setText("Edit");
        jMenuBar11.add(jMenu20);

        jMenuItem2.setText("jMenuItem2");

        jMenu21.setText("File");
        jMenuBar12.add(jMenu21);

        jMenu22.setText("Edit");
        jMenuBar12.add(jMenu22);

        setPreferredSize(new java.awt.Dimension(814, 678));

        txtNgAYSINH.setBorder(javax.swing.BorderFactory.createTitledBorder("THIẾT KẾ THÔNG TIN NHÂN VIÊN"));

        jLabel5.setText("ID");

        jLabel9.setText("MÃ NHÂN VIÊN");

        jLabel10.setText("TÊN NHÂN VIÊN");

        jLabel11.setText("CHỨC VỤ");

        jLabel12.setText("ĐỊA CHỈ");

        jLabel13.setText("SĐT");

        jLabel14.setText("GIỚI TÍNH");

        buttonGroup1.add(RDONam);
        RDONam.setSelected(true);
        RDONam.setText("NAM");

        buttonGroup1.add(RDONu);
        RDONu.setText("NỮ");

        jLabel15.setText("TRẠNG THÁI");

        buttonGroup2.add(rdoDANGLAM);
        rdoDANGLAM.setSelected(true);
        rdoDANGLAM.setText("ĐANG LÀM VIỆC");

        buttonGroup2.add(RDODaNghiViec);
        RDODaNghiViec.setText("ĐÃ NGHỈ VIỆC");

        jLabel16.setText("NGÀY SINH");

        BTADD.setText("ADD");
        BTADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTADDActionPerformed(evt);
            }
        });

        btUPDATE.setText("UPDATE");
        btUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUPDATEActionPerformed(evt);
            }
        });

        BTDELETE.setText("DELETE");
        BTDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTDELETEActionPerformed(evt);
            }
        });

        BTCLEAR.setText("CLEAR");
        BTCLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTCLEARActionPerformed(evt);
            }
        });

        btChucVu.setText("jButton5");
        btChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChucVuActionPerformed(evt);
            }
        });

        BTRESET.setText("RESET");
        BTRESET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTRESETActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txtNgAYSINHLayout = new javax.swing.GroupLayout(txtNgAYSINH);
        txtNgAYSINH.setLayout(txtNgAYSINHLayout);
        txtNgAYSINHLayout.setHorizontalGroup(
            txtNgAYSINHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtNgAYSINHLayout.createSequentialGroup()
                .addGroup(txtNgAYSINHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtNgAYSINHLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTADD, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btUPDATE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(txtNgAYSINHLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(txtNgAYSINHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(txtNgAYSINHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CBBchucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTENNV, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(btChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(txtNgAYSINHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtNgAYSINHLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(BTDELETE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(BTCLEAR, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(BTRESET, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))
                    .addGroup(txtNgAYSINHLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(txtNgAYSINHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txtNgAYSINHLayout.createSequentialGroup()
                                .addGroup(txtNgAYSINHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(47, 47, 47)
                                .addGroup(txtNgAYSINHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RDONam, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSĐT, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rdoDANGLAM)
                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))
                            .addGroup(txtNgAYSINHLayout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(txtNgAYSINHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RDONu, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(RDODaNghiViec, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(txtNgAYSINHLayout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        txtNgAYSINHLayout.setVerticalGroup(
            txtNgAYSINHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtNgAYSINHLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(txtNgAYSINHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtSĐT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(txtNgAYSINHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(RDONam)
                    .addComponent(RDONu))
                .addGap(15, 15, 15)
                .addGroup(txtNgAYSINHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTENNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(rdoDANGLAM)
                    .addComponent(RDODaNghiViec))
                .addGap(22, 22, 22)
                .addGroup(txtNgAYSINHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(txtNgAYSINHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(CBBchucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(btChucVu)))
                .addGap(23, 23, 23)
                .addGroup(txtNgAYSINHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(txtNgAYSINHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTCLEAR)
                    .addComponent(BTDELETE)
                    .addComponent(btUPDATE)
                    .addComponent(BTADD)
                    .addComponent(BTRESET))
                .addGap(23, 23, 23))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("LỌC"));

        jLabel17.setText("LỌC CHỨC VỤ");

        cbbLocCHUCvu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        cbbLocCHUCvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocCHUCvuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbbLocCHUCvu, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbLocCHUCvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("TÌM KIẾM"));

        txtTimKIEM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKIEMActionPerformed(evt);
            }
        });
        txtTimKIEM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKIEMKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(txtTimKIEM, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTimKIEM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("THÔNG TIN NHÂN VIÊN"));

        tableNhanVien.setModel(new javax.swing.table.DefaultTableModel(
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
        tableNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableNhanVien);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtNgAYSINH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txtNgAYSINH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1058, 711);
    }// </editor-fold>//GEN-END:initComponents

    private void tableNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableNhanVienMouseClicked
        int row = tableNhanVien.getSelectedRow();
        txtID.setText(tableNhanVien.getValueAt(row, 0).toString());
        txtMaNV.setText(tableNhanVien.getValueAt(row, 1).toString());
        txtTENNV.setText(tableNhanVien.getValueAt(row, 2).toString());

        try {
            Date date = (Date) new SimpleDateFormat("yyyy-MM-dd").parse((String) tableNhanVien.getValueAt(row, 3));
            txtNgaySinh.setDate(date);
        } catch (ParseException ex) {

        }
        txtSĐT.setText(tableNhanVien.getValueAt(row, 4).toString());
        CBBchucVu.setSelectedItem(tableNhanVien.getValueAt(row, 5).toString());
        String check = tableNhanVien.getValueAt(row, 6).toString();
        if (check.contains("ĐANG LÀM VIỆC")) {
            rdoDANGLAM.setSelected(true);

        } else {
            RDODaNghiViec.setSelected(true);
        }
        String check1 = tableNhanVien.getValueAt(row, 7).toString();
        if (check1.contains("NAM")) {
            RDONam.setSelected(true);

        } else {
            RDONu.setSelected(true);
        }
        txtDiachi.setText(tableNhanVien.getValueAt(row, 8).toString());


    }//GEN-LAST:event_tableNhanVienMouseClicked

    private void txtTimKIEMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKIEMKeyReleased
        if (txtTimKIEM.getText().isEmpty()) {
            showDATAnv(list);
        } else {
            String ma = txtTimKIEM.getText();
            List<NhanVienViewModel> search = nhanVienService.getTimkiem(ma);
            showDATAnv(search);
        }
    }//GEN-LAST:event_txtTimKIEMKeyReleased

    private void txtTimKIEMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKIEMActionPerformed

    }//GEN-LAST:event_txtTimKIEMActionPerformed

    private void BTADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTADDActionPerformed
        JOptionPane.showMessageDialog(this, nhanVienService.add(getdata()));
        list = nhanVienService.getAll();
        showDATAnv(list);
    }//GEN-LAST:event_BTADDActionPerformed

    private void btUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUPDATEActionPerformed
        JOptionPane.showMessageDialog(this, nhanVienService.update(getdata(), txtID.getText()));
        list = nhanVienService.getAll();
        showDATAnv(list);
    }//GEN-LAST:event_btUPDATEActionPerformed

    private void BTDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTDELETEActionPerformed
        JOptionPane.showMessageDialog(this, nhanVienService.delete(txtID.getText()));
        list = nhanVienService.getAll();
        showDATAnv(list);
    }//GEN-LAST:event_BTDELETEActionPerformed

    private void BTCLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTCLEARActionPerformed
        txtID.setText("");
        txtMaNV.setText("");
        txtNgaySinh.setDate(null);
        txtTENNV.setText("");
        txtDiachi.setText("");
        txtSĐT.setText("");
        RDONam.setSelected(true);
        rdoDANGLAM.setSelected(true);
        CBBchucVu.setSelectedIndex(0);
    }//GEN-LAST:event_BTCLEARActionPerformed

    private void cbbLocCHUCvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocCHUCvuActionPerformed
        if (cbbLocCHUCvu.getSelectedItem().toString().equalsIgnoreCase("All")) {
            list = nhanVienService.getAll();
            showDATAnv(list);
        } else {

            List<NhanVienViewModel> listloc = nhanVienService.locchucvu((String) cbbLocCHUCvu.getSelectedItem());
            showDATAnv(listloc);
        }
    }//GEN-LAST:event_cbbLocCHUCvuActionPerformed

    private void btChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChucVuActionPerformed
        ViewChucVu chucVu = new ViewChucVu(null, true);
        chucVu.setVisible(true);

    }//GEN-LAST:event_btChucVuActionPerformed

    private void BTRESETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTRESETActionPerformed
        CBBchucVu.setModel(comboBoxModel);
        for (ChucVu x : listcv) {
            comboBoxModel.removeAllElements();
        }
        for (ChucVu x : listcv) {
            comboBoxModel.addElement(x.getTenCV());
        }
        listcv = chucVuService.getAll();
        showCombOBOX(listcv);

    }//GEN-LAST:event_BTRESETActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTADD;
    private javax.swing.JButton BTCLEAR;
    private javax.swing.JButton BTDELETE;
    private javax.swing.JButton BTRESET;
    private javax.swing.JComboBox<String> CBBchucVu;
    private javax.swing.JRadioButton RDODaNghiViec;
    private javax.swing.JRadioButton RDONam;
    private javax.swing.JRadioButton RDONu;
    private javax.swing.JButton btChucVu;
    private javax.swing.JButton btUPDATE;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbLocCHUCvu;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenu jMenu19;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu20;
    private javax.swing.JMenu jMenu21;
    private javax.swing.JMenu jMenu22;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar10;
    private javax.swing.JMenuBar jMenuBar11;
    private javax.swing.JMenuBar jMenuBar12;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuBar jMenuBar6;
    private javax.swing.JMenuBar jMenuBar7;
    private javax.swing.JMenuBar jMenuBar8;
    private javax.swing.JMenuBar jMenuBar9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoDANGLAM;
    private javax.swing.JTable tableNhanVien;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JPanel txtNgAYSINH;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JTextField txtSĐT;
    private javax.swing.JTextField txtTENNV;
    private javax.swing.JTextField txtTimKIEM;
    // End of variables declaration//GEN-END:variables
}
