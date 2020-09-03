package com.nvc.bookshop.pojo;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class User {

    private Integer id;
    @Pattern(regexp = "^[a-z0-9_-]{3,16}$|^[\\u2E80-\\u9FFF]{3,16}$",message = "用户名长度只能3~16")
    private String username;
    @Pattern(regexp = "^[a-z0-9_-]{6,18}$",message = "密码不合法，需要6~18位数字和字母的组合")
    private String password;
    @Email(message = "非法的邮箱")
    private String email;
    @Pattern(regexp = "^1([3456789])\\d{9}$",message = "非法的手机号")
    private String phone;
    private String company;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
