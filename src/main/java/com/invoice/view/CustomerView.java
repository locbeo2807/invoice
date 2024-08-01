
package com.invoice.view;

import com.invoice.model.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.List;


public class CustomerView extends javax.swing.JFrame {
    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnRefresh;
    private JButton btnSearch;
    private JButton btnUpdate;
    private JComboBox<String> cbCusType;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JScrollPane jScrollPane1;
    private JRadioButton rAll;
    private JRadioButton rForeign;
    private JRadioButton rVietnamese;
    private JTable tbCustomers;
    private JTextField txtCusId;
    private JTextField txtCusName;
    private JTextField txtNationality;
    private JTextField txtQuota;
    private JTextField txtSearch;


    public CustomerView() {
        initComponents();

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rVietnamese);
        buttonGroup.add(rForeign);
        buttonGroup.add(rAll);

        cbCusType.removeAllItems();
        cbCusType.addItem("Sinh hoạt");
        cbCusType.addItem("Kinh doanh");
        cbCusType.addItem("Sản xuất");

        btnAdd.setEnabled(false);
        cbCusType.setEnabled(true);
        rAll.setSelected(true);

        this.setLocationRelativeTo(null);

    }


    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbCustomers = new javax.swing.JTable();
        rVietnamese = new javax.swing.JRadioButton();
        rForeign = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCusId = new javax.swing.JTextField();
        txtCusName = new javax.swing.JTextField();
        cbCusType = new javax.swing.JComboBox<>();
        txtQuota = new javax.swing.JTextField();
        txtNationality = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        rAll = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Loại khách hàng", "Hạn mức sử dụng", "Quốc tịch"
            }
        ));
        tbCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCustomersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCustomers);

        rVietnamese.setText("Khách Việt Nam");

        rForeign.setText("Khách nước ngoài");

        jLabel1.setText("Mã khách hàng:");

        jLabel2.setText("Tên khách hàng:");

        jLabel3.setText("Loại khách hàng:");

        jLabel4.setText("Hạn mức sử dụng:");

        jLabel5.setText("Quốc tịch:");

        cbCusType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAdd.setText("Thêm");

        btnUpdate.setText("Sửa");

        btnDelete.setText("Xoá");

        btnRefresh.setText("Làm mới");

        rAll.setText("Tất cả");

        jLabel6.setText("Tìm kiếm");

        btnSearch.setText("Tìm kiếm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rVietnamese)
                            .addComponent(rForeign)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rAll, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(244, 244, 244)
                                .addComponent(jLabel6)
                                .addGap(42, 42, 42)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnSearch))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(btnAdd)
                                .addGap(67, 67, 67)
                                .addComponent(btnUpdate)
                                .addGap(53, 53, 53)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRefresh))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbCusType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCusId, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCusName, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(161, 161, 161)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuota, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rAll)
                    .addComponent(jLabel6)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addComponent(rVietnamese)
                .addGap(18, 18, 18)
                .addComponent(rForeign)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(txtCusId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txtCusName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbCusType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnRefresh))
                .addGap(48, 48, 48))
        );

        pack();
    }

    private void tbCustomersMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = tbCustomers.getSelectedRow();

        String customerId = (tbCustomers.getValueAt(selectedRow, 0) != null) ? tbCustomers.getValueAt(selectedRow, 0).toString() : "";
        String customerName = (tbCustomers.getValueAt(selectedRow, 1) != null) ? tbCustomers.getValueAt(selectedRow, 1).toString() : "";
        String customerType = (tbCustomers.getValueAt(selectedRow, 2) != null) ? tbCustomers.getValueAt(selectedRow, 2).toString() : "";
        String quota = (tbCustomers.getValueAt(selectedRow, 3) != null) ? tbCustomers.getValueAt(selectedRow, 3).toString() : "";
        String nationality = (tbCustomers.getValueAt(selectedRow, 4) != null) ? tbCustomers.getValueAt(selectedRow, 4).toString() : "";

        if (nationality.isEmpty()) {
            txtNationality.setEnabled(false);
            txtQuota.setEnabled(true);
            cbCusType.setEnabled(true);
        } else {
            txtNationality.setEnabled(true);
            txtQuota.setEnabled(false);
            cbCusType.setEnabled(false);
        }

        txtCusId.setText(customerId);
        txtCusName.setText(customerName);
        cbCusType.setSelectedItem(customerType);
        txtQuota.setText(quota);
        txtNationality.setText(nationality);
    }


    public void addFilterByCustomerListener(ActionListener listener) {
        rVietnamese.addActionListener(listener);
        rForeign.addActionListener(listener);
        rAll.addActionListener(listener);

    }

    public void status() {
        btnAdd.setEnabled(rVietnamese.isSelected() || rForeign.isSelected());

        if (rVietnamese.isSelected()) {
            txtNationality.setEnabled(false);
            txtQuota.setEnabled(true);
            cbCusType.setEnabled(true);
        } else {
            txtNationality.setEnabled(true);
            txtQuota.setEnabled(false);
            cbCusType.setEnabled(false);
        }
    }

    public void setBtnAddListener(ActionListener listener) {
        btnAdd.addActionListener(listener);
    }

    public void setBtnUpdateListener(ActionListener listener) {
        btnUpdate.addActionListener(listener);
    }

    public void setBtnDeleteListener(ActionListener listener) {
        btnDelete.addActionListener(listener);
    }

    public void setBtnRefreshListener(ActionListener listener) {
        btnRefresh.addActionListener(listener);
    }

    public void setBtnSearchListener(ActionListener listener) {
        btnSearch.addActionListener(listener);
    }


    public String getKeyword(){
        return txtSearch.getText();
    }

    public void setDataToTable(List<Customer> customers) {

        DefaultTableModel model = (DefaultTableModel) tbCustomers.getModel();
        model.setRowCount(0);
        for (Customer customer : customers) {
            model.addRow(new Object[]{
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerType(),
                    customer.getQuota(),
                    customer.getNationality()


            });
        }
    }

    public boolean isVietnamese() {
        return rVietnamese.isSelected();
    }

    public boolean isForeign() {
        return rForeign.isSelected();
    }

    public Customer getCustomer() {
        String customerId = txtCusId.getText();
        String customerName = txtCusName.getText();
        Customer customer = new Customer();
        if (cbCusType.isEnabled()) {

            String customerType = cbCusType.getSelectedItem().toString();
            String quota = txtQuota.getText();
            if (customerId.isEmpty() || customerName.isEmpty() || customerType.isEmpty() || quota.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
                return null;
            }

            try {
                Integer.parseInt(quota);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Hạn mức sử dụng phải là số");
                return null;
            }

            customer.setCustomerId(customerId);
            customer.setCustomerName(customerName);
            customer.setCustomerType(customerType);
            customer.setQuota(txtQuota.getText());
            customer.setNationality(null);
        } else {

            String nationality = txtNationality.getText();

            if (customerId.isEmpty() || customerName.isEmpty() || nationality.isBlank()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
                return null;
            }

            customer.setCustomerId(txtCusId.getText());
            customer.setCustomerName(txtCusName.getText());
            customer.setCustomerType("");
            customer.setQuota(null);
            customer.setNationality(txtNationality.getText());
        }
        return customer;
    }

    public void clear() {
        txtCusId.setText("");
        txtCusName.setText("");
        txtQuota.setText("");
        txtNationality.setText("");
        cbCusType.setSelectedIndex(0);


    }





}
