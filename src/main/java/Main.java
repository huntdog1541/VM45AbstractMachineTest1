import TestClasses.Converter;
import TestClasses.EAXRegister;
import TestClasses.PrintUtils;
import VM.VM;
import VM.Register;
import VM.RegisterUtils;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        VM vm = VM.getVmInstance();
        RegisterUtils registerUtils = RegisterUtils.getInstance();
        /*System.out.println(vm.getResponse());
        int answer = (int)Math.pow(2, 3);
        System.out.println("Answer: " + answer);
        Register register = new Register("EAX", 8, true, false);
        register.setValue(8);
        register.printRegister();
        System.out.println("Possible Value: " + RegisterUtils.getPossibleValues(register));
        System.out.println("Lower limit: " + RegisterUtils.getLowerLimit(register));
        System.out.println("Upper limit: " + RegisterUtils.getUpperLimit(register));
        RegisterUtils.setValue(register, 15);
        register.printRegister();
        RegisterUtils.setValue(register, 2000);
        RegisterUtils.setValue(register, 127);
        register.printRegister();

        Register register2 = new Register("EBX", 8, false, false);
        RegisterUtils.setValue(register2, 2000);
        System.out.println("2000:");
        register2.printRegister();
        RegisterUtils.setValue(register2, 127);
        System.out.println("127:");
        register2.printRegister();
        RegisterUtils.setValue(register2, 256);
        System.out.println("256:");
        register2.printRegister();
        RegisterUtils.setValue(register2, 255);
        System.out.println("255:");
        register2.printRegister();*/

        /*registerUtils.createRegisters();
        Register eax = registerUtils.getRegister("EAX");
        eax.setValue(32);
        eax.printRegister();

        registerUtils.printRegisters();*/
        //testFuntionality();
        EAXRegister eax = new EAXRegister(32, false);
        eax.setValue(50);
        String bin = eax.getBinaryString();
        System.out.println("EAX: " + bin);
        System.out.println(PrintUtils.getFormattedString(bin, 4, " "));
        String hex = Converter.generateHexString(50, 32);
        System.out.println("Hex: " + hex);
    }

    /*public static void testFuntionality()
    {
        StringBuilder builder = new StringBuilder();
        int register = -44;
        int mask = 1, temp = 0;
        int i = 0;
        temp = register & mask;
        builder.append(temp == mask? "1" : "0");
        //System.out.print(temp == mask? "1" : "0");
        for(i = 1; i < 32; i++)
        {
            mask = mask << 1;
            temp = register & mask;
            //System.out.print(temp == mask? "1" : "0");
            builder.append(temp == mask? "1" : "0");
        }
        System.out.println(builder.reverse().toString());
    }*/
}
