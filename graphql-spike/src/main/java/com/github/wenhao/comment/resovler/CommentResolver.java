package com.github.wenhao.comment.resovler;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.github.wenhao.comment.type.Comment;
import com.github.wenhao.profile.type.Profile;
import com.github.wenhao.profile.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentResolver implements GraphQLResolver<Comment> {
    private ProfileRepository profileRepository;

    public Profile getAuthor(Comment comment) {
        return profileRepository.findById(comment.getAuthorId()).get();
    }
}
