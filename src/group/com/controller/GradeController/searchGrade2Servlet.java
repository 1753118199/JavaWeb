package group.com.controller.GradeController;

import group.com.service.GradeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/searchGrade2Servlet")
public class searchGrade2Servlet extends HttpServlet {

    GradeService service = new GradeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决页面中文乱码
        response.setContentType("text/html;charset=UTF-8");
        //获取客户端发送的参数
        int page = Integer.parseInt(request.getParameter("page"));
        int size = Integer.parseInt(request.getParameter("rows"));
        String cName = request.getParameter("cName");

        //调用service层的方法
        String s = service.searchPageGrade2(page,size,cName);
        //将结果响应给客户端
        PrintWriter out = response.getWriter();
        out.write(s);
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
