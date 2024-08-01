
package com.invoice.view;

import javax.swing.*;
public class MainView extends JFrame {
    private JButton btnCustomers;
    private JButton btnInvoices;
    private JLabel jLabel1;


    public MainView() {
        initComponents();

        this.setLocationRelativeTo(null);

        this.setTitle("Menu chính");
    }

    public void setBtnCustomersActionListener(java.awt.event.ActionListener actionListener){
        btnCustomers.addActionListener(actionListener);
    }

    public void setBtnInvoicesActionListener(java.awt.event.ActionListener actionListener){
        btnInvoices.addActionListener(actionListener);
    }


    private void initComponents() {

        btnCustomers = new javax.swing.JButton();
        btnInvoices = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCustomers.setText("Quản lý khách hàng");

        btnInvoices.setText("Quản lý hoá đơn");

        jLabel1.setText("Chọn chức năng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(btnCustomers)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(btnInvoices, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(130, 130, 130))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnInvoices, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }




}