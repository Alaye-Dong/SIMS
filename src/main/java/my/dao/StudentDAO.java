package my.dao;

import my.vo.Student;

import java.util.List;

public interface StudentDAO {
    // 增加
    void insert(Student student) throws Exception;

    // 修改
    void update(Student student) throws Exception;

    // 删除
    void delete(int studentId) throws Exception;

    // 按ID查询
    Student queryById(int studentId) throws Exception;

    List queryByName(String studentName) throws Exception;

    // 查询全部
    List queryAll(int start, int pageSize) throws Exception;

    int getTotalCount() throws Exception;
}
