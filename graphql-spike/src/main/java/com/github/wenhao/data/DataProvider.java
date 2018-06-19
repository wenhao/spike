package com.github.wenhao.data;

import com.github.wenhao.article.repository.ArticleRepository;
import com.github.wenhao.comment.repository.CommentRepository;
import com.github.wenhao.profile.repository.ProfileRepository;
import com.github.wenhao.article.type.Article;
import com.github.wenhao.comment.type.Comment;
import com.github.wenhao.profile.type.Profile;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DataProvider implements CommandLineRunner {
    private ProfileRepository profileRepository;
    private ArticleRepository articleRepository;
    private CommentRepository commentRepository;

    @Override
    @Transactional
    public void run(final String... args) throws Exception {
        Profile author = profileRepository.save(new Profile(null, "g00glen00b", "The author of this blog"));
        Profile admin = profileRepository.save(new Profile(null, "admin", "The administrator of this blog"));
        Article article1 = articleRepository.save(new Article(null, "Hello world", "This is a hello world", author.getId()));
        Article article2 = articleRepository.save(new Article(null, "Foo", "Bar", admin.getId()));
        commentRepository.save(new Comment(null, "Do you like this article?", article1.getId(), author.getId()));
        commentRepository.save(new Comment(null, "This is a great article", article1.getId(), admin.getId()));
        commentRepository.save(new Comment(null, "This is a comment", article2.getId(), admin.getId()));
    }
}
