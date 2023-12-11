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

@WebServlet(value= "/ScoreLevelcontroller")
public class ScoreLevelcontroller extends HttpServlet {
    GraphService service=new GraphService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sclass=Integer.parseInt(request.getParameter("sclass"));
        List<Integer> score = new ArrayList<>();
        try {
            score=service.scoreService(sclass);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        PrintWriter out=response.getWriter();
        out.write(""+score);
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
