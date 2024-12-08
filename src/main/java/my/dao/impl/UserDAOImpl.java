package my.dao.impl;

import my.dao.UserDAO;
import my.db.DataBaseConnection;
import my.vo.User;

import java.sql.*;

public class UserDAOImpl implements UserDAO {
    public void insert(User user) throws Exception {
        String sql = "INSERT INTO users(user_name,password) VALUES(?,?)" ;
        PreparedStatement pstmt = null ;
        DataBaseConnection dbc = null ;
        // 下面是针对数据库的具体操作
        try{
            // 连接数据库
            dbc = new DataBaseConnection() ;
            pstmt = dbc.getConnection().prepareStatement(sql) ;
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());
            // 进行数据库更新操作
            pstmt.executeUpdate() ;
            pstmt.close() ;
        }catch (Exception e){
            throw new Exception("操作出现异常") ;
        }
        finally{
            // 关闭数据库连接
            dbc.close() ;
        }
    }

    public boolean check(User user) throws Exception {
        String sql = "SELECT COUNT(*) FROM users WHERE user_name = ? AND password = ?";
        PreparedStatement pstmt = null;
        DataBaseConnection dbc = null;
        boolean isValidUser = false;

        try {
            // 连接数据库
            dbc = new DataBaseConnection();
            pstmt = dbc.getConnection().prepareStatement(sql);
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());

            // 执行查询
            ResultSet rs = pstmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                isValidUser = true;
            }
            rs.close();
        } catch (Exception e) {
            throw new Exception("操作出现异常");
        } finally {
            // 关闭数据库连接
            if (pstmt != null) pstmt.close();
            if (dbc != null) dbc.close();
        }

        return isValidUser;
    }
}
