package group.com.controller.GradeController;

import group.com.service.GradeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/updateGradeServlet")
public class updateGradeServlet extends HttpServlet {

    GradeService service = new GradeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sId = Integer.parseInt(request.getParameter("sId"));
        int cId = Integer.parseInt(request.getParameter("cId"));
        float score = (float)Integer.parseInt(request.getParameter("score"));

        boolean res = service.updateGrade(sId,cId,score);
        PrintWriter out = response.getWriter();
        out.write(""+res);
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
