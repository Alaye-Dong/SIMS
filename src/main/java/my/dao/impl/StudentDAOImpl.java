package my.dao.impl;

import my.dao.StudentDAO;
import my.db.DataBaseConnection;
import my.vo.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    public List queryAll() throws Exception {
        String sql = "SELECT * FROM students";
        PreparedStatement pstmt = null;
        DataBaseConnection dbc = null;
        List<Student> studentList = new ArrayList<>();

        try {
            // 连接数据库
            dbc = new DataBaseConnection();
            pstmt = dbc.getConnection().prepareStatement(sql);

            // 执行查询
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                // 从结果集中提取学生信息并封装到 Student 对象中
                Student student = new Student();
                student.setStudentId(rs.getInt("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setAge(rs.getInt("age"));
                student.setGender(rs.getString("gender"));
                // 将学生对象添加到列表
                studentList.add(student);
            }
            rs.close();
        } catch (Exception e) {
            throw new Exception("操作出现异常", e);
        } finally {
            // 关闭数据库连接
            if (pstmt != null) pstmt.close();
            if (dbc != null) dbc.close();
        }

        return studentList;
    }

    public void update(Student student) throws Exception {
        String sql = "UPDATE students SET student_name = ?, age = ?, gender = ? WHERE student_id = ?";
        PreparedStatement pstmt = null;
        DataBaseConnection dbc = null;

        try {
            // 连接数据库
            dbc = new DataBaseConnection();
            pstmt = dbc.getConnection().prepareStatement(sql);

            // 设置参数
            pstmt.setString(1, student.getStudentName());
            pstmt.setInt(2, student.getAge());
            pstmt.setString(3, student.getGender());
            pstmt.setInt(4, student.getStudentId());

            // 执行更新
            int rowsUpdated = pstmt.executeUpdate();

            // 检查更新是否成功
            if (rowsUpdated > 0) {
                System.out.println("学生信息更新成功！");
            } else {
                System.out.println("没有找到要更新的学生！");
            }
        } catch (Exception e) {
            throw new Exception("更新操作出现异常", e);
        } finally {
            // 关闭数据库连接
            if (pstmt != null) pstmt.close();
            if (dbc != null) dbc.close();
        }
    }

    public Student queryById(int studentId) throws Exception {
        String sql = "SELECT * FROM students WHERE student_id = ?";
        PreparedStatement pstmt = null;
        DataBaseConnection dbc = null;
        Student student = null;

        try {
            // 连接数据库
            dbc = new DataBaseConnection();
            pstmt = dbc.getConnection().prepareStatement(sql);

            // 设置参数
            pstmt.setInt(1, studentId);

            // 执行查询
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // 从结果集中提取学生信息并封装到 Student 对象中
                student = new Student();
                student.setStudentId(rs.getInt("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setAge(rs.getInt("age"));
                student.setGender(rs.getString("gender"));
            }

            rs.close();
        } catch (Exception e) {
            throw new Exception("查询操作出现异常", e);
        } finally {
            // 关闭数据库连接
            if (pstmt != null) pstmt.close();
            if (dbc != null) dbc.close();
        }

        return student;
    }

    public void delete(int studentId) throws Exception {
        String sql = "DELETE FROM students WHERE student_id = ?";
        PreparedStatement pstmt = null;
        DataBaseConnection dbc = null;

        try {
            // Connect to the database
            dbc = new DataBaseConnection();
            pstmt = dbc.getConnection().prepareStatement(sql);

            // Set the studentId parameter
            pstmt.setInt(1, studentId);

            // Execute the delete operation
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new Exception("删除操作出现异常", e);
        } finally {
            // Close the resources
            if (pstmt != null) pstmt.close();
            if (dbc != null) dbc.close();
        }
    }

    public void insert(Student student) throws Exception {
        String sql = "INSERT INTO students (student_id, student_name, age, gender) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = null;
        DataBaseConnection dbc = null;

        try {
            // 连接数据库
            dbc = new DataBaseConnection();
            pstmt = dbc.getConnection().prepareStatement(sql);

            // 设置参数
            pstmt.setInt(1, student.getStudentId());
            pstmt.setString(2, student.getStudentName());
            pstmt.setInt(3, student.getAge());
            pstmt.setString(4, student.getGender());

            // 执行插入操作
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new Exception("插入操作出现异常", e);
        } finally {
            // 关闭资源
            if (pstmt != null) pstmt.close();
            if (dbc != null) dbc.close();
        }
    }
}
