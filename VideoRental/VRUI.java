
import Controller.*;

public class VRUI {
	static MainController mng;

	VRUI(){

	}
	public static void main(String[] args) {
		mng = MainController.getInstance();
		System.out.println("do");
		while(mng.isRun()){
			mng.showCommand();
			mng.getCommand();
			mng.doCommand();
		}
	}
}