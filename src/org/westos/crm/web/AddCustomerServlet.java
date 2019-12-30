package org.westos.crm.web;

import org.apache.commons.beanutils.BeanUtils;
import org.westos.crm.domain.Customer;
import org.westos.crm.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Author: ShenMouMou
 * @CreateTime: 2019-12-27 14:25
 * @Company:西部开源教育科技有限公司
 * @Description:爱生活，爱Java!
 */
@WebServlet(name = "AddCustomerServlet",value = "/add")
public class AddCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            Map<String, String[]> parameterMap = request.getParameterMap();
            Customer customer = new Customer();
            //把表中的数据封装进JavaBean
            BeanUtils.populate(customer,parameterMap);
            //调用业务层
           boolean b= new CustomerService().addCustomer(customer);
           if(b){
               request.getRequestDispatcher("/findall").forward(request,response);
           }else{
               request.setAttribute("msg","添加失败");
               request.getRequestDispatcher("/addCustomer.jsp").forward(request, response);
           }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
