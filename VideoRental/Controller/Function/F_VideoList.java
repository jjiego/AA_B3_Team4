package Controller.Function;

import Manager.VideoManager;

public class F_VideoList extends IFunction {

    public F_VideoList(){
        name = "Video List";
    }
    @Override

    public boolean run() {
        System.out.println("List of videos");
        VideoManager.getInstance().showVideoList();
        System.out.println("End of list");
        return false;
    }
}
