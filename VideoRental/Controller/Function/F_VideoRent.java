package Controller.Function;

import Manager.CustomerManager;
import Manager.RentalManager;
import Manager.VideoManager;
import VO.CustomerVO;
import VO.VideoVO;

import java.util.Scanner;

public class F_VideoRent extends Controller.Function.F_FoundThings {

    public F_VideoRent(Scanner scanner) {
        super(scanner);
        name = "Rent Video";
    }

    @Override
    public boolean run() {
        if(getCustomer() == false)  return false;
        if(getVideo() == false)     return false;

        RentalManager.getInstance().rentVideo(customer.getName(),video);
        return false;
    }
}
