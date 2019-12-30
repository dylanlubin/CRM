package org.westos.crm.web;

import org.westos.crm.domain.Customer;
import org.westos.crm.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: ShenMouMou
 * @CreateTime: 2019-12-27 14:00
 * @Company:西部开源教育科技有限公司
 * @Description:爱生活，爱Java!
 */
@WebServlet(name = "FindAllCustomerServlet",value = "/findall")
public class FindAllCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=utf-8");
            //查询所有客户
            // 调用service
            List<Customer> list= new CustomerService().findAll();
            if(list.size()>0){
                //调到content.jsp
                request.setAttribute("list", list);
                request.getRequestDispatcher("/content.jsp").forward(request, response);
            }else{
                request.setAttribute("msg", "没有查询到任何客户");
                request.getRequestDispatcher("/content.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
