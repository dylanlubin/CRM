package org.westos.crm.web;

import org.apache.commons.beanutils.BeanUtils;
import org.westos.crm.domain.Customer;
import org.westos.crm.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "UpdateServlet", value = "/updateCustomer")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String ccid=null;
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            Map<String, String[]> updateMap = request.getParameterMap();
            System.out.println(updateMap.toString());
            Customer upcustomer = new Customer();
            //把表中的数据封装进JavaBean
            BeanUtils.populate(upcustomer, updateMap);
            //取出用户编号
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("ccid")) {
                        ccid = cookie.getValue();
                    }
                }
            }
            //调用业务层
            boolean b = new CustomerService().updateCustomer(upcustomer,ccid);
            if (b) {
                request.getRequestDispatcher("/findall").forward(request, response);
            } else {
                request.setAttribute("msg", "修改失败");
                request.getRequestDispatcher("/update.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
