package group.com.service;

import group.com.dao.StudentDao;
import group.com.entity.Student;
import net.sf.json.JSONObject;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {
    private StudentDao dao = new StudentDao();
    //模糊分页查询，将查询到的记录数据返回JSON格式数据
    public String searchPageStudent1(int page, int size, String name){
        String str = "";
        //解决url中name=null
        if(name==null)
            name="";

        try {
            List<Student> list = dao.searchPageStudent1(page,size,name);
            int total = dao.getAllStudent1(name);
            Map<String,Object> map = new HashMap<>();
            map.put("rows",list);
            map.put("total",total);
            JSONObject json = JSONObject.fromObject(map);
            str = json.toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return str;
    }

    public String searchPageStudent2(int page, int size, String sclass){
        String str = "";
        if(sclass==null)
            sclass="";

        try {
            List<Student> list = dao.searchPageStudent2(page,size,sclass);
            int total = dao.getAllStudent2(sclass);
            Map<String,Object> map = new HashMap<>();
            map.put("rows",list);
            map.put("total",total);
            JSONObject json = JSONObject.fromObject(map);
            str = json.toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return str;
    }

    public boolean deleteStudent(String sIds){
        int res = 0;
        try {
            res = dao.deleteStudent(sIds);
        }catch(Exception e){
            e.printStackTrace();
        }
        return res>0;
    }


    public boolean updateStudent(int sId,String sclass){
        int res = 0;
        try {
            res = dao.updateStudent(sId,sclass);
        }catch(Exception e){
            e.printStackTrace();
        }
        return res>0;
    }


    public boolean insertStudent(Student s){
        int res = 0;
        try {
            res = dao.insertStudent(s);
        }catch(Exception e){
            e.printStackTrace();
        }
        return res>0;
    }
}

