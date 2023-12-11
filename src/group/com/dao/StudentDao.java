package group.com.dao;

import group.com.entity.Student;
import group.com.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    //根据姓名搜索
    public List<Student> searchPageStudent1(int page, int size, String name) throws SQLException {
        List<Student> list = new ArrayList<>();
        //获取连接
        Connection con = JdbcUtil.getConnection();
        //创建preparedStatement
        String sql = "select * from student where deleted = 0 and sName like '%" + name +"%'" +
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
            String sex = rs.getString(3);
            String sClass = rs.getString(4);
            int deleted = rs.getInt(5);
            list.add(new Student(sId,sName,sex,sClass,deleted));
        }
        //关闭连接
        JdbcUtil.closeConnect(con);
        return list;
    }

    //根据姓名搜索
    public int getAllStudent1(String name) throws SQLException {
        int tol = 0;
        Connection con = JdbcUtil.getConnection();
        String sql = "select count(*) from student where deleted = 0 and sName like '%"+name+"%'";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet set = ps.executeQuery(sql);
        if(set.next()){
            tol = set.getInt(1);
        }
        JdbcUtil.closeConnect(con);
        return tol;
    }

    //根据班级搜索
    public List<Student> searchPageStudent2(int page, int size, String sclass) throws SQLException {
        List<Student> list = new ArrayList<>();
        //获取连接
        Connection con = JdbcUtil.getConnection();
        //创建preparedStatement
        String sql = "select * from student where deleted = 0 and sClass like '%" + sclass +"%'" +
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
            String sex = rs.getString(3);
            String sClass = rs.getString(4);
            int deleted = rs.getInt(5);
            list.add(new Student(sId,sName,sex,sClass,deleted));
        }
        //关闭连接
        JdbcUtil.closeConnect(con);
        return list;
    }

    //获取总的记录数2
    public int getAllStudent2(String sclass) throws SQLException {
        int tol = 0;
        Connection con = JdbcUtil.getConnection();
        String sql = "select count(*) from student where deleted = 0 and sClass like '%"+sclass+"%'";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet set = ps.executeQuery(sql);
        if(set.next()){
            tol = set.getInt(1);
        }
        JdbcUtil.closeConnect(con);
        return tol;
    }

    //删除多个或一个学生信息
    public int deleteStudent(String sIds) throws SQLException {
        int res = 0;//影响行数
        Connection con = JdbcUtil.getConnection();
        String sql = "update student set deleted = 1 where sId in "+sIds;
        PreparedStatement ps = con.prepareStatement(sql);
        res = ps.executeUpdate();
        JdbcUtil.closeConnect(con);
        return res;
    }

    //修改学生信息，sId->sClass
    public int updateStudent(int sId,String sclass) throws SQLException {
        int res = 0;//影响行数
        Connection con = JdbcUtil.getConnection();
        String sql = "update student set sClass = ? where sId = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,sclass);
        ps.setInt(2,sId);
        res = ps.executeUpdate();
        JdbcUtil.closeConnect(con);
        return res;
    }

    //添加学生信息
    public int insertStudent(Student s) throws SQLException {
        int res = 0;//影响行数
        Connection con = JdbcUtil.getConnection();
        String sql = "insert into student values(?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,s.getsId());
        ps.setString(2,s.getsName());
        ps.setString(3,s.getSex());
        ps.setString(4,s.getsClass());
        ps.setInt(5,s.getDeleted());
        res = ps.executeUpdate();
        JdbcUtil.closeConnect(con);
        return res;
    }


}
