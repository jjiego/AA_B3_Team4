package VO;

import java.util.Date;

import static VO.VideoVO.PRICE_CODE_TYPE;
import static VO.VideoVO.PRICE_CODE_TYPE.NEW_RELEASE;


public class RentalVO {
    private String customerName;
    private VideoVO video;
    private boolean status;
    private Date rentDate;
    private Date returnDate;

    private int daysRented;
    private int charge;

    public RentalVO(String customerName, VideoVO video){
        this.customerName = customerName;
        this.video = video;
        rentDate = new Date();
        status = true;
        video.setRented(true);
        daysRented = 0;
    }

    public String getCustomerName(){return customerName;}
    public VideoVO getVideo() { return video;}

    public int getDaysRented(){
        if(status) return calcRentedDay(new Date());
        return daysRented;

    }
    private int calcRentedDay(Date Compare){
        long diff = Compare.getTime() - rentDate.getTime();
        return (int) (diff / (1000 * 60 * 60 * 24)) + 1;
    }
    private int calcRegular(int rentedDay){
        charge = 2;
        if(rentedDay>2) charge += (rentedDay-2) * 1.5;
        return charge;
    }
    private int calcNewRelease(int rentedDay){
        return rentedDay * 3;
    }
    private int calcCharge(int rentedDay){
        int charge = 0;
        switch (video.getPriceCode()){
            case REGULAR:
                charge = calcRegular(rentedDay);
                break;
            case NEW_RELEASE:
                charge = calcNewRelease(rentedDay);
                break;
        }
        return charge;
    }
    public int getDaysRentedLimit(){
        int rentedDate = getDaysRented();
        if( rentedDate<=2 ) return 0;
        return video.getLimit();
    }
    public int getCharge(){
        if(status) return calcCharge(getDaysRented());
        return charge;
    }
    public int getPoint(){
        int point = (video.getPriceCode() == NEW_RELEASE)? 2 : 1;
        if( getDaysRented() > getDaysRentedLimit())
            point -= Math.min(point, video.getPenallty());
        return point;
    }
    public void returnVideo(){
        if(status) {
            returnDate = new Date();
            status = false;
            video.setRented(false);
            daysRented = calcRentedDay(returnDate);
            charge = calcCharge(daysRented);
        }
    }
}
