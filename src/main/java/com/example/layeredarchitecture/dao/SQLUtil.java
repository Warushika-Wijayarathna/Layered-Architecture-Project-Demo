package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUtil {
    public static <T> T execute(String sql, Object ...object) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        for (int i = 0; i < object.length; i++) {
            statement.setObject(i+1,object[i]);
        }

        boolean SELECT = sql.trim().startsWith("SELECT");
        if (SELECT) {
            return (T)statement.executeQuery();
        } else {
            return (T) (Boolean) (statement.executeUpdate()>0);
        }
    }


//    private static PreparedStatement getPreparedStatement(String sql, Object... args) throws SQLException{
//        Connection connection = DBConnection.getInstance().getConnection();
//        PreparedStatement statement = connection.prepareStatement(sql);
//        if(args !=null){
//            for (int i = 0; i < args.length; i++) {
//                statement.setObject(i+1, args[i]);
//            }
//        }
//
//        return statement;
//    }
//
//    public static boolean executeUpdate(String sql, Object... args) throws SQLException{
//        return getPreparedStatement(sql, args).executeUpdate()>0;
//    }
//
//    public static ResultSet executeQuery(String sql, Object... args) throws SQLException{
//        return getPreparedStatement(sql, args).executeQuery();
//    }
}

