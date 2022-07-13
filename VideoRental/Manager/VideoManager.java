package Manager;

import VO.VideoVO;

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
}