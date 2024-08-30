package org.scoula.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//자바빈으로 등록됨
@Controller
//Lombok제공, log()라는 멤버 변수가 생긴다
@Slf4j

public class HomeController {
    @GetMapping("/")
    public String home() {
        log.info("================> HomController /");
        return "index"; // View의 이름
    }
}

