package TestClasses;

import VM.Register;

public abstract class RegisterFunction {

    private int value;
    private String name;
    private int size;       // Size of register in bits
    private Range range;
    private boolean signed;
    private String binaryString;

    RegisterFunction(int value, String name, int size, boolean isSigned)
    {
        this.value = value;
        this.name = name;
        this.size = size;
        this.signed = isSigned;
        range = new Range(this.size, this.signed);
        generateBinaryString();
    }


    private void generateBinaryString()
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
    }

    private void setRegisterValue(int nwValue)
    {
        value = nwValue;
        generateBinaryString();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
       setRegisterValue(value);
    }

    public void setValue(int value, boolean signed)
    {
        setRegisterValue(value);
        this.signed = signed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }

    public int getLowerBound()
    {
        return this.range.getLowerBound();
    }

    public int getUpperBound()
    {
        return this.range.getUpperBound();
    }

    public int getSetCount()
    {
        return this.range.getPossibleRange();
    }

    public boolean isSigned() {
        return signed;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }

    public String getBinaryString()
    {
        return binaryString;
    }

}
