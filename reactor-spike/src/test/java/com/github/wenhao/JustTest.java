package com.github.wenhao;

import org.junit.Test;
import reactor.core.publisher.Mono;

public class JustTest {

  @Test
  public void just() {
    // given

    // when
    Mono.just(1)
        .subscribe(System.out::println);

    // then

  }

  @Test
  public void just_or_empty() {
    // given

    // when
    Mono.justOrEmpty(1)
        .subscribe(System.out::println);

    // then

  }

  @Test
  public void from() {
    // given

    // when


    // then

  }
}
