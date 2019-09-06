package TestClasses;

public class Converter {

    public static String generateHexString(int value, int size)
    {
        StringBuilder builder = new StringBuilder();
        int mask = 15, temp = 0, i = 0;
        int intervals = size / 4;
        temp = value & mask;
        builder.append(getHexValue(temp)).append(" ");
        for(i = 1; i < intervals; i++)
        {
            mask = mask << 4;
            temp = value & mask;
            temp = temp >> (4 * i);
            builder.append(getHexValue(temp)).append(" ");
        }
        return builder.reverse().toString();
    }

    private static char getHexValue(int val)
    {
        switch(val)
        {
            case 0: return '0';
            case 1: return '1';
            case 2: return '2';
            case 3: return '3';
            case 4: return '4';
            case 5: return '5';
            case 6: return '6';
            case 7: return '7';
            case 8: return '8';
            case 9: return '9';
            case 10: return 'A';
            case 11: return 'B';
            case 12: return 'C';
            case 13: return 'D';
            case 14: return 'E';
            case 15: return 'F';
            default: return '0';
        }
    }
}
