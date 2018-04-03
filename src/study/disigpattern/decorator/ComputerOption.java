package study.disigpattern.decorator;

/**
 * Created by KimYJ on 2018-04-03.
 */
class ComputerOption extends ComputerDecorator {
    @Override
    void addRunOptions() {
        System.out.println("add option");
    }
}
