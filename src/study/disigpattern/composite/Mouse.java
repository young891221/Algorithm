package study.disigpattern.composite;

/**
 * Created by KimYJ on 2018-04-03.
 */
//leaf
class Mouse implements ComputerDevice {
    @Override
    public int getPrice() {
        return 10000;
    }
}
