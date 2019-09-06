package TestClasses;

public class Range {

    private int lowerBound;
    private int upperBound;
    private int possibleRange;
    private boolean signed;

    public Range(int size, boolean isSigned)
    {
        calculateRange(size, isSigned);
    }

    private void calculateRange(int size, boolean isSigned)
    {
        if(isSigned)
        {
            lowerBound = (int) Math.pow(2, size-1)/2 * -1;
            upperBound = (int) Math.pow(2, size-1)/2 - 1;
        }
        else
        {
            lowerBound = 0;
            upperBound = (int) Math.pow(2, size-1);
        }
        possibleRange = (int)Math.pow(2, size-1);
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public int getPossibleRange() {
        return possibleRange;
    }
}
