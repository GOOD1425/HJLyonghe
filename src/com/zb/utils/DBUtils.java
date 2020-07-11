package com.zb.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: l
 * @date: 2020-7-8 18:52
 * @description:
 */
public   class DBUtils {

    public  static Connection getConnection(){
        ComboPooledDataSource dataSource=new ComboPooledDataSource("c3p0-config.xml");
        Connection conn=null;
        try {
            conn=dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
