package Controller.Function;

import Manager.VideoManager;

import java.util.Scanner;

public class F_VideoRegister extends IFunction {
    private static Scanner scanner;
    public F_VideoRegister(Scanner scanner){
        name = "Add Video";
        this.scanner = scanner;
    }

    @Override
    public boolean run() {
        System.out.println("Enter video title to register: ") ;
        String title = scanner.next() ;

        System.out.println("Enter video type( 1 for VHD, 2 for CD, 3 for DVD ):") ;
        int videoType = scanner.nextInt();

        System.out.println("Enter price code( 1 for Regular, 2 for New Release ):") ;
        int priceType = scanner.nextInt();

        VideoManager.getInstance().add(title,videoType,priceType);
        return false;
    }

}
