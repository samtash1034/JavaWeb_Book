package com.sam.dao;

import com.sam.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDao {

    //DBUtils是Apache組織開源的資料庫工具類。
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update：update/insert/delete
     * @param sql
     * @param args sql對應的參數
     * @return 失敗返回-1
     */
    public int update(String sql, Object...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return -1;
    }

    /**
     * 查詢返回一個javaBean的sql語句
     * @param type 回傳的類型
     * @param sql
     * @param args
     * @param <T>
     * @return 查不到返回null
     */
    public <T> T queryForOne(Class<T> type, String sql, Object...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 查詢返回多的javaBean語句
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return 查不到返回null
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 執行返回一行一列的sql語句
     * @param sql
     * @param args
     * @return 查不到返回null
     */
    public Object queryForSingleValue(String sql, Object...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new ScalarHandler(), args);//ScalarHandler 通常用於保存只有一行一列的結果集
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }
}
