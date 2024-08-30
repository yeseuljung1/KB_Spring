package org.scoula.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//자바빈으로 등록됨
@Controller
//Lombok제공, log()라는 멤버 변수가 생긴다
@Slf4j

public class HomeController
{
    @GetMapping("/")
    public String home(Model model) {
//        키와 value 쌍으로 model에 저장
//        request scope에 저장되며 , 뷰에서 사용 가능
        model.addAttribute("name", "홍길동");
        return "index"; // View의 이름
    }
}

