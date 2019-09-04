import VM.VM;
import VM.Register;
import VM.RegisterUtils;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        VM vm = VM.getVmInstance();
        System.out.println(vm.getResponse());
        int answer = (int)Math.pow(2, 3);
        System.out.println("Answer: " + answer);
        Register register = new Register("EAX", 8, true, false);
        register.setValue(8);
        register.printRegister();
        System.out.println("Possible Value: " + RegisterUtils.getPossibleValues(register));
        System.out.println("Lower limit: " + RegisterUtils.getLowerLimit(register));
        System.out.println("Upper limit: " + RegisterUtils.getUpperLimit(register));
        System.out.println("Test String: " + register.getTest());
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
        register2.printRegister();

    }
}
