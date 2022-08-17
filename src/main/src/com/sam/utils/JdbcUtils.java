package com.sam.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    //我們使用了連接池之後：從系統開始啟動的時候就會建立一個工廠物件，裡面有一定數量的資料庫連線物件，
    //使用者使用的時候直接會從池子裡拿連線物件，不需要自己在建立了。

    private static DataSource dataSource;

    static{

        try {
            //從類路徑下載入配置檔案，獲取一個輸入流
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

            //使用Properties物件的方法將配置檔案中屬性載入到Properties物件中
            Properties properties = new Properties();
            //配置了所有屬性
            properties.load(inputStream);
            //通過druid的工廠類建立連線池
            dataSource = DruidDataSourceFactory.createDataSource(properties);
//            System.out.println(dataSource.getConnection());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 獲取數據庫連接池中的連接
     * @return
     */
    public static Connection getConnection(){

        Connection connection = null;

        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 關閉連接，放回連接池
     * @param connection
     */
    public static void close(Connection connection){
        if(connection != null){//不為空才能關閉
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //測試有沒有連接到，會直接調用static區
    }
}
