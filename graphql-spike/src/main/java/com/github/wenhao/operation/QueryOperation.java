package com.github.wenhao.operation;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.github.wenhao.article.type.Article;
import com.github.wenhao.comment.type.Comment;
import com.github.wenhao.profile.type.Profile;
import com.github.wenhao.article.repository.ArticleRepository;
import com.github.wenhao.comment.repository.CommentRepository;
import com.github.wenhao.profile.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QueryOperation implements GraphQLQueryResolver {
    private ArticleRepository articleRepository;
    private ProfileRepository profileRepository;
    private CommentRepository commentRepository;

    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    public List<Profile> getProfiles() {
        return profileRepository.findAll();
    }

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    public Article getArticle(Long id) {
        return articleRepository.findById(id).get();
    }
}
