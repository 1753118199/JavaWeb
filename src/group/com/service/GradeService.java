package group.com.service;

import group.com.dao.GradeDao;
import group.com.entity.Grade;
import net.sf.json.JSONObject;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GradeService {
    private GradeDao dao = new GradeDao();
    //模糊分页查询，将查询到的记录数据返回JSON格式数据
    public String searchPageGrade1(int page, int size, int sId){
        String str = "";

        try {
            List<Grade> list = dao.searchPageGrade1(page,size,sId);
            int total = dao.getAllGrade1(sId);
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

    public String searchPageGrade2(int page, int size, String name){
        String str = "";
        //解决url中name=null
        if(name==null)
            name="";
        try {
            List<Grade> list = dao.searchPageGrade2(page,size,name);
            int total = dao.getAllGrade2(name);
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

    public String searchPageGrade3(int page, int size, String sclass){
        String str = "";
        //解决url中name=null
        if(sclass==null)
            sclass="";
        try {
            List<Grade> list = dao.searchPageGrade3(page,size,sclass);
            int total = dao.getAllGrade3(sclass);
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

    public boolean deleteGrade(String sIds){
        int res = 0;
        try {
            res = dao.deleteGrade(sIds);
        }catch(Exception e){
            e.printStackTrace();
        }
        return res>0;
    }


    public boolean updateGrade(int sId,int cId,float score){
        int res = 0;
        try {
            res = dao.updateGrade(sId,cId,score);
        }catch(Exception e){
            e.printStackTrace();
        }
        return res>0;
    }


    public boolean insertGrade(Grade g){
        int res = 0;
        try {
            res = dao.insertGrade(g);
        }catch(Exception e){
            e.printStackTrace();
        }
        return res>0;
    }

}
