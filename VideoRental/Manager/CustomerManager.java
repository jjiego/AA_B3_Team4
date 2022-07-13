package Manager;

import VO.CustomerVO;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private static CustomerManager cMng = null;
    private List<CustomerVO> customers;

    CustomerManager() {
        customers = new ArrayList<CustomerVO>();
    }

    public static CustomerManager getInstance() {
        if (cMng == null) cMng = new CustomerManager();
        return cMng;
    }
}