

package com.invoice;

import com.invoice.controller.CustomerController;
import com.invoice.controller.MainViewController;
import com.invoice.dao.CustomerDao;
import com.invoice.view.MainView;


import javax.swing.*;


public class Invoice {

    public static void main(String args[]) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {


            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainViewController mainViewController = new MainViewController(new MainView());
                mainViewController.showMainView();
            }
        });
    }
}
