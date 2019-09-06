package TestClasses;

public class PrintUtils
{

    public static String getFormattedString(String binary, int intervals, String interjects)
    {

        int sizeOfInterjects = interjects.length();
        int size = binary.length();
        int numberOfIntervals = size / intervals;
        int newSize = size + (numberOfIntervals * sizeOfInterjects);
        System.out.println("Size is : " + size + " new size: " + newSize + " Number of intervals: " + numberOfIntervals);
        StringBuilder builder = new StringBuilder(newSize);
        int i = 0;
        for(i = 0; i < size; i = i + intervals)
        {
            if((i+intervals) < size)
                builder.append(binary, i, (i+intervals)).append(interjects);
            else
                builder.append(binary, i, size);
        }
        return builder.toString();
    }
}
