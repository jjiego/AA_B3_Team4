package Manager;

import VO.RentalVO;

import java.util.ArrayList;
import java.util.List;

public class RentalManager {
    private static RentalManager rMng = null;
    private List<RentalVO> rentalList;
    private List<RentalVO> CustomerRental;

    RentalManager() {
        rentalList = new ArrayList<RentalVO>();
    }

    public static RentalManager getInstance() {
        if (rMng == null) rMng = new RentalManager();
        return rMng;
    }
}
