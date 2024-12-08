package my.dao;

import my.dao.impl.UserDAOImpl;

public class DAOFactory{
    public static UserDAO getUserDAOInstance(){
        return new UserDAOImpl() ;
    }
}
