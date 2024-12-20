package my.dao.inter;

import my.vo.Course;

import java.util.List;

public interface CourseDAOInter {
//    // 增加
//    void add(Course course) throws Exception;
//
//    // 修改
//    void update(Course course) throws Exception;
//
//    // 删除
//    void delete(int courseId) throws Exception;
//
//    // 按ID查询
//    Course queryById(int courseId) throws Exception;
//
//    List queryByName(String courseName) throws Exception;

    // 查询全部
    List queryAll() throws Exception;

    int addCourse(Course course) throws Exception;

    int updateCourse(Course course) throws Exception;

    int deleteCourse(int courseId) throws Exception;

    Course queryById(int courseId) throws Exception;

//    int getTotalCount() throws Exception;
}
