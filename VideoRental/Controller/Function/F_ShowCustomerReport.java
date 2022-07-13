package Controller.Function;

import Manager.HistoryManager;

import java.util.Scanner;

public class F_ShowCustomerReport extends F_FoundThings {
    public F_ShowCustomerReport(Scanner scanner) {
        super(scanner);
        name = "Show Customer Report";
    }

    @Override
    public boolean run() {
        if(getCustomer() == false) return false;
        HistoryManager.getInstance().showHistory(customer.getName());
        return false;
    }
}
