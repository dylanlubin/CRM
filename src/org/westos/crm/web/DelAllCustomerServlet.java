package org.westos.crm.web;

import org.westos.crm.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @Author: ShenMouMou
 * @CreateTime: 2019-12-27 15:35
 * @Company:西部开源教育科技有限公司
 * @Description:爱生活，爱Java!
 */
@WebServlet(name = "DelAllCustomerServlet",value = "/delall")
public class DelAllCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //删除多条客户
        String[] item_checkboxes = request.getParameterValues("item_checkbox");
        //调用service
        boolean b= false;
        try {
            b = new CustomerService().delMoreCustomer(item_checkboxes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (b) {
            request.getRequestDispatcher("/findall").forward(request, response);
        } else {
            request.setAttribute("msg", "删除失败");
            request.getRequestDispatcher("/content.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
