package group.com.service;

import group.com.dao.LoginDao;

import java.sql.SQLException;

public class LoginService {
        private LoginDao dao=new LoginDao();
        //登录
        public boolean loginsercive(int account,int password) throws SQLException {
            String acc=String.valueOf(account);
            String pass=String.valueOf(password);//转化成字符串来判断是否为空
                int ret=dao.login(account,password);
               return ret>0;
        }
}
