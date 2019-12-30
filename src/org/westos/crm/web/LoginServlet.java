package org.westos.crm.web;

import org.apache.commons.beanutils.BeanUtils;
import org.westos.crm.domain.User;
import org.westos.crm.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Author: ShenMouMou
 * @CreateTime: 2019-12-27 10:58
 * @Company:西部开源教育科技有限公司
 * @Description:爱生活，爱Java!
 */
@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            Map<String, String[]> parameterMap = request.getParameterMap();
            User user = new User();
            BeanUtils.populate(user,parameterMap);

            //调用业务层
           User newUser=new UserService().login(user);
           if(newUser!=null){
               //还得判断用户是否记住了密码
               String rember = request.getParameter("rember");
               if(rember!=null){
                   Cookie ucookie= new Cookie("username", user.getUsername());
                   Cookie pcookie = new Cookie("password", user.getPassword());
                   ucookie.setMaxAge(60*60*24*Integer.parseInt(rember));
                   pcookie.setMaxAge(60 * 60 * 24 * Integer.parseInt(rember));
                   response.addCookie(ucookie);
                   response.addCookie(pcookie);
               }
               //跳转到主页
               request.setAttribute("user",newUser);
               request.getRequestDispatcher("/main.jsp").forward(request,response);

           }else{
               request.setAttribute("msg","用户名或密码错误");
               request.getRequestDispatcher("/login.jsp").forward(request, response);
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
