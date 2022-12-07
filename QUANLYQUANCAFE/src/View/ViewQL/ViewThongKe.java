package View.ViewQL;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
import javax.swing.table.DefaultTableModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import Service.impl.HoaDonServiceIblm;
import Service.impl.SanPhamServiceImpl;
import ViewModels.HoaDon;
import ViewModels.SanPham;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JFrame;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author Admin
 */
public class ViewThongKe extends javax.swing.JInternalFrame {
    
    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultTableModel nhanvien;
    private HoaDonServiceIblm _HoaDonService = new HoaDonServiceIblm();
    private List<HoaDon> listHoaDon = new ArrayList<>();
    private HoaDonServiceIblm implHD = new HoaDonServiceIblm();
    private List<SanPham> ListSanPham = new ArrayList<>();
    private SanPhamServiceImpl implSP = new SanPhamServiceImpl();
    
    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Đồ Uống Bán Chạy Nhất", dataset, true, true, true);
        return chart;
    }
    
    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Sinh tố dâu", new Double(5.0));
        dataset.setValue("Cà Phê đen", new Double(10.0));
        dataset.setValue("Bạc xỉu", new Double(3.0));
        dataset.setValue("Trà hoa quả", new Double(0.0));
        return dataset;
    }
    
    String strFind = "";

    /**
     * Creates new form ViewThongKe
     */
    public ViewThongKe() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI uI = (BasicInternalFrameUI) this.getUI();
        uI.setNorthPane(null);
//        _HoaDonService = new HoaDonServiceIblm();
        String[] headers = {"STT", "Mã", "Ngày", "Tên", "Số lượng", "Tiền", "Tình Trạng"};
        tbl_thongke.setModel(dtm);
        dtm.setColumnIdentifiers(headers);
        ListSanPham = implSP.getAll();
        listHoaDon = implHD.getListHD();
        LoadTable(listHoaDon);
        TinhTong();
        TinhTongSlDon();

//        getSum();
    }

//    private void showDataTK(List<HoaDon> list) {
//        dtmThongKe.setRowCount(0);
//        int stt = 1;
//        for (HoaDon x : list) {
//            dtmThongKe.addRow(new Object[]{stt++, x.getMaHD(), x.getNgayLapHD(), x.getThanhTien()});
//        }
//    }
    public void LoadTable(List<HoaDon> list) {
//        _DefaultTableModel1.setRowCount(0);
        dtm.setRowCount(0);
        int stt = 1;
        for (HoaDon hd : list) {
            dtm.addRow(new Object[]{
                stt++, hd.getMaHD(), hd.getNgayLapHD(), hd.getSp().getTenSP(), hd.getHdct().getSoLuong(), hd.getThanhTien(), hd.getTinhTrang()
            });
        }
    }
    
    public void findHD(List<HoaDon> list) {
        dtm.setRowCount(0);
        int stt = 1;
        for (HoaDon hd : list) {
            dtm.addRow(new Object[]{stt++, hd.getMaHD(), hd.getNgayLapHD(), hd.getSp().getTenSP(), hd.getHdct().getSoLuong(), hd.getThanhTien(), hd.getTinhTrang()});
        }
    }

//    public void getSum() {
//        int sum = 0;
//        for (int i = 0; i < tbl_thongke.getRowCount(); i++) {
//            sum = sum + Integer.parseInt(tbl_thongke.getValueAt(i, 3).toString());
//        }
//        jLabel4.setText(Integer.toString(sum));
//    }
    public void TinhTong() {
//        _DefaultTableModel1 = (DefaultTableModel) tbl_thongke.getModel();
//        _DefaultTableModel1.setRowCount(0);
        DecimalFormat x = new DecimalFormat("###,###,###");
        int TinhTong = 0;
        for (int i = 0; i < tbl_thongke.getRowCount(); i++) {
            String Tong1 = (tbl_thongke.getValueAt(i, 5).toString());
            double Tong = Double.valueOf(Tong1);
            TinhTong = (int) (TinhTong + Tong);
        }
        jLabel7.setText("" + x.format(TinhTong) + " " + "VNĐ");
    }
    
    public void TinhTongSlDon() {
        DecimalFormat x = new DecimalFormat("###,###,###");
        int TinhTong = 0;
        for (int i = 0; i < tbl_thongke.getRowCount(); i++) {
            String Tong1 = (tbl_thongke.getValueAt(i, 4).toString());
            int Tong = Integer.valueOf(Tong1);
            TinhTong = (int) (TinhTong + Tong);
        }
        jLabel4.setText("" + x.format(TinhTong) + " " + "Sản Phẩm");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txt_date = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblloi = new javax.swing.JLabel();
        bltXuatHD = new javax.swing.JButton();
        bltThongKe = new javax.swing.JButton();
        SortSL = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_thongke = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(814, 678));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        txt_date.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_dateCaretUpdate(evt);
            }
        });
        txt_date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_dateMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_dateMouseExited(evt);
            }
        });
        txt_date.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_dateKeyReleased(evt);
            }
        });

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Tìm Kiếm Theo Hóa Đơn");

        bltXuatHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon.jpg"))); // NOI18N
        bltXuatHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bltXuatHDActionPerformed(evt);
            }
        });

        bltThongKe.setBackground(new java.awt.Color(0, 0, 0));
        bltThongKe.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bltThongKe.setForeground(new java.awt.Color(102, 255, 51));
        bltThongKe.setText("+");
        bltThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bltThongKeActionPerformed(evt);
            }
        });

        SortSL.setText("Sắp Xếp Số Lượng");
        SortSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortSLActionPerformed(evt);
            }
        });

        jButton1.setText("Sắp Xếp Tên Sản Phẩm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(SortSL)
                        .addGap(34, 34, 34)
                        .addComponent(jButton1)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblloi, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bltThongKe)
                        .addGap(18, 18, 18)
                        .addComponent(bltXuatHD, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(bltXuatHD)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(bltThongKe)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SortSL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblloi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Doanh Thu Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        tbl_thongke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "", "Mã HD", "Ngày Đặt", "", "Tên SP", "Thành Tiền", "Tinh Trang"
            }
        ));
        jScrollPane1.setViewportView(tbl_thongke);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Doanh Thu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));
        jPanel7.setForeground(new java.awt.Color(153, 102, 0));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Số Lượng Sản Phẩm:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel7.add(jLabel5, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("0");
        jPanel7.add(jLabel4, new java.awt.GridBagConstraints());

        jPanel8.setBackground(new java.awt.Color(102, 102, 102));
        jPanel8.setForeground(new java.awt.Color(153, 102, 0));
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new java.awt.GridBagLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tổng Doanh Thu: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel8.add(jLabel6, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("0");
        jPanel8.add(jLabel7, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(253, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(506, 506, 506)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setBounds(0, 0, 1093, 735);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_dateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_dateMouseExited

    }//GEN-LAST:event_txt_dateMouseExited

    private void txt_dateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_dateMouseClicked

    }//GEN-LAST:event_txt_dateMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txt_date.setText("");
        listHoaDon = implHD.getListHD();
        LoadTable(listHoaDon);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_dateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dateKeyReleased
        if (txt_date.getText().equalsIgnoreCase("")) {
            findHD(listHoaDon);
        } else {
            List<HoaDon> searchNgayHD = implHD.search(txt_date.getText());
            LoadTable(searchNgayHD);
        }
    }//GEN-LAST:event_txt_dateKeyReleased

    private void txt_dateCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_dateCaretUpdate

    }//GEN-LAST:event_txt_dateCaretUpdate

    private void bltXuatHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bltXuatHDActionPerformed
//        InhoaDon1();
    }//GEN-LAST:event_bltXuatHDActionPerformed

    private void bltThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bltThongKeActionPerformed
        JFreeChart pieChart = createChart(createDataset());
        ChartPanel chartPanel = new ChartPanel(pieChart);
        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.setTitle("Biểu đồ Doanh Thu Cafe");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }//GEN-LAST:event_bltThongKeActionPerformed

    private void SortSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortSLActionPerformed
        Collections.sort(listHoaDon, (a, b) -> (int) (b.getHdct().getSoLuong() - a.getHdct().getSoLuong()));
        LoadTable(listHoaDon);
    }//GEN-LAST:event_SortSLActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Collections.sort(listHoaDon, new Comparator<HoaDon>() {
            @Override
            public int compare(HoaDon o1, HoaDon o2) {
                return o1.getSp().getTenSP().compareTo(o2.getSp().getTenSP());
            }
            
        });
        LoadTable(listHoaDon);
        

    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * @param args the command line arguments
     */
//  public void InhoaDon1() {
//        try {
//            XSSFWorkbook workbook = new XSSFWorkbook();
//            XSSFSheet spreadSheet = workbook.createSheet("Thống Kê");
//
//            XSSFRow row = null;
//            Cell cell = null;
//            row = spreadSheet.createRow((short) 2);
//            row.setHeight((short) 500);
//            cell = row.createCell(0, CellType.STRING);
//
//            cell.setCellValue("DANH SÁCH THỐNG KÊ");
//
//            row = spreadSheet.createRow((short) 3);
//            row.setHeight((short) 500);
//            cell = row.createCell(1, CellType.STRING);
//            cell.setCellValue("MÃ HÓA ĐƠN");
//            cell = row.createCell(2, CellType.STRING);
//            cell.setCellValue("NGÀY LẬP HÓA ĐƠN");
//            cell = row.createCell(3, CellType.STRING);
//            cell.setCellValue("THÀNH TIỀN");
//            List<HoaDon> listHoaDon = implHD.getListHD();
//
//            for (int i = 0; i < implHD.size(); i++) {
//                HoaDon hd = implHD.get(i);
////                Ban b = listB.get(i);
////                SanPham sp = listSP.get(i);
////                HoaDonChiTiet hdct = listHDCT.get(i);
////                Topping tp = listTP.get(i);
//                row = spreadSheet.createRow((short) 4 + i);
//                row.setHeight((short) 400);
//                row.createCell(0).setCellValue(hd.getMaHD());
//                row.createCell(1).setCellValue(hd.getBan().getTenBan());
//                row.createCell(2).setCellValue("Nhân Viên A");
//                row.createCell(3).setCellValue(hd.getNgayLapHD());
//                row.createCell(4).setCellValue("Tiền mặt");
//                row.createCell(5).setCellValue(hd.getSp().getTenSP());
//                row.createCell(6).setCellValue(hd.getSp().getGiaBan());
//                row.createCell(7).setCellValue(hd.getHdct().getSoLuong());
//                row.createCell(8).setCellValue(hd.getTp().getTopping());
//                row.createCell(9).setCellValue(hd.getThanhTien());
//                row.createCell(10).setCellValue(hd.getTinhTrang());
//            }
//            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\vietv\\Downloads\\excelTK\\hdct.xlsx"));
//            workbook.write(out);
//            out.close();
//            JOptionPane.showMessageDialog(this, "Xuất Hóa Đơn Excel Thành Công !");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SortSL;
    private javax.swing.JButton bltThongKe;
    private javax.swing.JButton bltXuatHD;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblloi;
    private javax.swing.JTable tbl_thongke;
    private javax.swing.JTextField txt_date;
    // End of variables declaration//GEN-END:variables

}
