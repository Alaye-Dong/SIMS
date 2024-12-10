package my.dao.impl;

import my.dao.inter.CourseDAOInter;
import my.vo.Course;
import my.db.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAOInter {

    @Override
    public List<Course> queryAll() throws Exception {
        List<Course> courseList = new ArrayList<>();
        String sql = "SELECT course_id, course_name, course_duration FROM courses";
        DataBaseConnection dbc = new DataBaseConnection();
        try (Connection conn = dbc.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getInt("course_id"));
                course.setCourseName(rs.getString("course_name"));
                course.setCourseDuration(rs.getString("course_duration"));
                courseList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("查询课程信息失败", e);
        }
        return courseList;
    }
}