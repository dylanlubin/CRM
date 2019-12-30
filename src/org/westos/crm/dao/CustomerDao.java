package org.westos.crm.dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.westos.crm.domain.Customer;
import org.westos.crm.domain.User;
import org.westos.crm.utils.MD5Utils;
import org.westos.crm.utils.UUIDUtils;

import javax.servlet.http.Cookie;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Properties;


public class CustomerDao {
    public List<Customer> findAllCustomer() throws Exception {
        //查询数据库
        Properties properties = new Properties();
        InputStream in = UserDao.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(in);
        DataSource dataSource = new DruidDataSourceFactory().createDataSource(properties);
        QueryRunner queryRunner = new QueryRunner(dataSource);
        List<Customer> list = queryRunner.query("select * from customer", new BeanListHandler<Customer>(Customer.class));
        return list;
    }

    public boolean addCustomer(Customer customer) throws Exception {
        //查询数据库
        Properties properties = new Properties();
        InputStream in = UserDao.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(in);
        DataSource dataSource = new DruidDataSourceFactory().createDataSource(properties);
        QueryRunner queryRunner = new QueryRunner(dataSource);
        int i = queryRunner.update("insert into customer values(?,?,?,?,?,?,?)", customer.getCid(), customer.getCname(), customer.getAge(), customer.getGender(), customer.getEmail(), customer.getTelephone(), customer.getDescription());
        return i>0;
    }

    public boolean delCustomer(String cid) throws Exception {
        Properties properties = new Properties();
        InputStream in = UserDao.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(in);
        DataSource dataSource = new DruidDataSourceFactory().createDataSource(properties);
        QueryRunner queryRunner = new QueryRunner(dataSource);
        int i = queryRunner.update("delete from customer where cid=?", cid);
        return i>0;
    }

    public boolean delAllCustomer(String[] item_checkboxes) throws Exception {

        Properties properties = new Properties();
        InputStream in = UserDao.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(in);
        DataSource dataSource = new DruidDataSourceFactory().createDataSource(properties);
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from customer where cid=?");
        for (String cid : item_checkboxes) {
            preparedStatement.setString(1,cid);
            preparedStatement.addBatch();
        }
        int[] ints = preparedStatement.executeBatch();
        preparedStatement.clearBatch();
        return ints.length>0;
    }

    public Customer preparedupdateCustomerInfo(String cid) throws Exception{

        Properties properties = new Properties();
        InputStream in = UserDao.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(in);
        DataSource dataSource = new DruidDataSourceFactory().createDataSource(properties);
        QueryRunner queryRunner = new QueryRunner(dataSource);

        Customer customer = queryRunner.query("select * from customer where cid=? ", new BeanHandler<Customer>(Customer.class),cid);
        System.out.println(customer.getCname());

        return customer;

    }

    public boolean updateCustomerInfo(Customer upcustomer,String ccid) throws Exception {

        Properties properties = new Properties();
        InputStream in = UserDao.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(in);
        DataSource dataSource = new DruidDataSourceFactory().createDataSource(properties);
        QueryRunner queryRunner = new QueryRunner(dataSource);
        int i = queryRunner.update("update customer set cname=?,age=?,gender=?,email=?,telephone=?,description=? where cid=?", upcustomer.getCname(), upcustomer.getAge(), upcustomer.getGender(), upcustomer.getEmail(), upcustomer.getTelephone(), upcustomer.getDescription(),ccid);
        return i>0;

    }

    public List<Customer> queryAllCustomer(String customername, String phonenumber) throws Exception {
        Properties properties = new Properties();
        InputStream in = UserDao.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(in);
        DataSource dataSource = new DruidDataSourceFactory().createDataSource(properties);
        QueryRunner queryRunner = new QueryRunner(dataSource);
        List<Customer> list = queryRunner.query("select * from customer where (cname like ?) and (telephone like ?)", new BeanListHandler<Customer>(Customer.class),'%'+customername+'%','%'+phonenumber+'%');
        return list;
    }
}
