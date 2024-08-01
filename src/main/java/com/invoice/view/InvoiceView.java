
package com.invoice.view;

import com.invoice.model.Invoice;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class InvoiceView extends javax.swing.JFrame {
    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnExport;
    private JButton btnRefresh;
    private JButton btnSearch;
    private JButton btnUpdate;
    private JComboBox<String> cbCusId;
    private JComboBox<String> cbCusId1;
    private JComboBox<String> cbMonth;
    private JDateChooser dpInvoiceDate;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JScrollPane jScrollPane1;
    private JYearChooser jYear;
    private JTable tbInvoices;
    private JTextField txtQuantity;
    private JTextField txtTotal;
    private JTextField txtUnitPrice;


    public InvoiceView() {
        initComponents();

        dpInvoiceDate.setDateFormatString("yyyy-MM-dd");

        dpInvoiceDate.getDateEditor().setEnabled(false);

        txtTotal.setEditable(false);
        this.setLocationRelativeTo(null);

        cbMonth.removeAllItems();
        for (int i = 1; i <= 12; i++) {
            cbMonth.addItem(String.format("%02d", i));
        }

        cbMonth.setSelectedIndex(-1);

    }


    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbInvoices = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dpInvoiceDate = new com.toedter.calendar.JDateChooser();
        cbCusId = new javax.swing.JComboBox<>();
        txtQuantity = new javax.swing.JTextField();
        txtUnitPrice = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jYear = new com.toedter.calendar.JYearChooser();
        cbMonth = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbCusId1 = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbInvoices.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String[]{
                        "Mã khách hàng", "Ngày lập hoá đơn", "Số lượng tiêu thụ", "Đơn giá", "Tổng tiền"
                }
        ));
        tbInvoices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbInvoicesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbInvoices);

        jLabel1.setText("Mã khách hàng:");

        jLabel2.setText("Ngày lập hoá đơn:");

        jLabel3.setText("Số lượng tiêu thụ");

        jLabel4.setText("Đơn giá:");

        jLabel5.setText("Tổng tiền:");

        cbCusId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        btnUpdate.setText("Sửa");

        btnDelete.setText("Xoá");

        btnRefresh.setText("Làm mới");

        btnAdd.setText("Thêm");

        btnExport.setText("In hoá đơn");

        jLabel6.setText("Chọn tháng");

        jLabel7.setText("Chọn năm:");

        cbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        jLabel8.setText("Mã khách hàng:");

        cbCusId1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        btnSearch.setText("Tìm kiếm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(dpInvoiceDate, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                                        .addComponent(cbCusId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtQuantity)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(88, 88, 88)
                                                .addComponent(btnAdd)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnUpdate)
                                                .addGap(28, 28, 28)
                                                .addComponent(btnDelete)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnRefresh)
                                                .addGap(43, 43, 43)
                                                .addComponent(btnExport))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtUnitPrice)
                                                        .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))))
                                .addGap(115, 115, 115))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel7)
                                .addGap(28, 28, 28)
                                .addComponent(jYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbCusId1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearch)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel6)
                                                .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel7)
                                        .addComponent(jYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel8)
                                                .addComponent(cbCusId1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnSearch)))
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(cbCusId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel2))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(dpInvoiceDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnUpdate)
                                        .addComponent(btnDelete)
                                        .addComponent(btnRefresh)
                                        .addComponent(btnAdd)
                                        .addComponent(btnExport))
                                .addGap(30, 30, 30))
        );

        pack();
    }


    private void tbInvoicesMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = tbInvoices.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tbInvoices.getModel();

        cbCusId.setSelectedItem(model.getValueAt(selectedRow, 0).toString());

        String date = model.getValueAt(selectedRow, 1).toString();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(date, formatter);
            Date formattedDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            dpInvoiceDate.setDate(formattedDate);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Ngày không hợp lệ");
            e.printStackTrace();
        }

        txtQuantity.setText(model.getValueAt(selectedRow, 2).toString());

        txtUnitPrice.setText(model.getValueAt(selectedRow, 3).toString());

        txtTotal.setText(model.getValueAt(selectedRow, 4).toString());
    }

    public void setDataToTable(List<Invoice> invoices) {
        DefaultTableModel model = (DefaultTableModel) tbInvoices.getModel();
        model.setRowCount(0);
        for (Invoice invoice : invoices) {
            model.addRow(new Object[]{
                    invoice.getCustomerId(),
                    invoice.getInvoiceDate(),
                    invoice.getQuantity(),
                    invoice.getUnitPrice(),
                    invoice.getTotal()
            });
        }
    }

    public Invoice getInvoice() {
        String customerId = cbCusId.getSelectedItem().toString();
        LocalDate date = dpInvoiceDate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String invoiceDate = date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        String quantity = txtQuantity.getText();
        String unitPrice = txtUnitPrice.getText();

        if (customerId.isEmpty() || invoiceDate.isEmpty() || quantity.isEmpty() || unitPrice.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
            return null;
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate formattedDate = LocalDate.parse(invoiceDate, formatter);

            System.out.println(formattedDate);

            return new Invoice(customerId, formattedDate, Integer.parseInt(quantity), Double.parseDouble(unitPrice), 0f);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ");
            System.out.println(e.getMessage());
            return null;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng hoặc đơn giá không hợp lệ");
            System.out.println(e.getMessage());
            return null;
        }
    }


    public Optional<Integer> getMonth() {
        int month = cbMonth.getSelectedIndex();


        if (month == -1) {
            return Optional.empty();
        }

        return Optional.of(month + 1);
    }

    public int getYear() {
        return jYear.getYear();
    }

    public void setBtnSearchAction(ActionListener listener) {
        btnSearch.addActionListener(listener);
    }

    public void clear() {
        cbCusId.setSelectedIndex(0);
        dpInvoiceDate.setDate(null);
        txtQuantity.setText("");
        txtUnitPrice.setText("");
        txtTotal.setText("");

        cbCusId1.setSelectedIndex(-1);
        cbMonth.setSelectedIndex(-1);
    }

    public void setCbCusId(List<String> cusIds) {
        cbCusId.removeAllItems();
        cbCusId1.removeAllItems();
        for (String cusId : cusIds) {
            cbCusId.addItem(cusId);
            cbCusId1.addItem(cusId);
        }

        cbCusId1.setSelectedIndex(-1);
    }


    public void setBtnAddAction(ActionListener listener) {
        btnAdd.addActionListener(listener);
    }

    public void setBtnUpdateAction(ActionListener listener) {
        btnUpdate.addActionListener(listener);
    }

    public void setBtnDeleteAction(ActionListener listener) {
        btnDelete.addActionListener(listener);
    }

    public void setBtnRefreshAction(ActionListener listener) {
        btnRefresh.addActionListener(listener);
    }

    public void setBtnExportAction(ActionListener listener) {
        btnExport.addActionListener(listener);
    }

    public Optional<String> getCusIdSearch(){
        if(cbCusId1.getSelectedIndex() == -1){
            return Optional.empty();
        }

        return Optional.of(cbCusId1.getSelectedItem().toString());

    }




}



