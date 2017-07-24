package com.github.springboot.controller;

import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class BasedErrorController extends BasicErrorController {

    private static final String ERROR_ATTRIBUTE = DefaultErrorAttributes.class.getName()
            + ".ERROR";

    public BasedErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
        super(errorAttributes, errorProperties);
    }

    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        MethodArgumentNotValidException exception = (MethodArgumentNotValidException) requestAttributes.getAttribute(ERROR_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST);
        BindingResult bindingResult = exception.getBindingResult();
        List<String> errorMessages = bindingResult.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(toList());
        Map<String, Object> errors = new HashMap<String, Object>() {{
            put("errors", errorMessages);
        }};
        return new ResponseEntity<>(errors, getStatus(request));
    }
}
