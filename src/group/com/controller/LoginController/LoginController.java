package group.com.controller.LoginController;

import group.com.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(value= "/Login")
public class LoginController extends HttpServlet {
    LoginService service = new LoginService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //获取客户端发过来的编号
        int account=Integer.parseInt(request.getParameter("account"));
        int password=Integer.parseInt(request.getParameter("password"));

        //调用service层
        boolean res= false;
        try {
            res = service.loginsercive(account,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //返回结果
        PrintWriter out=response.getWriter();
        out.write(""+res);
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
