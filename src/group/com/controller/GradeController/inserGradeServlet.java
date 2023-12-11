package group.com.controller.GradeController;

import group.com.entity.Grade;
import group.com.service.GradeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/inserGradeServlet")
public class inserGradeServlet extends HttpServlet {

    GradeService service = new GradeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int sId = Integer.parseInt(request.getParameter("sId"));
        String sName = request.getParameter("sName");
        int cId = Integer.parseInt(request.getParameter("cId"));
        String cName = request.getParameter("cName");
        float score = (float) Integer.parseInt(request.getParameter("score"));
        int deleted = 0;
        Grade s =new Grade(sId,sName,cId,cName,score,deleted);
        boolean res = service.insertGrade(s);
        PrintWriter out = response.getWriter();
        out.write(""+res);
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
