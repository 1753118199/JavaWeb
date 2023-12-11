package group.com.dao;

import group.com.entity.Grade;
import group.com.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDao {

    //根据学号搜索
    public List<Grade> searchPageGrade1(int page, int size, int sid) throws SQLException {
        List<Grade> list = new ArrayList<>();
        //获取连接
        Connection con = JdbcUtil.getConnection();
        //创建preparedStatement
        String sql = "select * from grade where sId = ? and deleted = 0 "+
                "LIMIT ?, ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,sid);
        ps.setInt(2,(page-1)*size);
        ps.setInt(3,size);
        //执行executeQuery
        ResultSet rs = ps.executeQuery();
        //将ResultSet对象解析到list集合中
        while(rs.next()){
            int sId = rs.getInt(1);
            String sName = rs.getString(2);
            int cId = rs.getInt(3);
            String cName = rs.getString(4);
            float score = rs.getFloat(5);
            list.add(new Grade(sId,sName,cId,cName,score,0));
        }
        //关闭连接
        JdbcUtil.closeConnect(con);
        return list;
    }

    //获取总的记录数1
    public int getAllGrade1(int sid) throws SQLException {
        int tol = 0;
        Connection con = JdbcUtil.getConnection();
        String sql = "select count(*) from grade where sId = ? and deleted = 0";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,sid);
        ResultSet set = ps.executeQuery();
        if(set.next()){
            tol = set.getInt(1);
        }
        JdbcUtil.closeConnect(con);
        return tol;
    }

    //根据课程名搜索
    public List<Grade> searchPageGrade2(int page, int size, String name) throws SQLException {
        List<Grade> list = new ArrayList<>();
        //获取连接
        Connection con = JdbcUtil.getConnection();
        //创建preparedStatement
        String sql = "select * from grade where deleted = 0 and cName like '%" + name +"%'" +
                "LIMIT ?, ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,(page-1)*size);
        ps.setInt(2,size);
        //执行executeQuery
        ResultSet rs = ps.executeQuery();
        //将ResultSet对象解析到list集合中
        while(rs.next()){
            int sId = rs.getInt(1);
            String sName = rs.getString(2);
            int cId = rs.getInt(3);
            String cName = rs.getString(4);
            float score = rs.getFloat(5);
            list.add(new Grade(sId,sName,cId,cName,score,0));
        }
        //关闭连接
        JdbcUtil.closeConnect(con);
        return list;
    }

    //获取总的记录数2
    public int getAllGrade2(String name) throws SQLException {
        int tol = 0;
        Connection con = JdbcUtil.getConnection();
        String sql = "select count(*) from grade where deleted = 0 and cName like '%"+ name +"%'";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet set = ps.executeQuery(sql);
        if(set.next()){
            tol = set.getInt(1);
        }
        JdbcUtil.closeConnect(con);
        return tol;
    }

    //根据班级名搜索
    public List<Grade> searchPageGrade3(int page, int size, String sclass) throws SQLException {
        List<Grade> list = new ArrayList<>();
        //获取连接
        Connection con = JdbcUtil.getConnection();
        //创建preparedStatement
        String sql = "select grade.* from grade,student where grade.deleted = 0 and grade.sId = student.sId and sClass like '%" + sclass +"%'" +
                " LIMIT ?, ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,(page-1)*size);
        ps.setInt(2,size);
        //执行executeQuery
        ResultSet rs = ps.executeQuery();
        //将ResultSet对象解析到list集合中
        while(rs.next()){
            int sId = rs.getInt(1);
            String sName = rs.getString(2);
            int cId = rs.getInt(3);
            String cName = rs.getString(4);
            float score = rs.getFloat(5);
            list.add(new Grade(sId,sName,cId,cName,score,0));
        }
        //关闭连接
        JdbcUtil.closeConnect(con);
        return list;
    }

    //获取总的记录数3
    public int getAllGrade3(String sclass) throws SQLException {
        int tol = 0;
        Connection con = JdbcUtil.getConnection();
        String sql = "select count(*) from grade,student where grade.deleted = 0 and grade.sId = student.sId and sClass like '%" + sclass +"%'";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet set = ps.executeQuery(sql);
        if(set.next()){
            tol = set.getInt(1);
        }
        JdbcUtil.closeConnect(con);
        return tol;
    }


    //修改成绩
    public int updateGrade(int sId,int cId,float score) throws SQLException {
        int res = 0;//影响行数
        Connection con = JdbcUtil.getConnection();
        String sql = "update grade set score = ? where sId = ? and cId = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setFloat(1,score);
        ps.setInt(2,sId);
        ps.setInt(3,cId);
        res = ps.executeUpdate();
        JdbcUtil.closeConnect(con);
        return res;
    }

    //录入成绩
    public int insertGrade(Grade g) throws SQLException {
        int res = 0;//影响行数
        Connection con = JdbcUtil.getConnection();
        String sql = "insert into grade values(?,?,?,?,?,0)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,g.getsId());
        ps.setString(2,g.getsName());
        ps.setInt(3,g.getcId());
        ps.setString(4,g.getcName());
        ps.setFloat(5,g.getScore());
        res = ps.executeUpdate();
        JdbcUtil.closeConnect(con);
        return res;
    }

    //删除单或多条记录
    public int deleteGrade(String sIds) throws SQLException {
        int res = 0;//影响行数
        Connection con = JdbcUtil.getConnection();
        String sql = "update grade set deleted = 1 where sId in "+sIds;
        PreparedStatement ps = con.prepareStatement(sql);
        res = ps.executeUpdate();
        JdbcUtil.closeConnect(con);
        return res;
    }
}
