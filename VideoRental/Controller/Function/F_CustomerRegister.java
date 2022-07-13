package Controller.Function;

import Manager.CustomerManager;

import java.util.Scanner;

public class F_CustomerRegister extends IFunction {
    private static Scanner scanner;
    public F_CustomerRegister(Scanner scanner){name = "Add Customer"; this.scanner = scanner;}

    @Override
    public boolean run() {
        return false;
    }
}
