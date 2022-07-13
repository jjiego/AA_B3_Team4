package Manager;

import VO.RentalVO;

import java.util.ArrayList;
import java.util.List;

public class HistoryManager {
    private static HistoryManager hMng = null;
    private List<RentalVO> History;

    HistoryManager() {
        History = new ArrayList<>();
    }

    public static HistoryManager getInstance() {
        if (hMng == null) hMng = new HistoryManager();
        return hMng;
    }

    public void addHistory(RentalVO hitory){
        History.add(hitory);
    }

    public List<RentalVO> getRentalHistory(String customerName){
        List<RentalVO> customHist = new ArrayList<>();
        for(RentalVO rent : History){
            if(rent.getCustomerName().equals(customerName))
                customHist.add(rent);
        }
        return customHist;
    }

        public void showHistory(String customerName) {
            int totalCharge = 0;
            int totalPoint = 0;
            int nowCharge;
            int nowPoint;
            List<RentalVO> hitsory = HistoryManager.getInstance().getRentalHistory(customerName);

            for (RentalVO rental : hitsory) {
                nowCharge = rental.getCharge();
                totalCharge += nowCharge;
                nowPoint = rental.getPoint();
                totalPoint += nowPoint;

                System.out.println(
                        "\t" + rental.getVideo().getTitle()
                                + "\tDays rented: " + rental.getDaysRented()
                                + "\tCharge: " + nowCharge
                                + "\tPoint: " + nowPoint + "\n");
            }
            System.out.println(
                    "Total charge: " + totalCharge
                            + "\tTotal Point:" + totalPoint + "\n"
            );
            if (totalPoint >= 10) {
                System.out.println("Congrat! You earned one free coupon");
            }
            if (totalPoint >= 30) {
                System.out.println("Congrat! You earned two free coupon");
            }
        }

    }
