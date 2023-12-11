package group.com.dao;


import group.com.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    //登录
    public int login(int account,int password) throws SQLException {
        int res=0;
        Connection con= JdbcUtil.getConnection();
        String sql="SELECT password FROM login WHERE account=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,account);
        ResultSet resource=ps.executeQuery();
        int income=0;
        if (resource.next()) {
             income=resource.getInt(1); // 或者使用 getColumnIndex("columnName")
            // 处理你的值
        }
        if (income==password)
            res=1;
        else res=0;
        JdbcUtil.closeConnect(con);
        return res;
    }

}
