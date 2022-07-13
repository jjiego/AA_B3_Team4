package Controller;

import Controller.Function.*;
import Manager.CustomerManager;
import Manager.HistoryManager;
import Manager.RentalManager;
import Manager.VideoManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {

    private static Scanner scanner = new Scanner(System.in);
    private static MainController mng = null;
    private boolean quit;
    private int command;
    private List<IFunction> func;
    CustomerManager customerManager;
    VideoManager videoManager;
    RentalManager rentalManager;
    HistoryManager historyManager;

    MainController() {
        command = 0;
        quit = false;
        scanner = new Scanner(System.in);
        func = new ArrayList<>();
        setFunction();
        customerManager = CustomerManager.getInstance();
        videoManager = VideoManager.getInstance();
        rentalManager = RentalManager.getInstance();
        historyManager = HistoryManager.getInstance();
    }

    public static MainController getInstance(){
        if(mng==null ) mng = new MainController();
        return mng;
    }

    private void setFunction(){
        func.add(new F_Quit());
        func.add(new F_CustomerList());
        func.add(new F_VideoList());
        func.add(new F_CustomerRegister(scanner));
        func.add(new F_VideoRegister(scanner));
        func.add(new F_VideoRent(scanner));
        func.add(new F_VideoReturn(scanner));
        func.add(new F_ShowCustomerReport(scanner));
        func.add(new F_ShowNClearRent(scanner));

    }
}

