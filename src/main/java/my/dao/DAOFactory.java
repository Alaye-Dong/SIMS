package my.dao;

import my.dao.impl.*;

public class DAOFactory{
    public static UserDAO getUserDAOInstance(){
        return new UserDAOImpl() ;
    }

    public static StudentDAO getStudentDAOInstance(){
        return new StudentDAOImpl() ;
    }
}
