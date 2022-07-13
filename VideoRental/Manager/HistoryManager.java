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
}