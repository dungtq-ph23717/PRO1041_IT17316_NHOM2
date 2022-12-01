/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View.ViewQL;

import javax.swing.table.DefaultTableModel;
import DomainModels.HoaDonModel;
import Repository.HoaDonRepository;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import Service.impl.HoaDonServiceIblm;
import ViewModels.HoaDon;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ViewThongKe extends javax.swing.JInternalFrame {

    private DefaultTableModel _DefaultTableModel1;
    private HoaDonServiceIblm _HoaDonService;
    private List<HoaDon> listHoaDon = new ArrayList<>();
      private HoaDonServiceIblm implHD = new HoaDonServiceIblm();

    String strFind = "";

    /**
     * Creates new form ViewThongKe
     */
    public ViewThongKe() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI uI = (BasicInternalFrameUI) this.getUI();
        uI.setNorthPane(null);
        _HoaDonService = new HoaDonServiceIblm();
        LoadTable();
        TinhTong();
//        getSum();

    }

    public void LoadTable() {
        _DefaultTableModel1 = (DefaultTableModel) tbl_thongke.getModel();
        _DefaultTableModel1.setRowCount(0);
        int stt = 1;
        for (var o : _HoaDonService.getListHD()) {
            _DefaultTableModel1.addRow(new Object[]{
                stt++, o.getMaHD(), o.getNgayLapHD(), o.getThanhTien()
            });
        }
    }

    public void findHD(List<HoaDon> list) {
        _DefaultTableModel1.setRowCount(0);
        for (HoaDon hd : list) {
            _DefaultTableModel1.addRow(new Object[]{hd.getMaHD(), hd.getNgayLapHD(), hd.getThanhTien()});
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
            String Tong1 = (tbl_thongke.getValueAt(i, 3).toString());
            double Tong = Double.valueOf(Tong1);
            TinhTong = (int) (TinhTong + Tong);
        }
        jLabel4.setText("" + x.format(TinhTong) + " " + "VNĐ");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_date = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_thongke = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(814, 678));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel2.setText("Thống Kê Doanh Thu");

        jLabel3.setText("Tim Kiem Theo Ma HD");

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

        tbl_thongke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Ma HD", "Ngày Đat", "Thành Tiên"
            }
        ));
        jScrollPane1.setViewportView(tbl_thongke);

        jPanel7.setForeground(new java.awt.Color(153, 102, 0));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tong Doanh Thu:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel7.add(jLabel5, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel7.add(jLabel4, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(365, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(270, 270, 270))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(506, 506, 506)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jButton2))
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(523, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setBounds(0, 0, 1093, 735);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_dateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_dateMouseExited

    }//GEN-LAST:event_txt_dateMouseExited

    private void txt_dateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_dateMouseClicked

    }//GEN-LAST:event_txt_dateMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed


    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_dateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dateKeyReleased
        if (txt_date.getText().equalsIgnoreCase("")) {
            findHD(listHoaDon);
        } else {
            List<HoaDon> searchNgayHD = implHD.search(txt_date.getText());
            findHD(searchNgayHD);
        }
    }//GEN-LAST:event_txt_dateKeyReleased
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_thongke;
    private javax.swing.JTextField txt_date;
    // End of variables declaration//GEN-END:variables

}
