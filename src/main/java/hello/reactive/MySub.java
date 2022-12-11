package hello.reactive;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MySub implements Subscriber<Integer> {

    private Subscription s;

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("==== 구독자 : 구독 정보 잘 받았어");
        this.s = subscription;
        System.out.println("나 이제 신문 1개씩 줘");
        s.request(1);
    }

    @Override
    public void onNext(Integer integer) {
        System.out.println("==== 구독 데이터 전달");
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("==== 에러");
    }

    @Override
    public void onComplete() {

        System.out.println("==== 구독 완료");
    }
}
