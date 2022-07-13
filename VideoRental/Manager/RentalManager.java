package Manager;

import VO.RentalVO;
import VO.VideoVO;

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
<<<<<<< HEAD
    public List<RentalVO> rentalList(String customerName){
        List<RentalVO> CustomerRental = new ArrayList<>();

        for(RentalVO rent : rentalList){
            if(rent.getCustomerName().equals(customerName)){
                CustomerRental.add(rent);
            }
        }
        return CustomerRental;
    }
    public RentalVO getRental(String customerName, String videoTitle){
        for(RentalVO rent : rentalList){
            if(rent.getCustomerName().equals(customerName)
                    && rent.getVideo().getTitle().equals(videoTitle)){
                return rent;
            }
        }
        return null;
    }
    public void rentVideo(String customerName, VideoVO video){
        RentalVO rental = new RentalVO(customerName, video);
        rentalList.add(rental);
        HistoryManager.getInstance().addHistory(rental);
    }
    public void returnVideo(String customerName, String videoTitle){
        RentalVO rental = getRental(customerName,videoTitle);
        if(rental == null) return;
        rental.returnVideo();
        rentalList.remove(rental);
    }

=======
>>>>>>> 46d14ce2525e78aa42c0b66bc733dcf362301d58
}
