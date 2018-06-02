package com.github.wenhao;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import lombok.var;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class LombokTest {

    @Test
    public void should_run_val() {
        // given
        val name = "name";

        // when

        // then
        assertThat(name).isEqualTo("name");
    }

    @Test
    public void should_run_var() {
        // given
        var name = "name";

        // when
        name = "name-other";

        // then
        assertThat(name).isEqualTo("name-other");
    }

    @Test
    public void should_run_getter_setter() {
        // given

        // when
        Person person = Person.builder()
                .name("name")
                .address("address")
                .build();

        // then
        assertThat(person.getName()).isEqualTo("name");
    }

    @Test
    public void should_run_log() {
        // given

        // when
        log.info("output log.");

        // then

    }
}
