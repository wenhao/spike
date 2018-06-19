package com.github.wenhao.comment.mapper;

import com.github.wenhao.comment.input.CreateCommentInput;
import com.github.wenhao.comment.type.Comment;
import org.mapstruct.Mapper;

@Mapper
public interface CommentMapper {

    Comment createCommentInputToComment(CreateCommentInput input);
}
