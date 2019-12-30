package org.westos.crm.web;

import org.westos.crm.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author: ShenMouMou
 * @CreateTime: 2019-12-27 09:29
 * @Company:西部开源教育科技有限公司
 * @Description:爱生活，爱Java!
 */
@WebServlet(name = "CheckUsernameServlet",value = "/checkusername")
public class CheckUsernameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Ajax请求来了");
        //获取用户提交上来的用户名
        String username = request.getParameter("username");
        System.out.println(username);
        //调用业务层
        //调用到查询用户名是否存在
        //给前台响应
        boolean b = false;
        try {
            b = new UserDao().findUsername(username);
            System.out.println(b);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(b);
        if(b){
            response.getWriter().write("yes");
        }else{
            response.getWriter().write("no");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
