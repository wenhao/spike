package com.github.wenhao.article.mapper;

import com.github.wenhao.article.input.CreateArticleInput;
import com.github.wenhao.article.input.UpdateArticleInput;
import com.github.wenhao.article.type.Article;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface ArticleMapper  {

    Article createArticleInputToArticle(CreateArticleInput input);

    Article updateArticleInputToArticle(UpdateArticleInput input);
}
