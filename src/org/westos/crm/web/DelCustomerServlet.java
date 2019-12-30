package org.westos.crm.web;

import org.westos.crm.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: ShenMouMou
 * @CreateTime: 2019-12-27 14:40
 * @Company:西部开源教育科技有限公司
 * @Description:爱生活，爱Java!
 */
@WebServlet(name = "DelCustomerServlet",value="/delCustomer")
public class DelCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //获取客户的cid
            String cid = request.getParameter("cid");
            //System.out.println(cid);
            boolean b=new CustomerService().delCustomer(cid);
            if (b) {
                request.getRequestDispatcher("/findall").forward(request, response);
            } else {
                request.setAttribute("msg", "删除失败");
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
