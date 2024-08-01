package com.invoice.controller;

import com.invoice.view.CustomerView;
import com.invoice.view.InvoiceView;
import com.invoice.view.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainViewController {
    public final MainView mainView;

    public MainViewController(MainView mainView){
        this.mainView = mainView;

        mainView.setBtnCustomersActionListener(new Customers());
        mainView.setBtnInvoicesActionListener(new Invoices());
    }

    public void showMainView(){
        mainView.setVisible(true);
    }

    class Customers implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CustomerController customerController = new CustomerController(new CustomerView());
            customerController.showFrm();
        }
    }

    class Invoices implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            InvoiceController invoiceController = new InvoiceController(new InvoiceView());
            invoiceController.showFrm();
        }
    }
}
