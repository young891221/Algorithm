package study.disigpattern.observer;

/**
 * Created by KimYJ on 2018-04-03.
 */
class ObserverB implements Observer {
    @Override
    public void listen(String message) {
        System.out.println(message);
    }
}
