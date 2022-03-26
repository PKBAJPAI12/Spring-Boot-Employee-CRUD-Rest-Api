package com.example.spring1.Controller;


             import org.springframework.beans.factory.annotation.Autowired;
             import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//    @CrossOrigin(origins = "http://localhost:3000")
    @RestController
    @RequestMapping("/api/")
    public class UserController {
//        @Autowired
//        private UserRepository userRepository;

    @GetMapping("user1")
    public String getUsers() {
        return "Prateek";
    }

    @GetMapping("user2")
    public String getUsers1() {
        return "Tarun";
    }
}


