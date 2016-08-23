package com.doshare.share.mvp.models;

/**
 * Created by vaitt on 16/8/22.<br/>
 * To: vaitt_joy@163.com
 * 用户信息
 */
public class User {
    private String userName;//用户名
    private String password;
    private String email;//邮箱
    private String sessionToken;// 服务器token令牌
    private int age;//年龄
    private String sex;//性别

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", sessionToken='" + sessionToken + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
