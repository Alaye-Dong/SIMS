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

    @Override
    public int addCourse(Course course) throws Exception {
        String sql = "INSERT INTO courses(course_name, course_duration) VALUES(?, ?)";
        DataBaseConnection dbc = new DataBaseConnection();
        try (Connection conn = dbc.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, course.getCourseName());
            stmt.setString(2, course.getCourseDuration());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("添加课程失败", e);
        }
    }

    @Override
    public int updateCourse(Course course) throws Exception {
        String sql = "UPDATE courses SET course_name = ?, course_duration = ? WHERE course_id = ?";
        DataBaseConnection dbc = new DataBaseConnection();
        try (Connection conn = dbc.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, course.getCourseName());
            stmt.setString(2, course.getCourseDuration());
            stmt.setInt(3, course.getCourseId());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("更新课程失败", e);
        }
    }

    @Override
    public int deleteCourse(int courseId) throws Exception {
        String sql = "DELETE FROM courses WHERE course_id = ?";
        DataBaseConnection dbc = new DataBaseConnection();
        try (Connection conn = dbc.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, courseId);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("删除课程失败", e);
        }
    }

    @Override
    public Course queryById(int courseId) throws Exception {
        String sql = "SELECT course_id, course_name, course_duration FROM courses WHERE course_id = ?";
        DataBaseConnection dbc = new DataBaseConnection();
        try (Connection conn = dbc.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getInt("course_id"));
                course.setCourseName(rs.getString("course_name"));
                course.setCourseDuration(rs.getString("course_duration"));
                return course;
            } else {
                return null; // or throw an exception if course not found
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("查询课程失败", e);
        }
    }
}