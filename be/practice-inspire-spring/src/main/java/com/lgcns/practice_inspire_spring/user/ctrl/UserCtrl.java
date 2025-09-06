package com.lgcns.practice_inspire_spring.user.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgcns.practice_inspire_spring.user.service.UserService;

@RestController
@RequestMapping("/api/v10/inspire/user")
public class UserCtrl {
    
    @Autowired
    UserService userService;

    

}
