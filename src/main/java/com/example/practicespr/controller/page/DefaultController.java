package com.example.practicespr.controller.page;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
@Controller
public class DefaultController {

    @GetMapping("/index")
    public String index() {
        System.out.println("index 페이지에 접근합니다.");

        return "index";
    }

    // Controller 에서는 오직 String 만 반환한다.(view name 을 반환)
}
