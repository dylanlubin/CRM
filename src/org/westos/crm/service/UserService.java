package org.westos.crm.service;

import org.westos.crm.dao.UserDao;
import org.westos.crm.domain.User;
import org.westos.crm.utils.UUIDUtils;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;


public class UserService {
    //注册用户
    public boolean registerUser(User user) throws Exception {
        user.setUid(UUIDUtils.getUUID());
        //调用dao来注册
        UserDao dao = new UserDao();
        boolean b = dao.findUsername(user.getUsername());
        if (b) {
            dao.registerUser(user);
        }
        return b;
    }
    public User login(User user) throws Exception {
        //调用dao
        User user1 = new UserDao().login(user);
        return user1;
    }
}
