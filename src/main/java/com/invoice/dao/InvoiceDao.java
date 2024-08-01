package com.invoice.dao;

import com.invoice.model.Invoice;
import com.invoice.util.DbConnect;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InvoiceDao {
    private final DbConnect dbConnect;

    public InvoiceDao() {
        dbConnect = DbConnect.getInstance();
    }

    public List<Invoice> getAllInvoices() {
        List<Invoice> result = new ArrayList<>();
        String sql = "select * from invoices";

        try (ResultSet rs = dbConnect.executeQuery(sql)) {
            while (rs.next()) {
                Invoice invoice = new Invoice();
                invoice.setCustomerId(rs.getString("customerId"));
                invoice.setInvoiceDate(rs.getDate("invoiceDate").toLocalDate());
                invoice.setQuantity(rs.getInt("quantity"));
                invoice.setUnitPrice(rs.getDouble("unitPrice"));
                invoice.setTotal(rs.getDouble("totalAmount"));

                result.add(invoice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public void addInvoice(Invoice invoice) {
        LocalDate invoiceDate = invoice.getInvoiceDate();
        int month = invoiceDate.getMonthValue();
        int year = invoiceDate.getYear();

        int count = 0;
        String checkSql = "SELECT COUNT(*) FROM Invoices WHERE customerId = ? AND YEAR(InvoiceDate) = ? AND MONTH(InvoiceDate) = ?";

        try (ResultSet rs = dbConnect.executeQuery(checkSql, invoice.getCustomerId(), year, month)) {
            if (rs.next()) {
                count = rs.getInt(1);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (count > 0) {
            JOptionPane.showMessageDialog(null, "Khách hàng đã có hóa đơn trong tháng này.");
        } else {
            String sql = "INSERT INTO Invoices (customerId, invoiceDate, quantity, unitPrice, totalAmount) VALUES (?, ?, ?, ?, ?)";
            dbConnect.executeUpdate(sql,
                    invoice.getCustomerId(),
                    invoice.getInvoiceDate(),
                    invoice.getQuantity(),
                    invoice.getUnitPrice(),
                    invoice.getTotal());
            JOptionPane.showMessageDialog(null, "Thêm hóa đơn thành công");

        }
    }


    public void deleteInvoice(Invoice invoice) {
        LocalDate invoiceDate = invoice.getInvoiceDate();

        String sql = "DELETE FROM Invoices WHERE customerId = ? AND InvoiceDate = ?";
        dbConnect.executeUpdate(sql,
                invoice.getCustomerId(),
                invoiceDate);
    }


    public void updateInvoice(Invoice invoice) {
        String sql = "update invoices set  quantity = ?, unitPrice = ?, totalAmount = ? where customerId = ? and invoiceDate = ?";
        dbConnect.executeUpdate(sql,
                invoice.getQuantity(),
                invoice.getUnitPrice(),
                invoice.getTotal(),
                invoice.getCustomerId(),
                invoice.getInvoiceDate());
    }

    public Map<String, String> getInvoiceInfoByCusId(Invoice invoice) {
        String sql = """   
                       SELECT c.CustomerID,
                       c.FullName,
                       i.InvoiceDate,
                       i.Quantity,
                       CASE
                           WHEN c.Nationality IS NOT NULL AND c.Nationality <> '' THEN 'Foreign'
                           ELSE 'Vietnam'
                           END AS Nationality,
                       i.TotalAmount
                FROM Customers c
                         JOIN Invoices i ON c.CustomerID = i.CustomerID
                WHERE c.CustomerID = ?
                  AND i.InvoiceDate = ?;
                            """;

        try (ResultSet rs = dbConnect.executeQuery(sql, invoice.getCustomerId(), invoice.getInvoiceDate())) {
            if (rs.next()) {
                return Map.of(
                        "{customerId}", rs.getString("CustomerID"),
                        "{fullName}", rs.getString("FullName"),
                        "{invoiceDate}", rs.getDate("InvoiceDate").toString(),
                        "{quantity}", rs.getString("Quantity"),
                        "{customerType}", rs.getString("Nationality"),
                        "{totalAmount}", rs.getString("TotalAmount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;


    }

    public List<Invoice> searchInvoices(String customerId, Integer month, Integer year) {
        List<Invoice> result = new ArrayList<>();

        StringBuilder sql = new StringBuilder("SELECT * FROM Invoices WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (customerId != null && !customerId.isEmpty()) {
            sql.append(" AND customerId = ?");
            params.add(customerId);
        }
        if (month != null) {
            sql.append(" AND MONTH(invoiceDate) = ?");
            params.add(month);
        }
        if (year != null) {
            sql.append(" AND YEAR(invoiceDate) = ?");
            params.add(year);
        }

        try (ResultSet rs = dbConnect.executeQuery(sql.toString(), params.toArray())) {
            while (rs.next()) {
                Invoice invoice = new Invoice();
                invoice.setCustomerId(rs.getString("customerId"));
                invoice.setInvoiceDate(rs.getDate("invoiceDate").toLocalDate());
                invoice.setQuantity(rs.getInt("quantity"));
                invoice.setUnitPrice(rs.getDouble("unitPrice"));
                invoice.setTotal(rs.getDouble("totalAmount"));

                result.add(invoice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }



}
