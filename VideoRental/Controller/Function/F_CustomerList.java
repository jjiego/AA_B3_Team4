package Controller.Function;

import Manager.CustomerManager;
import Manager.RentalManager;
import VO.CustomerVO;
import VO.RentalVO;

import java.util.List;

public class F_CustomerList extends IFunction{

    public F_CustomerList(){
        name = "Customer List";
    }
    @Override
    public  boolean run() {

        List<CustomerVO> customerList = CustomerManager.getInstance().customerList();
        List<RentalVO> rentalList;

        for (CustomerVO customer : customerList) {
            rentalList = RentalManager.getInstance().rentalList(customer.getName());
            System.out.println("Name: " + customer.getName() +
                    "\tRentals: " + rentalList.size());
            for (RentalVO rental : rentalList) {
                System.out.print("\t" + rental.getVideo().getInform());
            }
        }
        return false;
    }
}
