package hello.reactive;

public class MyApp {

    public static void main(String[] args) {


        MyPub myPub = new MyPub();
        MySub mySub = new MySub();

        myPub.subscribe(mySub);


    }

}
