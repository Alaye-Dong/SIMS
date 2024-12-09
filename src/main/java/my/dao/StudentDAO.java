package my.dao;

import my.vo.Student;

import java.util.List;

public interface StudentDAO {
    //    // 增加操作
//    void insert(Student student) throws Exception ;
    void update(Student student) throws Exception;

    // 删除操作
    void delete(int studentId) throws Exception;

    //    // 按ID查询操作
    Student queryById(int studentId) throws Exception;

    // 查询全部
    List queryAll() throws Exception;
}
