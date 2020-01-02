package com.chinasoft.springboot.controller;

import com.chinasoft.springboot.dao.UserDao;
import com.chinasoft.springboot.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class SignInController {

    @Autowired
    private UserDao userDao;

    @PostMapping("/signIn")
    public String signIn(@RequestParam("username")String username , @RequestParam("password")String password
            , Model model, HttpSession httpSession){
        User user = userDao.findByUserName(username);
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)){
            if (username.equals(user.getUserName()) && password.equals(user.getPassWord())){
                httpSession.setAttribute("loginUser",username);
                return "redirect:/dashboard";
            }
        }
        model.addAttribute("msg","用户名或密码错误");
        return "/login";
    }
}
