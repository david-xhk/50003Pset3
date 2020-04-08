package esc.problemset3.cohortexercise04;


public class Digit
{
    final Type type;
    
    Digit(Type type)
    {
        this.type = type;
    }
    
    @Override
    public String toString()
    {
        switch (type)
        {
            case ZERO:
                return "0";
            
            case ONE:
                return "1";
            
            case TWO:
                return "2";
            
            case THREE:
                return "3";
            
            case FOUR:
                return "4";
            
            case FIVE:
                return "5";
            
            case SIX:
                return "6";
            
            case SEVEN:
                return "7";
            
            case EIGHT:
                return "8";
            
            case NINE:
                return "9";
            
            default:
                throw new IllegalStateException("Digit has no type");
        }
    }
    
    enum Type
    {
        ZERO,
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE
    }
}
