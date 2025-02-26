package com.example.osj_test_backend.board;

import com.example.osj_test_backend.board.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    public void register(BoardDto.BoardRegister dto) {
        Board board = boardRepository.save(dto.toEntity());
    }

    public void registerComment(CommentDto.CommentRegister dto) {
        Board board = boardRepository.findById(dto.getBoardId()).orElse(null);
        Comment comment = commentRepository.save(dto.toEntity(board));
    }

    public List<BoardDto.BoardListRes> list() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardDto.BoardListRes> responseList = new ArrayList<>();
        for (Board board : boardList) {
            List<Comment> commentList = board.getCommentList();
            int commentNum = commentList.size();
            responseList.add(BoardDto.BoardListRes.from(board, commentNum));
        }
        return responseList;

    }

    public BoardDto.BoardRes read(Long boardIdx) {
        Board board = boardRepository.findById(boardIdx).orElseThrow();
        List<Comment> commentList = board.getCommentList();
        BoardDto.BoardRes response = BoardDto.BoardRes.from(board, commentList);

        return response;
    }

}
