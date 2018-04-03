package study.disigpattern.observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by KimYJ on 2018-04-03.
 */
class Observable {
    private List<Observer> observers;

    public Observable() {
        this.observers = new ArrayList<>(Arrays.asList(new ObserverA(), new ObserverB()));
    }

    void run() {
        observers.forEach(observer -> observer.listen("시작했따~"));
    }
}
