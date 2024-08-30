package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController 
@RequestMapping("/api/board") //메소드들의 공통 url
@RequiredArgsConstructor //final이 붙은 필드로 생성자 만들어줌
@Slf4j //로깅을 위한 어노테이션
public class BoardController {
    private final BoardService service;

    @GetMapping("")
//    http://localhost:8080/api/board
    public ResponseEntity<List<BoardDTO>> getList() {
        //상태 코드가 200이고 body 타입이 list 인 응답 객체를 리턴
        return ResponseEntity.ok(service.getList());
    }
//    http://localhost:8080/api/board/9
    @GetMapping("/{no}")
    public ResponseEntity<BoardDTO> get(@PathVariable Long no) {
        return ResponseEntity.ok(service.get(no));
    }
    @PostMapping("")
    public ResponseEntity<BoardDTO> create(@RequestBody BoardDTO board) {
        return ResponseEntity.ok(service.create(board));
    }
    //    http://localhost:8080/api/board/9
    //기존 게시글 수정
    @PutMapping("/{no}")
    public ResponseEntity<BoardDTO> update(@PathVariable Long no, @RequestBody BoardDTO board) {
        return ResponseEntity.ok(service.update(board));
    }
//    http://localhost:8080/api/board/9
//    기존 게시글 삭제
    @DeleteMapping("/{no}")
    public ResponseEntity<BoardDTO> delete(@PathVariable Long no) {
        return ResponseEntity.ok(service.delete(no));
    }
}
