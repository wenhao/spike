package com.github.wenhao.article.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.github.wenhao.comment.repository.CommentRepository;
import com.github.wenhao.profile.repository.ProfileRepository;
import com.github.wenhao.article.type.Article;
import com.github.wenhao.comment.type.Comment;
import com.github.wenhao.profile.type.Profile;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArticleResolver implements GraphQLResolver<Article> {
    private ProfileRepository profileRepository;
    private CommentRepository commentRepository;

    public Profile getAuthor(Article article) {
        return profileRepository.findById(article.getAuthorId()).get();
    }

    public List<Comment> getComments(Article article) {
        return commentRepository.findByArticleId(article.getId());
    }
}
