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

@WebServlet(name = "FuzzyQueryServlet",value = "/queryall")
public class FuzzyQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            String customername = request.getParameter("customername");
            System.out.println(customername);
            String phonenumber = request.getParameter("phonenumber");
            System.out.println(phonenumber);
            List<Customer> list =new CustomerService().queryCustomer(customername,phonenumber);
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
