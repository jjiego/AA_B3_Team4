package Controller.Function;

public abstract class IFunction {

    String name;
    public String funcName() {
        return name;
    }
    public abstract boolean run();
}
