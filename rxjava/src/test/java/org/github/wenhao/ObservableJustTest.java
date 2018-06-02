package org.github.wenhao;

import io.reactivex.Observable;
import org.junit.Test;

public class ObservableJustTest {

    @Test
    public void should_work_just() {

        Observable<String> justObservable = Observable.just("string")
                .doOnNext(config -> System.out.println(config + "1"))
                .doOnNext(config -> System.out.println(config + "2"))
                .doOnNext(config -> System.out.println(config + "3"));

        justObservable.subscribe(s -> System.out.println(s), throwable -> System.out.println(throwable.getMessage()));
    }
}
