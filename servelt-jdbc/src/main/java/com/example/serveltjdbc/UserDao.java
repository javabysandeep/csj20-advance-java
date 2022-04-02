package com.example.serveltjdbc;

import java.sql.*;

public class UserDao {
    User registerUser(User user) {
        Connection connection = getConnection();
        String query = "insert into user(name, email, phone, username, password) values(?,?,?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getUsername());
            preparedStatement.setString(5, user.getPassword());
            int status = preparedStatement.executeUpdate();
            connection.close();
            return getUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    User getUser(User user) {
        Connection connection = getConnection();
        String query = "SELECT * FROM user where email=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();
            User result = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                result = result.builder()
                        .id(id)
                        .name(name)
                        .email(email)
                        .phone(phone)
                        .username(username)
                        .password(password)
                        .build();
                return result;
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/cyber_success";
        String username = "root";
        String password = "root@1234";
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
