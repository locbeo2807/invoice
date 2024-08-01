package com.invoice.dao;

import com.invoice.model.Customer;
import com.invoice.util.DbConnect;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomerDao {

    private final DbConnect dbConnect;

    public CustomerDao() {
        dbConnect = DbConnect.getInstance();
    }

    public List<Customer> getAllCustomers() {
        String sql = "select * from customers";
        List<Customer> result = new ArrayList<>();

        try (ResultSet rs = dbConnect.executeQuery(sql)) {
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(rs.getString("customerId"));
                customer.setCustomerName(rs.getString("FullName"));
                customer.setCustomerType(rs.getString("customerType"));
                customer.setQuota(rs.getString("Quota"));
                customer.setNationality(rs.getString("Nationality"));

                result.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return result;
    }

    public void addCustomer(Customer customer) {

        if(isExistCustomer(customer.getCustomerId())){
            JOptionPane.showMessageDialog(null, "Mã khách hàng đã tồn tại!");
            return;
        }

        String sql = "insert into customers(customerId, FullName, customerType, Quota, Nationality) values(?, ?, ?, ?, ?)";
        dbConnect.executeUpdate(sql,
                customer.getCustomerId(),
                customer.getCustomerName(),
                customer.getCustomerType(),
                customer.getQuota(),
                customer.getNationality());
    }

    public boolean isExistCustomer(String customerId) {
        String sql = "select * from customers where customerId = ?";
        try (ResultSet rs = dbConnect.executeQuery(sql, customerId)) {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void deleteCustomer(Customer customer) {
        String sql = "delete from customers where customerId = ?";
        dbConnect.executeUpdate(sql, customer.getCustomerId());
    }

    public void updateCustomer(Customer customer) {
        String sql = "update customers set FullName = ?, customerType = ?, Quota = ?, Nationality=? where customerId = ?";
        dbConnect.executeUpdate(sql,
                customer.getCustomerName(),
                customer.getCustomerType(),
                customer.getQuota(),
                customer.getNationality(),
                customer.getCustomerId());
    }

    public List<String> getAllCustomerIds(){
        List<String> result = new ArrayList<>();
        String sql = "select customerId from customers";
        try (ResultSet rs = dbConnect.executeQuery(sql)) {
            while (rs.next()) {
                result.add(rs.getString("customerId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public String getQuotaByCusId(String cusId){
        String sql = "select Quota from customers where customerId = ?";
        try (ResultSet rs = dbConnect.executeQuery(sql, cusId)) {
            if (rs.next()) {
                return rs.getString("Quota");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
