package group.com.test;

import group.com.service.GraphService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Grouptest {


    public static void main(String[] args) throws SQLException {
        GraphService service=new GraphService();
        List<Integer> total = new ArrayList<>();
        total=service.totalpeopleService();
        System.out.println(total);
    }
}
