package com.github.wenhao.operation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.github.wenhao.article.input.CreateArticleInput;
import com.github.wenhao.article.input.UpdateArticleInput;
import com.github.wenhao.article.exception.ArticleNotFoundException;
import com.github.wenhao.comment.input.CreateCommentInput;
import com.github.wenhao.profile.exception.ProfileNotFoundException;
import com.github.wenhao.article.mapper.ArticleMapper;
import com.github.wenhao.comment.mapper.CommentMapper;
import com.github.wenhao.profile.mapper.ProfileMapper;
import com.github.wenhao.article.repository.ArticleRepository;
import com.github.wenhao.profile.input.CreateProfileInput;
import com.github.wenhao.profile.input.UpdateProfileInput;
import com.github.wenhao.comment.repository.CommentRepository;
import com.github.wenhao.profile.repository.ProfileRepository;
import com.github.wenhao.article.type.Article;
import com.github.wenhao.comment.type.Comment;
import com.github.wenhao.profile.type.Profile;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class MutationOperation implements GraphQLMutationResolver {

    private ArticleRepository articleRepository;
    private ArticleMapper articleMapper;
    private ProfileMapper profileMapper;
    private ProfileRepository profileRepository;
    private CommentMapper commentMapper;
    private CommentRepository commentRepository;

    @Transactional
    public Article createArticle(CreateArticleInput input) {
        final Article article = articleMapper.createArticleInputToArticle(input);
        return articleRepository.save(article);
    }

    @Transactional
    public Article updateArticle(UpdateArticleInput input) {
        articleRepository.findById(input.getId()).orElseThrow(() -> ArticleNotFoundException.of(input.getId()));
        val article = articleMapper.updateArticleInputToArticle(input);
        return articleRepository.save(article);
    }

    @Transactional
    public int deleteArticle(Long id) {
        articleRepository.deleteById(id);
        return 1;
    }

    @Transactional
    public Profile createProfile(CreateProfileInput input) {
        val profile = profileMapper.createProfileInputToProfile(input);
        return profileRepository.save(profile);
    }

    @Transactional
    public Profile updateProfile(UpdateProfileInput input) {
        profileRepository.findById(input.getId()).orElseThrow(() -> ProfileNotFoundException.of(input.getId()));
        val profile = profileMapper.updateProfileInputToProfile(input);
        return profileRepository.save(profile);
    }

    @Transactional
    public int deleteProfile(Long id) {
        profileRepository.deleteById(id);
        return 1;
    }

    @Transactional
    public Comment createComment(CreateCommentInput input) {
        val comment = commentMapper.createCommentInputToComment(input);
        return commentRepository.save(comment);
    }

    @Transactional
    public int deleteComment(Long id) {
        commentRepository.deleteById(id);
        return 1;
    }
}
