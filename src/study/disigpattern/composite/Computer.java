package study.disigpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KimYJ on 2018-04-03.
 */
//Composite
class Computer implements ComputerDevice {
    private List<ComputerDevice> computerDevices;

    public Computer() {
        this.computerDevices = new ArrayList<>();
    }

    public void addDevice(ComputerDevice computerDevice) {
        computerDevices.add(computerDevice);
    }

    @Override
    public int getPrice() {
        return computerDevices.stream()
                .mapToInt(ComputerDevice::getPrice)
                .sum();
    }
}
