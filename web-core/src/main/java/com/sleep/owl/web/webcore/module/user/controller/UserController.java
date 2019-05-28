package com.sleep.owl.web.webcore.module.user.controller;

import com.sleep.owl.web.webcore.base.BaseController;
import com.sleep.owl.web.webcore.module.user.model.User;
import com.sleep.owl.web.webcore.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("passage")
    public String passage() {
        return "templete :: listTemp";
    }

    @GetMapping("module")
    public String module() {
        return "templete :: module-element";
    }

    @GetMapping("findAll")
    @ResponseBody
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping
    public String page() {
      /*  User user = new User();
        user.setCode("1000");
        user.setName("whwhwh");
        userService.save(user);*/
        return "index";
    }

}
