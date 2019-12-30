package org.westos.crm.domain;

public class User {
    private String uid;
    private String username;
    private String password;

    public User() {
    }

    public User(String uid, String username, String password) {
        this.uid = uid;
        this.username = username;
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public boolean checkUsernameAndPassword(){
        if(!(username!=null&&username.matches("[a-zA-Z]{6,12}"))){
            return false;

        }

        if(!(password!=null&&password.matches("[0-9]{6,12}"))){
            return false;

        }

        return true;
    }
}

/*
* MVC：
* model
* view
* controller
* 三层架构:
* web层  Servlet JSP
* service层  组装业务逻辑
* dao 持久层 对数据库进行操作，以及封装数据模型
* 注解：会用
*注册：Ajax JS 异步请求，局部刷新
*
* */