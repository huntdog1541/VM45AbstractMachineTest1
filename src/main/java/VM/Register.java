package VM;

import java.util.BitSet;

public class Register
{
    private String name;
    private int size;
    private boolean isFlag;
    private BitSet bitSet;
    private String bitString;
    private int MaxValue;
    private int value;

    public Register(String name, int size, boolean isFlag)
    {
        setUpRegister(name, size, 0, isFlag);
    }

    public Register(String name, int size, int value, boolean isFlag)
    {
        setUpRegister(name, size, value, isFlag);
    }

    private void setUpRegister(String name, int size, int value, boolean isFlag)
    {
        this.name = name;
        this.size = size;
        this.bitSet = new BitSet(size);
        clearRegister();
        if(value != 0)
        {
            setValue(value);
        }
        this.isFlag = isFlag;
        MaxValue = (int) Math.pow(2, this.size);
    }

    public void setValue(int value)
    {
        int tempValue = value;
        boolean setRestZeros = false;
        int remainder = 0;
        for(int i = size; i > 0; i--)
        {
            if (!setRestZeros)
            {
                int powValue = (int)Math.pow(2, i-1);
                if((tempValue/powValue) == 1)
                {
                    bitSet.set(i, true);
                    tempValue = tempValue % powValue;
                }
                else
                {
                    bitSet.set(i, false);
                }
                if(tempValue == 0)
                {
                    setRestZeros = true;
                }
            }
            else
            {
                bitSet.set(i, false);
            }

        }
    }

    public void printRegister()
    {
        System.out.println("Register: " + this.name);
        setCharArray();
        System.out.println(bitString);
    }

    private void setCharArray()
    {
        StringBuilder builder = new StringBuilder(this.size);
        for(int i = 0; i < this.size; i++)
        {
            if(bitSet.get(i))
            {
                builder.append("1");
            }
            else
            {
                builder.append("0");
            }
        }
        bitString = insertPeriodically(builder.toString(), "-", 4);
    }

    public String insertPeriodically(String text, String insert, int period)
    {
        StringBuilder builder = new StringBuilder(
                text.length() + insert.length() * (text.length()/period)+1);

        int index = 0;
        String prefix = "";
        while (index < text.length())
        {
            // Don't put the insert in the very first iteration.
            // This is easier than appending it *after* each substring
            builder.append(prefix);
            prefix = insert;
            builder.append(text.substring(index,
                    Math.min(index + period, text.length())));
            index += period;
        }
        return builder.toString();
    }

    public void clearRegister()
    {
        bitSet.clear();
    }

    public int getIntegerValue()
    {
        int answer = 0;
        for(int i = this.size; i > 0; i--)
        {
            if(bitSet.get(i))
            {
                answer += Math.pow(2.0, i);
            }
        }
        return answer;
    }

    public String getName()
    {
        return this.name;
    }

    public int getValue()
    {
        return this.value;
    }

    public boolean isRegisterAFlag()
    {
        return this.isFlag;
    }

    public BitSet getBitSet()
    {
        return this.bitSet;
    }

    public int getMaxValue()
    {
        return this.MaxValue;
    }
}
