package TestClasses;

public class EAXRegister extends RegisterFunction {

    public EAXRegister()
    {
        super(0, "", 0, false);
    }

    public EAXRegister(int size, boolean signed)
    {
        super(0, "EAX", size, signed);
    }

    public EAXRegister(int value, int size, boolean signed)
    {
        super(value, "EAX", size, signed);
    }

}
