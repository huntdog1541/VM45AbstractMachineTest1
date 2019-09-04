package VM;

public class RegisterUtils {

    private static RegisterUtils instance = new RegisterUtils();

    private RegisterUtils()
    {

    }

    public static RegisterUtils getInstance()
    {
        return instance;
    }

    public static int getPossibleValues(Register reg)
    {
        return (int) Math.pow(2, reg.getSize());
    }

    public static int getLowerLimit(Register reg)
    {
        if(reg.isSigned())
        {
            return (RegisterUtils.getPossibleValues(reg) / 2) * -1;
        }
        else
        {
            return 0;
        }
    }

    public static int getUpperLimit(Register reg)
    {
        if(reg.isSigned())
        {
            return (RegisterUtils.getPossibleValues(reg) / 2) - 1;
        }
        else
        {
            return RegisterUtils.getPossibleValues(reg) - 1;
        }
    }

    public static void setValue(Register reg, int value)
    {
        if(value > RegisterUtils.getUpperLimit(reg) || value < RegisterUtils.getLowerLimit(reg))
        {
            System.err.println("Error! Value: " + value + " exceeds the limits of the register lower limit " +
                    RegisterUtils.getLowerLimit(reg) + " upper limit " + RegisterUtils.getUpperLimit(reg));
        }
        else
        {
            reg.setValue(value);
        }

    }
}
