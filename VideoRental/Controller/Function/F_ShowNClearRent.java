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
        List<RentalVO> rentalList = HistoryManager.getInstance().getRentalHistory(customer.getName());
        System.out.println("Name: " + customer.getName() +
                "\tRentals: " + rentalList.size()) ;
        for(RentalVO rental : rentalList){
            System.out.println(rental.getVideo().getInform()) ;
        }
        return false;
    }
}
