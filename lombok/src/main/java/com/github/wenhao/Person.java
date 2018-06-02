package com.github.wenhao;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor(staticName = "of")
@Builder
@Slf4j
public class Person {
    @Getter
    @Setter
    @NonNull
    private String name;

    @Getter
    @Setter
    @Builder.Default
    private int age = 5;

    @EqualsAndHashCode.Exclude
    private final String email;

    @Singular
    private List<String> addresses;

    public void tolog() {
        log.info("logger");
    }

}
