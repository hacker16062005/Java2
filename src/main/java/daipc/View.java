/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package daipc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author DaiPc
 */
public class View extends javax.swing.JFrame {
    DefaultTableModel modelTB = new DefaultTableModel(
            new String[]{"Mã NV", "Họ tên NV", "Giới tính", "Ngày sinh", "Chức vụ"}, 3){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
    QuanLiNhanVien QLNV = new QuanLiNhanVien();
    int selectedRow = -1;
    
    
    /**
     * Creates new form View
     */
    public View() {
        setAlwaysOnTop(true);
        initComponents();
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        
        
        
        tableNV.setModel(modelTB);
        int[] columnWidhts = {66, 130, 80, 80, 110};
        for(int i = 0; i < 5; i++){
            TableColumn column = tableNV.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidhts[i]);
        }
        
        cboChucVu.removeAllItems();
        cboChucVu.addItem("Giám đốc");
        cboChucVu.addItem("Trưởng phòng");
        cboChucVu.addItem("Phó phòng");
        cboChucVu.addItem("Nhân viên");
        cboChucVu.addItem("Bảo vệ");
        
        tableNV.getTableHeader().setReorderingAllowed(false);

        QLNV.fixedData();
        fillToTable();
        showDetails();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        btnGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        labelMaNV = new javax.swing.JLabel();
        labelHoTen = new javax.swing.JLabel();
        txt_Hoten = new javax.swing.JTextField();
        labelDate = new javax.swing.JLabel();
        txt_Date = new javax.swing.JTextField();
        genderLabel = new javax.swing.JLabel();
        maleButton = new javax.swing.JRadioButton();
        femaleButton = new javax.swing.JRadioButton();
        labelChucVu = new javax.swing.JLabel();
        cboChucVu = new javax.swing.JComboBox<>();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        scrennMaNV = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableNV = new javax.swing.JTable();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelMaNV.setText("Mã NV   -");

        labelHoTen.setText("Họ tên");

        txt_Hoten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_HotenActionPerformed(evt);
            }
        });

        labelDate.setText("Ngày sinh");

        txt_Date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DateActionPerformed(evt);
            }
        });

        genderLabel.setText("Giới tính");

        btnGroup.add(maleButton);
        maleButton.setText("Nam");
        maleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleButtonActionPerformed(evt);
            }
        });

        btnGroup.add(femaleButton);
        femaleButton.setText("Nữ");

        labelChucVu.setText("Chức vụ");

        cboChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboChucVuActionPerformed(evt);
            }
        });

        editButton.setText("Sửa");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Xóa");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        scrennMaNV.setText("NV001");

        addButton.setText("Thêm");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(genderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(maleButton)
                                .addGap(18, 18, 18)
                                .addComponent(femaleButton)
                                .addGap(49, 49, 49))
                            .addComponent(txt_Hoten, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrennMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Date)
                            .addComponent(cboChucVu, 0, 155, Short.MAX_VALUE))
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addGap(12, 12, 12)
                        .addComponent(editButton)
                        .addGap(12, 12, 12)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMaNV)
                    .addComponent(scrennMaNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHoTen)
                    .addComponent(txt_Hoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDate)
                    .addComponent(txt_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderLabel)
                    .addComponent(maleButton)
                    .addComponent(femaleButton)
                    .addComponent(labelChucVu)
                    .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton)
                    .addComponent(deleteButton)
                    .addComponent(clearButton)
                    .addComponent(addButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tableNV.setModel(new javax.swing.table.DefaultTableModel(
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
        tableNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableNVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableNV);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_DateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DateActionPerformed

    private void maleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maleButtonActionPerformed

    private void txt_HotenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_HotenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_HotenActionPerformed

    private void cboChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboChucVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboChucVuActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn bản ghi cần sửa");
            return;
        }
        if(JOptionPane.showConfirmDialog(this, "Chọn bản ghi này ?") == 0){
            int id =  selectedRow;
            if(readForm() == null){
                return;
            }
            if(QLNV.EDIT(readForm(), selectedRow)){
                fillToTable();
                selectedRow = id;
                showDetails();
                JOptionPane.showMessageDialog(this, "Sửa thành công !");
            }
            else{
                JOptionPane.showMessageDialog(this, "Sửa thất bại !", "", 0);
            }
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Xác nhận muốn xóa nhân viên này ? ") == 0){
            if(QLNV.REMOVE(selectedRow)){
                fillToTable();
                showDetails();
                JOptionPane.showMessageDialog(this, "Xoá nhân viên thành công !");
            }
            else{
                JOptionPane.showMessageDialog(this, "Xóa nhân viên thất bại !");
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void tableNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableNVMouseClicked
        // TODO add your handling code here:
        try{
            selectedRow = tableNV.getSelectedRow();
        showDetails();
        }catch(Exception e){}
        
    }//GEN-LAST:event_tableNVMouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Xác nhận muốn thêm nhân viên ? ") == 0){
            if(readForm() == null){
                return;
            }
            if(QLNV.ADD(readForm())){
                fillToTable();
                showDetails();
                JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công !");
            }
            else{
                JOptionPane.showMessageDialog(this, "Thêm nhân viên thất bại !");
            }
        }
        
    }//GEN-LAST:event_addButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Xác nhận muốn xóa toàn bộ ? ") == 0){
            if(QLNV.CLEAR()){
                fillToTable();
                JOptionPane.showMessageDialog(this, "Xoá bảng nhân viên thành công !");
            }
            else{
                JOptionPane.showMessageDialog(this, "Xóa bảng nhân viên thất bại !");
            }
        }
    }//GEN-LAST:event_clearButtonActionPerformed

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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }
    
    public void fillToTable(){
        clearForm();
        modelTB.setRowCount(0);
        for(NhanVien nv : QLNV.nhanViens){
            modelTB.addRow(new Object[]{nv.getMaNV(), nv.getHoten(), nv.getDate(), nv.getGioiTinh() ? "Nam" : "Nữ", nv.getChucVu()});
        }
        selectedRow = QLNV.nhanViens.size() - 1;
    }
    
    public void clearForm(){
        selectedRow = -1;
        scrennMaNV.setText("");
        txt_Hoten.setText("");
        txt_Date.setText("");
        btnGroup.clearSelection();
        cboChucVu.setSelectedItem(null);
    }
    
    public void showDetails(){
        scrennMaNV.setText(QLNV.nhanViens.get(selectedRow).getMaNV());
        txt_Hoten.setText(QLNV.nhanViens.get(selectedRow).getHoten());
        txt_Date.setText(QLNV.nhanViens.get(selectedRow).getDate());
        if(QLNV.nhanViens.get(selectedRow).getGioiTinh()){
            maleButton.setSelected(true);
        }
        else{
            femaleButton.setSelected(true);
        }
        cboChucVu.setSelectedItem(QLNV.nhanViens.get(selectedRow).getChucVu());
        tableNV.setRowSelectionInterval(selectedRow, selectedRow);
    }
    
    public NhanVien readForm(){
        maleButton.setActionCommand(maleButton.getText());
        femaleButton.setActionCommand(femaleButton.getText());
        if(!txt_Hoten.getText().isEmpty() && !txt_Date.getText().isEmpty() && btnGroup.getSelection() != null && cboChucVu.getSelectedItem() != null){
            return new NhanVien(String.format("NV%03d", QLNV.nhanViens.size() + 1), txt_Hoten.getText(), 
                    txt_Date.getText(), btnGroup.getSelection().getActionCommand().equals(maleButton.getText()), 
                    cboChucVu.getSelectedItem().toString());
        }
        JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin !");
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JComboBox<String> cboChucVu;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JRadioButton femaleButton;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelChucVu;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelHoTen;
    private javax.swing.JLabel labelMaNV;
    private javax.swing.JRadioButton maleButton;
    private javax.swing.JLabel scrennMaNV;
    private javax.swing.JTable tableNV;
    private javax.swing.JTextField txt_Date;
    private javax.swing.JTextField txt_Hoten;
    // End of variables declaration//GEN-END:variables
}