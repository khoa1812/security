//package com.codegym.controller;
//
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.security.Principal;
//
//@Controller
//public class UserController {
//    @GetMapping("/")
//    public ModelAndView index() {
//        return new ModelAndView("/index");
//    }
//
//    @GetMapping("/user")
//    public ModelAndView user(Principal principal) {
//        System.out.println(principal.getName());
//        return new ModelAndView("/user");
//    }
//
//    @GetMapping("/admin")
//    public ModelAndView admin() {
//        SecurityContext context = SecurityContextHolder.getContext();
//        System.out.println(context.getAuthentication().getName());
//        return new ModelAndView("/admin");
//    }
//}

package com.codegym.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class UserController {
    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/user")
    public ModelAndView user(Principal principal) {
        // Get authenticated username from Principal
        System.out.println(principal.getName());
        return new ModelAndView("user");
    }

    @GetMapping("/admin")
    public ModelAndView admin() {
        // Get authenticated username from SecurityContext
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println(context.getAuthentication().getName());
        return new ModelAndView("admin");
    }

    @GetMapping("/dangnhap")
    public ModelAndView login() {
        return new ModelAndView("dangnhap");
    }

    @GetMapping("/dangnhap-error")
    public ModelAndView loginError() {
        ModelAndView modelAndView = new ModelAndView("dangnhap");
        modelAndView.addObject("error", "true");
        return modelAndView;
    }
}
