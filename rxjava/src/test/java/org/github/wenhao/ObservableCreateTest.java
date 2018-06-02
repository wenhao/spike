package org.github.wenhao;

import io.reactivex.Observable;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ObservableCreateTest {

    @Test
    public void should_work_create() {
        // given
        String config = "config";

        // when
        rangeObserver().subscribe(System.out::println);

        // then

    }

    private Observable<Integer> rangeObserver() {
        return Observable.range(1, 10);
    }

    private Observable<Long> interval() {
        return Observable.interval(1, TimeUnit.SECONDS);
    }
}
