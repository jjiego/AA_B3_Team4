package Controller.Function;

import Controller.Function.F_FoundThings;
import Manager.CustomerManager;
import Manager.RentalManager;
import VO.CustomerVO;

import java.util.Scanner;

public class F_VideoReturn extends F_FoundThings {

    public F_VideoReturn(Scanner scanner) {
        super(scanner);
        name = "Return Video";
    }

    @Override
    public boolean run() {
        return false;
    }
}
