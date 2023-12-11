package group.com.controller.StudentController;

import group.com.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/updateStudentServlet")
public class updateStudentServlet extends HttpServlet {

    StudentService service = new StudentService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sId = Integer.parseInt(request.getParameter("sId"));
        String sClass = request.getParameter("sClass");

        boolean res = service.updateStudent(sId,sClass);
        PrintWriter out = response.getWriter();
        out.write(""+res);
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
