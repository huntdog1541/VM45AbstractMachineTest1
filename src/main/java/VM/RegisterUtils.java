package VM;

import java.util.HashMap;
import java.util.Map;

import VM.Register;

public class RegisterUtils {

    private static RegisterUtils instance = new RegisterUtils();
    private HashMap<String, Register> registerHashMap = new HashMap<String, Register>();

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

    public void addRegister(Register reg)
    {
        registerHashMap.put(reg.getName(), reg);
    }

    public Register getRegister(String regName)
    {
        return registerHashMap.get(regName);
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

    public void createRegisters()
    {
        Register eax = new Register("EAX", 32, 0, false, false);
        Register ebx = new Register("EBX", 32, 0, false, false);
        Register ecx = new Register("ECX", 32, 0, false, false);
        Register edx = new Register("EDX", 32, 0, false, false);

        addRegister(eax);
        addRegister(ebx);
        addRegister(ecx);
        addRegister(edx);
    }

    public void printRegisters()
    {
        for(Map.Entry<String, Register> entry : registerHashMap.entrySet())
        {
            entry.getValue().printRegisterDetails();
        }
    }
}
