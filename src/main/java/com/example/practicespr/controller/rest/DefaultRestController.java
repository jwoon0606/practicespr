package com.example.practicespr.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class DefaultRestController {

    @GetMapping("/index")
    public int index() {
        return 1+1;
    }

    // @RestController 는 @Controller 와 @ResponseBody 합친 것이다.
    // rest controller 에서는 String 외의 타입도 반환할 수 있다.
}
