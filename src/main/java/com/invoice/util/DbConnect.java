package com.invoice.util;

import java.sql.*;

public class DbConnect {
    private static DbConnect instance;

    private final static String jdbcUrl = "jdbc:mysql://localhost:3306/electric_invoice?useSSL=false&serverTimezone=UTC";
    private final static String username = "root";
    private final static String password = "16112004";

    private Connection connection;

    private DbConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static DbConnect getInstance() {
        if (instance == null) {
            instance = new DbConnect();
        }
        return instance;
    }

    public ResultSet executeQuery(String sql, Object... parameters) {
        try {
            PreparedStatement preparedStatement = createPreparedStatement(sql, parameters);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int executeUpdate(String sql, Object... parameters) {
        try {
            PreparedStatement preparedStatement = createPreparedStatement(sql, parameters);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private PreparedStatement createPreparedStatement(String sql, Object... parameters) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < parameters.length; i++) {
            preparedStatement.setObject(i + 1, parameters[i]);
        }
        return preparedStatement;
    }
}
