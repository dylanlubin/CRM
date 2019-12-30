package org.westos.crm.service;

import org.westos.crm.dao.CustomerDao;
import org.westos.crm.domain.Customer;
import org.westos.crm.utils.UUIDUtils;

import java.util.List;


public class CustomerService {
    public List<Customer> findAll() throws Exception {
       List<Customer> customerList= new CustomerDao().findAllCustomer();
       return customerList;
    }

    public boolean addCustomer(Customer customer) throws Exception {
        customer.setCid(UUIDUtils.getUUID());
       boolean b= new CustomerDao().addCustomer(customer);
       return b;
    }

    public boolean delCustomer(String cid) throws Exception {
        boolean b = new CustomerDao().delCustomer(cid);
        return b;
    }

    public boolean delMoreCustomer(String[] item_checkboxes) throws Exception {
       boolean b= new CustomerDao().delAllCustomer(item_checkboxes);
       return b;
    }

    public Customer preparedupdateCustomer(String cid) throws Exception {
        Customer customer =new CustomerDao().preparedupdateCustomerInfo(cid);
        return customer;
    }

    public boolean updateCustomer(Customer upcustomer,String ccid) throws Exception {
        boolean b=new CustomerDao().updateCustomerInfo(upcustomer,ccid);
        return  b;
    }

    public List<Customer> queryCustomer(String customername, String phonenumber) throws Exception {
        List<Customer> list =new CustomerDao().queryAllCustomer(customername,phonenumber);
        return list;
    }
}
