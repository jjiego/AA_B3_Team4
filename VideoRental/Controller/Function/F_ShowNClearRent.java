package Controller.Function;

import Manager.HistoryManager;
import VO.RentalVO;

import java.util.List;
import java.util.Scanner;

public class F_ShowNClearRent extends F_FoundThings {

    public F_ShowNClearRent(Scanner scanner) {
        super(scanner);
        name = "Show Customer Report and Clear Rental";
    }

    @Override
    public boolean run() {
        if(getCustomer() == false ) return false;
        HistoryManager historyMng = HistoryManager.getInstance();
        List<RentalVO> historyList = historyMng.getRentalHistory(customer.getName());
        System.out.println("Name: " + customer.getName() +
                "\tRentals: " + historyList.size()) ;
        for(RentalVO history : historyList){
            System.out.println(history.getVideo().getInform()) ;
            historyMng.remove(history);
        }
        return false;
    }
}
