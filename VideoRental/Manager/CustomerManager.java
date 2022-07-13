package Manager;

import VO.CustomerVO;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private static CustomerManager cMng = null;
    private List<CustomerVO> customers;

    private CustomerManager() {
        customers = new ArrayList<CustomerVO>();
    }

    public static CustomerManager getInstance() {
        if (cMng == null) cMng = new CustomerManager();
        return cMng;
    }
    public List<CustomerVO> customerList(){
        return customers;
    }
    public CustomerVO getCustomer(String name){
        for(CustomerVO customer : customers){
            if(customer.getName().equals(name))
                return customer;
        }
        return null;
    }
    public void add(String name){
        customers.add(new CustomerVO(name));
    }

    public void customerReport(String name){
        CustomerVO customer = getCustomer(name);
        if(customer == null){
            System.out.println("No customer found");
            return;
        }

    }
}
