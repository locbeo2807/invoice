package com.invoice.controller;

import com.invoice.dao.CustomerDao;
import com.invoice.model.Customer;
import com.invoice.view.CustomerView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerController {
    private final CustomerDao customerDao;
    private final CustomerView customerView;

    public CustomerController(CustomerView customerView) {
        this.customerView = customerView;
        this.customerDao = new CustomerDao();

        customerView.addFilterByCustomerListener(new FilterByCustomer());
        customerView.setBtnAddListener(new AddButtonListener());
        customerView.setBtnRefreshListener(new RefreshListener());
        customerView.setBtnDeleteListener(new DeleteButtonListener());
        customerView.setBtnUpdateListener(new UpdateButtonListener());
        customerView.setBtnSearchListener(new SearchButtonListener());
    }

    public void showFrm() {
        customerView.setVisible(true);
        updateCustomerTable();
    }

    private void updateCustomerTable() {
        boolean isVietnamese = customerView.isVietnamese();
        boolean isForeigner = customerView.isForeign();
        List<Customer> customers = customerDao.getAllCustomers();

        if (isVietnamese) {
            customers = customers.stream()
                    .filter(customer -> customer.getNationality() == null || customer.getNationality().isEmpty())
                    .collect(Collectors.toList());
        } else if (isForeigner) {
            customers = customers.stream()
                    .filter(customer -> customer.getNationality() != null && !customer.getNationality().isEmpty())
                    .collect(Collectors.toList());
        }

        customerView.setDataToTable(customers);
    }

    class FilterByCustomer implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            customerView.status();
            updateCustomerTable();
        }
    }

    class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Customer customer = customerView.getCustomer();
            if (customer == null) {
                return;
            }

            customerDao.addCustomer(customer);
            JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công!");

            updateCustomerTable();
            customerView.clear();
        }
    }

    class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Customer customer = customerView.getCustomer();
            if (customer == null) {
                return;
            }

            int indexAnswer = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa khách hàng này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (indexAnswer == JOptionPane.NO_OPTION) {
                return;
            }
            customerDao.deleteCustomer(customer);
            updateCustomerTable();
            customerView.clear();
        }
    }

    class RefreshListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            customerView.clear();
            updateCustomerTable();
        }
    }

    class UpdateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Customer customer = customerView.getCustomer();
            if (customer == null) {
                return;
            }

            customerDao.updateCustomer(customer);
            JOptionPane.showMessageDialog(null, "Cập nhật khách hàng thành công!");
            updateCustomerTable();
            customerView.clear();
        }
    }

    class SearchButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String search = customerView.getKeyword().toLowerCase().trim();
            if (search.isEmpty()) {
                updateCustomerTable();
                return;
            }
            List<Customer> customers = customerDao.getAllCustomers();

            customers = customers.stream()
                    .filter(customer -> customer.getCustomerId().toLowerCase().trim().contains(search))
                    .toList();

            customerView.setDataToTable(customers);
        }
    }
}
