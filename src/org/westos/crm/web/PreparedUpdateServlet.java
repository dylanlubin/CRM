package org.westos.crm.web;

import org.westos.crm.dao.UserDao;
import org.westos.crm.domain.Customer;
import org.westos.crm.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "PreparedUpdateServlet", value = "/preparedupdateCustomer")
public class PreparedUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String cid = request.getParameter("cid");
            Cookie ccookie= new Cookie("ccid", cid);
            ccookie.setMaxAge(60*60*24);
            response.addCookie(ccookie);
            Customer customer =new CustomerService().preparedupdateCustomer(cid);
            request.setAttribute("updatecustomer",customer);
            request.getRequestDispatcher("/update.jsp").forward(request,response);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
