package group.com.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
    private static DataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
            //JdbcUtil类名就是所在类的类名。
            InputStream inputStream =
                    JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            properties.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  static Connection getConnection()  {
        Connection con = null;
        try {
            con = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }

    public static void closeConnect(Connection con)  {
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
