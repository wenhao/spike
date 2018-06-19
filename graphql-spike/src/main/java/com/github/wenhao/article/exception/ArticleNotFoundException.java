package com.github.wenhao.article.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.ImmutableMap;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor(staticName = "of")
public class ArticleNotFoundException extends RuntimeException implements GraphQLError {

    @NonNull
    private Long articleId;

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public String getMessage() {
        return "Article with ID " + articleId + " could not be found";
    }

    @Override
    public Map<String, Object> getExtensions() {
        return ImmutableMap.of("articleId", articleId);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.ValidationError;
    }

    @JsonIgnore
    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }
}
