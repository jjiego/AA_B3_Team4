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
        return false;
    }

}
