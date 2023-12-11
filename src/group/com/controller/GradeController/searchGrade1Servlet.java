package group.com.controller.GradeController;

import group.com.service.GradeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/searchGrade1Servlet")
public class searchGrade1Servlet extends HttpServlet {

    GradeService service = new GradeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决页面中文乱码
        response.setContentType("text/html;charset=UTF-8");
        //获取客户端发送的参数
        int page = Integer.parseInt(request.getParameter("page"));
        int size = Integer.parseInt(request.getParameter("rows"));
        int sId = Integer.parseInt(request.getParameter("sId"));

        //调用service层的方法
        String s = service.searchPageGrade1(page,size,sId);
        //将结果响应给客户端
        PrintWriter out = response.getWriter();
        out.write(s);
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
