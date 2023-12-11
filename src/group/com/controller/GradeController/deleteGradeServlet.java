package group.com.controller.GradeController;

import group.com.service.GradeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/deleteGradeServlet")
public class deleteGradeServlet extends HttpServlet {

    GradeService service = new GradeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String str = request.getParameter("sIds");
        boolean res = service.deleteGrade(str);
        PrintWriter out = response.getWriter();
        out.write(""+res);
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
