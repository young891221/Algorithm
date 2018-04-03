package study.disigpattern.composite;

/**
 * Created by KimYJ on 2018-04-03.
 */
//leaf
class Keyboard implements ComputerDevice {
    @Override
    public int getPrice() {
        return 5000;
    }
}
