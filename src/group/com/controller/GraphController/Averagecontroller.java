package group.com.controller.GraphController;

import group.com.service.GraphService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/averagecontroller")
public class Averagecontroller extends HttpServlet {
    GraphService service=new GraphService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cname=request.getParameter("cname");
        List<Float> averages = new ArrayList<>();
        //System.out.println(cname);
        //调用service层

        try {
            averages= service.averageservice(cname);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //返回结果
        PrintWriter out=response.getWriter();
        out.write(""+averages);
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
