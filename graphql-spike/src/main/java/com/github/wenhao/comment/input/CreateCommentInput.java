package com.github.wenhao.comment.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommentInput {
    private String text;
    private Long authorId;
    private Long articleId;
}
