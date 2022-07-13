package Controller.Function;

import Manager.CustomerManager;
import Manager.VideoManager;
import VO.CustomerVO;
import VO.VideoVO;

import java.util.Scanner;

public abstract class F_FoundThings extends IFunction {
    static Scanner scanner;
    CustomerVO customer;
    VideoVO video;
    public F_FoundThings(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public boolean run() {return false;}

    public boolean getCustomer(){
        return true;
    }
    public boolean getVideo(){
        return true;
    }
    public String getVideoTitle(){
        return "";
    }
}
