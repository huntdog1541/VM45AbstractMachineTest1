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
        String hex = Converter.generateHexString(50, 32, true);
        System.out.println("Hex: " + hex);
        int hexNumber = Converter.generateHexValue(50, 32);
        System.out.println("Hex Number: " + hexNumber);

        System.out.println("--------------------------------------");
        System.out.println("Floating point number");
        System.out.println(Float.intBitsToFloat(0x7fffff));
        System.out.println("\n\n");
        testFunctionality2();
        testFunctionality3();

    }

    public static void testFunctionality3()
    {
        System.out.println("Testing Binary Integer Functions");
        int number = 15;
        String binaryString = Integer.toBinaryString(number);
        System.out.println("BinaryString: " + binaryString + " size: " + binaryString.length());
        System.out.println("Leading Zeros: " + Integer.numberOfLeadingZeros(number));
        System.out.println("Trailing Zeros: " + Integer.numberOfTrailingZeros(number));
        String binaryStringWithLeadingZeros = appendLeadingZeros(binaryString, number);
        System.out.println("Binary String: " + binaryStringWithLeadingZeros + " size: " + binaryStringWithLeadingZeros.length());
    }

    public static String appendLeadingZeros(String bin, int value)
    {
        StringBuilder builder = new StringBuilder();
        int i, limit = Integer.numberOfLeadingZeros(value);
        for(i = 0; i < limit; i++)
        {
            builder.append("0");
        }
        builder.append(bin);
        return builder.toString();
    }

    public static void testFuntionality()
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
    }

    public static void testFunctionality2()
    {
        System.out.println("Testing functionality - 2");
        /*StringBuilder builder = new StringBuilder();
        double register = 3.05;
        double temp = 0;
        int mask = 1;
        temp = register & mask;*/
        int floatValue = Float.floatToRawIntBits((float) -3.05);
        String floatBinary = Integer.toBinaryString(floatValue);
        System.out.println("Original Raw Bits:" + floatBinary + " size: " + floatBinary.length());
        if(floatValue < 0)
        {
            floatBinary = "1".concat(floatBinary);
        }
        else
        {
            floatBinary = "0".concat(floatBinary);
        }
        System.out.println("Float: " + floatBinary);
        System.out.println("Signed bit: " + PrintUtils.getBinaryPosition(floatBinary, 32, 31, 32));
        String signedString = floatBinary.substring(0, 1);
        String exponentString = floatBinary.substring(1, 8);
        String mantissaString = floatBinary.substring(8, 32);
        System.out.println("Signed: " + floatBinary.substring(0, 1) +" Value: " + Integer.parseInt(signedString));
        System.out.println("Exponent: " + floatBinary.substring(1, 8) + " Value: " + Integer.parseInt(exponentString));
        System.out.println("Mantissa: " + floatBinary.substring(8, 32));
        //mantissaString = mantissaString.replaceFirst("^0*", "");
        System.out.println("Mantissa string with leading zeros | " + PrintUtils.getFormattedString(mantissaString, 4, " "));
        System.out.println("Mantissa: " + Converter.getNumberFromBinaryString(mantissaString));
        System.out.println("Exponent: " + Converter.getNumberFromBinaryString(exponentString));
        System.out.println("Signed: "  + Converter.getNumberFromBinaryString(signedString));
        //long mantissa = Long.parseLong(mantissaString);
        //System.out.println("Mantissa value: " + mantissa);
        System.out.println(floatBinary.length());
    }



/*    private void generateBinaryString()
    {
        StringBuilder builder = new StringBuilder();
        int mask = 1, temp = 0, i = 0;
        temp = value & mask;
        builder.append(temp == mask? "1" : "0");
        for(i = 1; i < size; i++)
        {
            mask = mask << 1;
            temp = value & mask;
            builder.append(temp == mask? "1" : "0");
        }
        binaryString = builder.reverse().toString();
    }*/
}
