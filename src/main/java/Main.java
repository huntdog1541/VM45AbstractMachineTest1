import VM.VM;
import VM.Register;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        VM vm = VM.getVmInstance();
        System.out.println(vm.getResponse());
        int answer = (int)Math.pow(2, 3);
        System.out.println("Answer: " + answer);
        Register register = new Register("EAX", 8, false);
        register.setValue(8);
        register.printRegister();
        System.out.println("Max Value: " + register.getMaxValue());
    }
}
