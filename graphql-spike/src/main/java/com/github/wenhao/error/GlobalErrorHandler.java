package com.github.wenhao.error;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class GlobalErrorHandler implements GraphQLErrorHandler {
    @Override
    public List<GraphQLError> processErrors(final List<GraphQLError> errors) {
        return errors.stream()
                .map(this::getGraphQLError)
                .collect(toList());
    }

    private GraphQLError getGraphQLError(final GraphQLError error) {
        if (error instanceof ExceptionWhileDataFetching) {
            final ExceptionWhileDataFetching exceptionError = (ExceptionWhileDataFetching) error;
            if (exceptionError.getException() instanceof GraphQLError) {
                return (GraphQLError) exceptionError.getException();
            }
        }
        return error;
    }
}
