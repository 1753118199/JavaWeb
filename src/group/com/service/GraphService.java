package group.com.service;

import group.com.dao.GraphDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GraphService {
    //平均分
    public List<Float> averageservice(String cname) throws SQLException {
        List<Float> averages = new ArrayList<>();
        GraphDao dao=new GraphDao();
        averages=dao.averageDao(cname);
        return averages;
    }

    //总人数
    public List<Integer> totalpeopleService() throws SQLException {
        List<Integer> total = new ArrayList<>();
        GraphDao dao=new GraphDao();
        total=dao.totalpeople();
        return total;
    }
    //成绩等级
    public List<Integer> scoreService(int sclass) throws SQLException {
        List<Integer> list = new ArrayList<>();
        GraphDao dao=new GraphDao();
        list=dao.scoredao();

        List<List<Integer>> groups = new ArrayList<>();
        //System.out.println(list);
        for (int i = 0; i < list.size(); i += 4) {
            int endIndex = Math.min(i + 4, list.size());
            List<Integer> group = new ArrayList<>(list.subList(i, endIndex));
            groups.add(group);
        }

        // 访问特定分组
        int groupIndex = sclass; // 要访问的分组索引
        if (groupIndex >= 0 && groupIndex < groups.size()) {
            List<Integer> selectedGroup = groups.get(groupIndex);
            //System.out.println(selectedGroup);
            return selectedGroup;
        } else {
            return null;
        }

    }
}
