package esc.problemset3.cohortexercise04;


public class Integer
{
    final Type type;
    Integer leftHandSide;
    Digit rightHandSide;
    
    Integer(Type type)
    {
        this.type = type;
    }
    
    @Override
    public String toString()
    {
        switch (type)
        {
            case DIGIT:
                return rightHandSide.toString();
            
            case INTEGER_DIGIT:            
                return leftHandSide.toString() + rightHandSide.toString();
            
            default:
                throw new IllegalStateException("Integer has no type");
        }
    }
    
    enum Type
    {
        DIGIT,
        INTEGER_DIGIT
    }
}
