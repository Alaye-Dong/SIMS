package my.dao;

import my.vo.User;

public interface UserDAO{
    // 增加操作
    void insert(User user) throws Exception ;
    boolean check(User user) throws Exception ;
    // 修改操作
//    void update(User user) throws Exception ;
//    // 删除操作
//    void delete(int userid) throws Exception ;
//    // 按ID查询操作
//    User queryById(int userid) throws Exception ;
//    // 查询全部
//    List queryAll() throws Exception ;
}
