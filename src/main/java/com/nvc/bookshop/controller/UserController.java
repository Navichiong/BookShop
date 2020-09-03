package com.nvc.bookshop.controller;

import com.nvc.bookshop.pojo.User;
import com.nvc.bookshop.service.UserService;
import com.nvc.bookshop.utils.ServerMessage;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public ServerMessage login(User user, boolean rememberMe) {

        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            try {
                UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
                subject.login(token);
                return ServerMessage.success();
            } catch (UnknownAccountException e) {

            }
        }
        return null;
    }

    @GetMapping("/checkUsername")
    @ResponseBody
    public ServerMessage checkUser(String username) {
        return userService.handleCheckUsername(username);
    }

    @PostMapping("/register")
    @ResponseBody
    public ServerMessage register(@Valid User user) {
        return userService.handleRegister(user);
    }

    @PostMapping("/login")
    @ResponseBody
    public ServerMessage login(User user, HttpSession session) {
        ServerMessage sm = userService.handleLogin(user);
        if (sm.getCode() == 100) {
            session.setAttribute("user", sm.getData().get("user"));
        }
        return sm;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/home/index";
    }
}
