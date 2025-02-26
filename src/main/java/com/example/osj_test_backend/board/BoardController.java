package com.example.osj_test_backend.board;

import com.example.osj_test_backend.board.model.BoardDto;
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
        return "결제 등록 완료";
    }

    @GetMapping("/list")
    public ResponseEntity<List<BoardDto.BoardResponse>> list() {
        List<BoardDto.BoardResponse> response = boardService.list();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{boardIdx}")
    public ResponseEntity<BoardDto.BoardResponse> read(@PathVariable Long boardIdx) {
        BoardDto.BoardResponse response = boardService.read(boardIdx);
        return ResponseEntity.ok(response);
    }

}