package group.com.controller.StudentController;

import group.com.entity.Student;
import group.com.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/insertStudentServlet")
public class insertStudentServlet extends HttpServlet {

    StudentService service = new StudentService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int sId = Integer.parseInt(request.getParameter("sId"));
        String sName = request.getParameter("sName");
        String sex = request.getParameter("sex");
        String sClass = request.getParameter("sClass");
        int deleted = 0;
        Student s =new Student(sId,sName,sex,sClass,deleted);
        boolean res = service.insertStudent(s);
        PrintWriter out = response.getWriter();
        out.write(""+res);
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
