package com.example.osj_test_backend.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class CommentDto {
    @Getter
    public static class CommentRegister {
        private Long boardId;
        private String content;
        private String writer;
        public Comment toEntity(Board board) {
            return Comment.builder()
                    .content(content)
                    .writer(writer)
                    .board(board)
                    .build();
        }
    }

    @Getter
    @Builder
    public static class CommentRes {
        private Long idx;
        private String content;
        private String writer;

        public static CommentRes from(Comment comment) {
            return CommentRes.builder()
                    .idx(comment.getIdx())
                    .content(comment.getContent())
                    .writer(comment.getWriter())
                    .build();
        }
    }


}
