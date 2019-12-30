package org.westos.crm.dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.xml.internal.ws.api.pipe.ClientPipeAssemblerContext;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.westos.crm.domain.User;
import org.westos.crm.utils.MD5Utils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class UserDao {
    public boolean findUsername(String username) throws Exception {
        System.out.println("daodaodao");
        Properties properties = new Properties();
        InputStream in = UserDao.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(in);
        DataSource dataSource = new DruidDataSourceFactory().createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user where username=?");
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean b = !resultSet.next();
        return b;
    }

    public void registerUser(User user) throws Exception {
        Properties properties = new Properties();
        InputStream in = UserDao.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(in);
        DataSource dataSource = new DruidDataSourceFactory().createDataSource(properties);
        QueryRunner queryRunner = new QueryRunner(dataSource);
        queryRunner.update("insert into user values(?,?,?)", user.getUid(), user.getUsername(), MD5Utils.getMD5(user.getPassword()));

    }

    public User login(User user) throws Exception {
        Properties properties = new Properties();
        InputStream in = UserDao.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(in);
        DataSource dataSource = new DruidDataSourceFactory().createDataSource(properties);
        QueryRunner queryRunner = new QueryRunner(dataSource);
        User user1 = queryRunner.query("select * from user where username=? and password=?", new BeanHandler<User>(User.class), user.getUsername(), MD5Utils.getMD5(user.getPassword()));

        return user1;
    }
}
