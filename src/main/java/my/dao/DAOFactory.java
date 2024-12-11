package my.dao;

import my.dao.impl.*;
import my.dao.inter.CourseDAOInter;
import my.dao.inter.StudentDAOInter;
import my.dao.inter.UserDAOInter;

public class DAOFactory {
    public static UserDAOInter getUserDAOInstance() {
        return new UserDAOImpl();
    }

    public static StudentDAOInter getStudentDAOInstance() {
        return new StudentDAOImpl();
    }

    public static CourseDAOInter getCourseDAOInstance() {
        return new CourseDAOImpl();
    }
    // TODO 重构代码调用DAOFactory生成CourseDAO
}
