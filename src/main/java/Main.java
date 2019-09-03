import VM.VM;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        VM vm = VM.getVmInstance();
        System.out.println(vm.getResponse());
    }
}
