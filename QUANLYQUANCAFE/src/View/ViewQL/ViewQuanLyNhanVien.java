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

    /**
     * Creates new form ViewNhanVien
     */
    public ViewQuanLyNhanVien() {
        initComponents();

        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI uI = (BasicInternalFrameUI) this.getUI();
        uI.setNorthPane(null);

        txtID.disable();
        txtIDCV.disable();
        tableNhanVien.setModel(dtm);
        String[] header = {"ID", "MÃ NV", "TÊN NV", "NGÀY SINH", "SĐT", "TÊN CV"};
        dtm.setColumnIdentifiers(header);
        tableChucVu.setModel(dtmcv);
        String[] headercv = {"ID", "MÃ CV", "TÊN CV"};
        dtmcv.setColumnIdentifiers(headercv);
        list = nhanVienService.getAll();
        listcv = chucVuService.getAll();
        showDATAnv(list);
        showCombOBOX(listcv);
        showdatacv(listcv);
    }

    private void showDATAnv(List<NhanVienViewModel> lits) {
        dtm.setRowCount(0);
        for (NhanVienViewModel nv : lits) {
            dtm.addRow(nv.toRowData());

        }
    }

    private void showCombOBOX(List<ChucVu> listcv) {
        comboBoxModel = (DefaultComboBoxModel) cbbChucVu.getModel();
        for (ChucVu chucVu : listcv) {
            comboBoxModel.addElement(chucVu.getTenCV());

        }
    }

    private NhanVienModel getdata() {
        NhanVienModel nhanVien = new NhanVienModel();
        nhanVien.setMaNV(txtManv.getText());
        nhanVien.setTenNV(txtTenNv.getText());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(txtNgaySinh.getDate());
        nhanVien.setNgaySinh(date);
        int indextencv = cbbChucVu.getSelectedIndex();
        nhanVien.setSDT(txtSDT.getText());
        ChucVu chucVu = listcv.get(indextencv);
        nhanVien.setIdCV(chucVu.getID());
        return nhanVien;

    }

    private void showdatacv(List<ChucVu> lits) {
        dtmcv.setRowCount(0);
        for (ChucVu cv : lits) {
            dtmcv.addRow(cv.toRowData());

        }
    }

    private DomainModels.ChucVu getdatacv() {
        DomainModels.ChucVu chucVu = new DomainModels.ChucVu();
        chucVu.setMacv(txtMacv.getText());
        chucVu.setTenCV(txtTenCV.getText());
        return chucVu;
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
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtIDCV = new javax.swing.JTextField();
        txtMacv = new javax.swing.JTextField();
        txtTenCV = new javax.swing.JTextField();
        btADDCV = new javax.swing.JButton();
        btClearCV = new javax.swing.JButton();
        btUpdateCV = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableChucVu = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtManv = new javax.swing.JTextField();
        txtTenNv = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        btADD = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        btDELETE = new javax.swing.JButton();
        btClear = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableNhanVien = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        cbbChucVu = new javax.swing.JComboBox<>();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
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

        jPanel6.setBackground(new java.awt.Color(102, 51, 0));

        jLabel18.setText("ID");

        jLabel19.setText("MÃ CV");

        jLabel20.setText("TÊN CV");

        btADDCV.setText("ADD");
        btADDCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btADDCVActionPerformed(evt);
            }
        });

        btClearCV.setText("Clear");
        btClearCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearCVActionPerformed(evt);
            }
        });

        btUpdateCV.setText("UPDATE");
        btUpdateCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateCVActionPerformed(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức Vụ"));

        tableChucVu.setModel(new javax.swing.table.DefaultTableModel(
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
        tableChucVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableChucVuMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableChucVu);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel19)
                        .addComponent(jLabel18)))
                .addGap(54, 54, 54)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMacv)
                    .addComponent(txtIDCV)
                    .addComponent(txtTenCV, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btClearCV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btUpdateCV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btADDCV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(185, 185, 185))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtIDCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btADDCV))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtMacv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btClearCV))
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtTenCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btUpdateCV))
                .addGap(31, 31, 31)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Quản Lý Chức Vụ", jPanel6);

        jPanel5.setBackground(new java.awt.Color(102, 51, 0));

        jLabel7.setText("ID");

        jLabel12.setText("MÃ NV");

        jLabel13.setText("TÊN NV");

        jLabel14.setText("NGÀY SINH");

        jLabel15.setText("CHỨC VỤ");

        jLabel16.setText("SĐT");

        jLabel17.setText("anhnv");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel17)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel17)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        btADD.setText("ADD");
        btADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btADDActionPerformed(evt);
            }
        });

        btUpdate.setText("UPDATE");
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        btDELETE.setText("DELETE");
        btDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDELETEActionPerformed(evt);
            }
        });

        btClear.setText("CLEAR");
        btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearActionPerformed(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhân Viên"));

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
        jScrollPane3.setViewportView(tableNhanVien);

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel13)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel12)))
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtID)
                            .addComponent(txtManv)
                            .addComponent(txtTenNv)
                            .addComponent(txtSDT)
                            .addComponent(cbbChucVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                        .addGap(60, 60, 60)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btADD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btClear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btDELETE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(100, 100, 100))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btADD)
                        .addGap(18, 18, 18)
                        .addComponent(btUpdate)
                        .addGap(26, 26, 26)
                        .addComponent(btDELETE)
                        .addGap(18, 18, 18)
                        .addComponent(btClear))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtManv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(txtTenNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Quản Lý Nhân Viên", jPanel5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btADDActionPerformed
        int chon = JOptionPane.showConfirmDialog((btADD), "bạn có chắc chắn muốn thêm không", "xác nhận thêm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (chon == JOptionPane.YES_OPTION) {
            nhanVienService.add(getdata());
            list = nhanVienService.getAll();
            showDATAnv(list);
        }
    }//GEN-LAST:event_btADDActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        int chon = JOptionPane.showConfirmDialog((btUpdate), "bạn có chắc chắn muốn sửa không", "xác nhận sửa", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (chon == JOptionPane.YES_OPTION) {
            nhanVienService.update(getdata(), txtID.getText());

            list = nhanVienService.getAll();
            showDATAnv(list);
        }
    }//GEN-LAST:event_btUpdateActionPerformed

    private void btDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDELETEActionPerformed
        int chon = JOptionPane.showConfirmDialog((btDELETE), "bạn có chắc chắn muốn xóa không", "xác nhận xóa", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (chon == JOptionPane.YES_OPTION) {
            nhanVienService.delete(txtID.getText());

            list = nhanVienService.getAll();
            showDATAnv(list);
        }
    }//GEN-LAST:event_btDELETEActionPerformed

    private void tableNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableNhanVienMouseClicked
        int row = tableNhanVien.getSelectedRow();
        txtID.setText(tableNhanVien.getValueAt(row, 0).toString());
        txtManv.setText(tableNhanVien.getValueAt(row, 1).toString());
        txtTenNv.setText(tableNhanVien.getValueAt(row, 2).toString());

        try {
            Date date = (Date) new SimpleDateFormat("yyyy-MM-dd").parse((String) tableNhanVien.getValueAt(row, 3));
            txtNgaySinh.setDate(date);
        } catch (ParseException ex) {

        }
        txtSDT.setText(tableNhanVien.getValueAt(row, 4).toString());
        cbbChucVu.setSelectedItem(tableNhanVien.getValueAt(row, 5).toString());
    }//GEN-LAST:event_tableNhanVienMouseClicked

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        txtID.setText("");
        txtManv.setText("");
        txtNgaySinh.setDate(null);
        txtSDT.setText("");
        txtTenNv.setText("");
        cbbChucVu.setSelectedIndex(0);
    }//GEN-LAST:event_btClearActionPerformed

    private void tableChucVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableChucVuMouseClicked
        int row = tableChucVu.getSelectedRow();
        txtIDCV.setText(tableChucVu.getValueAt(row, 0).toString());
        txtMacv.setText(tableChucVu.getValueAt(row, 1).toString());
        txtTenCV.setText(tableChucVu.getValueAt(row, 2).toString());
    }//GEN-LAST:event_tableChucVuMouseClicked

    private void btClearCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearCVActionPerformed
        txtID.setText("");
        txtMacv.setText("");
        txtTenCV.setText("");

    }//GEN-LAST:event_btClearCVActionPerformed

    private void btADDCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btADDCVActionPerformed
        int chon = JOptionPane.showConfirmDialog((btADDCV), "bạn có chắc chắn muốn thêm không", "xác nhận thêm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (chon == JOptionPane.YES_OPTION) {
            chucVuService.add(getdatacv());
            listcv = chucVuService.getAll();
            showdatacv(listcv);

        }
    }//GEN-LAST:event_btADDCVActionPerformed

    private void btUpdateCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateCVActionPerformed

        int chon = JOptionPane.showConfirmDialog((btUpdateCV), "bạn có chắc chắn muốn sửa không", "xác nhận sửa", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (chon == JOptionPane.YES_OPTION) {
            chucVuService.update(getdatacv(), txtIDCV.getText());
            listcv = chucVuService.getAll();
            showdatacv(listcv);
        }

    }//GEN-LAST:event_btUpdateCVActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
       if (txtTimKiem.getText().isEmpty()) {
            showDATAnv(list);
        } else {
           String ma=txtTimKiem.getText();
            List<NhanVienViewModel> search =nhanVienService.getTimkiem(ma);
            showDATAnv(search);
        }
    }//GEN-LAST:event_txtTimKiemKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btADD;
    private javax.swing.JButton btADDCV;
    private javax.swing.JButton btClear;
    private javax.swing.JButton btClearCV;
    private javax.swing.JButton btDELETE;
    private javax.swing.JButton btUpdate;
    private javax.swing.JButton btUpdateCV;
    private javax.swing.JComboBox<String> cbbChucVu;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tableChucVu;
    private javax.swing.JTable tableNhanVien;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDCV;
    private javax.swing.JTextField txtMacv;
    private javax.swing.JTextField txtManv;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenCV;
    private javax.swing.JTextField txtTenNv;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
