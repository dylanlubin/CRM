package org.westos.crm.web;

import org.apache.commons.beanutils.BeanUtils;
import org.westos.crm.domain.User;
import org.westos.crm.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Map;

/**
 * @Author: ShenMouMou
 * @CreateTime: 2019-12-27 09:54
 * @Company:西部开源教育科技有限公司
 * @Description:爱生活，爱Java!
 */
@WebServlet(name = "RegisiterServlet",value = "/register")
public class RegisiterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //处理乱码
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            //获取用户提交的请求参数
            Map<String, String[]> parameterMap = request.getParameterMap();
            User user = new User();
            //使用BeanUtils工具类，把请求参数直接封装进user对象
            BeanUtils.populate(user, parameterMap);
            //二次校验
            boolean b = user.checkUsernameAndPassword();
            if(b){
                //校验验证码
                //用户输入的验证码
                String usercheckcode = request.getParameter("usercheckcode");
                //后台生成的验证码
               String serverCode= (String) request.getSession().getAttribute("servercheckcode");
               //从会话域中清除验证码
                request.getSession().removeAttribute("servercheckcode");
               if(serverCode.equalsIgnoreCase(usercheckcode)){
                   //调用业务层去注册
                  boolean flag= new UserService().registerUser(user);
                  if(flag){
                      //注册成功跳转到登录页面
                      request.getRequestDispatcher("/login.jsp").forward(request,response);
                  }else{
                      request.getRequestDispatcher("/register.jsp").forward(request, response);
                  }
               }else{
                   request.setAttribute("msg","验证码不正确请重新输入");
                   request.getRequestDispatcher("/register.jsp").forward(request,response);
               }
            }else{
                response.getWriter().write("<h1 style='color:red'>呵呵！哥们有经验</h1>");
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
