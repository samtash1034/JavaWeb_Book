package com.sam.test;

import com.sam.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils(){
        for(int i = 0; i < 100; i++){
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);//最多只能獲取10個(jdbc.properties設置的)
            JdbcUtils.close(connection);//如果每次獲取完都釋放則獲取多少個都沒問題
        }
    }
}
