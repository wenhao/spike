package com.github.wenhao.article.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateArticleInput {
    private Long id;
    private String title;
    private String text;
}
