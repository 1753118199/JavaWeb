package group.com.test;

import group.com.dao.GradeDao;
import group.com.entity.Grade;
import group.com.service.GradeService;

import java.sql.SQLException;
import java.util.List;

public class GradeTest {
    public static GradeDao dao =new GradeDao();
    public static GradeService service = new GradeService();
    public static void main(String[] args) throws SQLException {

        //searchDao1();
        //searchService1();
        //searchDao2();
        //searchService2();
        //searchDao3();
        //searchService3();
        //deleteDao();
        //deletedService();
        //updateDao();
        //updateService();
        //inserDao();
        //inserService();
    }

    public static void searchDao1() throws SQLException {
        List<Grade> list = dao.searchPageGrade1(1,5,20002);
        System.out.println(list);
    }
    public static void searchService1(){
        String str = "";
        str = service.searchPageGrade1(1,5,10031);
        System.out.println(str);
    }

    public static void searchDao2() throws SQLException {
        List<Grade> list = dao.searchPageGrade2(1,5,"Liu Rui");
        System.out.println(list);
    }
    public static void searchService2(){
        String str = "";
        str =service.searchPageGrade2(1,5,"数据库");
        System.out.println(str);
    }

    public static void searchDao3() throws SQLException {
        List<Grade> list = dao.searchPageGrade3(1,5,"制造");
        System.out.println(list);
    }
    public static void searchService3(){
        String str = "";
        str =service.searchPageGrade3(1,5,"物流");
        System.out.println(str);
    }

    public static void deleteDao() throws SQLException {
        int res = dao.deleteGrade("(10010)");
        System.out.println(res);
    }
    public static void deletedService(){
        boolean res = service.deleteGrade("(10011,10012)");
        System.out.println(res);
    }

    public static void updateDao() throws SQLException {
        int res = dao.updateGrade(10001,100,52);
        System.out.println(res);
    }
    public static void updateService(){
        boolean res = service.updateGrade(10002,101,80);
        System.out.println(res);
    }

    public static void inserDao() throws SQLException {
        Grade g = new Grade(20001,"王海洋",10,"数据库",100,0);
        int res = dao.insertGrade(g);
        System.out.println(res);
    }
    public static void inserService(){
        Grade g = new Grade(20002,"zhu",10,"数据库",100,0);
        boolean res = service.insertGrade(g);
        System.out.println(res);
    }

}
