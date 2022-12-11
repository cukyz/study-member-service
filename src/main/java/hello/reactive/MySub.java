package hello.reactive;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MySub implements Subscriber<Integer> {

    private Subscription s;
    private int bufferSize = 3;

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("==== 구독자 : 구독 정보 잘 받았어");
        this.s = subscription;
        System.out.println("나 이제 신문 1개씩 줘");
        s.request(bufferSize);  // 백프레셔 : 소비자가 한번에 처리할 수 있는 개수를 요청, 매일 1개씩 줘!
        // request할때 주는 데이터는 내가 받을 총 갯수가 아니라, 한 번에 받을 갯수를 요청하는 것

    }

    @Override
    public void onNext(Integer integer) {
        System.out.println("onNext(): " + integer);
        //그다음날에도 1개 요청

        bufferSize--;
        if (bufferSize == 0) {
            System.out.println("하루 지남");
            bufferSize = 3;
            s.request(bufferSize);
        }
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
