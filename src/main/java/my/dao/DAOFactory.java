package my.dao;

import my.dao.impl.*;
import my.dao.inter.StudentDAOInter;
import my.dao.inter.UserDAOInter;

public class DAOFactory {
    public static UserDAOInter getUserDAOInstance() {
        return new UserDAOImpl();
    }

    public static StudentDAOInter getStudentDAOInstance() {
        return new StudentDAOImpl();
    }
}
