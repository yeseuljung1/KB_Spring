package org.scoula.ex03.controller;

import lombok.extern.log4j.Log4j;
import org.scoula.dto.SampleDTO;
import org.scoula.dto.SampleDTOList;
import org.scoula.dto.TodoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.http.HttpHeaders;
import java.util.ArrayList;

@Controller //bean 등록 +Controller명시
@RequestMapping("/sample") // 해당 클래스에 있는 메소드는 해당 url로 매핑하겠다
@Log4j


public class SampleController {
//    http://localhost:8080/sample
    @RequestMapping("")       // url : /sample
    public void basic() {
        log.info("basic............");
    }
    
//    GET 과 POST 두개 다 모두 처리하는 메소드
//    http://localhost:8080/sample/basic
    @RequestMapping(value="/basic", method= {RequestMethod.GET, RequestMethod.POST}) // url: /sample/basic
    public void basicGet(){
        log.info("basic GET............");
    }
    
//   RequestMapping 와 GET 요청을 합친 어노테이션, GET요청만 처리가능
//    http://localhost:8080/sample/basicOnlyGet
    @GetMapping("/basicOnlyGet") // url: /sample/basicOnlyGet
    public void basicGet2(){
        log.info("basic get only get............");
    }

    //    http://localhost:8080/sample/ex01
    @GetMapping("/ex01")
    public String ex01(SampleDTO dto) {
//        넣어준 값이 없을경우 초기값으로 나온다
        log.info("" + dto);
        return "ex01"; //뷰의 이름 반환
    }

//   RequestParam 은 DTO 객체를 안쓰고 각각 파라미터를 받아줄때 사용
//    필드 두개 다 제대로 안넣어주면 예외발생, 개별 파라미터는 뷰로 전달 불가능
    @GetMapping("/ex02")
    public String ex02(
            @RequestParam("name") String name,
            @RequestParam("age") int age) {
        log.info("name: " + name);
        log.info("age: " + age);
        return "ex02";
    }

//    같은이름으로 여러번 전달하는 경우 List나 배열로 받아올 수 있다
//    http://localhost:8080/sample/ex02List
    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
        log.info("ids: " + ids);
        return "ex02List";
    }

    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTOList list) {
        log.info("list dtos: " + list);
        return "ex02Bean";
    }

    @GetMapping("/ex03")
    public String ex03(TodoDTO todo) {
        log.info("todo: " + todo);
        return "ex03";
    }

//    http://localhost:8080/sample/ex04?name=aaa&age=11&page=9
@GetMapping("/ex04")
public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
    log.info("dto: " + dto);
    log.info("page: " + page);
    return "sample/ex04";
}

    @GetMapping("/ex05")
    public void ex05() {
        log.info("/ex05........");
    }

    @GetMapping("/ex06")
//    http://localhost:8080/sample/ex06-2?name=AAA&age=10 로 리다이렉트함
//    리다이렉트 시 요청 파라미터로 name과 age를 추가해준다
    public String ex06(RedirectAttributes ra) {
        log.info("/ex06........");
        ra.addAttribute("name", "AAA");
        ra.addAttribute("age", 10);
        return "redirect:/sample/ex06-2";
    }
//    http://localhost:8080/sample/ex07
//    ResponseBody 어노테이션은 반환된 객체가 json 형식으로 변환되어 보여지도록 한다
    @GetMapping("/ex07")
    public
    @ResponseBody SampleDTO ex07() {
        log.info("/ex07........");
        SampleDTO dto = new SampleDTO();
        dto.setAge(10);
        dto.setName("홍길동");
        return dto;
    }
//http://localhost:8080/sample/ex08
    @GetMapping("/ex08")
    public ResponseEntity<String> ex08() {
        log.info("/ex08..........");
// {"name": "홍길동"}
        String msg = "{\"name\": \"홍길동\"}";
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "application/json;charset=UTF-8");
        return new ResponseEntity<>(msg, header, HttpStatus.OK);
    }

    @GetMapping("/exUpload")
    public void exUpload() {
        log.info("/exUpload..........");
    }

    @PostMapping("/exUploadPost")
    public void exUploadPost(ArrayList<MultipartFile> files) {
        for (MultipartFile file : files) {
            log.info("----------------------------------");
            log.info("name:" + file.getOriginalFilename());
            log.info("size:" + file.getSize());
        }
    }
 }







