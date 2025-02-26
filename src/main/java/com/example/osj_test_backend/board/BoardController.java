package com.example.osj_test_backend.board;

import com.example.osj_test_backend.board.model.Board;
import com.example.osj_test_backend.board.model.BoardDto;
import com.example.osj_test_backend.board.model.CommentDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @Operation(summary = "게시글 등록", description = "게시글을 등록하는 기능입니다")
    @PostMapping("/register")
    public String register(@RequestBody BoardDto.BoardRegister dto) {
        boardService.register(dto);
        return "게시글 등록 완료";
    }

    @Operation(summary = "답변 등록", description = "답변을 등록하는 기능입니다")
    @PostMapping("/comment")
    public String registerComment (@RequestBody CommentDto.CommentRegister dto) {
        boardService.registerComment(dto);
        return "답변 등록 완료";
    }

    @Operation(summary = "게시글 목록 확인", description = "게시글 목록을 확인하는 기능입니다")
    @GetMapping("/list")
    public ResponseEntity<List<BoardDto.BoardListRes>> list() {
        List<BoardDto.BoardListRes> response = boardService.list();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "게시글 상세 보기", description = "한 게시물의 내용, 답글 등을 보는 기능입니다")
    @GetMapping("/{boardIdx}")
    public ResponseEntity<BoardDto.BoardRes> read(@PathVariable Long boardIdx) {
        BoardDto.BoardRes response = boardService.read(boardIdx);
        return ResponseEntity.ok(response);
    }

}