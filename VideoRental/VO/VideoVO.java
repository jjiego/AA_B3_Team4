package VO;

import java.util.Date;


public class VideoVO {
    private String title ;
    private VIDEO_TYPE videoType ;
    private PRICE_CODE_TYPE priceCode ;
    private boolean rented ;
    private int penallty;
    private int limit;

    Date registeredDate;
    public VideoVO(String title, VIDEO_TYPE videoType, PRICE_CODE_TYPE priceCode, int limit){
        this.title = title;
        this.videoType = videoType;
        this.priceCode = priceCode;
        this.registeredDate = new Date();
        rented = false;
        setPenallty();
        this.limit = limit;

    }
    private void setPenallty(){
        switch ( videoType ) {
            case VHS: penallty = 1 ; break ;
            case CD: penallty = 2 ; break ;
            case DVD: penallty = 3 ; break ;
            default: penallty = 0;
        }
    }

    public String getTitle(){  return this.title; }
    public PRICE_CODE_TYPE getPriceCode(){ return priceCode;}
    public int getPenallty(){return penallty;}

    public String getInform(){
        return "\tTitle : "+title+"\t Price"+priceCode;
    }
    public boolean isRented(){
        return rented;
    }
    public void setRented(boolean rent){
        this.rented = rent;
    }

    public VIDEO_TYPE getVideoType() {
        return videoType;
    }

    public int getLimit() {return limit;}


    public enum PRICE_CODE_TYPE{
        NONE,
        REGULAR,
        NEW_RELEASE
    }
    public enum VIDEO_TYPE{
        NONE,
        VHS,
        CD,
        DVD
    }

}
