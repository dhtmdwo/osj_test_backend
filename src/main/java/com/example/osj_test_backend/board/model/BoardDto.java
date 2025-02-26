package com.example.osj_test_backend.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class BoardDto {
    @Getter
    public static class BoardRegister {
        private String title;
        private String content;
        private String writer;
        public Board toEntity() {
            return Board.builder()
                    .title(title)
                    .content(content)
                    .writer(writer)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class BoardListRes {
        private String title;
        private String content;
        private String writer;
        private int commentNum;

        public static BoardListRes from(Board board, int commentNum) {
            return BoardListRes.builder()
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .commentNum(commentNum)
                    .build();
        }

    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class BoardRes {
        private String title;
        private String content;
        private String writer;
        private List<CommentDto.CommentRes> commentList;

        public static BoardRes from(Board board, List<Comment> commentList) {
            List<CommentDto.CommentRes> commentResList = new ArrayList<>();
            for (Comment comment : commentList) {
                commentResList.add(CommentDto.CommentRes.from(comment));
            }

            return BoardRes.builder()
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .commentList(commentResList)
                    .build();
        }

    }


}