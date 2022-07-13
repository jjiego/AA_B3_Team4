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
        System.out.println("Enter customer name: ") ;
        String customerName = scanner.next() ;
        customer = CustomerManager.getInstance().getCustomer(customerName);
        if(customer==null){
            System.out.println("No customer found");
            return false;
        }
        return true;
    }
    public boolean getVideo(){
        String videoTitle = getVideoTitle();
        VideoVO video = VideoManager.getInstance().getAbleVideo(videoTitle);
        if(video == null) return false;
        return true;
    }
    public String getVideoTitle(){
        System.out.println("Enter video title to rent: ") ;
        return scanner.next();
    }
}
