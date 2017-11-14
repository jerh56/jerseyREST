package com.coppel.models;


import com.coppel.entities.Users;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emmanuel
 */
public class UsersModel {
    
    //private final Properties properties;
    
    public UsersModel() {
        //properties = new Properties();
        //properties.setProperty("ip", System.getenv(""));
    }
    
    private Connection getSource() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://tomcatdev.centralus.cloudapp.azure.com:5432/empleados", "postgres", "db2017");
    }
    
    public List<Users> show(String userName) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Users> users = new ArrayList<>();
        Users user = null;
        try {
            connection = this.getSource();
            if (userName == null) {
                preparedStatement = connection.prepareCall("SELECT * FROM usuarios;");
            } else {
                preparedStatement = connection.prepareCall("SELECT * FROM usuarios WHERE user_name = ?");
                preparedStatement.setString(1, userName);
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new Users(resultSet.getLong("id_usuario"),
                        resultSet.getString("user_name"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido_paterno"),
                        resultSet.getString("apellido_paterno"),
                        resultSet.getInt("edad"), 
                        resultSet.getString("imagen"), 
                        resultSet.getString("fecha_creacion"), 
                        resultSet.getShort("estatus"));
                users.add(user);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
            throw ex;
        }
        return users;
    }
    
}
