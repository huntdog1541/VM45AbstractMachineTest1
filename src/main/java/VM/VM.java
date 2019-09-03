package VM;

public class VM {

    private static final VM vmInstance = new VM();

    private String response = "VM is up and running";

    private VM()
    {

    }

    public static VM getVmInstance()
    {
        return vmInstance;
    }

    public String getResponse() {
        return response;
    }
}
