package com.github.wenhao.article.repository;

import com.github.wenhao.article.type.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
