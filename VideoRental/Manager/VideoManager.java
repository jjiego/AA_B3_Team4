package Manager;

import VO.VideoVO;
import VO.VideoVO.VIDEO_TYPE;
import VO.VideoVO.PRICE_CODE_TYPE;

import java.util.ArrayList;
import java.util.List;

public class VideoManager {
    private static VideoManager vMng = null;
    private List<VideoVO> videoList;


    VideoManager() {
        videoList = new ArrayList<>();
    }

    public static VideoManager getInstance() {
        if (vMng == null) vMng = new VideoManager();
        return vMng;
    }
    public void showVideoList(){
        for( VideoVO video : videoList){
            System.out.println(video.getInform());
        }
    }
    public void add(String title, int videoType, int priceCode){
        VIDEO_TYPE eVideoType = getVideoType(videoType);
        PRICE_CODE_TYPE ePriceCode = getPriceType(priceCode);
        int limit = getLimit(eVideoType);

        VideoVO video = new VideoVO(title, eVideoType, ePriceCode, limit) ;

        videoList.add(video) ;
    }

    public VideoVO getAbleVideo(String videoTitle){
        for(VideoVO video : videoList){
            if(video.getTitle().equals(videoTitle) && video.isRented()==false)
                return video;
        }
        return null;
    }
    private int getLimit(VIDEO_TYPE videoType){
        switch (videoType){
            case VHS: return 5;
            case CD: return 3;
            case DVD: return 2;
            default : return 0;
        }
    }
    public VIDEO_TYPE getVideoType(int type){
        switch(type){
            case 1: return VIDEO_TYPE.VHS;
            case 2: return VIDEO_TYPE.CD;
            case 3: return VIDEO_TYPE.DVD;
        }
        return VIDEO_TYPE.NONE;
    }
    public PRICE_CODE_TYPE getPriceType(int type){
        if(type==1) return PRICE_CODE_TYPE.REGULAR;
        return PRICE_CODE_TYPE.NEW_RELEASE;
    }

}