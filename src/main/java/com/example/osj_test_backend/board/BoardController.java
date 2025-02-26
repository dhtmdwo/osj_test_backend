package com.example.osj_test_backend.board;

import com.example.osj_test_backend.board.model.Board;
import com.example.osj_test_backend.board.model.BoardDto;
import com.example.osj_test_backend.board.model.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    @PostMapping("/register")
    public String register(@RequestBody BoardDto.BoardRegister dto) {
        boardService.register(dto);
        return "게시글 등록 완료";
    }

    @PostMapping("/comment")
    public String registerComment (@RequestBody CommentDto.CommentRegister dto) {
        boardService.registerComment(dto);
        return "답변 등록 완료";
    }

    @GetMapping("/list")
    public ResponseEntity<List<BoardDto.BoardListRes>> list() {
        List<BoardDto.BoardListRes> response = boardService.list();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{boardIdx}")
    public ResponseEntity<BoardDto.BoardRes> read(@PathVariable Long boardIdx) {
        BoardDto.BoardRes response = boardService.read(boardIdx);
        return ResponseEntity.ok(response);
    }

}