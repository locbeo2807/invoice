package com.invoice.controller;

import com.invoice.dao.CustomerDao;
import com.invoice.dao.InvoiceDao;
import com.invoice.model.Invoice;
import com.invoice.util.ExportInvoice;
import com.invoice.view.InvoiceView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class InvoiceController {
    private final InvoiceDao invoiceDao;
    private final InvoiceView invoiceView;
    private final CustomerDao customerDao;

    public InvoiceController(InvoiceView invoiceView) {
        this.invoiceView = invoiceView;
        this.invoiceDao = new InvoiceDao();
        this.customerDao = new CustomerDao();

        invoiceView.setCbCusId(customerDao.getAllCustomerIds());
        invoiceView.setBtnAddAction(new AddButtonListener());
        invoiceView.setBtnDeleteAction(new DeleteButtonListener());
        invoiceView.setBtnRefreshAction(new RefreshListener());
        invoiceView.setBtnUpdateAction(new UpdateButtonListener());
        invoiceView.setBtnExportAction(new ExportButtonListener());
        invoiceView.setBtnSearchAction(new SearchButtonListener());

    }

    public void showFrm() {
        invoiceView.setVisible(true);
        invoiceView.setDataToTable(invoiceDao.getAllInvoices());
    }

    public double calculateTotalAmount(int quantity, double unitPrice, String customerId) {
        String quotaStr = customerDao.getQuotaByCusId(customerId);

        int quota = quotaStr != null ? Integer.parseInt(quotaStr) : 0;

        if (quota == 0) {
            return quantity * unitPrice;
        } else {
            if (quantity <= quota) {
                return quantity * unitPrice;
            } else {
                return (quota * unitPrice) + ((quantity - quota) * unitPrice * 2.5);
            }
        }
    }


    class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Invoice invoice = invoiceView.getInvoice();
            if (invoice == null) {
                return;
            }

            invoice.setTotal(calculateTotalAmount(invoice.getQuantity(), invoice.getUnitPrice(), invoice.getCustomerId()));

            invoiceDao.addInvoice(invoice);
            invoiceView.setDataToTable(invoiceDao.getAllInvoices());
            invoiceView.clear();
        }
    }

    class DeleteButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Invoice invoice = invoiceView.getInvoice();

            if (invoice == null) {
                return;
            }

            int indexAnswer = JOptionPane.showConfirmDialog(invoiceView, "Bạn có chắc chắn muốn xóa hóa đơn này không?");

            if (indexAnswer == JOptionPane.NO_OPTION) {
                return;
            }

            invoiceDao.deleteInvoice(invoice);
            invoiceView.setDataToTable(invoiceDao.getAllInvoices());
            invoiceView.clear();
        }
    }

    class RefreshListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            invoiceView.clear();
            invoiceView.setDataToTable(invoiceDao.getAllInvoices());
        }
    }

    class UpdateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Invoice invoice = invoiceView.getInvoice();
            if (invoice == null) {
                return;
            }

            invoice.setTotal(calculateTotalAmount(invoice.getQuantity(), invoice.getUnitPrice(), invoice.getCustomerId()));

            invoiceDao.updateInvoice(invoice);
            invoiceView.setDataToTable(invoiceDao.getAllInvoices());
            invoiceView.clear();
            JOptionPane.showMessageDialog(invoiceView, "Cập nhật hóa đơn thành công");
        }
    }

    class ExportButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Invoice invoice = invoiceView.getInvoice();
            if (invoice == null) {
                return;
            }

            Map<String, String> invoiceInfo = invoiceDao.getInvoiceInfoByCusId(invoice);
            System.out.println(invoiceInfo);
            ExportInvoice.exportInvoice(
                    invoiceInfo.get("{customerId}"),
                    invoiceInfo.get("{fullName}"),
                    invoiceInfo.get("{invoiceDate}"),
                    invoiceInfo.get("{quantity}"),
                    invoiceInfo.get("{customerType}"),
                    invoiceInfo.get("{totalAmount}")
            );

        }
    }

    class SearchButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String customerId = invoiceView.getCusIdSearch().orElse(null);
            Integer month = invoiceView.getMonth().orElse(null);
            Integer year = invoiceView.getYear();

            List<Invoice> invoices = invoiceDao.searchInvoices(customerId, month, year);
            invoiceView.setDataToTable(invoices);

        }
    }


}
