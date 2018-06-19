package com.github.wenhao.profile.exception;

import com.google.common.collect.ImmutableMap;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor(staticName = "of")
public class ProfileNotFoundException extends RuntimeException implements GraphQLError {
    @NonNull
    private Long profileId;

    @Override
    public String getMessage() {
        return "Profile with ID " + profileId + " could not be found";
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.ValidationError;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return ImmutableMap.of("profileId", profileId);
    }
}
