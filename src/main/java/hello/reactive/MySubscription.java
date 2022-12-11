package hello.reactive;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Iterator;

//구독자가 누구인지, 어떤 데이터를 구독하는지?
public class MySubscription implements Subscription {

    private Subscriber s;
    private Iterator<Integer> it;

    public MySubscription(Subscriber s, Iterable its) {
        this.s = s;
        this.it = its.iterator();
        System.out.println("구독정보 생성 완료");

    }

    @Override
    public void request(long n) {

        while (n > 0) {
            if (it.hasNext()) {
                s.onNext(it.next());
            } else {
                s.onComplete();
                break;
            }
            n--;

        }


    }

    @Override
    public void cancel() {

    }
}
