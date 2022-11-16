/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View.ViewQL;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import DomainModels.KhuyenMaiModel;
import Service.impl.KhuyenMaiServiceIblm;
import ViewModels.KhuyenMai;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ViewKhuyenMai extends javax.swing.JInternalFrame {

    private List<KhuyenMai> listKM = new ArrayList<>();
    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultComboBoxModel box1 = new DefaultComboBoxModel();
    private Service.impl.KhuyenMaiServiceIblm impl = new KhuyenMaiServiceIblm();

    /**
     * Creates new form ViewKhuyenMai
     */
    public ViewKhuyenMai() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI uI = (BasicInternalFrameUI) this.getUI();
        uI.setNorthPane(null);
        String header[] = {"ID", "maKM", "tenKM", "hinhThucGG", "mucGiam", "tgBatDau", "tgKetThuc", "moTa"};
        bangKM.setModel(dtm);
        dtm.setColumnIdentifiers(header);
        cbbHinhThucGG.setModel(box1);
        box1.addElement("Giam theo %");
        box1.addElement("Giam theo so tien");
        listKM = impl.getAll();
        showData(listKM);
    }

    public void fillData(int index) {
        KhuyenMai km = listKM.get(index);
        txtMaKM.setText(km.getMaKM());
        txtTenKM.setText(km.getTenKM());
        cbbHinhThucGG.setSelectedItem(km.getHinhThucGG());
        txtMucGiam.setText(km.getMucGiam());
        txtTGBD.setText(km.getTgBatDau());
        txtTGKT.setText(km.getTgKetThuc());
        txtMoTa.setText(km.getMoTa());
    }

    private void showData(List<KhuyenMai> km) {
        dtm.setRowCount(0);
        for (KhuyenMai x : km) {
            dtm.addRow(x.toRowData());
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

        jSplitPane1 = new javax.swing.JSplitPane();
        txtMucGiam = new javax.swing.JTextField();
        bltAdd = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        bltUpdate = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bangKM = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        bltSearch = new javax.swing.JButton();
        cbbHinhThucGG = new javax.swing.JComboBox<>();
        txtTGBD = new javax.swing.JTextField();
        bltXoa = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtTGKT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaKM = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        txtTenKM = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(814, 678));

        bltAdd.setText("Add");
        bltAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bltAddActionPerformed(evt);
            }
        });

        jLabel4.setText("HinhThucGG: ");

        bltUpdate.setText("Update");
        bltUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bltUpdateActionPerformed(evt);
            }
        });

        jLabel5.setText("MucGiam: ");

        bangKM.setModel(new javax.swing.table.DefaultTableModel(
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
        bangKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangKMMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(bangKM);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Search theo MaKM: ");

        bltSearch.setText("Search");
        bltSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bltSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bltSearch)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bltSearch))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        cbbHinhThucGG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bltXoa.setText("Delete");
        bltXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bltXoaActionPerformed(evt);
            }
        });

        jLabel6.setText("TGBatDau: ");

        jLabel2.setText("MaKM: ");

        jLabel7.setText("TGKetThuc: ");

        jLabel8.setText("Mota: ");

        jLabel3.setText("TenKM: ");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane1.setViewportView(txtMoTa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2)
                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(263, 263, 263)
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(29, 29, 29)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTGKT, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtMucGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                                .addComponent(txtTGBD, javax.swing.GroupLayout.Alignment.LEADING)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(66, 66, 66)
                                            .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel8))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel3)
                                            .addGap(29, 29, 29)
                                            .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(48, 48, 48)
                                            .addComponent(bltAdd)
                                            .addGap(18, 18, 18)
                                            .addComponent(bltUpdate)
                                            .addGap(18, 18, 18)
                                            .addComponent(bltXoa)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbHinhThucGG, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMucGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbbHinhThucGG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTGBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtTGKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bltAdd)
                            .addComponent(bltUpdate)
                            .addComponent(bltXoa))))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bltAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bltAddActionPerformed
        String ma = txtMaKM.getText();
        String ten = txtTenKM.getText();
        String hinhTGG = cbbHinhThucGG.getSelectedItem().toString();
        String mucG = txtMucGiam.getText();
        String tgBD = txtTGBD.getText();
        String tgKT = txtTGKT.getText();
        String mota = txtMoTa.getText();
        KhuyenMaiModel km = new KhuyenMaiModel(ma, ten, hinhTGG, mucG, tgBD, tgKT, mota);
        JOptionPane.showMessageDialog(this, impl.add(km));
        listKM = impl.getAll();
        showData(listKM);
    }//GEN-LAST:event_bltAddActionPerformed

    private void bltUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bltUpdateActionPerformed
        String ma = txtMaKM.getText();
        String ten = txtTenKM.getText();
        String hinhTGG = cbbHinhThucGG.getSelectedItem().toString();
        String mucG = txtMucGiam.getText();
        String tgBD = txtTGBD.getText();
        String tgKT = txtTGKT.getText();
        String mota = txtMoTa.getText();
        KhuyenMaiModel km = new KhuyenMaiModel(ma, ten, hinhTGG, mucG, tgBD, tgKT, mota);
        JOptionPane.showMessageDialog(this, impl.update(km, txtMaKM.getText()));
        listKM = impl.getAll();
        showData(listKM);
    }//GEN-LAST:event_bltUpdateActionPerformed

    private void bangKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangKMMouseClicked
        int row = bangKM.getSelectedRow();
        fillData(row);
    }//GEN-LAST:event_bangKMMouseClicked

    private void bltSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bltSearchActionPerformed
        List<KhuyenMai> searchTheoTenKM = impl.searchTheoMaKM(txtSearch.getText());
        showData(searchTheoTenKM);
    }//GEN-LAST:event_bltSearchActionPerformed

    private void bltXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bltXoaActionPerformed
        JOptionPane.showMessageDialog(this, impl.delete(txtMaKM.getText()));
        listKM = impl.getAll();
        showData(listKM);
    }//GEN-LAST:event_bltXoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bangKM;
    private javax.swing.JButton bltAdd;
    private javax.swing.JButton bltSearch;
    private javax.swing.JButton bltUpdate;
    private javax.swing.JButton bltXoa;
    private javax.swing.JComboBox<String> cbbHinhThucGG;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField txtMaKM;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtMucGiam;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTGBD;
    private javax.swing.JTextField txtTGKT;
    private javax.swing.JTextField txtTenKM;
    // End of variables declaration//GEN-END:variables
}
