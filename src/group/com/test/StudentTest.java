package group.com.test;

import group.com.dao.StudentDao;
import group.com.entity.Student;
import group.com.service.StudentService;

import java.sql.SQLException;
import java.util.List;

public class StudentTest {
    public static StudentDao dao = new StudentDao();
    public static StudentService service = new StudentService();

    public static void main(String[] args) throws SQLException {
        //search1Test();
        //search1Service();
        search2Test();
        search2Service();
        //deleteTest();
        //deleteService();
        //updateTest();
        //updateService();
        //insertTest();
        //insertService();
    }

    public static void search1Test() throws SQLException {
        List<Student> list = dao.searchPageStudent1(1,5,"杨詩涵");
        System.out.println(list);
    }
    public static void search1Service(){
        String str = "";
        str = service.searchPageStudent1(1,5,"王海洋");
        System.out.println(str);
    }

    public static void search2Test() throws SQLException {
        List<Student> list = dao.searchPageStudent2(1,5,"3");
        System.out.println(list);
    }
    public static void search2Service(){
        String str = "";
        str = service.searchPageStudent2(1,5,"3");
        System.out.println(str);
    }

    public static void deleteTest() throws SQLException {
        int res = dao.deleteStudent("(10003)");
        System.out.println(res);
    }
    public static void deleteService(){
        String sIds = "(10076,10078)";
        boolean res = service.deleteStudent(sIds);
        System.out.println(res);
    }

    public static void updateTest() throws SQLException {
        int res = dao.updateStudent(10001,"软件223");
        System.out.println(res);

    }
    public static void updateService(){
        boolean res = service.updateStudent(10084,"软件213");
        System.out.println(res);
    }

    public static void insertTest() throws SQLException {
        Student s = new Student(20001,"王海洋","男","软件工程213",0);
        int res = dao.insertStudent(s);
        System.out.println(res);
    }
    public static void insertService(){
        Student s = new Student(20002,"zhu","男","软件工程213",0);
        boolean res = service.insertStudent(s);
        System.out.println(res);
    }

}
