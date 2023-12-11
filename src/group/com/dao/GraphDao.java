package group.com.dao;

import group.com.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GraphDao {
    //总人数
    public List<Integer> totalpeople() throws SQLException {
        List<Integer> total = new ArrayList<>();

        Connection con= JdbcUtil.getConnection();
        String sql="SELECT  COUNT(*) AS total_students\n" +
                "FROM student\n" +
                "WHERE sClass IN ('计算机类1班', '计算机类2班', '计算机类3班') AND deleted=0\n" +
                "GROUP BY sClass";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet resource=ps.executeQuery();
        while (resource.next()) {
            total.add(resource.getInt(1)); // 或者使用 getColumnIndex("columnName")
            // 处理你的值
        }
        JdbcUtil.closeConnect(con);
        return total;
    }
    //平均分传参是课程名和班级
    public List<Float>  averageDao(String cname) throws SQLException {
        List<Float> averages = new ArrayList<>();
        float aver=0;
        Connection con= JdbcUtil.getConnection();
        String sql="\n" +
                "SELECT  AVG(score) AS average_grade\n" +
                "FROM student\n" +
                "JOIN grade ON student.sId = grade.sId\n" +
                "WHERE cName = ? AND sClass IN ('计算机类1班', '计算机类2班', '计算机类3班') AND student.deleted=0\n" +
                "GROUP BY sClass";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,cname);
        ResultSet resource=ps.executeQuery();
        while (resource.next()) {
            averages.add(resource.getFloat(1));

            // 或者使用 getColumnIndex("columnName")
            // 处理你的值
        }
        JdbcUtil.closeConnect(con);
        return averages;
    }
    //成绩等级
    public List<Integer> scoredao() throws SQLException, SQLException {
        List<Integer> score = new ArrayList<>();
        Connection con= JdbcUtil.getConnection();
        String sql="SELECT\n" +
                "       COUNT(CASE WHEN g.score >= 90 THEN 1 END) AS num_score_above_90,\n" +
                "       COUNT(CASE WHEN g.score >= 80 THEN 1 END) AS num_score_above_80,\n" +
                "       COUNT(CASE WHEN g.score >= 60 THEN 1 END) AS num_score_above_60,\n" +
                "       COUNT(CASE WHEN g.score < 60 THEN 1 END) AS num_score_below_60\n" +
                "FROM student s\n" +
                "JOIN grade g ON s.sId = g.sId\n" +
                "WHERE s.deleted = 0\n" +
                "GROUP BY s.sClass";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet resource=ps.executeQuery();
        while (resource.next()) {
            // score.add(resource.getInt(1)); // 或者使用 getColumnIndex("columnName")
            // 处理你的值
            score.add(resource.getInt("num_score_above_90"));
            score.add(resource.getInt("num_score_above_80"));
            score.add(resource.getInt("num_score_above_60"));
            score.add(resource.getInt("num_score_below_60"));
        }
        JdbcUtil.closeConnect(con);
        return score;
    }
}
