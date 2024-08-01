package com.invoice.util;

import com.lowagie.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExportInvoice {

    public static void exportInvoice(String customerId,
                                     String customerName,
                                     String invoiceDate,
                                     String quantity,
                                     String customerType,
                                     String totalAmount) {

        String templatePath = "C:\\Users\\TSC\\Downloads\\invoice\\invoice\\src\\main\\resources\\invoice_template.html";
        String html = readFile(templatePath);

        html = html
                .replace("{customerId}", customerId)
                .replace("{fullName}", customerName)
                .replace("{invoiceDate}", invoiceDate)
                .replace("{quantity}", quantity)
                .replace("{customerType}", customerType)
                .replace("{totalAmount}", totalAmount);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Invoice As");
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            fileToSave = new File(fileToSave.getAbsolutePath() + ".pdf");

            try (OutputStream os = new FileOutputStream(fileToSave)) {
                ITextRenderer renderer = new ITextRenderer();
                renderer.setDocumentFromString(html);
                renderer.layout();
                renderer.createPDF(os);
                JOptionPane.showMessageDialog(null, "Tạo hoá đơn thàng công lưu tại: " + fileToSave.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (DocumentException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String readFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


}
