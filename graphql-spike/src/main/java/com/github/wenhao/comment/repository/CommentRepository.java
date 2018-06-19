package com.github.wenhao.comment.repository;

import com.github.wenhao.comment.type.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByArticleId(Long id);
}
