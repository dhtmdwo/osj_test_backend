package com.example.osj_test_backend.board;

import com.example.osj_test_backend.board.model.Board;
import com.example.osj_test_backend.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    public void register(BoardDto.BoardRegister dto) {
        Board board = boardRepository.save(dto.toEntity());
    }

    public List<BoardDto.BoardResponse> list() {
        List<Board> boardList = boardRepository.findAll();
        return boardList.stream().map(BoardDto.BoardResponse::from).collect(Collectors.toList());
    }

    public BoardDto.BoardResponse read(Long boardIdx) {
        Board board = boardRepository.findById(boardIdx).orElseThrow();
        return BoardDto.BoardResponse.from(board);
    }

}
