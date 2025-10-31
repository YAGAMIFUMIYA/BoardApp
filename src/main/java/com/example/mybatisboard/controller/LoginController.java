//package com.example.mybatisboard.controller;
//
//import com.example.mybatisboard.model.User;
//import com.example.mybatisboard.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.ui.Model;
//
//@Controller
//public class LoginController {
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/login")
//    public String showLoginForm() {
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestParam String username,
//                        @RequestParam String password,
//                        Model model) {
//        User user = userService.findByUsername(username);
//        if(user != null && user.getPassword().equals(password)) {
//            return "redirect:/";
//        } else {
//            model.addAttribute("error", "ユーザー名またはパスワードが違います");
//            return "login";
//        }
//    }
//}package com.example.mybatisboard.controller;
//
//import com.example.mybatisboard.model.User;
//import com.example.mybatisboard.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.ui.Model;
//
//@Controller
//public class LoginController {
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/login")
//    public String showLoginForm() {
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestParam String username,
//                        @RequestParam String password,
//                        Model model) {
//        User user = userService.findByUsername(username);
//        if(user != null && user.getPassword().equals(password)) {
//            return "redirect:/";
//        } else {
//            model.addAttribute("error", "ユーザー名またはパスワードが違います");
//            return "login";
//        }
//    }
//}