package study.disigpattern.decorator;

/**
 * Created by KimYJ on 2018-04-03.
 */
abstract class ComputerDecorator implements Computer {
    @Override
    public void run() {
        System.out.println("run!!");
    }

    abstract void addRunOptions();
}
