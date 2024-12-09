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
}
